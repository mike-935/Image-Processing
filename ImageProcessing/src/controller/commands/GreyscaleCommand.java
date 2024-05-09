package controller.commands;

import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageProcessingModel;

/**
 * Represents the GreyscaleCommand operation that greyscales an image with the given name,
 * and refers to it henceforth in the program by the given destination name.
 */
public class GreyscaleCommand extends AbstractIPCommand {
  /**
   * Constructs a new GreyscaleCommand command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public GreyscaleCommand(String filename, String newName) {
    super(filename, newName);
  }

  @Override
  public void execute(ImageProcessingModel model) {
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, model.changeBrightness(this.filename, 0));
    model.put(this.newName, betterModel.greyscale(this.filename));
  }
}
