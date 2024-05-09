package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the load operation that loads an image from the specified path
 * and refer it to henceforth in the program by the given image name.
 */
public class Load extends AbstractIPCommand {

  /**
   * Constructs a new load command to be used by a controller.
   * @param filepath given filepath to load an image to
   * @param filename given filename to refer the file to henceforth
   */
  public Load(String filepath, String filename) {
    super(filepath, filename);
  }

  /**
   * Executes the desired command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.put(this.newName, model.load(this.filename));
  }


}
