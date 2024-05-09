import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import controller.BetterImageProcessingControllerImpl;
import controller.ImageProcessingController;
import model.BetterImageProcessingModel;
import model.BetterImageProcessingModelImpl;
import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;
import view.ImageProcessingTextView;
import view.ImageProcessingView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * To represent the test class for testing the BetterImageProcessingController
 * implementation's functionality.
 */
public class BetterImageProcessingControllerImplTest extends ImageProcessingControllerImplTest {

  private ImageProcessingController controller18;
  private BetterImageProcessingModel model18;
  private ImageProcessingController controller19;
  private BetterImageProcessingModel model19;
  private ImageProcessingController controller20;
  private BetterImageProcessingModel model20;
  private ImageProcessingController controller21;
  private BetterImageProcessingModel model21;
  private ImageProcessingController controller22;
  private BetterImageProcessingModel model22;
  private ImageProcessingController controller23;
  private BetterImageProcessingModel model23;

  @Override
  public void setup() {
    super.setup();
    Readable stringReader1 = new StringReader("q");
    this.controller1 = new BetterImageProcessingControllerImpl(this.model1,this.view1,
            stringReader1);

    Readable stringReader2 = new StringReader("load res/FirstPPM.ppm FirstPPMCopy2 q");
    ImageProcessingView view2 = new ImageProcessingTextView(this.stringBuilder2);
    this.controller2 = new BetterImageProcessingControllerImpl(this.model2, view2,
            stringReader2);

    Readable stringReader3 = new StringReader("red-component FirstPPMCopy3 FirstPPMRedCopy3 q");
    Appendable stringBuilder3 = new StringBuilder();
    ImageProcessingView view3 = new ImageProcessingTextView(stringBuilder3);
    this.model3 = new ImageProcessingModelImpl();
    this.controller3 = new BetterImageProcessingControllerImpl(this.model3, view3,
            stringReader3);

    Readable stringReader4
            = new StringReader("blue-component FirstPPMCopy4 FirstPPMBlueCopy4 q");
    Appendable stringBuilder4 = new StringBuilder();
    ImageProcessingView view4 = new ImageProcessingTextView(stringBuilder4);
    this.model4 = new ImageProcessingModelImpl();
    this.controller4 = new BetterImageProcessingControllerImpl(this.model4, view4,
            stringReader4);

    Readable stringReader5
            = new StringReader("green-component FirstPPMCopy5 FirstPPMGreenCopy5 q");
    Appendable stringBuilder5 = new StringBuilder();
    ImageProcessingView view5 = new ImageProcessingTextView(stringBuilder5);
    this.model5 = new ImageProcessingModelImpl();
    this.controller5 = new BetterImageProcessingControllerImpl(this.model5, view5,
            stringReader5);

    Readable stringReader6
            = new StringReader("horizontal-flip FirstPPMCopy6 FirstPPMFlipHorCopy6 q");
    Appendable stringBuilder6 = new StringBuilder();
    ImageProcessingView view6 = new ImageProcessingTextView(stringBuilder6);
    this.model6 = new ImageProcessingModelImpl();
    this.controller6 = new BetterImageProcessingControllerImpl(this.model6, view6,
            stringReader6);

    Readable stringReader7
            = new StringReader("vertical-flip FirstPPMCopy7 FirstPPMFlipVerCopy7 q");
    Appendable stringBuilder7 = new StringBuilder();
    ImageProcessingView view7 = new ImageProcessingTextView(stringBuilder7);
    this.model7 = new ImageProcessingModelImpl();
    this.controller7 = new BetterImageProcessingControllerImpl(this.model7, view7,
            stringReader7);

    Readable stringReader8
            = new StringReader("intensity-component FirstPPMCopy8 FirstPPMIntensityCopy8 q");
    Appendable stringBuilder8 = new StringBuilder();
    ImageProcessingView view8 = new ImageProcessingTextView(stringBuilder8);
    this.model8 = new ImageProcessingModelImpl();
    this.controller8 = new BetterImageProcessingControllerImpl(this.model8, view8,
            stringReader8);

    Readable stringReader9
            = new StringReader("value-component FirstPPMCopy9 FirstPPMValueCopy9 q");
    Appendable stringBuilder9 = new StringBuilder();
    ImageProcessingView view9 = new ImageProcessingTextView(stringBuilder9);
    this.model9 = new ImageProcessingModelImpl();
    this.controller9 = new BetterImageProcessingControllerImpl(this.model9, view9,
            stringReader9);

    Readable stringReader10
            = new StringReader("luma-component FirstPPMCopy10 FirstPPMLumaCopy10 q");
    Appendable stringBuilder10 = new StringBuilder();
    ImageProcessingView view10 = new ImageProcessingTextView(stringBuilder10);
    this.model10 = new ImageProcessingModelImpl();
    this.controller10 = new BetterImageProcessingControllerImpl(this.model10, view10,
            stringReader10);

    Readable stringReader11 = new StringReader("save res/FirstPPMCopy11.ppm FirstPPM11 q");
    Appendable stringBuilder11 = new StringBuilder();
    ImageProcessingView view11 = new ImageProcessingTextView(stringBuilder11);
    this.model11 = new ImageProcessingModelImpl();
    this.controller11 = new BetterImageProcessingControllerImpl(this.model11, view11,
            stringReader11);

    Readable stringReader12
            = new StringReader("brighten 10 FirstPPMCopy12 FirstPPMBrightenCopy12 q");
    Appendable stringBuilder12 = new StringBuilder();
    ImageProcessingView view12 = new ImageProcessingTextView(stringBuilder12);
    this.model12 = new ImageProcessingModelImpl();
    this.controller12 = new BetterImageProcessingControllerImpl(this.model12, view12,
            stringReader12);

    Readable stringReader13
            = new StringReader("darken 10 FirstPPMCopy13 FirstPPMDarkenCopy13 q");
    Appendable stringBuilder13 = new StringBuilder();
    ImageProcessingView view13 = new ImageProcessingTextView(stringBuilder13);
    this.model13 = new ImageProcessingModelImpl();
    this.controller13 = new BetterImageProcessingControllerImpl(this.model13, view13,
            stringReader13);

    Readable stringReader14
            = new StringReader("brighten 10 FirstPPMCopy14 FirstPPMBrightenCopy14 " +
            "darken 2 FirstPPMBrightenCopy14 FirstPPMDarkenCopy14 q");
    Appendable stringBuilder14 = new StringBuilder();
    ImageProcessingView view14 = new ImageProcessingTextView(stringBuilder14);
    this.model14 = new ImageProcessingModelImpl();
    this.controller14 = new BetterImageProcessingControllerImpl(this.model14, view14,
            stringReader14);

    Readable stringReader15 = new StringReader("move q");
    this.stringBuilder15 = new StringBuilder();
    ImageProcessingView view15 = new ImageProcessingTextView(this.stringBuilder15);
    ImageProcessingModel model15 = new ImageProcessingModelImpl();
    this.controller15 = new BetterImageProcessingControllerImpl(model15, view15,
            stringReader15);

    Readable stringReader16 = new StringReader("move blah blah q");
    this.stringBuilder16 = new StringBuilder();
    ImageProcessingView view16 = new ImageProcessingTextView(this.stringBuilder16);
    ImageProcessingModel model16 = new ImageProcessingModelImpl();
    this.controller16 = new BetterImageProcessingControllerImpl(model16, view16,
            stringReader16);

    Readable stringReader17
            = new StringReader("q red-component FirstPPMCopy17 FirstPPMRedCopy17");
    Appendable stringBuilder17 = new StringBuilder();
    ImageProcessingView view17 = new ImageProcessingTextView(stringBuilder17);
    this.model17 = new ImageProcessingModelImpl();
    this.controller17 = new BetterImageProcessingControllerImpl(this.model17, view17,
            stringReader17);

    Readable stringReader18
            = new StringReader("blur FirstPPMCopy18 FirstPPMBlurCopy18 q");
    Appendable stringBuilder18 = new StringBuilder();
    ImageProcessingView view18 = new ImageProcessingTextView(stringBuilder18);
    this.model18 = new BetterImageProcessingModelImpl();
    this.controller18 = new BetterImageProcessingControllerImpl(this.model18, view18,
            stringReader18);

    Readable stringReader19
            = new StringReader("sharpen FirstPPMCopy19 FirstPPMSharpenCopy19 q");
    Appendable stringBuilder19 = new StringBuilder();
    ImageProcessingView view19 = new ImageProcessingTextView(stringBuilder19);
    this.model19 = new BetterImageProcessingModelImpl();
    this.controller19 = new BetterImageProcessingControllerImpl(this.model19, view19,
            stringReader19);

    Readable stringReader20
            = new StringReader("greyscale FirstPPMCopy20 FirstPPMGreyscaleCopy20 q");
    Appendable stringBuilder20 = new StringBuilder();
    ImageProcessingView view20 = new ImageProcessingTextView(stringBuilder20);
    this.model20 = new BetterImageProcessingModelImpl();
    this.controller20 = new BetterImageProcessingControllerImpl(this.model20, view20,
            stringReader20);

    Readable stringReader21
            = new StringReader("sepia FirstPPMCopy21 FirstPPMSepiaCopy21 q");
    Appendable stringBuilder21 = new StringBuilder();
    ImageProcessingView view21 = new ImageProcessingTextView(stringBuilder21);
    this.model21 = new BetterImageProcessingModelImpl();
    this.controller21 = new BetterImageProcessingControllerImpl(this.model21, view21,
            stringReader21);

    Readable stringReader22
            = new StringReader("load src/manhattan-small.png ManhattanSmall q");
    Appendable stringBuilder22 = new StringBuilder();
    ImageProcessingView view22 = new ImageProcessingTextView(stringBuilder22);
    this.model22 = new BetterImageProcessingModelImpl();
    this.controller22 = new BetterImageProcessingControllerImpl(this.model22, view22,
            stringReader22);

    Readable stringReader23
            = new StringReader("load src/manhattan-small.png ManhattanSmall3 " +
            "save res/manhattan-small3.png ManhattanSmall3 q");
    Appendable stringBuilder23 = new StringBuilder();
    ImageProcessingView view23 = new ImageProcessingTextView(stringBuilder23);
    this.model23 = new BetterImageProcessingModelImpl();
    this.controller23 = new BetterImageProcessingControllerImpl(this.model23, view23,
            stringReader23);

  }

