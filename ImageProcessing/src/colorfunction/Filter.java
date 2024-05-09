package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Represents a filter operation to be performed on a specified pixel of a specified image.
 */
public abstract class Filter implements ColorFunction {
  private final double[][] values;

  /**
   * Constructs a new filter with the given odd-dimensioned kernel.
   *
   * @param values the kernel for this filter
   * @throws IllegalArgumentException if the given kernel does not have odd dimensions, if it is
   *                                  null, or if the kernel is not square
   */
  public Filter(double[][] values) throws IllegalArgumentException {
    if (values == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    if (values.length % 2 != 1) {
      throw new IllegalArgumentException("Invalid dimensions");
    }
    for (double[] lod : values) {
      if (lod.length != values.length) {
        throw new IllegalArgumentException("Invalid dimensions");
      }
    }
    this.values = values;
  }

  /**
   * Applies this filter's kernel at the specified location on the given image.
   *
   * @param x     the x position of pixel
   * @param y     the y position of the pixel
   * @param image the image the pixel is on
   * @return a new Color
   */
  @Override
  public Color apply(int x, int y, BufferedImage image) {
    int range = (this.values.length - 1) / 2;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;
    for (int i = 0; i < this.values.length; i += 1) {
      for (int j = 0; j < this.values[i].length; j += 1) {
        int currentPixelX = x + (i - range);
        int currentPixelY = y + (j - range);
        if ((currentPixelX >= 0 && currentPixelX < image.getWidth())
                && (currentPixelY >= 0 && currentPixelY < image.getHeight())) {
          Color color = new Color(image.getRGB(currentPixelX, currentPixelY));
          redValue += (this.values[i][j] * color.getRed());
          greenValue += (this.values[i][j] * color.getGreen());
          blueValue += (this.values[i][j] * color.getBlue());
        }
      }
    }
    redValue = Math.max(0, Math.min(255, redValue));
    greenValue = Math.max(0, Math.min(255, greenValue));
    blueValue = Math.max(0, Math.min(255, blueValue));
    return new Color((int) redValue, (int) greenValue, (int) blueValue);
  }
}
