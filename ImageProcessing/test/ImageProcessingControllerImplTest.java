import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.StringReader;

import model.ImageProcessingModelImpl;
import view.ImageProcessingView;
import view.ImageProcessingTextView;
import controller.ImageProcessingController;
import controller.ImageProcessingControllerImpl;

import model.ImageProcessingModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * To represent the tests for an ImageProcessingControllerImpl.
 */
public class ImageProcessingControllerImplTest {
  protected ImageProcessingController controller1;
  protected ImageProcessingView view1;
  protected ImageProcessingModel model1;
  protected ImageProcessingController controller2;
  protected ImageProcessingModel model2;
  protected Appendable stringBuilder2;
  protected ImageProcessingController controller3;
  protected ImageProcessingModel model3;
  protected ImageProcessingController controller4;
  protected ImageProcessingModel model4;
  protected ImageProcessingController controller5;
  protected ImageProcessingModel model5;
  protected ImageProcessingController controller6;
  protected ImageProcessingModel model6;
  protected ImageProcessingController controller7;
  protected ImageProcessingModel model7;
  protected ImageProcessingController controller8;
  protected ImageProcessingModel model8;
  protected ImageProcessingController controller9;
  protected ImageProcessingModel model9;
  protected ImageProcessingController controller10;
  protected ImageProcessingModel model10;
  protected ImageProcessingController controller11;
  protected ImageProcessingModel model11;
  protected ImageProcessingController controller12;
  protected ImageProcessingModel model12;
  protected ImageProcessingController controller13;
  protected ImageProcessingModel model13;
  protected ImageProcessingController controller14;
  protected ImageProcessingModel model14;
  protected ImageProcessingController controller15;
  protected Appendable stringBuilder15;
  protected ImageProcessingController controller16;
  protected Appendable stringBuilder16;
  protected ImageProcessingController controller17;
  protected ImageProcessingModel model17;


