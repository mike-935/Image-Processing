import java.awt.image.BufferedImage;

import model.ImageProcessingModel;

/**
 * Mock model to be used for testing.
 */
public class ImageProcessingModelMock implements ImageProcessingModel {

  private final StringBuilder log;

  public ImageProcessingModelMock(StringBuilder log) {
    this.log = log;
  }

  @Override
  public BufferedImage load(String filepath) throws IllegalArgumentException {
    log.append("load " + filepath + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage getRedChannel(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage getGreenChannel(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage getBlueChannel(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage getValueComponent(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage getIntensityComponent(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage getLumaComponent(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage flipHorizontal(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage flipVertical(String filename) throws IllegalArgumentException {
    log.append(filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public BufferedImage changeBrightness(String filename, int value)
          throws IllegalArgumentException {
    log.append(value + " " + filename + "\n");
    return new BufferedImage(1, 1, 1);
  }

  @Override
  public void saveImage(String destination, String filename) throws IllegalArgumentException {
    log.append("save " + destination + " " + filename + "\n");
  }

  @Override
  public void put(String filename, BufferedImage image) throws IllegalArgumentException {
    log.append("put " + filename + "\n");
  }
}
