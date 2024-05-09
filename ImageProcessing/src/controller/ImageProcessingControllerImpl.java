package controller;

import controller.commands.ImageProcessingCommands;
import controller.commands.BlueChannelCommand;
import controller.commands.ChangeBrightnessCommand;
import controller.commands.FlipHorizontalCommand;
import controller.commands.FlipVerticalCommand;
import controller.commands.GreenChannelCommand;
import controller.commands.IntensityComponentCommand;
import controller.commands.Load;
import controller.commands.LumaComponentCommand;
import controller.commands.RedChannelCommand;
import controller.commands.SaveImageCommand;
import controller.commands.ValueComponentCommand;
import model.ImageProcessingModel;
import view.ImageProcessingView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Represents an implementation of a controller for an ImageProcessingModel.
 */
public class ImageProcessingControllerImpl implements ImageProcessingController {

  private final ImageProcessingModel model;
  private final ImageProcessingView view;
  private final Readable rd;
  protected final Map<String, Function<Scanner, ImageProcessingCommands>> knownCommands;

  /**
   * Constructs a new ImageProcessingController that will utilize the provided model to modify
   * an image.
   *
   * @param model given model that provides operations to perform upon an image
   * @param view  given view that provides functionality to be displayed too.
   * @throws IllegalArgumentException if arguments are null
   */
  public ImageProcessingControllerImpl(ImageProcessingModel model, ImageProcessingView view,
                                       Readable rd) throws IllegalArgumentException {
    if (model == null || view == null || rd == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.model = model;
    this.view = view;
    this.rd = rd;
    this.knownCommands = new HashMap<String, Function<Scanner, ImageProcessingCommands>>();
    this.knownCommands.put("load", s -> new Load(s.next(), s.next()));
    this.knownCommands.put("red-component", s -> new RedChannelCommand(s.next(), s.next()));
    this.knownCommands.put("green-component", s -> new GreenChannelCommand(s.next(), s.next()));
    this.knownCommands.put("blue-component", s -> new BlueChannelCommand(s.next(), s.next()));

    this.knownCommands.put("horizontal-flip", s -> new FlipHorizontalCommand(s.next(), s.next()));
    this.knownCommands.put("vertical-flip", s -> new FlipVerticalCommand(s.next(), s.next()));
    this.knownCommands.put("intensity-component", s -> new IntensityComponentCommand(s.next(),
            s.next()));
    this.knownCommands.put("value-component", s -> new ValueComponentCommand(s.next(), s.next()));
    this.knownCommands.put("luma-component", s -> new LumaComponentCommand(s.next(), s.next()));
    this.knownCommands.put("save", s -> new SaveImageCommand(s.next(), s.next()));

    this.knownCommands.put("brighten", s -> new ChangeBrightnessCommand(s.nextInt(), s.next(),
            s.next()));
    this.knownCommands.put("darken", s -> new ChangeBrightnessCommand(-s.nextInt(), s.next(),
            s.next()));

  }


  @Override
  public void run() {
    Scanner sc = new Scanner(rd);
    while (sc.hasNext()) {
      ImageProcessingCommands i;
      String in = sc.next();
      if (in.equalsIgnoreCase("q") || in.equalsIgnoreCase("quit")) {
        return;
      }
      Function<Scanner, ImageProcessingCommands> cmd =
              knownCommands.getOrDefault(in, null);
      if (cmd == null) {
        this.renderMessage("Unknown command! Please try again.\n");
      } else {
        try {
          this.renderMessage("Please wait, this may take a while...\n");
          i = cmd.apply(sc);
          i.execute(model);
          this.renderMessage("Command successfully executed!\n");
        } catch (RuntimeException e) {
          this.renderMessage("Error: " + e.getMessage() + ". Please try again.\n");
        }
      }
    }
  }

  // Renders a message to the view. Created a private method to not have to write a try-catch block
  // everywhere.
  protected void renderMessage(String message) {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
