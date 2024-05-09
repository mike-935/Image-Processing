package colorfunction;

/**
 * Represents a function object to sharpen each pixel of an image.
 */
public class SharpenFunction extends Filter {

  /**
   * Creates a new SharpenFunction.
   */
  public SharpenFunction() {
    super(new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, 0.25, 1.0, 0.25, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, -0.125, -0.125, -0.125, -0.125}});
  }
}
