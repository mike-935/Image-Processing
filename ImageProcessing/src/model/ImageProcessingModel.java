package model;

import java.awt.image.BufferedImage;

/**
 * Represents functionality for processing images.
 *
 * <p>Implementations should store images with distinct names in some way.
 */
public interface ImageProcessingModel {

  /**
   * Creates an image from the given file path.
   * @param filepath the path to the file
   * @return the image at the file path
   * @throws IllegalArgumentException if the given filepath does not exist, or if the given filepath
   *     is not a valid ppm file
   */
  BufferedImage load(String filepath) throws IllegalArgumentException;

  /**
   * Creates an image from the red color channel of the given image.
   * @param filename the image to get the red color channel of
   * @return the red channel as an image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage getRedChannel(String filename) throws IllegalArgumentException;

  /**
   * Creates an image from the green color channel of the given image.
   * @param filename the image to get the green color channel of
   * @return the green channel as an image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage getGreenChannel(String filename) throws IllegalArgumentException;

  /**
   * Creates an image from the blue color channel of the given image.
   * @param filename the image to get the blue color channel of
   * @return the blue channel as an image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage getBlueChannel(String filename) throws IllegalArgumentException;


  /**
   * Creates an image from the maximum value of the three components for each pixel.
   * @param filename the image to get the maximum values from
   * @return the value as an image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage getValueComponent(String filename) throws IllegalArgumentException;


  /**
   * Creates an image based on the average of the three components for each pixel.
   * @param filename the image to get the average intensities from
   * @return the three component average as an image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage getIntensityComponent(String filename) throws IllegalArgumentException;

  /**
   * Creates an image based on luma value that is the weighted sum of the RGB values.
   * @param filename the image to get luma value from
   * @return an image made from the luma value of the given image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage getLumaComponent(String filename) throws IllegalArgumentException;

  /**
   * Flips an image horizontally.
   * @param filename the image to be flipped
   * @return a new image that is flipped horizontally from the given image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage flipHorizontal(String filename) throws IllegalArgumentException;

  /**
   * This will flip the given image vertically.
   * @param filename image to be flipped vertically
   * @return the image after being flipped vertically
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage flipVertical(String filename) throws IllegalArgumentException;

  /**
   * Changes the brightness of the given image by the given value.
   * @param filename the image to change the brightness of
   * @param value the amount to change the brightness
   * @return a new image with the brightness changed by the given amount
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage changeBrightness(String filename, int value) throws IllegalArgumentException;

  /**
   * Saves the image with the given filename to the given destination.
   * @param destination the destination path to which the image will be saved to.
   * @param filename the name of the image that will be saved
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  void saveImage(String destination, String filename) throws IllegalArgumentException;

  /**
   * Stores the given image with the given name.
   * @param filename the name of the image to be stored
   * @param image image that will be stored
   * @throws IllegalArgumentException if the given image is null
   */
  void put(String filename, BufferedImage image) throws IllegalArgumentException;
}
