package colorfunction;

/**
 * Represents a function object to greyscale each pixel of an image.
 */
public class GreyscaleFunction extends ColorTransformation {
  /**
   * Constructs a new GreyscaleFunction.
   */
  public GreyscaleFunction() {
    super(new double[][]{{0.2126, 0.7152, 0.0722},
        {0.2126, 0.7152, 0.0722},
        {0.2126, 0.7152, 0.0722}});
  }
}
