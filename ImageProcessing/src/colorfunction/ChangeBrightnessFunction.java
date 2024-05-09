package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Represents a function object to change the brightness of a pixel on an image.
 */
public class ChangeBrightnessFunction implements ColorFunction {

  private final int change;

  /**
   * Constructs a new ChangeBrightnessFunction.
   * @param change the amount for each rgb value to change
   */
  public ChangeBrightnessFunction(int change) {
    this.change = change;
  }

  /**
   * Converts the pixel at the specified coordinate on the image to a color with a different
   * brightness offset by this function's 'change.'
   * @param x the x position of pixel
   * @param y the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    Color color = new Color(image.getRGB(x, y));
    int redValue = Math.max(0, Math.min(255, color.getRed() + this.change));
    int greenValue = Math.max(0, Math.min(255, color.getGreen() + this.change));
    int blueValue = Math.max(0, Math.min(255, color.getBlue() + this.change));
    return new Color(redValue, greenValue, blueValue);
  }
}
