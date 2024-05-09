package controller;

import controller.commands.BetterLoadCommand;
import controller.commands.BetterSaveImageCommand;
import controller.commands.BlurCommand;
import controller.commands.GreyscaleCommand;
import controller.commands.SepiaCommand;
import controller.commands.SharpenCommand;
import model.ImageProcessingModel;
import view.ImageProcessingView;

/**
 * Implementation of a better controller for an image processing model with
 * additional functionality.
 */
public class BetterImageProcessingControllerImpl extends ImageProcessingControllerImpl {
  /**
   * Constructs a new ImageProcessingController that will utilize the provided model to modify
   * an image.
   *
   * @param model given model that provides operations to perform upon an image
   * @param view  given view that provides functionality to be displayed too.
   * @throws IllegalArgumentException if arguments are null
   */
  public BetterImageProcessingControllerImpl(ImageProcessingModel model, ImageProcessingView view,
                                             Readable rd) throws IllegalArgumentException {
    super(model, view, rd);
    this.knownCommands.put("blur", s -> new BlurCommand(s.next(), s.next()));
    this.knownCommands.put("sharpen", s -> new SharpenCommand(s.next(), s.next()));
    this.knownCommands.put("sepia", s -> new SepiaCommand(s.next(), s.next()));
    this.knownCommands.put("greyscale", s -> new GreyscaleCommand(s.next(), s.next()));
    this.knownCommands.put("save", s -> new BetterSaveImageCommand(s.next(), s.next()));
    this.knownCommands.put("load", s -> new BetterLoadCommand(s.next(), s.next()));
  }
}
