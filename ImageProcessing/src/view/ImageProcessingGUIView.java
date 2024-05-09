package view;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.event.ListSelectionListener;

/**
 * Represents a Graphical User Interface for performing operations on an image.
 * There should be a place to input an amount to brighten or darken an image.
 */
public interface ImageProcessingGUIView extends ImageProcessingView {
  /**
   * Set the image that is currently being worked on.
   * @param image the image to be displayed
   */
  void setImage(BufferedImage image);

  /**
   * Gets what is set to brighten an image by.
   * @return the number to brighten the image by
   * @throws IllegalStateException if the amount to change by is not an integer
   */
  int getBrightenInput() throws IllegalStateException;

  /**
   * Gets what is set to darken an image by.
   * @return the number to darken the image by
   * @throws IllegalStateException if the amount to change by is not an integer
   */
  int getDarkenInput() throws IllegalStateException;

  /**
   * Sets the listener to be used for any actions.
   * @param listener the listener to be set
   */
  void setActionListener(ActionListener listener);

  /**
   * Sets the listener to be used by any lists.
   * @param listener the listener to be set
   */
  void setListListener(ListSelectionListener listener);

  /**
   * Adds the given name to a list of created images if it is not already present.
   * @param name the name to be added.
   */
  void addImageName(String name);

  /**
   * Makes this view visible.
   */
  void makeVisible();

  /**
   * Refreshes this view.
   */
  void refresh();

  /**
   * Gets the name of the selected image.
   * @return the name of the selected image as a string.
   */
  String getSelectedImage();
}
