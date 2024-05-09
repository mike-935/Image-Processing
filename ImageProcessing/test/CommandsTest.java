import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import controller.commands.BetterLoadCommand;
import controller.commands.BetterSaveImageCommand;
import controller.commands.BlueChannelCommand;
import controller.commands.BlurCommand;
import controller.commands.ChangeBrightnessCommand;
import controller.commands.FlipHorizontalCommand;
import controller.commands.FlipVerticalCommand;
import controller.commands.GreenChannelCommand;
import controller.commands.GreyscaleCommand;
import controller.commands.ImageProcessingCommands;
import controller.commands.IntensityComponentCommand;
import controller.commands.Load;
import controller.commands.LumaComponentCommand;
import controller.commands.RedChannelCommand;
import controller.commands.SaveImageCommand;
import controller.commands.SepiaCommand;
import controller.commands.SharpenCommand;
import controller.commands.ValueComponentCommand;
import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests for commands used by a controller for an image processing model.
 */
public class CommandsTest {

  ImageProcessingModel model;
  ImageProcessingCommands cmd;
  String filename;
  BufferedImage image;

  @Before
  public void init() {
    this.model = new ImageProcessingModelImpl();
    this.model.put("koala", this.model.load("src/Koala.ppm"));
    this.filename = "koala";
  }

  @Test
  public void testBlueChannelCommand() {
    this.cmd = new BlueChannelCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getBlueChannel(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testRedChannelCommand() {
    this.cmd = new RedChannelCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getRedChannel(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testGreenChannelCommand() {
    this.cmd = new GreenChannelCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getGreenChannel(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testValueComponentCommand() {
    this.cmd = new ValueComponentCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getValueComponent(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testIntensityComponentCommand() {
    this.cmd = new IntensityComponentCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getIntensityComponent(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testLumaComponentCommand() {
    this.cmd = new LumaComponentCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getLumaComponent(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testFlipHorizontalCommand() {
    this.cmd = new FlipHorizontalCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.flipHorizontal(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testFlipVerticalCommand() {
    this.cmd = new FlipVerticalCommand("koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.flipVertical(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testChangeBrightnessCommand() {
    this.cmd = new ChangeBrightnessCommand(50, "koala", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.changeBrightness(this.filename, 50);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testLoadCommand() {
    this.cmd = new Load("src/Koala.ppm", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getBlueChannel("koala-new");
    assertEquals(img.getRGB(0, 0),
            this.model.getBlueChannel("koala-new").getRGB(0, 0));
  }

  @Test
  public void testSaveCommand() {
    try {
      Files.deleteIfExists(Paths.get("res/Koala.ppm"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.cmd = new SaveImageCommand("res/Koala.ppm", "koala");
    try {
      this.model.load("res/Koala.ppm");
      fail("File was found before it was saved");
    } catch (IllegalArgumentException e) {
      // continue if exception is thrown
    }
    this.cmd.execute(this.model);
    this.model.load("res/Koala.ppm");
    File file = new File("res/Koala.ppm");
    file.delete();
  }

  @Test
  public void testBetterLoadCommand() {
    this.cmd = new BetterLoadCommand("src/Koala.ppm", "koala-new");
    this.testCommand();
    BufferedImage img = this.model.getBlueChannel("koala-new");
    assertEquals(img.getRGB(0, 0),
            this.model.getBlueChannel("koala-new").getRGB(0, 0));

    this.cmd = new BetterLoadCommand("src/manhattan-small.png", "manhattan-new");
    this.filename = "manhattan";
    this.testCommand();
    img = this.model.getBlueChannel("manhattan-new");
    assertEquals(img.getRGB(0, 0),
            this.model.getBlueChannel("manhattan-new").getRGB(0, 0));
  }

  @Test
  public void testBetterSaveCommand() {
    try {
      Files.deleteIfExists(Paths.get("res/manhattan-small.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      Files.deleteIfExists(Paths.get("res/Koala.ppm"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.cmd = new BetterSaveImageCommand("res/Koala.ppm", "koala");
    try {
      this.model.load("res/Koala.ppm");
      fail("File was found before it was saved");
    } catch (IllegalArgumentException e) {
      // continue if exception is thrown
    }
    this.cmd.execute(this.model);
    this.model.load("res/Koala.ppm");
    File file = new File("res/Koala.ppm");
    file.delete();

    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    this.cmd = new BetterSaveImageCommand("res/manhattan-small.png", "manhattan");
    this.filename = "manhattan";
    this.model.put("manhattan", betterModel.load("src/manhattan-small.png"));
    try {
      betterModel.load("res/manhattan-small.png");
      fail("File was found before it was saved");
    } catch (IllegalArgumentException e) {
      // continue if exception is thrown
    }
    this.cmd.execute(this.model);
    betterModel.load("res/manhattan-small.png");
  }

  @Test
  public void testBlurCommand() {
    this.cmd = new BlurCommand("koala", "koala-new");
    this.testCommand();
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, this.model.changeBrightness(this.filename, 0));
    BufferedImage img = betterModel.blur(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testSharpenCommand() {
    this.cmd = new SharpenCommand("koala", "koala-new");
    this.testCommand();
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, this.model.changeBrightness(this.filename, 0));
    BufferedImage img = betterModel.sharpen(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testGreyscaleCommand() {
    this.cmd = new GreyscaleCommand("koala", "koala-new");
    this.testCommand();
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, this.model.changeBrightness(this.filename, 0));
    BufferedImage img = betterModel.greyscale(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  @Test
  public void testSepiaCommand() {
    this.cmd = new SepiaCommand("koala", "koala-new");
    this.testCommand();
    BetterImageProcessingModel betterModel = new BetterImageProcessingModelImpl();
    betterModel.put(this.filename, this.model.changeBrightness(this.filename, 0));
    BufferedImage img = betterModel.sepia(this.filename);
    for (int i = 0; i < img.getWidth(); i += 1) {
      for (int j = 0; j < img.getHeight(); j += 1) {
        assertEquals(img.getRGB(i, j), this.image.getRGB(i, j));
      }
    }
  }

  private void testCommand() {
    try {
      this.model.getBlueChannel(this.filename + "-new");
      fail("Should have thrown an exception");
    } catch (IllegalArgumentException e) {
      // continue if exception is thrown
    }
    this.cmd.execute(this.model);
    this.image = this.model.changeBrightness(this.filename + "-new", 0);
  }
}
