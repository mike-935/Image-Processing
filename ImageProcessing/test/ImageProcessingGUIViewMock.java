import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.event.ListSelectionListener;

import view.ImageProcessingGUIView;

/**
 * Represents a mock gui view to be used for testing.
 */
public class ImageProcessingGUIViewMock implements ImageProcessingGUIView {

  private final StringBuilder log;

  /**
   * Constructor for a mock gui view.
   * @param log the log to be written to when methods are called
   */
  public ImageProcessingGUIViewMock(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void setImage(BufferedImage image) {
    log.append("setImage\n");
  }

  @Override
  public int getBrightenInput() throws IllegalStateException {
    log.append("brighten\n");
    return 0;
  }

  @Override
  public int getDarkenInput() throws IllegalStateException {
    log.append("darken\n");
    return 0;
  }

  @Override
  public void setActionListener(ActionListener listener) {
    log.append("setActionListener\n");
  }

  @Override
  public void setListListener(ListSelectionListener listener) {
    log.append("setListListener\n");
  }

  @Override
  public void addImageName(String name) {
    log.append("addImageName ").append(name).append("\n");
  }

  @Override
  public void makeVisible() {
    log.append("makeVisible\n");
  }

  @Override
  public void refresh() {
    log.append("refresh\n");
  }

  @Override
  public String getSelectedImage() {
    log.append("getSelectedImage\n");
    return "mock";
  }

  @Override
  public void renderMessage(String message) throws IOException {
    log.append("renderMessage ").append(message).append("\n");
  }
}
