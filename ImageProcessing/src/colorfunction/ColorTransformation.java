package colorfunction;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Represents a Color transformation that modifies the color of a pixel based on its own color.
 */
public abstract class ColorTransformation implements ColorFunction {
  private final double[][] colorMatrix;

  /**
   * Constructs a new Color Transformation.
   *
   * @param colorMatrix the matrix of ratios to be applied to the pixel
   * @throws IllegalArgumentException if the given matrix is null, or it is not 3 by 3
   */
  public ColorTransformation(double[][] colorMatrix) throws IllegalArgumentException {
    if (colorMatrix == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    if (colorMatrix.length != 3) {
      throw new IllegalArgumentException("Invalid dimensions");
    }
    for (double[] lod : colorMatrix) {
      if (lod.length != 3) {
        throw new IllegalArgumentException("Invalid dimensions");
      }
    }
    this.colorMatrix = colorMatrix;
  }

  @Override
  public Color apply(int x, int y, BufferedImage image) {
    double[] result = new double[3];
    Color color = new Color(image.getRGB(x, y));
    double[] colorAsArray = new double[]{
            color.getRed(),
            color.getGreen(),
            color.getBlue()};
    for (int r = 0; r < this.colorMatrix.length; r += 1) {
      double value = 0;
      for (int c = 0; c < this.colorMatrix[r].length; c += 1) {
        value += this.colorMatrix[r][c] * colorAsArray[c];
      }
      result[r] = value;
    }
    for (int i = 0; i < result.length; i += 1) {
      result[i] = Math.max(0, Math.min(255, result[i]));
    }
    return new Color((int) result[0], (int) result[1], (int) result[2]);
  }
}
