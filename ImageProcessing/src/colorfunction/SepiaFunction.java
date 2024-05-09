package colorfunction;

/**
 * This class is the function object that will be used to obtain the sepia tone,
 * of the given pixel on the given image.
 */
public class SepiaFunction extends ColorTransformation {
  /**
   * Constructs a new SepiaFunction.
   */
  public SepiaFunction() {
    super(new double[][]{{0.393, 0.769, 0.189},
        {0.349, 0.686, 0.168},
        {0.272, 0.534, 0.131}});
  }
}
