package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.BetterImageProcessingModel;
import view.ImageProcessingGUIView;

/**
 * Represents an implementation of an ImageProcessingGUIController that allows a client to utilize
 * a gui to load, process, and save images. The controller operates upon an image,
 * a histogram of the image, the operations supported in the form of buttons,
 * and a list of all the images being operated upon.
 */
public class ImageProcessingGUIController implements ActionListener, ListSelectionListener {

  private final BetterImageProcessingModel model;
  private final ImageProcessingGUIView view;
  private String currentImageName;

  /**
   * Constructs a new ImageProcessingGUIController that will utilize the provided model to modify
   * an image.
   *
   * @param model given model that provides operations to perform upon an image
   * @param view  given view that provides functionality to be displayed too.
   * @throws IllegalArgumentException if arguments are null
   */
  public ImageProcessingGUIController(BetterImageProcessingModel model, ImageProcessingGUIView view)
          throws IllegalArgumentException {
    if (model == null || view == null) {
      throw new IllegalArgumentException("Arguments cannot be null");
    }
    this.model = model;
    this.view = view;
    this.view.setActionListener(this);
    this.view.setListListener(this);
    this.view.makeVisible();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
    String commandName = "-" + e.getActionCommand().split("-")[0];
    JFileChooser fchooser;
    BufferedImage image;
    int retvalue;
    try {
      switch (action) {
        case "load":
          fchooser = new JFileChooser(".");
          FileNameExtensionFilter filter = new FileNameExtensionFilter(
                  "Images", "jpg", "gif", "png", "ppm");
          fchooser.setFileFilter(filter);
          retvalue = fchooser.showOpenDialog(null);
          if (retvalue == JFileChooser.APPROVE_OPTION) {
            File f = fchooser.getSelectedFile();
            image = this.model.load(f.getPath());
            String[] temp = f.getName().split("\\.");
            String name = temp[temp.length - 2];
            this.model.put(name, image);
            this.view.setImage(image);
            this.view.addImageName(name);
            this.currentImageName = name;
          }
          break;
        case "save":
          fchooser = new JFileChooser(".");
          retvalue = fchooser.showSaveDialog(null);
          if (retvalue == JFileChooser.APPROVE_OPTION) {
            File f = fchooser.getSelectedFile();
            this.model.saveImage(f.getPath(), this.currentImageName);
          }
          break;
        case "red-component":
          this.processCommand(commandName, this.model.getRedChannel(this.currentImageName));
          break;
        case "green-component":
          this.processCommand(commandName, this.model.getGreenChannel(this.currentImageName));
          break;
        case "blue-component":
          this.processCommand(commandName, this.model.getBlueChannel(this.currentImageName));
          break;
        case "value-component":
          this.processCommand(commandName, this.model.getValueComponent(this.currentImageName));
          break;
        case "intensity-component":
          this.processCommand(commandName, this.model.getIntensityComponent(this.currentImageName));
          break;
        case "luma-component":
          this.processCommand(commandName, this.model.getLumaComponent(this.currentImageName));
          break;
        case "horizontal-flip":
          this.processCommand(commandName, this.model.flipHorizontal(this.currentImageName));
          break;
        case "vertical-flip":
          this.processCommand(commandName, this.model.flipVertical(this.currentImageName));
          break;
        case "blur":
          this.processCommand(commandName, this.model.blur(this.currentImageName));
          break;
        case "sharpen":
          this.processCommand(commandName, this.model.sharpen(this.currentImageName));
          break;
        case "greyscale":
          this.processCommand(commandName, this.model.greyscale(this.currentImageName));
          break;
        case "sepia":
          this.processCommand(commandName, this.model.sepia(this.currentImageName));
          break;
        case "brighten":
          this.processCommand(commandName + this.view.getBrightenInput(),
                  this.model.changeBrightness(this.currentImageName,
                  this.view.getBrightenInput()));
          break;
        case "darken":
          this.processCommand(commandName + this.view.getDarkenInput(),
                  this.model.changeBrightness(this.currentImageName,
                  -this.view.getDarkenInput()));
          break;
        default:
          this.renderMessage("Unknown command");
          break;
      }
    } catch (Exception exception) {
      this.renderMessage("Error: " + exception.getMessage());
    }
    this.view.refresh();
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    this.currentImageName = this.view.getSelectedImage();
    BufferedImage image = this.model.changeBrightness(this.currentImageName, 0);
    this.view.setImage(image);
    this.view.refresh();
  }

  // Renders a message to the view. Created a private method to not have to write a try-catch block
  // everywhere.
  private void renderMessage(String message) {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void processCommand(String name, BufferedImage image) {
    this.model.put(this.currentImageName + name,
            image);
    this.view.setImage(image);
    this.view.addImageName(this.currentImageName + name);
  }
}