  //to test blur in run
  @Test
  public void testRunBlur() {
    BufferedImage myPPM18 = this.model18.load("res/FirstPPM.ppm");
    this.model18.put("FirstPPM18", myPPM18);
    this.model18.saveImage("res/FirstPPMCopy18.ppm", "FirstPPM18");
    BufferedImage samePPM18 = this.model18.load("res/FirstPPMCopy18.ppm");
    this.model18.put("FirstPPMCopy18", samePPM18);

    for (int i = 0; i < myPPM18.getWidth(); i += 1) {
      for (int j = 0; j < myPPM18.getHeight(); j += 1) {
        assertEquals(myPPM18.getRGB(i, j), samePPM18.getRGB(i, j));
      }
    }

    this.controller18.run();
    BufferedImage myPPM18Blur = this.model18.blur("FirstPPM18");
    this.model18.saveImage("res/FirstPPMBlurCopy18.ppm",
            "FirstPPMBlurCopy18");
    BufferedImage samePPMBlur18 = this.model18.load("res/FirstPPMBlurCopy18.ppm");
    for (int i = 0; i < myPPM18Blur.getWidth(); i += 1) {
      for (int j = 0; j < myPPM18Blur.getHeight(); j += 1) {
        assertEquals(myPPM18Blur.getRGB(i, j), samePPMBlur18.getRGB(i, j));
      }
    }
  }

