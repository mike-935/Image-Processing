package controller.commands;

import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageProcessingModel;

/**
 * Represents the BlurCommand operation that blurs an image with the given name,
 * and refers to it henceforth in the program by the given destination name.
 */
public class BlurCommand extends AbstractIPCommand {

  /**
   * Constructs a new BlurCommand command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public BlurCommand(String filename, String newName) {
    super(filename, newName);
  }

  @Override
  public void execute(ImageProcessingModel model) {
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, model.changeBrightness(this.filename, 0));
    model.put(this.newName, betterModel.blur(this.filename));
  }
}
