package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Represents a function object to change a pixel on an image.
 */
public interface ColorFunction {

  /**
   * This method takes in an x,y pixel position as well as an image and produces a new color
   * after performing an operation on the pixel at that position. This operation will change for
   * each implementation.
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new color
   */
  Color apply(int x, int y, BufferedImage image);
}