  //to test the sharpen operation in run
  @Test
  public void testRunSharpen() {
    BufferedImage myPPM19 = this.model19.load("res/FirstPPM.ppm");
    this.model19.put("FirstPPM19", myPPM19);
    this.model19.saveImage("res/FirstPPMCopy19.ppm", "FirstPPM19");
    BufferedImage samePPM19 = this.model19.load("res/FirstPPMCopy19.ppm");
    this.model19.put("FirstPPMCopy19", samePPM19);

    for (int i = 0; i < myPPM19.getWidth(); i += 1) {
      for (int j = 0; j < myPPM19.getHeight(); j += 1) {
        assertEquals(myPPM19.getRGB(i, j), samePPM19.getRGB(i, j));
      }
    }

    this.controller19.run();
    BufferedImage myPPM19Sharpen = this.model19.sharpen("FirstPPM19");
    this.model19.saveImage("res/FirstPPMSharpenCopy19.ppm",
            "FirstPPMSharpenCopy19");
    BufferedImage samePPMSharpen19 = this.model19.load("res/FirstPPMSharpenCopy19.ppm");
    for (int i = 0; i < myPPM19Sharpen.getWidth(); i += 1) {
      for (int j = 0; j < myPPM19Sharpen.getHeight(); j += 1) {
        assertEquals(myPPM19Sharpen.getRGB(i, j), samePPMSharpen19.getRGB(i, j));
      }
    }
  }

