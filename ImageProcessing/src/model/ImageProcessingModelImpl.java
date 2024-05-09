package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;


import colorfunction.ColorFunction;
import colorfunction.RedChannelFunction;
import colorfunction.GreenChannelFunction;
import colorfunction.BlueChannelFunction;
import colorfunction.ValueComponentFunction;
import colorfunction.IntensityComponentFunction;
import colorfunction.LumaComponentFunction;
import colorfunction.ChangeBrightnessFunction;
import colorfunction.FlipHorizontalFunction;
import colorfunction.FlipVerticalFunction;




/**
 * Represents a simple implementation of an ImageProcessingModel.
 * Provides functionality to modify, save, and load images.
 */
public class ImageProcessingModelImpl implements ImageProcessingModel {

  protected final Map<String, BufferedImage> images;

  /**
   * To construct a ImageProcessing model implementation that will store all of our images.
   */
  public ImageProcessingModelImpl() {
    this.images = new HashMap<String, BufferedImage>();
  }

  @Override
  public BufferedImage load(String filepath) throws IllegalArgumentException {
    return ImageUtil.readPPM(filepath);
  }

  @Override
  public BufferedImage getRedChannel(String filename) throws IllegalArgumentException {
    return this.map(filename, new RedChannelFunction());
  }

  @Override
  public BufferedImage getGreenChannel(String filename) throws IllegalArgumentException {
    return this.map(filename, new GreenChannelFunction());
  }

  @Override
  public BufferedImage getBlueChannel(String filename) throws IllegalArgumentException {
    return this.map(filename, new BlueChannelFunction());
  }

  @Override
  public BufferedImage getValueComponent(String filename) throws IllegalArgumentException {
    return this.map(filename, new ValueComponentFunction());
  }

  @Override
  public BufferedImage getIntensityComponent(String filename) throws IllegalArgumentException {
    return this.map(filename, new IntensityComponentFunction());
  }

  @Override
  public BufferedImage getLumaComponent(String filename) throws IllegalArgumentException {
    return this.map(filename, new LumaComponentFunction());
  }

  @Override
  public BufferedImage flipHorizontal(String filename) throws IllegalArgumentException {
    return this.map(filename, new FlipHorizontalFunction());
  }

  @Override
  public BufferedImage flipVertical(String filename) throws IllegalArgumentException {
    return this.map(filename, new FlipVerticalFunction());
  }

  @Override
  public BufferedImage changeBrightness(String filename, int value)
          throws IllegalArgumentException {
    return this.map(filename, new ChangeBrightnessFunction(value));
  }

  @Override
  public void saveImage(String destination, String filename) throws IllegalArgumentException {
    try {
      new File(destination).createNewFile();
      FileWriter writer = new FileWriter(destination);
      BufferedImage image = this.images.get(filename);
      writer.write("P3\n");
      writer.write(image.getWidth() + " " + image.getHeight() + "\n");
      writer.write(255 + "\n");
      for (int y = 0; y < image.getHeight(); y += 1) {
        for (int x = 0; x < image.getWidth(); x += 1) {
          Color color = new Color(image.getRGB(x, y));
          writer.write(color.getRed() + "\n");
          writer.write(color.getGreen() + "\n");
          writer.write(color.getBlue() + "\n");
        }
      }
      writer.close();
    }
    catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  @Override
  public void put(String filename, BufferedImage image) throws IllegalArgumentException {
    if (image != null) {
      this.images.put(filename, image);
    } else {
      throw new IllegalArgumentException("Given image cannot be null");
    }
  }

  /**
   * Returns a new image by executing the apply method of the given function object on each pixel
   * of the image with the given filename in the Map for this model.
   * @param filename the name of the file to be processed
   * @param func the function to be applied to every pixel of the specified image
   * @throws IllegalArgumentException if an image with the given name has not been stored
   */
  protected BufferedImage map(String filename, ColorFunction func) throws IllegalArgumentException {
    BufferedImage image = this.images.get(filename);
    if (image == null) {
      throw new IllegalArgumentException("Given image cannot be null");
    }
    BufferedImage result = new BufferedImage(image.getWidth(),
            image.getHeight(),
            BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < image.getWidth(); x += 1) {
      for (int y = 0; y < image.getHeight(); y += 1) {
        result.setRGB(x, y, func.apply(x, y, image).getRGB());
      }
    }
    return result;
  }
}
