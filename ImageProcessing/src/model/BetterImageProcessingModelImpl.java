package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;

import colorfunction.BlurFunction;
import colorfunction.GreyscaleFunction;
import colorfunction.SepiaFunction;
import colorfunction.SharpenFunction;

/**
 * Represents a simple implementation of a BetterImageProcessingModel.
 * Provides additional functionality to modify, save, and load images, in that it can work on
 * additional image formats, and supports additional operations.
 */
public class BetterImageProcessingModelImpl extends ImageProcessingModelImpl
        implements BetterImageProcessingModel {

  public BetterImageProcessingModelImpl() {
    super();
  }

  @Override
  public BufferedImage load(String filepath) throws IllegalArgumentException {
    BufferedImage result;
    try {
      result = ImageUtil.readPPM(filepath);
    } catch (Exception exception) {
      if (exception.getMessage().equals("File " + filepath + " not found!")) {
        throw new IllegalArgumentException(exception.getMessage());
      } else {
        try {
          result = ImageIO.read(new File(filepath));
        } catch (Exception ioe) {
          throw new IllegalArgumentException(ioe.getMessage());
        }
      }
    }
    return result;
  }

  @Override
  public BufferedImage blur(String filename) throws IllegalArgumentException {
    return this.map(filename, new BlurFunction());
  }

  @Override
  public BufferedImage sharpen(String filename) throws IllegalArgumentException {
    return this.map(filename, new SharpenFunction());
  }

  @Override
  public BufferedImage greyscale(String filename) throws IllegalArgumentException {
    return this.map(filename, new GreyscaleFunction());
  }

  @Override
  public BufferedImage sepia(String filename) throws IllegalArgumentException {
    return this.map(filename, new SepiaFunction());
  }

  @Override
  public void saveImage(String destination, String filename) throws IllegalArgumentException {
    try {
      String[] temp = destination.split("\\.");
      String formatName = temp[temp.length - 1];
      if (formatName.equals("ppm")) {
        super.saveImage(destination, filename);
      } else if (Arrays.asList(ImageIO.getWriterFormatNames()).contains(formatName)) {
        if (!ImageIO.write(this.images.get(filename), formatName, new File(destination))) {
          throw new IllegalArgumentException("Unexpected error occurred when saving");
        }
      } else {
        throw new IllegalArgumentException("Unsupported file format");
      }
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }
}
