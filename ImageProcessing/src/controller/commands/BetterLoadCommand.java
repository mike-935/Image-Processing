package controller.commands;

import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageProcessingModel;

/**
 * Represents the BetterLoadCommand operation that loads an image at the given filepath and
 * refer it to henceforth in the program by the given image name.
 */
public class BetterLoadCommand extends AbstractIPCommand {
  /**
   * Constructs a new BetterLoadCommand command to be used by a controller.
   * @param filepath given filepath to load an image to
   * @param filename given filename to refer the file to henceforth
   */
  public BetterLoadCommand(String filepath, String filename) {
    super(filepath, filename);
  }

  /**
   * Executes the desired command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    model.put(this.newName, betterModel.load(this.filename));
  }
}
