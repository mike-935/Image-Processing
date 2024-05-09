package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the operation to Flip an image horizontally to create a new image,
 * referred to henceforth by the given destination name.
 */
public class FlipHorizontalCommand extends AbstractIPCommand {

  /**
   * Constructs a new FlipHorizontal command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public FlipHorizontalCommand(String filename, String newName) {
    super(filename, newName);
  }

  /**
   * Executes the flip Horizontal command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.put(this.newName, model.flipHorizontal(this.filename));
  }
}
