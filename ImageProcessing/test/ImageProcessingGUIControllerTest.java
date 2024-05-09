import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.event.ListSelectionEvent;

import controller.ImageProcessingGUIController;
import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import view.ImageProcessingGUIView;
import view.ImageProcessingGUIViewImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Represents the test class to test operations (that can be tested and are our own code)
 * offered by the ImageProcessingGUIController.
 */
public class ImageProcessingGUIControllerTest {

  private ImageProcessingGUIController controller;
  private BetterImageProcessingModel model;
  private ImageProcessingGUIView view;
  private StringBuilder log;

  //to initialize our data.
  @Before
  public void setup() {
    this.log = new StringBuilder();
    this.view = new ImageProcessingGUIViewMock(log);
    this.model = new BetterImageProcessingModelImpl();
    this.controller = new ImageProcessingGUIController(this.model, this.view);
  }

  @Test
  public void actionPerformed() {
    BufferedImage image1 = this.model.load("res/FirstPPM.ppm");
    this.model.put("mock", image1);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Red = this.model.getRedChannel("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "red-component"));
    BufferedImage resultRed = this.model.changeBrightness("mock-red", 0);
    this.test2(image1Red, resultRed);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Green = this.model.getGreenChannel("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "green-component"));
    BufferedImage resultGreen = this.model.changeBrightness("mock-green", 0);
    this.test2(image1Green, resultGreen);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Blue = this.model.getBlueChannel("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "blue-component"));
    BufferedImage resultBlue = this.model.changeBrightness("mock-blue", 0);
    this.test2(image1Blue, resultBlue);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Intensity = this.model.getIntensityComponent("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "intensity-component"));
    BufferedImage resultIntensity = this.model.changeBrightness("mock-intensity", 0);
    this.test2(image1Intensity, resultIntensity);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Luma = this.model.getLumaComponent("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "luma-component"));
    BufferedImage resultLuma = this.model.changeBrightness("mock-luma", 0);
    this.test2(image1Luma, resultLuma);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Value = this.model.getValueComponent("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "value-component"));
    BufferedImage resultValue = this.model.changeBrightness("mock-value", 0);
    this.test2(image1Value, resultValue);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1HorFlip = this.model.flipHorizontal("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "horizontal-flip"));
    BufferedImage resultHorFlip = this.model.changeBrightness("mock-horizontal", 0);
    this.test2(image1HorFlip, resultHorFlip);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1VerFlip = this.model.flipVertical("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "vertical-flip"));
    BufferedImage resultVerFlip = this.model.changeBrightness("mock-vertical", 0);
    this.test2(image1VerFlip, resultVerFlip);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Blur = this.model.blur("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "blur"));
    BufferedImage resultBlur = this.model.changeBrightness("mock-blur", 0);
    this.test2(image1Blur, resultBlur);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Sharpen = this.model.sharpen("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "sharpen"));
    BufferedImage resultSharpen = this.model.changeBrightness("mock-sharpen", 0);
    this.test2(image1Sharpen, resultSharpen);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Greyscale = this.model.greyscale("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "greyscale"));
    BufferedImage resultGreyscale = this.model.changeBrightness("mock-greyscale", 0);
    this.test2(image1Greyscale, resultGreyscale);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1Sepia = this.model.sepia("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "sepia"));
    BufferedImage resultSepia = this.model.changeBrightness("mock-sepia", 0);
    this.test2(image1Sepia, resultSepia);

    String expected = "setActionListener\n" +
            "setListListener\n" +
            "makeVisible\n" +
            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-red\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-green\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-blue\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-intensity\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-luma\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-value\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-horizontal\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-vertical\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-blur\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-sharpen\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-greyscale\nrefresh\n" +

            "getSelectedImage\nsetImage\nrefresh\n" +
            "setImage\naddImageName mock-sepia\nrefresh\n";

    assertEquals(expected, log.toString());

  }

  //to test what happens an unknown command is given
  @Test
  public void testUnknownCommands() {
    BufferedImage image1 = this.model.load("res/FirstPPM.ppm");
    this.model.put("mock", image1);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage irrelevant = this.model.getRedChannel("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "red-irrelevant"));
    String expected = "setActionListener\n" + "setListListener\n" + "makeVisible\n"
            + "getSelectedImage\n" + "setImage\n" + "refresh\n" + "renderMessage Unknown command\n"
            + "refresh\n";
    assertEquals(expected, log.toString());
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "red-component"));

    expected = "setActionListener\n" + "setListListener\n" + "makeVisible\n"
            + "getSelectedImage\n" + "setImage\n" + "refresh\n" + "renderMessage Unknown command\n"
            + "refresh\n" + "setImage\naddImageName mock-red\nrefresh\n";
    assertEquals(expected, log.toString());
  }


  //tests that two images are equivalent
  private boolean test2(BufferedImage image1, BufferedImage image2) {
    for (int i = 0; i < image1.getWidth(); i += 1) {
      for (int j = 0; j < image1.getHeight(); j += 1) {
        assertEquals(image1.getRGB(i, j), image2.getRGB(i, j));
      }
    }
    return true;
  }

  //to test a valid initialization of the constructor
  @Test
  public void testValidConstructor() {
    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1HorFlip = this.model.flipHorizontal("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "horizontal-flip"));
    BufferedImage resultHorFlip = this.model.changeBrightness("mock-horizontal", 0);
    boolean temp = this.test2(image1HorFlip, resultHorFlip);
    assertTrue(temp);

    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    BufferedImage image1VerFlip = this.model.flipVertical("mock");
    this.controller.actionPerformed(new ActionEvent(this.view, 0,
            "vertical-flip"));
    BufferedImage resultVerFlip = this.model.changeBrightness("mock-vertical", 0);
    temp = this.test2(image1VerFlip, resultVerFlip);
    assertTrue(temp);

  }

  //tests an invalid initialization of the constructor.
  @Test
  public void testInvalidConstructor() {
    try {
      BetterImageProcessingModel failModel = new BetterImageProcessingModelImpl();
      ImageProcessingGUIController failController = new ImageProcessingGUIController(failModel,
              null);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      ImageProcessingGUIView failView = new ImageProcessingGUIViewImpl();
      ImageProcessingGUIController failController = new ImageProcessingGUIController(null,
              failView);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      ImageProcessingGUIController failController = new ImageProcessingGUIController(null,
              null);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

  }


  //tests the value changed method
  @Test
  public void valueChanged() {
    this.model.put("mock", new BufferedImage(1, 1, 1));
    this.controller.valueChanged(new ListSelectionEvent(
            this.view, 0, 0, false));
    String expected = "setActionListener\n" +
            "setListListener\n" +
            "makeVisible\ngetSelectedImage\nsetImage\nrefresh\n";
    assertEquals(expected, log.toString());
  }


}