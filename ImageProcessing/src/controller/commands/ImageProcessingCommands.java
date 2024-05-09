package controller.commands;

import model.ImageProcessingModel;

/**
 * Represents commands that will be utilized by an ImageProcessingController to perform operations
 * provided by an ImageProcessingModel.
 */
public interface ImageProcessingCommands {

  /**
   * Executes the desired command provided by a given ImageProcessing Model to an image.
   * @param model given model that provides functionality
   */
  void execute(ImageProcessingModel model);

}
