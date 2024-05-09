package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the operation to Flip an image vertically to create a new image,
 * referred to henceforth by the given destination name.
 */
public class FlipVerticalCommand extends AbstractIPCommand {
  /**
   * Constructs a new FlipVertical command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public FlipVerticalCommand(String filename, String newName) {
    super(filename, newName);
  }

  /**
   * Executes the flip Vertical command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.put(this.newName, model.flipVertical(this.filename));
  }
}

