package controller.commands;

import model.ImageProcessingModel;

/**
 * Command that represent the operation that provides the ability to change the brightness
 * (either darken or lighten) of an image.
 */
public class ChangeBrightnessCommand extends AbstractIPCommand {
  private final int value;

  /**
   * Constructs a new ChangeBrightness command that is used by the controller.
   * @param value the int value that the image's brightness will be changed by
   * @param filename name of the image to be modified
   * @param newName name that the modified image will be stored as
   */
  public ChangeBrightnessCommand(int value, String filename, String newName) {
    super(filename, newName);
    this.value = value;
  }

  /**
   * Executes the changeBrightness command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  @Override
  public void execute(ImageProcessingModel model) {
    model.put(this.newName, model.changeBrightness(this.filename, this.value));
  }


}