  @Before
  public void setup() {
    Readable stringReader1 = new StringReader("q");
    Appendable stringBuilder1 = new StringBuilder();
    this.view1 = new ImageProcessingTextView(stringBuilder1);
    this.model1 = new ImageProcessingModelImpl();
    this.controller1 = new ImageProcessingControllerImpl(this.model1,this.view1,
            stringReader1);
    Readable stringReader2 = new StringReader("load res/FirstPPM.ppm FirstPPMCopy2 q");
    this.stringBuilder2 = new StringBuilder();
    ImageProcessingView view2 = new ImageProcessingTextView(this.stringBuilder2);
    this.model2 = new ImageProcessingModelImpl();
    this.controller2 = new ImageProcessingControllerImpl(this.model2, view2,
            stringReader2);

    Readable stringReader3 = new StringReader("red-component FirstPPMCopy3 FirstPPMRedCopy3 q");
    Appendable stringBuilder3 = new StringBuilder();
    ImageProcessingView view3 = new ImageProcessingTextView(stringBuilder3);
    this.model3 = new ImageProcessingModelImpl();
    this.controller3 = new ImageProcessingControllerImpl(this.model3, view3,
            stringReader3);

    Readable stringReader4
            = new StringReader("blue-component FirstPPMCopy4 FirstPPMBlueCopy4 q");
    Appendable stringBuilder4 = new StringBuilder();
    ImageProcessingView view4 = new ImageProcessingTextView(stringBuilder4);
    this.model4 = new ImageProcessingModelImpl();
    this.controller4 = new ImageProcessingControllerImpl(this.model4, view4,
            stringReader4);

    Readable stringReader5
            = new StringReader("green-component FirstPPMCopy5 FirstPPMGreenCopy5 q");
    Appendable stringBuilder5 = new StringBuilder();
    ImageProcessingView view5 = new ImageProcessingTextView(stringBuilder5);
    this.model5 = new ImageProcessingModelImpl();
    this.controller5 = new ImageProcessingControllerImpl(this.model5, view5,
            stringReader5);

    Readable stringReader6
            = new StringReader("horizontal-flip FirstPPMCopy6 FirstPPMFlipHorCopy6 q");
    Appendable stringBuilder6 = new StringBuilder();
    ImageProcessingView view6 = new ImageProcessingTextView(stringBuilder6);
    this.model6 = new ImageProcessingModelImpl();
    this.controller6 = new ImageProcessingControllerImpl(this.model6, view6,
            stringReader6);

    Readable stringReader7
            = new StringReader("vertical-flip FirstPPMCopy7 FirstPPMFlipVerCopy7 q");
    Appendable stringBuilder7 = new StringBuilder();
    ImageProcessingView view7 = new ImageProcessingTextView(stringBuilder7);
    this.model7 = new ImageProcessingModelImpl();
    this.controller7 = new ImageProcessingControllerImpl(this.model7, view7,
            stringReader7);

    Readable stringReader8
            = new StringReader("intensity-component FirstPPMCopy8 FirstPPMIntensityCopy8 q");
    Appendable stringBuilder8 = new StringBuilder();
    ImageProcessingView view8 = new ImageProcessingTextView(stringBuilder8);
    this.model8 = new ImageProcessingModelImpl();
    this.controller8 = new ImageProcessingControllerImpl(this.model8, view8,
            stringReader8);

    Readable stringReader9
            = new StringReader("value-component FirstPPMCopy9 FirstPPMValueCopy9 q");
    Appendable stringBuilder9 = new StringBuilder();
    ImageProcessingView view9 = new ImageProcessingTextView(stringBuilder9);
    this.model9 = new ImageProcessingModelImpl();
    this.controller9 = new ImageProcessingControllerImpl(this.model9, view9,
            stringReader9);

    Readable stringReader10
            = new StringReader("luma-component FirstPPMCopy10 FirstPPMLumaCopy10 q");
    Appendable stringBuilder10 = new StringBuilder();
    ImageProcessingView view10 = new ImageProcessingTextView(stringBuilder10);
    this.model10 = new ImageProcessingModelImpl();
    this.controller10 = new ImageProcessingControllerImpl(this.model10, view10,
            stringReader10);

    Readable stringReader11 = new StringReader("save res/FirstPPMCopy11.ppm FirstPPM11 q");
    Appendable stringBuilder11 = new StringBuilder();
    ImageProcessingView view11 = new ImageProcessingTextView(stringBuilder11);
    this.model11 = new ImageProcessingModelImpl();
    this.controller11 = new ImageProcessingControllerImpl(this.model11, view11,
            stringReader11);

    Readable stringReader12
            = new StringReader("brighten 10 FirstPPMCopy12 FirstPPMBrightenCopy12 q");
    Appendable stringBuilder12 = new StringBuilder();
    ImageProcessingView view12 = new ImageProcessingTextView(stringBuilder12);
    this.model12 = new ImageProcessingModelImpl();
    this.controller12 = new ImageProcessingControllerImpl(this.model12, view12,
            stringReader12);

    Readable stringReader13
            = new StringReader("darken 10 FirstPPMCopy13 FirstPPMDarkenCopy13 q");
    Appendable stringBuilder13 = new StringBuilder();
    ImageProcessingView view13 = new ImageProcessingTextView(stringBuilder13);
    this.model13 = new ImageProcessingModelImpl();
    this.controller13 = new ImageProcessingControllerImpl(this.model13, view13,
            stringReader13);

    Readable stringReader14
            = new StringReader("brighten 10 FirstPPMCopy14 FirstPPMBrightenCopy14 " +
            "darken 2 FirstPPMBrightenCopy14 FirstPPMDarkenCopy14 q");
    Appendable stringBuilder14 = new StringBuilder();
    ImageProcessingView view14 = new ImageProcessingTextView(stringBuilder14);
    this.model14 = new ImageProcessingModelImpl();
    this.controller14 = new ImageProcessingControllerImpl(this.model14, view14,
            stringReader14);

    Readable stringReader15 = new StringReader("move q");
    this.stringBuilder15 = new StringBuilder();
    ImageProcessingView view15 = new ImageProcessingTextView(this.stringBuilder15);
    ImageProcessingModel model15 = new ImageProcessingModelImpl();
    this.controller15 = new ImageProcessingControllerImpl(model15, view15,
            stringReader15);

    Readable stringReader16 = new StringReader("move blah blah q");
    this.stringBuilder16 = new StringBuilder();
    ImageProcessingView view16 = new ImageProcessingTextView(this.stringBuilder16);
    ImageProcessingModel model16 = new ImageProcessingModelImpl();
    this.controller16 = new ImageProcessingControllerImpl(model16, view16,
            stringReader16);

    Readable stringReader17
            = new StringReader("q red-component FirstPPMCopy17 FirstPPMRedCopy17");
    Appendable stringBuilder17 = new StringBuilder();
    ImageProcessingView view17 = new ImageProcessingTextView(stringBuilder17);
    this.model17 = new ImageProcessingModelImpl();
    this.controller17 = new ImageProcessingControllerImpl(this.model17, view17,
            stringReader17);

  }