  //to test the Greyscale operation in run
  @Test
  public void testRunGreyScale() {
    BufferedImage myPPM20 = this.model20.load("res/FirstPPM.ppm");
    this.model20.put("FirstPPM20", myPPM20);
    this.model20.saveImage("res/FirstPPMCopy20.ppm", "FirstPPM20");
    BufferedImage samePPM20 = this.model20.load("res/FirstPPMCopy20.ppm");
    this.model20.put("FirstPPMCopy20", samePPM20);

    for (int i = 0; i < myPPM20.getWidth(); i += 1) {
      for (int j = 0; j < myPPM20.getHeight(); j += 1) {
        assertEquals(myPPM20.getRGB(i, j), samePPM20.getRGB(i, j));
      }
    }

    this.controller20.run();
    BufferedImage myPPM20Greyscale = this.model20.greyscale("FirstPPM20");
    this.model20.saveImage("res/FirstPPMGreyscaleCopy20.ppm",
            "FirstPPMGreyscaleCopy20");
    BufferedImage samePPMBlur20 = this.model20.load("res/FirstPPMGreyscaleCopy20.ppm");
    for (int i = 0; i < myPPM20Greyscale.getWidth(); i += 1) {
      for (int j = 0; j < myPPM20Greyscale.getHeight(); j += 1) {
        assertEquals(myPPM20Greyscale.getRGB(i, j), samePPMBlur20.getRGB(i, j));
      }
    }
  }

  //to test the sepia operation in run
  @Test
  public void testRunSepia() {
    BufferedImage myPPM21 = this.model21.load("res/FirstPPM.ppm");
    this.model21.put("FirstPPM21", myPPM21);
    this.model21.saveImage("res/FirstPPMCopy21.ppm", "FirstPPM21");
    BufferedImage samePPM21 = this.model21.load("res/FirstPPMCopy21.ppm");
    this.model21.put("FirstPPMCopy21", samePPM21);

    for (int i = 0; i < myPPM21.getWidth(); i += 1) {
      for (int j = 0; j < myPPM21.getHeight(); j += 1) {
        assertEquals(myPPM21.getRGB(i, j), samePPM21.getRGB(i, j));
      }
    }

    this.controller21.run();
    BufferedImage myPPM21Sepia = this.model21.sepia("FirstPPM21");
    this.model21.saveImage("res/FirstPPMSepiaCopy21.ppm",
            "FirstPPMSepiaCopy21");
    BufferedImage samePPMSepia21 = this.model21.load("res/FirstPPMSepiaCopy21.ppm");
    for (int i = 0; i < myPPM21Sepia.getWidth(); i += 1) {
      for (int j = 0; j < myPPM21Sepia.getHeight(); j += 1) {
        assertEquals(myPPM21Sepia.getRGB(i, j), myPPM21Sepia.getRGB(i, j));
      }
    }
  }

