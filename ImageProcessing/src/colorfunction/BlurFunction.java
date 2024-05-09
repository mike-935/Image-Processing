package colorfunction;

/**
 * Represents a function object to blur each pixel of an image.
 */
public class BlurFunction extends Filter {

  /**
   * Creates a new BlurFunction.
   */
  public BlurFunction() {
    super(new double[][]{{1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0},
        {1.0 / 8.0, 1.0 / 4.0, 1.0 / 8.0},
        {1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0}});
  }
}
