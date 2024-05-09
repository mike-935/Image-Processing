package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Represents a function object to flip an image vertically.
 */
public class FlipVerticalFunction implements ColorFunction {
  /**
   * Gets the pixel vertically opposite to the one at the specified coordinate.
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    return new Color(image.getRGB(x, (image.getHeight() - 1) - y));
  }
}
