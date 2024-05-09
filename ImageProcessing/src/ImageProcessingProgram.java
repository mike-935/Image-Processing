import java.io.FileReader;
import java.io.InputStreamReader;

import controller.BetterImageProcessingControllerImpl;
import controller.ImageProcessingController;
import controller.ImageProcessingGUIController;
import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import view.ImageProcessingGUIViewImpl;
import view.ImageProcessingTextView;
import view.ImageProcessingView;

/**
 * Main class to be run.
 */
public class ImageProcessingProgram {
  /**
   * Main method to be run.
   * @param args command line arguments
   */
  public static void main(String[] args) {
    BetterImageProcessingModel model = new BetterImageProcessingModelImpl();
    ImageProcessingView view = new ImageProcessingTextView(System.out);
    ImageProcessingController controller;
    if (args.length > 0) {
      if (args[0].equals("-file")) {
        try {
          controller = new BetterImageProcessingControllerImpl(model,
                  view,
                  new FileReader(args[1]));
          controller.run();
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if (args[0].equals("-text")) {
        controller = new BetterImageProcessingControllerImpl(model,
                view,
                new InputStreamReader(System.in));
        controller.run();
      }
    } else {
      new ImageProcessingGUIController(model, new ImageProcessingGUIViewImpl());
    }
  }
}
