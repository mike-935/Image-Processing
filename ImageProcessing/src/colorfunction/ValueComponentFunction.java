package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class is the function object that will be used to obtain the Value color,
 * of the given pixel on the given image.
 */
public class ValueComponentFunction implements ColorFunction {
  /**
   * This will return a new color corresponding to the value of the given pixel on the given image,
   * Meaning that a new color will be made to replace the pixel's current color.
   * The new color being the max of the 3 RGB/component values of the current color.
   *
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    Color color = new Color(image.getRGB(x, y));
    int maxValue = Math.max(color.getRed(), Math.max(color.getGreen(), color.getBlue()));
    return new Color(maxValue, maxValue, maxValue);
  }

}
