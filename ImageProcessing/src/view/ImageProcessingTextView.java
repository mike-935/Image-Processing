package view;

import java.io.IOException;

/**
 * Represents a text-based view for an Image Processing Model.
 */
public class ImageProcessingTextView implements ImageProcessingView {
  private final Appendable out;

  /**
   * Construct a ImageProcessingTextView that provides functionality to display to the client.
   * @param out the Appendable object given to the view to append content to.
   * @throws IllegalArgumentException if the given Appendable is null
   */
  public ImageProcessingTextView(Appendable out)
          throws IllegalArgumentException {
    if (out == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.out = out;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.out.append(message);
  }
}
