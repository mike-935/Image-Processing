package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the same image operation that saves the image with the given name
 * to the specified path which should include the name of the file.
 */
public class SaveImageCommand extends AbstractIPCommand {

  /**
   * Constructs a new SaveImage command to be used by a controller.
   * @param destination the destination for the file to be saved to given as a string
   * @param filename the given filename
   */
  public SaveImageCommand(String destination, String filename) {
    super(filename, destination);
  }

  /**
   * Executes the SaveImage command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.saveImage(this.newName, this.filename);
  }


}

