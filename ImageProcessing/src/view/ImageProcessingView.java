package view;

import java.io.IOException;

/**
 * Represents the functionality offered by a view for an Image Processing Model.
 */
public interface ImageProcessingView {
  /**
   * Renders a message to the provided data destination.
   * @param message message to be transmitted
   * @throws IOException if transmission fails
   */
  void renderMessage(String message) throws IOException;
}
