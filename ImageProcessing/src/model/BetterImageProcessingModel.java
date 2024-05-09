package model;

import java.awt.image.BufferedImage;

/**
 * Represents functionality for processing images.
 *
 * <p>Adds new functionality over an old ImageProcessingModel. Allows for blur, sharpen, greyscale,
 * and sepia along with all previously available operations.
 *
 * <p>Implementations should store images with distinct names in some way.
 */
public interface BetterImageProcessingModel extends ImageProcessingModel {

  /**
   * Creates an image from the given file path.
   * @param filepath the path to the file
   * @return the image at the file path
   * @throws IllegalArgumentException if the given filepath does not exist
   */
  @Override
  BufferedImage load(String filepath) throws IllegalArgumentException;

  /**
   * Applies a blur filter to every channel of every pixel of the specified image.
   * @param filename the name of the image to be blurred
   * @return a new image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage blur(String filename) throws IllegalArgumentException;

  /**
   * Applies a sharpen filter to every channel of every pixel of the specified image, accentuating
   * edges, and giving the image a sharper look.
   * @param filename the name of the image to be sharpened
   * @return a new image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage sharpen(String filename) throws IllegalArgumentException;

  /**
   * Converts a colored image into a greyscale image.
   * @param filename the name of the image to be greyscaled
   * @return a new image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage greyscale(String filename) throws IllegalArgumentException;

  /**
   * Creates an image with a reddish-brown tone.
   * @param filename the name of the image to be sepiad
   * @return a new image
   * @throws IllegalArgumentException if an image with the given filename has not been stored
   */
  BufferedImage sepia(String filename) throws IllegalArgumentException;
}
