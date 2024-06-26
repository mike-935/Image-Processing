package model;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


/**
 * <<<<<<< HEAD
 * <<<<<<< HEAD
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 * =======
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 * >>>>>>> 6566cef6bcf4b1e1f08b86ab9aeea3c37181068b
 * =======
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 * >>>>>>> 08f97b5045fcd72878548fc1fc174481b621845c
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static BufferedImage readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File " + filename + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    sc.nextInt(); // the max value of this image
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        int rgb = 256 * 256 * r + 256 * g + b;
        image.setRGB(j, i, rgb);
      }
    }
    return image;
  }

  /**
   * Main method to be run.
   * @param args command line arguments
   */
  public static void main(String[] args) {
    String filename;

    if (args.length > 0) {
      filename = args[0];
    } else {
      filename = "sample.ppm";
    }

    ImageUtil.readPPM(filename);
  }
}