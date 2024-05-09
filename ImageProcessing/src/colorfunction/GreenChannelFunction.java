package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * This class is the function object that will be used to obtain the green channel color,
 * of the given pixel on the given image.
 */
public class GreenChannelFunction implements ColorFunction {

  /**
   * Converts the pixel at the specified coordinate on the image to a greyscale color with the value
   * of the green channel of that pixel.
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    Color color = new Color(image.getRGB(x, y));
    int greenValue = color.getGreen();
    return new Color(greenValue, greenValue, greenValue);
  }
}
