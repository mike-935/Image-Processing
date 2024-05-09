package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Represents a function object to flip an image horizontally.
 */
public class FlipHorizontalFunction implements ColorFunction {
  /**
   * Gets the pixel horizontally opposite to the one at the specified coordinate.
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    return new Color(image.getRGB((image.getWidth() - 1) - x, y));
  }
}
