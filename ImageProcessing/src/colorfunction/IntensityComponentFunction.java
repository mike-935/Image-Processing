package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class is the function object that will be used to obtain the Intensity color,
 * of the given pixel on the given image.
 */
public class IntensityComponentFunction implements ColorFunction {

  /**
   * This will return a new color corresponding to the Intensity of the given pixel
   * on the given image,Meaning that a new color will be made to replace the pixel's current color.
   * The new color being the average of the 3 RGB/component values of the current color.
   *
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    Color color = new Color(image.getRGB(x, y));
    int avgValue = (color.getRed() + color.getBlue() + color.getGreen()) / 3;
    return new Color(avgValue, avgValue, avgValue);
  }
}
