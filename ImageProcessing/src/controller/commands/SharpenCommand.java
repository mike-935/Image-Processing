package controller.commands;

import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageProcessingModel;

/**
 * Represents the SharpenCommand operation that sharpens an image with the given name,
 * and refers to it henceforth in the program by the given destination name.
 */
public class SharpenCommand extends AbstractIPCommand {
  /**
   * Constructs a new SharpenCommand command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public SharpenCommand(String filename, String newName) {
    super(filename, newName);
  }

  @Override
  public void execute(ImageProcessingModel model) {
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, model.changeBrightness(this.filename, 0));
    model.put(this.newName, betterModel.sharpen(this.filename));
  }
}
