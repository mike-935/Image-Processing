package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class is the function object that will be used to obtain the luma color,
 * of the given pixel on the given image.
 */
public class LumaComponentFunction implements ColorFunction {
  /**
   * This will return a new color corresponding to the luma of the given pixel
   * on the given image, meaning that a new color will be made to replace the pixel's current color.
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    Color color = new Color(image.getRGB(x, y));
    int luma = (int)((0.2126 * color.getRed() + 0.7152 * color.getGreen()
            + 0.0722 * color.getBlue()));
    return new Color(luma, luma, luma);
  }

}
