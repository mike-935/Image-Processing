package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the BlueChannelCommand operation that creates a greyscale image
 * with the blue-component of the image with the given name, and refer to it henceforth
 * in the program by the given destination name.
 */
public class BlueChannelCommand extends AbstractIPCommand {

  /**
   * Constructs a new BlueChannelCommand command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public BlueChannelCommand(String filename, String newName) {
    super(filename, newName);
  }

  /**
   * Executes the desired command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.put(this.newName, model.getBlueChannel(this.filename));
  }

}

