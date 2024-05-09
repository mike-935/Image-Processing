import org.junit.Test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for a BetterImageProcessingModelImpl.
 */
public class BetterImageProcessingModelImplTest extends ImageProcessingModelImplTest {

  private BetterImageProcessingModel betterModel;

  @Override
  public void init() {
    this.betterModel = new BetterImageProcessingModelImpl();
    this.model = this.betterModel;
  }

  @Test
  public void load() {
    try {
      BufferedImage expected = ImageIO.read(new File("src/manhattan-small.png"));
      BufferedImage actual = this.betterModel.load("src/manhattan-small.png");
      for (int i = 0; i < actual.getWidth(); i += 1) {
        for (int j = 0; j < actual.getHeight(); j += 1) {
          assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
        }
      }
      expected = ImageUtil.readPPM("src/Koala.ppm");
      actual = this.betterModel.load("src/Koala.ppm");
      for (int i = 0; i < actual.getWidth(); i += 1) {
        for (int j = 0; j < actual.getHeight(); j += 1) {
          assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void blur() {
    BufferedImage koala = this.betterModel.load("src/Koala.ppm");
    this.betterModel.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    double[][] filterValues = new double[][]{{1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0},
        {1.0 / 8.0, 1.0 / 4.0, 1.0 / 8.0},
        {1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0}};
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        for (int c = 0; c < 3; c += 1) {
          for (int r = 0; r < 3; r += 1) {
            int currentX = i - (c - 1);
            int currentY = j - (r - 1);
            if (currentX >= 0 && currentX < koala.getWidth()
                    && currentY >= 0 && currentY < koala.getHeight()) {
              Color color = new Color(koala.getRGB(currentX, currentY));
              redValue += filterValues[c][r] * color.getRed();
              greenValue += filterValues[c][r] * color.getGreen();
              blueValue += filterValues[c][r] * color.getBlue();
            }
          }
        }
        redValue = Math.max(0, Math.min(255, redValue));
        greenValue = Math.max(0, Math.min(255, greenValue));
        blueValue = Math.max(0, Math.min(255, blueValue));
        expected.setRGB(i, j,
                new Color((int) redValue, (int) greenValue, (int) blueValue).getRGB());
        redValue = 0;
        greenValue = 0;
        blueValue = 0;
      }
    }

    BufferedImage actual = this.betterModel.blur("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }
  }

  @Test
  public void sharpen() {
    BufferedImage koala = this.betterModel.load("src/Koala.ppm");
    this.betterModel.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    double[][] filterValues = new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, 0.25, 1.0, 0.25, -0.125},
        {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, -0.125, -0.125, -0.125, -0.125}};
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        for (int c = 0; c < 5; c += 1) {
          for (int r = 0; r < 5; r += 1) {
            int currentX = i - (c - 2);
            int currentY = j - (r - 2);
            if (currentX >= 0 && currentX < koala.getWidth()
                    && currentY >= 0 && currentY < koala.getHeight()) {
              Color color = new Color(koala.getRGB(currentX, currentY));
              redValue += filterValues[c][r] * color.getRed();
              greenValue += filterValues[c][r] * color.getGreen();
              blueValue += filterValues[c][r] * color.getBlue();
            }
          }
        }
        redValue = Math.max(0, Math.min(255, redValue));
        greenValue = Math.max(0, Math.min(255, greenValue));
        blueValue = Math.max(0, Math.min(255, blueValue));
        expected.setRGB(i, j,
                new Color((int) redValue, (int) greenValue, (int) blueValue).getRGB());
        redValue = 0;
        greenValue = 0;
        blueValue = 0;
      }
    }

    BufferedImage actual = this.betterModel.sharpen("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }
  }

  @Test
  public void greyscale() {
    BufferedImage koala = this.betterModel.load("src/Koala.ppm");
    this.betterModel.put("koala", koala);
    BufferedImage expected = this.betterModel.getLumaComponent("koala");
    BufferedImage actual = this.betterModel.greyscale("koala");
    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }
  }

  @Test
  public void sepia() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int redValue = (int) Math.max(0, Math.min(255, color.getRed() * 0.393
                + color.getGreen() * 0.769
                + color.getBlue() * 0.189));
        int greenValue = (int) Math.max(0, Math.min(255, color.getRed() * 0.349
                + color.getGreen() * 0.686
                + color.getBlue() * 0.168));
        int blueValue = (int) Math.max(0, Math.min(255, color.getRed() * 0.272
                + color.getGreen() * 0.534
                + color.getBlue() * 0.131));
        expected.setRGB(i, j, new Color(redValue, greenValue, blueValue).getRGB());
      }
    }

    BufferedImage actual = this.betterModel.sepia("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }
  }

  @Test
  public void saveImage() {
    try {
      Files.deleteIfExists(Paths.get("res/manhattan-small.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    BufferedImage koala = this.betterModel.load("src/Koala.ppm");
    this.betterModel.put("koala", koala);
    try {
      this.betterModel.load("res/Koala.ppm");
      fail("File was found before it was saved");
    } catch (IllegalArgumentException e) {
      // continue if exception is thrown
    }
    this.betterModel.saveImage("res/Koala.ppm", "koala");
    this.betterModel.load("res/Koala.ppm");
    File file = new File("res/Koala.ppm");
    file.delete();


    this.betterModel.put("manhattan", this.betterModel.load("src/manhattan-small.png"));
    try {
      this.betterModel.load("res/manhattan-small.png");
      fail("File was found before it was saved");
    } catch (IllegalArgumentException e) {
      // continue if exception is thrown
    }
    this.betterModel.saveImage("res/manhattan-small.png", "manhattan");
    betterModel.load("res/manhattan-small.png");
  }
}