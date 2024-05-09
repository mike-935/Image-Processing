package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the GreenChannelCommand operation that creates a greyscale image
 * with the green-component of the image with the given name, and refer to it henceforth
 * in the program by the given destination name.
 */
public class GreenChannelCommand extends AbstractIPCommand {
  /**
   * Constructs a new GreenChannelCommand command to be used by a controller.
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public GreenChannelCommand(String filename, String newName) {
    super(filename, newName);
  }

  /**
   * Executes the desired command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.put(this.newName, model.getGreenChannel(this.filename));
  }

}