  //
  @Test
  public void run() {
    BufferedImage myPPM1 = this.model1.load("res/FirstPPM.ppm");
    this.model1.put("FirstPPM1", myPPM1);
    this.model1.saveImage("res/FirstPPMCopy1.ppm", "FirstPPM1");
    BufferedImage samePPM1 = this.model1.load("res/FirstPPMCopy1.ppm");
    this.controller1.run();
    for (int i = 0; i < myPPM1.getWidth(); i += 1) {
      for (int j = 0; j < myPPM1.getHeight(); j += 1) {
        assertEquals(myPPM1.getRGB(i, j), samePPM1.getRGB(i, j));
      }
    }

    BufferedImage myPPM2 = this.model2.load("res/FirstPPM.ppm");
    this.model2.put("FirstPPM2", myPPM2);
    try {
      this.model2.getRedChannel("FirstPPMCopy2");
      fail("Should have failed as this doesn't exist yet as it hasn't loaded in");
    } catch (IllegalArgumentException e) {
      //do nothing because this should crash
    }
    this.controller2.run();
    assertEquals("Please wait, this may take a while...\n" +
            "Command successfully executed!" + "\n", this.stringBuilder2.toString());

    this.model2.getRedChannel("FirstPPMCopy2");

    BufferedImage myPPM3 = this.model3.load("res/FirstPPM.ppm");
    this.model3.put("FirstPPM3", myPPM3);
    this.model3.saveImage("res/FirstPPMCopy3.ppm", "FirstPPM3");
    BufferedImage samePPM3 = this.model3.load("res/FirstPPMCopy3.ppm");
    this.model3.put("FirstPPMCopy3", samePPM3);

    for (int i = 0; i < myPPM3.getWidth(); i += 1) {
      for (int j = 0; j < myPPM3.getHeight(); j += 1) {
        assertEquals(myPPM3.getRGB(i, j), samePPM3.getRGB(i, j));
      }
    }

    this.controller3.run();
    BufferedImage myPPM3Red = this.model3.getRedChannel("FirstPPM3");
    this.model3.saveImage("res/FirstPPMRedCopy3.ppm", "FirstPPMRedCopy3");
    BufferedImage samePPMRed3 = this.model3.load("res/FirstPPMRedCopy3.ppm");
    for (int i = 0; i < myPPM3Red.getWidth(); i += 1) {
      for (int j = 0; j < myPPM3Red.getHeight(); j += 1) {
        assertEquals(myPPM3Red.getRGB(i, j), samePPMRed3.getRGB(i, j));
      }
    }

    BufferedImage myPPM4 = this.model4.load("res/FirstPPM.ppm");
    this.model4.put("FirstPPM4", myPPM4);
    this.model4.saveImage("res/FirstPPMCopy4.ppm", "FirstPPM4");
    BufferedImage samePPM4 = this.model4.load("res/FirstPPMCopy4.ppm");
    this.model4.put("FirstPPMCopy4", samePPM4);

    for (int i = 0; i < myPPM4.getWidth(); i += 1) {
      for (int j = 0; j < myPPM4.getHeight(); j += 1) {
        assertEquals(myPPM3.getRGB(i, j), samePPM3.getRGB(i, j));
      }
    }

    this.controller4.run();
    BufferedImage myPPM4Blue = this.model4.getBlueChannel("FirstPPM4");
    this.model4.saveImage("res/FirstPPMBlueCopy4.ppm", "FirstPPMBlueCopy4");
    BufferedImage samePPMBlue4 = this.model4.load("res/FirstPPMBlueCopy4.ppm");
    for (int i = 0; i < myPPM4Blue.getWidth(); i += 1) {
      for (int j = 0; j < myPPM4Blue.getHeight(); j += 1) {
        assertEquals(myPPM4Blue.getRGB(i, j), samePPMBlue4.getRGB(i, j));
      }
    }

    BufferedImage myPPM5 = this.model5.load("res/FirstPPM.ppm");
    this.model5.put("FirstPPM5", myPPM5);
    this.model5.saveImage("res/FirstPPMCopy5.ppm", "FirstPPM5");
    BufferedImage samePPM5 = this.model5.load("res/FirstPPMCopy5.ppm");
    this.model5.put("FirstPPMCopy5", samePPM5);

    for (int i = 0; i < myPPM5.getWidth(); i += 1) {
      for (int j = 0; j < myPPM5.getHeight(); j += 1) {
        assertEquals(myPPM5.getRGB(i, j), samePPM5.getRGB(i, j));
      }
    }

    this.controller5.run();
    BufferedImage myPPM5Green = this.model5.getGreenChannel("FirstPPM5");
    this.model5.saveImage("res/FirstPPMGreenCopy5.ppm", "FirstPPMGreenCopy5");
    BufferedImage samePPMGreen5 = this.model5.load("res/FirstPPMGreenCopy5.ppm");
    for (int i = 0; i < myPPM5Green.getWidth(); i += 1) {
      for (int j = 0; j < myPPM5Green.getHeight(); j += 1) {
        assertEquals(myPPM5Green.getRGB(i, j), samePPMGreen5.getRGB(i, j));
      }
    }

    BufferedImage myPPM6 = this.model6.load("res/FirstPPM.ppm");
    this.model6.put("FirstPPM6", myPPM6);
    this.model6.saveImage("res/FirstPPMCopy6.ppm", "FirstPPM6");
    BufferedImage samePPM6 = this.model6.load("res/FirstPPMCopy6.ppm");
    this.model6.put("FirstPPMCopy6", samePPM6);

    for (int i = 0; i < myPPM6.getWidth(); i += 1) {
      for (int j = 0; j < myPPM6.getHeight(); j += 1) {
        assertEquals(myPPM6.getRGB(i, j), samePPM6.getRGB(i, j));
      }
    }

    this.controller6.run();
    BufferedImage myPPM6FlipHor = this.model6.flipHorizontal("FirstPPM6");
    this.model6.saveImage("res/FirstPPMFlipHorCopy6.ppm",
            "FirstPPMFlipHorCopy6");
    BufferedImage samePPMFlipHor6 = this.model6.load("res/FirstPPMFlipHorCopy6.ppm");
    for (int i = 0; i < myPPM6FlipHor.getWidth(); i += 1) {
      for (int j = 0; j < myPPM6FlipHor.getHeight(); j += 1) {
        assertEquals(myPPM6FlipHor.getRGB(i, j), samePPMFlipHor6.getRGB(i, j));
      }
    }

    BufferedImage myPPM7 = this.model7.load("res/FirstPPM.ppm");
    this.model7.put("FirstPPM7", myPPM7);
    this.model7.saveImage("res/FirstPPMCopy7.ppm", "FirstPPM7");
    BufferedImage samePPM7 = this.model7.load("res/FirstPPMCopy7.ppm");
    this.model7.put("FirstPPMCopy7", samePPM7);

    for (int i = 0; i < myPPM7.getWidth(); i += 1) {
      for (int j = 0; j < myPPM7.getHeight(); j += 1) {
        assertEquals(myPPM7.getRGB(i, j), samePPM7.getRGB(i, j));
      }
    }

    this.controller7.run();
    BufferedImage myPPM7FlipVer = this.model7.flipVertical("FirstPPM7");
    this.model7.saveImage("res/FirstPPMFlipVerCopy7.ppm",
            "FirstPPMFlipVerCopy7");
    BufferedImage samePPMFlipVer7 = this.model7.load("res/FirstPPMFlipVerCopy7.ppm");
    for (int i = 0; i < myPPM7FlipVer.getWidth(); i += 1) {
      for (int j = 0; j < myPPM7FlipVer.getHeight(); j += 1) {
        assertEquals(myPPM7FlipVer.getRGB(i, j), samePPMFlipVer7.getRGB(i, j));
      }
    }

    BufferedImage myPPM8 = this.model8.load("res/FirstPPM.ppm");
    this.model8.put("FirstPPM8", myPPM8);
    this.model8.saveImage("res/FirstPPMCopy8.ppm", "FirstPPM8");
    BufferedImage samePPM8 = this.model8.load("res/FirstPPMCopy8.ppm");
    this.model8.put("FirstPPMCopy8", samePPM8);

    for (int i = 0; i < myPPM8.getWidth(); i += 1) {
      for (int j = 0; j < myPPM8.getHeight(); j += 1) {
        assertEquals(myPPM8.getRGB(i, j), samePPM8.getRGB(i, j));
      }
    }

    this.controller8.run();
    BufferedImage myPPM8Intensity = this.model8.getIntensityComponent("FirstPPM8");
    this.model8.saveImage("res/FirstPPMIntensityCopy8.ppm",
            "FirstPPMIntensityCopy8");
    BufferedImage samePPMIntensity8 = this.model8.load("res/FirstPPMIntensityCopy8.ppm");
    for (int i = 0; i < myPPM8Intensity.getWidth(); i += 1) {
      for (int j = 0; j < myPPM8Intensity.getHeight(); j += 1) {
        assertEquals(myPPM8Intensity.getRGB(i, j), samePPMIntensity8.getRGB(i, j));
      }
    }

    BufferedImage myPPM9 = this.model9.load("res/FirstPPM.ppm");
    this.model9.put("FirstPPM9", myPPM9);
    this.model9.saveImage("res/FirstPPMCopy9.ppm", "FirstPPM9");
    BufferedImage samePPM9 = this.model9.load("res/FirstPPMCopy9.ppm");
    this.model9.put("FirstPPMCopy9", samePPM9);

    for (int i = 0; i < myPPM9.getWidth(); i += 1) {
      for (int j = 0; j < myPPM9.getHeight(); j += 1) {
        assertEquals(myPPM9.getRGB(i, j), samePPM9.getRGB(i, j));
      }
    }

    this.controller9.run();
    BufferedImage myPPM9Value = this.model9.getValueComponent("FirstPPM9");
    this.model9.saveImage("res/FirstPPMValueCopy9.ppm",
            "FirstPPMValueCopy9");
    BufferedImage samePPMValue9 = this.model9.load("res/FirstPPMValueCopy9.ppm");
    for (int i = 0; i < myPPM9Value.getWidth(); i += 1) {
      for (int j = 0; j < myPPM9Value.getHeight(); j += 1) {
        assertEquals(myPPM9Value.getRGB(i, j), samePPMValue9.getRGB(i, j));
      }
    }

    BufferedImage myPPM10 = this.model10.load("res/FirstPPM.ppm");
    this.model10.put("FirstPPM10", myPPM10);
    this.model10.saveImage("res/FirstPPMCopy10.ppm", "FirstPPM10");
    BufferedImage samePPM10 = this.model10.load("res/FirstPPMCopy10.ppm");
    this.model10.put("FirstPPMCopy10", samePPM10);

    for (int i = 0; i < myPPM10.getWidth(); i += 1) {
      for (int j = 0; j < myPPM10.getHeight(); j += 1) {
        assertEquals(myPPM10.getRGB(i, j), samePPM10.getRGB(i, j));
      }
    }

    this.controller10.run();
    BufferedImage myPPM10Luma = this.model10.getLumaComponent("FirstPPM10");
    this.model10.saveImage("res/FirstPPMLumaCopy10.ppm",
            "FirstPPMLumaCopy10");
    BufferedImage samePPMLuma10 = this.model10.load("res/FirstPPMLumaCopy10.ppm");
    for (int i = 0; i < myPPM10Luma.getWidth(); i += 1) {
      for (int j = 0; j < myPPM10Luma.getHeight(); j += 1) {
        assertEquals(myPPM10Luma.getRGB(i, j), samePPMLuma10.getRGB(i, j));
      }
    }

    BufferedImage myPPM11 = this.model11.load("res/FirstPPM.ppm");
    this.model11.put("FirstPPM11", myPPM11);

    try {
      BufferedImage failPPM11 = this.model11.load("res/FirstPPMCopy11.ppm");
      this.model11.getRedChannel("FailPPM11");
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    this.controller11.run();
    BufferedImage samePPM11 = this.model11.load("res/FirstPPMCopy11.ppm");
    for (int i = 0; i < myPPM11.getWidth(); i += 1) {
      for (int j = 0; j < myPPM11.getHeight(); j += 1) {
        assertEquals(myPPM11.getRGB(i, j), samePPM11.getRGB(i, j));
      }
    }

    BufferedImage myPPM12 = this.model12.load("res/FirstPPM.ppm");
    this.model12.put("FirstPPM12", myPPM12);
    this.model12.saveImage("res/FirstPPMCopy12.ppm", "FirstPPM12");
    BufferedImage samePPM12 = this.model12.load("res/FirstPPMCopy12.ppm");
    this.model12.put("FirstPPMCopy12", samePPM12);

    for (int i = 0; i < myPPM12.getWidth(); i += 1) {
      for (int j = 0; j < myPPM12.getHeight(); j += 1) {
        assertEquals(myPPM12.getRGB(i, j), samePPM12.getRGB(i, j));
      }
    }

    this.controller12.run();
    BufferedImage myPPM12Brighten = this.model12.changeBrightness("FirstPPM12",10);
    this.model12.saveImage("res/FirstPPMBrightenCopy12.ppm",
            "FirstPPMBrightenCopy12");
    BufferedImage samePPMBrighten12 = this.model12.load("res/FirstPPMBrightenCopy12.ppm");
    for (int i = 0; i < myPPM12Brighten.getWidth(); i += 1) {
      for (int j = 0; j < myPPM12Brighten.getHeight(); j += 1) {
        assertEquals(myPPM12Brighten.getRGB(i, j), samePPMBrighten12.getRGB(i, j));
      }
    }

    BufferedImage myPPM13 = this.model13.load("res/FirstPPM.ppm");
    this.model13.put("FirstPPM13", myPPM12);
    this.model13.saveImage("res/FirstPPMCopy13.ppm", "FirstPPM13");
    BufferedImage samePPM13 = this.model13.load("res/FirstPPMCopy13.ppm");
    this.model13.put("FirstPPMCopy13", samePPM13);

    for (int i = 0; i < myPPM13.getWidth(); i += 1) {
      for (int j = 0; j < myPPM13.getHeight(); j += 1) {
        assertEquals(myPPM13.getRGB(i, j), samePPM13.getRGB(i, j));
      }
    }

    this.controller13.run();
    BufferedImage myPPM13Darken = this.model13.changeBrightness("FirstPPM13",-10);
    this.model13.saveImage("res/FirstPPMDarkenCopy13.ppm",
            "FirstPPMDarkenCopy13");
    BufferedImage samePPMDarken13 = this.model13.load("res/FirstPPMDarkenCopy13.ppm");
    for (int i = 0; i < myPPM13Darken.getWidth(); i += 1) {
      for (int j = 0; j < myPPM13Darken.getHeight(); j += 1) {
        assertEquals(myPPM13Darken.getRGB(i, j), samePPMDarken13.getRGB(i, j));
      }
    }

    BufferedImage myPPM14 = this.model14.load("res/FirstPPM.ppm");
    this.model14.put("FirstPPM14", myPPM14);
    this.model14.saveImage("res/FirstPPMCopy14.ppm", "FirstPPM14");
    BufferedImage samePPM14 = this.model12.load("res/FirstPPMCopy12.ppm");
    this.model14.put("FirstPPMCopy14", samePPM14);

    for (int i = 0; i < myPPM14.getWidth(); i += 1) {
      for (int j = 0; j < myPPM14.getHeight(); j += 1) {
        assertEquals(myPPM14.getRGB(i, j), samePPM14.getRGB(i, j));
      }
    }

    this.controller14.run();
    BufferedImage myPPM14Brighten = this.model14.changeBrightness("FirstPPM14",10);
    BufferedImage myPPM14BrightenDarken = this.model14.changeBrightness("FirstPPM14",
            -2);
    this.model14.saveImage("res/FirstPPMBrightenCopy14.ppm",
            "FirstPPMBrightenCopy14");
    BufferedImage samePPMBrighten14 = this.model14.load("res/FirstPPMBrightenCopy14.ppm");
    for (int i = 0; i < myPPM14Brighten.getWidth(); i += 1) {
      for (int j = 0; j < myPPM14Brighten.getHeight(); j += 1) {
        assertEquals(myPPM14Brighten.getRGB(i, j), samePPMBrighten14.getRGB(i, j));
      }
    }

    StringBuilder log = new StringBuilder();
    this.model1 = new ImageProcessingModelMock(log);
    StringReader rd = new StringReader("load src/Koala.ppm koala-0 "
            + "red-component koala-0 koala-1 "
            + "green-component koala-0 koala-1 "
            + "blue-component koala-0 koala-1 "
            + "value-component koala-0 koala-1 "
            + "intensity-component koala-0 koala-1 "
            + "luma-component koala-0 koala-1 "
            + "vertical-flip koala-0 koala-1 "
            + "horizontal-flip koala-0 koala-1 "
            + "brighten 10 koala-0 koala-1 "
            + "darken 10 koala-0 koala-1 "
            + "save res/Koala.ppm koala-1 q");
    this.view1 = new ImageProcessingTextView(new StringBuilder());
    this.controller1 = new ImageProcessingControllerImpl(this.model1, this.view1, rd);
    this.controller1.run();
    String expected = "load src/Koala.ppm\nput koala-0\n"
            + "koala-0\nput koala-1\n"
            + "koala-0\nput koala-1\n"
            + "koala-0\nput koala-1\n"
            + "koala-0\nput koala-1\n"
            + "koala-0\nput koala-1\n"
            + "koala-0\nput koala-1\n"
            + "koala-0\nput koala-1\n"
            + "koala-0\nput koala-1\n"
            + "10 koala-0\nput koala-1\n"
            + "-10 koala-0\nput koala-1\n"
            + "save res/Koala.ppm koala-1\n";
    assertEquals(expected, log.toString());

    //tests wht happens if you provide a command thats not a valid input
    this.controller15.run();
    assertEquals("Unknown command! Please try again.\n", this.stringBuilder15.toString());


    //in this case its the same as above but this time it shows that the next inputs are checked
    // to be commands as you get the error message each time for each inalid command
    this.controller16.run();
    assertEquals("Unknown command! Please try again.\n"
            + "Unknown command! Please try again.\n"
            + "Unknown command! Please try again.\n", this.stringBuilder16.toString());


    BufferedImage myPPM17 = this.model3.load("res/FirstPPM.ppm");
    this.model17.put("FirstPPM17", myPPM17);
    this.model17.saveImage("res/FirstPPMCopy17.ppm", "FirstPPM17");
    BufferedImage samePPM17 = this.model17.load("res/FirstPPMCopy17.ppm");
    this.model17.put("FirstPPMCopy17", samePPM17);

    for (int i = 0; i < myPPM14.getWidth(); i += 1) {
      for (int j = 0; j < myPPM14.getHeight(); j += 1) {
        assertEquals(myPPM17.getRGB(i, j), samePPM17.getRGB(i, j));
      }
    }
    this.controller17.run();

    try {
      this.model17.saveImage("res/FirstPPMRedCopy17.ppm", "FirstPPMRedCopy17");
      fail("Should fail as this has never been created");
    }
    catch (IllegalArgumentException e) {
      //do nothing as test should fail because the program was quit
      //before anything could be red channeled
    }



  }

  //
  @Test
  public void testValidConstructor() {
    BufferedImage myPPM3 = this.model3.load("res/FirstPPM.ppm");
    this.model3.put("FirstPPM3", myPPM3);
    this.model3.saveImage("res/FirstPPMCopy3.ppm", "FirstPPM3");
    BufferedImage samePPM3 = this.model3.load("res/FirstPPMCopy3.ppm");
    this.model3.put("FirstPPMCopy3", samePPM3);

    for (int i = 0; i < myPPM3.getWidth(); i += 1) {
      for (int j = 0; j < myPPM3.getHeight(); j += 1) {
        assertEquals(myPPM3.getRGB(i, j), samePPM3.getRGB(i, j));
      }
    }

    this.controller3.run();
    BufferedImage myPPM3Red = this.model3.getRedChannel("FirstPPM3");
    this.model3.saveImage("res/FirstPPMRedCopy3.ppm", "FirstPPMRedCopy3");
    BufferedImage samePPMRed3 = this.model3.load("res/FirstPPMRedCopy3.ppm");
    for (int i = 0; i < myPPM3Red.getWidth(); i += 1) {
      for (int j = 0; j < myPPM3Red.getHeight(); j += 1) {
        assertEquals(myPPM3Red.getRGB(i, j), samePPMRed3.getRGB(i, j));
      }
    }

    BufferedImage myPPM4 = this.model4.load("res/FirstPPM.ppm");
    this.model4.put("FirstPPM4", myPPM4);
    this.model4.saveImage("res/FirstPPMCopy4.ppm", "FirstPPM4");
    BufferedImage samePPM4 = this.model4.load("res/FirstPPMCopy4.ppm");
    this.model4.put("FirstPPMCopy4", samePPM4);

    for (int i = 0; i < myPPM4.getWidth(); i += 1) {
      for (int j = 0; j < myPPM4.getHeight(); j += 1) {
        assertEquals(myPPM3.getRGB(i, j), samePPM3.getRGB(i, j));
      }
    }

    this.controller4.run();
    BufferedImage myPPM4Blue = this.model4.getBlueChannel("FirstPPM4");
    this.model4.saveImage("res/FirstPPMBlueCopy4.ppm", "FirstPPMBlueCopy4");
    BufferedImage samePPMBlue4 = this.model4.load("res/FirstPPMBlueCopy4.ppm");
    for (int i = 0; i < myPPM4Blue.getWidth(); i += 1) {
      for (int j = 0; j < myPPM4Blue.getHeight(); j += 1) {
        assertEquals(myPPM4Blue.getRGB(i, j), samePPMBlue4.getRGB(i, j));
      }
    }
  }

  //
  @Test
  public void testInvalidConstructor() {
    try {
      StringReader failRead1 = new StringReader("q");
      StringBuilder failBuild1 = new StringBuilder();
      ImageProcessingView failView1 = new ImageProcessingTextView(failBuild1);
      ImageProcessingController failController1
              = new ImageProcessingControllerImpl(null, failView1,
              failRead1);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      StringReader failRead2 = new StringReader("q");
      StringBuilder failBuild2 = new StringBuilder();
      ImageProcessingModel failModel2 = new ImageProcessingModelImpl();
      ImageProcessingController failController1 = new ImageProcessingControllerImpl(failModel2,
              null, failRead2);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      StringBuilder failBuild3 = new StringBuilder();
      ImageProcessingView failView3 = new ImageProcessingTextView(failBuild3);
      ImageProcessingModel failModel3 = new ImageProcessingModelImpl();
      ImageProcessingController failController1 = new ImageProcessingControllerImpl(failModel3,
              failView3, null);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      ImageProcessingController failController1 = new ImageProcessingControllerImpl(null,
              null, null);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

  }

}