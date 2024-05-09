package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the RedChannelCommand operation that creates a greyscale image
 * with the red-component of the image with the given name, and refer to it henceforth
 * in the program by the given destination name.
 */
public class RedChannelCommand extends AbstractIPCommand {
  /**
   * Constructs a new RedChannelCommand command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public RedChannelCommand(String filename, String newName) {
    super(filename, newName);
  }

  /**
   * Executes the desired command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.put(this.newName, model.getRedChannel(this.filename));
  }

}