  //to test the new save that can work on multiple file types, specifically testing with pngs here
  @Test
  public void testRunBetterSave() {
    try {
      Files.deleteIfExists(Paths.get("res/manhattan-small3.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    BufferedImage myPNG23 = this.model23.load("src/manhattan-small.png");
    this.model23.put("ManhattanSmallCopy", myPNG23);

    try {
      BufferedImage failPNG = this.model23.load("res/manhattan-small3.png");
      //this should fail because this image hasn't been saved yet
      fail("Fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    this.controller23.run();
    //Now this works because it has been saved and so it can be loaded
    BufferedImage png23 = this.model23.load("res/manhattan-small3.png");

    for (int i = 0; i < myPNG23.getWidth(); i += 1) {
      for (int j = 0; j < myPNG23.getHeight(); j += 1) {
        assertEquals(myPNG23.getRGB(i, j), png23.getRGB(i, j));
      }
    }

  }

  //to test the new load that can work on multiple file types, specifically testing with pngs here
  @Test
  public void testRubBetterLoad() {
    BufferedImage myPPM22 = this.model22.load("src/manhattan-small.png");
    this.model22.put("ManhattanSmallCopy", myPPM22);
    try {
      this.model22.sepia("ManhattanSmall");
      //this should fail because ManhattanSmall doesn't exist
      fail("Fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    //This won't throw an exception because this exists
    BufferedImage mySepiaCopy = this.model22.sepia("ManhattanSmallCopy");

    this.controller22.run();

    //now doesn't crash because it exists
    BufferedImage mySepia = this.model22.sepia("ManhattanSmall");

    for (int i = 0; i < mySepia.getWidth(); i += 1) {
      for (int j = 0; j < mySepia.getHeight(); j += 1) {
        assertEquals(mySepia.getRGB(i, j), mySepiaCopy.getRGB(i, j));
      }
    }
  }

  //to test a valid initialization of the constructor and that it doesn't crash when used
  @Test
  public void testValidBetterConstructor() {
    BufferedImage myPPM18 = this.model18.load("res/FirstPPM.ppm");
    this.model18.put("FirstPPM18", myPPM18);
    this.model18.saveImage("res/FirstPPMCopy18.ppm", "FirstPPM18");
    BufferedImage samePPM18 = this.model18.load("res/FirstPPMCopy18.ppm");
    this.model18.put("FirstPPMCopy18", samePPM18);

    for (int i = 0; i < myPPM18.getWidth(); i += 1) {
      for (int j = 0; j < myPPM18.getHeight(); j += 1) {
        assertEquals(myPPM18.getRGB(i, j), samePPM18.getRGB(i, j));
      }
    }

    this.controller18.run();

    BufferedImage myPPM19 = this.model19.load("res/FirstPPM.ppm");
    this.model19.put("FirstPPM19", myPPM19);
    this.model19.saveImage("res/FirstPPMCopy19.ppm", "FirstPPM19");
    BufferedImage samePPM19 = this.model19.load("res/FirstPPMCopy19.ppm");
    this.model19.put("FirstPPMCopy19", samePPM19);

    for (int i = 0; i < myPPM19.getWidth(); i += 1) {
      for (int j = 0; j < myPPM19.getHeight(); j += 1) {
        assertEquals(myPPM19.getRGB(i, j), samePPM19.getRGB(i, j));
      }
    }

    this.controller19.run();
  }

  //to test an invalid initialization of the constructor
  @Test
  public void testInvalidBetterConstructor() {
    try {
      StringReader failRead1 = new StringReader("q");
      StringBuilder failBuild1 = new StringBuilder();
      ImageProcessingView failView1 = new ImageProcessingTextView(failBuild1);
      ImageProcessingController failController1
              = new BetterImageProcessingControllerImpl(null, failView1,
              failRead1);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      StringReader failRead2 = new StringReader("q");
      StringBuilder failBuild2 = new StringBuilder();
      ImageProcessingModel failModel2 = new ImageProcessingModelImpl();
      ImageProcessingController failController2 =
              new BetterImageProcessingControllerImpl(failModel2,
              null, failRead2);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      StringBuilder failBuild3 = new StringBuilder();
      ImageProcessingView failView3 = new ImageProcessingTextView(failBuild3);
      ImageProcessingModel failModel3 = new ImageProcessingModelImpl();
      ImageProcessingController failController3 =
              new BetterImageProcessingControllerImpl(failModel3,
              failView3, null);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      ImageProcessingController failController4 =
              new BetterImageProcessingControllerImpl(null,
              null, null);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

  }






}