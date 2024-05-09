package controller.commands;

import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageProcessingModel;

/**
 * Represents the BetterSaveImageCommand operation that saves an image with the given name. Images
 * can be saved as a ppm, png, jpg, bmp, webmp, or gif.
 */
public class BetterSaveImageCommand extends AbstractIPCommand {
  /**
   * Constructs a new BetterSaveImageCommand command to be used by a controller.
   * @param destination the destination for the file to be saved to given as a string
   * @param filename the given filename
   */
  public BetterSaveImageCommand(String destination, String filename) {
    super(filename, destination);
  }

  @Override
  public void execute(ImageProcessingModel model) {
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, model.changeBrightness(this.filename, 0));
    betterModel.saveImage(this.newName, this.filename);
  }
}
