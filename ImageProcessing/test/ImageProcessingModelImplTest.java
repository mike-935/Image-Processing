import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.ImageProcessingModel;
import model.ImageProcessingModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for an image processing model.
 */
public class ImageProcessingModelImplTest {

  protected ImageProcessingModel model;

  //to initialize data
  @Before
  public void init() {
    this.model = new ImageProcessingModelImpl();
  }

  //
  @Test
  public void load() {
    String filename = "src/Koala.ppm";

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

    BufferedImage actual = this.model.load("src/Koala.ppm");

    for (int i = 0; i < width; i += 1) {
      for (int j = 0; j < height; j += 1) {
        assertEquals(image.getRGB(i, j), actual.getRGB(i, j));
      }
    }


  }

  //
  @Test
  public void getRedChannel() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int redValue = color.getRed();
        expected.setRGB(i, j, new Color(redValue, redValue, redValue).getRGB());
      }
    }

    BufferedImage actual = this.model.getRedChannel("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }


    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmRed = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int redValue = color.getRed();
        ppmRed.setRGB(i, j, new Color(redValue, redValue, redValue).getRGB());
      }
    }

    BufferedImage myPPMRed = this.model.getRedChannel("FirstPPM");

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(ppmRed.getRGB(i, j), myPPMRed.getRGB(i, j));
      }
    }

    BufferedImage redChannel = this.model.load("res/RedChannel3.ppm");
    this.model.put("RedChannel1", redChannel);


    //checking that its equal to its counterpart I made that has its RGB values set to the red ones
    // a.k.a the red channel
    for (int i = 0; i < redChannel.getWidth(); i += 1) {
      for (int j = 0; j < redChannel.getHeight(); j += 1) {
        assertEquals(redChannel.getRGB(i, j), myPPMRed.getRGB(i, j));
      }
    }


  }

  //to test getGreenChannel
  @Test
  public void getGreenChannel() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int greenValue = color.getGreen();
        expected.setRGB(i, j, new Color(greenValue, greenValue, greenValue).getRGB());
      }
    }

    BufferedImage actual = this.model.getGreenChannel("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }

    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmGreen = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int greenValue = color.getGreen();
        ppmGreen.setRGB(i, j, new Color(greenValue, greenValue, greenValue).getRGB());
      }
    }

    BufferedImage myPPMGreen = this.model.getGreenChannel("FirstPPM");

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(ppmGreen.getRGB(i, j), myPPMGreen.getRGB(i, j));
      }
    }

    BufferedImage greenChannel = this.model.load("res/GreenChannel.ppm");
    this.model.put("GreenPPM", greenChannel);


    //checking that its equal to its counterpart I made that has its RGB values set to the green
    // a.k.a. the green channel
    for (int i = 0; i < greenChannel.getWidth(); i += 1) {
      for (int j = 0; j < greenChannel.getHeight(); j += 1) {
        assertEquals(greenChannel.getRGB(i, j), myPPMGreen.getRGB(i, j));
      }
    }

  }

  @Test
  public void getBlueChannel() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);

    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int blueValue = color.getBlue();
        expected.setRGB(i, j, new Color(blueValue, blueValue, blueValue).getRGB());
      }
    }

    BufferedImage actual = this.model.getBlueChannel("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }

    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmBlue = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int blueValue = color.getBlue();
        ppmBlue.setRGB(i, j, new Color(blueValue, blueValue, blueValue).getRGB());
      }
    }

    BufferedImage myPPMBlue = this.model.getBlueChannel("FirstPPM");

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(ppmBlue.getRGB(i, j), myPPMBlue.getRGB(i, j));
      }
    }

    BufferedImage blueChannel = this.model.load("res/BlueChannel3.ppm");
    this.model.put("BluePPM", blueChannel);

    //checking that its equal to its counterpart I made that has its RGB values set to the blue
    // a.k.a the blue channel
    for (int i = 0; i < blueChannel.getWidth(); i += 1) {
      for (int j = 0; j < blueChannel.getHeight(); j += 1) {
        assertEquals(blueChannel.getRGB(i, j), myPPMBlue.getRGB(i, j));
      }
    }

  }

  @Test
  public void getValueComponent() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int maxValue = Math.max(color.getRed(), Math.max(color.getGreen(), color.getBlue()));
        expected.setRGB(i, j, new Color(maxValue, maxValue, maxValue).getRGB());
      }
    }

    BufferedImage actual = this.model.getValueComponent("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }

    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmValue = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int maxValue = Math.max(color.getRed(), Math.max(color.getGreen(), color.getBlue()));
        ppmValue.setRGB(i, j, new Color(maxValue, maxValue, maxValue).getRGB());
      }
    }

    BufferedImage myPPMValue = this.model.getValueComponent("FirstPPM");

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(ppmValue.getRGB(i, j), myPPMValue.getRGB(i, j));
      }
    }

    BufferedImage valueChannel = this.model.load("res/ValueChannel.ppm");
    this.model.put("ValuePPM", valueChannel);

    //checking that its equal to its counterpart I made that has its RGB values set to the value
    // a.k.a the value channel/mac component of each rgb
    for (int i = 0; i < valueChannel.getWidth(); i += 1) {
      for (int j = 0; j < valueChannel.getHeight(); j += 1) {
        assertEquals(valueChannel.getRGB(i, j), myPPMValue.getRGB(i, j));
      }
    }

  }

  //
  @Test
  public void getIntensityComponent() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int intensity = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        expected.setRGB(i, j, new Color(intensity, intensity, intensity).getRGB());
      }
    }

    BufferedImage actual = this.model.getIntensityComponent("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }

    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmIntensity = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int avgValue = (color.getRed() + color.getBlue() + color.getGreen()) / 3;
        ppmIntensity.setRGB(i, j, new Color(avgValue, avgValue, avgValue).getRGB());
      }
    }

    BufferedImage myPPMIntensity = this.model.getIntensityComponent("FirstPPM");

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(ppmIntensity.getRGB(i, j), myPPMIntensity.getRGB(i, j));
      }
    }

    BufferedImage intensityChannel = this.model.load("res/IntensityChannel.ppm");
    this.model.put("IntensityPPM", intensityChannel);

    //checking that its equal to its counterpart I made that has its RGB values set to the Intensity
    //Channel a.k.a. the max of the 3 RGB components
    for (int i = 0; i < intensityChannel.getWidth(); i += 1) {
      for (int j = 0; j < intensityChannel.getHeight(); j += 1) {
        assertEquals(intensityChannel.getRGB(i, j), myPPMIntensity.getRGB(i, j));
      }
    }

  }

  @Test
  public void getLumaComponent() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int luma = (int) (0.2126 * color.getRed()
                + 0.7152 * color.getGreen()
                + 0.0722 * color.getBlue());
        expected.setRGB(i, j, new Color(luma, luma, luma).getRGB());
      }
    }

    BufferedImage actual = this.model.getLumaComponent("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }


    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmLuma = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int luma = (int) ((0.2126 * color.getRed() + 0.7152 * color.getGreen()
                + 0.0722 * color.getBlue()));
        ppmLuma.setRGB(i, j, new Color(luma, luma, luma).getRGB());
      }
    }

    BufferedImage myPPMLuma = this.model.getLumaComponent("FirstPPM");

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(ppmLuma.getRGB(i, j), myPPMLuma.getRGB(i, j));
      }
    }

    BufferedImage lumaChannel = this.model.load("res/LumaChannel.ppm");
    this.model.put("LumaPPM", lumaChannel);

    //checking that its equal to its counterpart I made that has its RGB values set to the Luma
    //Channel
    for (int i = 0; i < lumaChannel.getWidth(); i += 1) {
      for (int j = 0; j < lumaChannel.getHeight(); j += 1) {
        assertEquals(lumaChannel.getRGB(i, j), myPPMLuma.getRGB(i, j));
      }
    }

  }

  //to test the flip horizontal operation
  @Test
  public void flipHorizontal() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        int color = koala.getRGB(i, j);
        expected.setRGB((koala.getWidth() - 1) - i, j, color);
      }
    }

    BufferedImage actual = this.model.flipHorizontal("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }


    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmFlipHor = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        int color = myPPM.getRGB(i, j);
        ppmFlipHor.setRGB((myPPM.getWidth() - 1) - i, j, color);
      }
    }

    BufferedImage flipHor = this.model.flipHorizontal("FirstPPM");

    for (int i = 0; i < flipHor.getWidth(); i += 1) {
      for (int j = 0; j < flipHor.getHeight(); j += 1) {
        assertEquals(flipHor.getRGB(i, j), ppmFlipHor.getRGB(i, j));
      }
    }

    BufferedImage horizontalFlip = this.model.load("res/HorizontalFlip.ppm");
    this.model.put("HorizontalPPM", horizontalFlip);

    //checking that its equal to its counterpart I made that has its RGB values set to the Luma
    //Channel
    for (int i = 0; i < horizontalFlip.getWidth(); i += 1) {
      for (int j = 0; j < horizontalFlip.getHeight(); j += 1) {
        assertEquals(horizontalFlip.getRGB(i, j), flipHor.getRGB(i, j));
      }
    }

  }

  //
  @Test
  public void flipVertical() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        int color = koala.getRGB(i, j);
        expected.setRGB(i, (koala.getHeight() - 1) - j, color);
      }
    }

    BufferedImage actual = this.model.flipVertical("koala");

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }

    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmFlipVer = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        int color = myPPM.getRGB(i, j);
        ppmFlipVer.setRGB(i, (myPPM.getHeight() - 1) - j, color);
      }
    }

    BufferedImage flipVer = this.model.flipVertical("FirstPPM");

    for (int i = 0; i < flipVer.getWidth(); i += 1) {
      for (int j = 0; j < flipVer.getHeight(); j += 1) {
        assertEquals(flipVer.getRGB(i, j), ppmFlipVer.getRGB(i, j));
      }
    }

    BufferedImage verticalFlip = this.model.load("res/VerticalFlip2.ppm");
    this.model.put("VerticalPPM", verticalFlip);

    //checking that its equal to its counterpart I made that has its RGB values set to the Luma
    //Channel
    for (int i = 0; i < verticalFlip.getWidth(); i += 1) {
      for (int j = 0; j < verticalFlip.getHeight(); j += 1) {
        assertEquals(verticalFlip.getRGB(i, j), flipVer.getRGB(i, j));
      }
    }

  }

  //tests changeBrightness (our bright and darken features)
  @Test
  public void changeBrightness() {
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage expected = new BufferedImage(koala.getWidth(),
            koala.getHeight(),
            1);
    for (int i = 0; i < koala.getWidth(); i += 1) {
      for (int j = 0; j < koala.getHeight(); j += 1) {
        Color color = new Color(koala.getRGB(i, j));
        int redValue = Math.max(0, Math.min(255, color.getRed() + 10));
        int greenValue = Math.max(0, Math.min(255, color.getGreen() + 10));
        int blueValue = Math.max(0, Math.min(255, color.getBlue() + 10));
        expected.setRGB(i, j, new Color(redValue, greenValue, blueValue).getRGB());
      }
    }

    BufferedImage actual = this.model.changeBrightness("koala", 10);

    for (int i = 0; i < actual.getWidth(); i += 1) {
      for (int j = 0; j < actual.getHeight(); j += 1) {
        assertEquals(expected.getRGB(i, j), actual.getRGB(i, j));
      }
    }

    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    BufferedImage ppmBrighten = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int redValue = Math.max(0, Math.min(255, color.getRed() + 20));
        int greenValue = Math.max(0, Math.min(255, color.getGreen() + 20));
        int blueValue = Math.max(0, Math.min(255, color.getBlue() + 20));
        ppmBrighten.setRGB(i, j, new Color(redValue, greenValue, blueValue).getRGB());
      }
    }

    BufferedImage brighten = this.model.changeBrightness("FirstPPM", 20);

    for (int i = 0; i < brighten.getWidth(); i += 1) {
      for (int j = 0; j < brighten.getHeight(); j += 1) {
        assertEquals(brighten.getRGB(i, j), ppmBrighten.getRGB(i, j));
      }
    }

    BufferedImage ppmBrightenMax = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        ppmBrightenMax.setRGB(i, j, new Color(255, 255, 255).getRGB());
      }
    }

    BufferedImage brightenMax = this.model.changeBrightness("FirstPPM", 255);

    //Shows us that if you were to max out all  the values it would indeed max at 255
    for (int i = 0; i < brightenMax.getWidth(); i += 1) {
      for (int j = 0; j < brightenMax.getHeight(); j += 1) {
        assertEquals(ppmBrightenMax.getRGB(i, j), brightenMax.getRGB(i, j));
      }
    }

    BufferedImage ppmDarken = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        Color color = new Color(myPPM.getRGB(i, j));
        int redValue = Math.max(0, Math.min(255, color.getRed() - 55));
        int greenValue = Math.max(0, Math.min(255, color.getGreen() - 55));
        int blueValue = Math.max(0, Math.min(255, color.getBlue() - 55));
        ppmDarken.setRGB(i, j, new Color(redValue, greenValue, blueValue).getRGB());
      }
    }

    BufferedImage darken = this.model.changeBrightness("FirstPPM", -55);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(darken.getRGB(i, j), ppmDarken.getRGB(i, j));
      }
    }


    BufferedImage ppmDarkenMin = new BufferedImage(myPPM.getWidth(),
            myPPM.getHeight(),
            1);

    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        ppmDarkenMin.setRGB(i, j, new Color(0, 0, 0).getRGB());
      }
    }

    BufferedImage darkenMin = this.model.changeBrightness("FirstPPM", -255);

    //Shows us that if you were to min out all the values it would indeed min at 0
    for (int i = 0; i < brightenMax.getWidth(); i += 1) {
      for (int j = 0; j < brightenMax.getHeight(); j += 1) {
        assertEquals(darkenMin.getRGB(i, j), ppmDarkenMin.getRGB(i, j));
      }
    }

  }

  //to test our save image operation
  @Test
  public void saveImage() {
    BufferedImage myPPM = this.model.load("res/FirstPPM.ppm");
    this.model.put("FirstPPM", myPPM);
    this.model.saveImage("res/SamePPM.ppm", "FirstPPM");
    BufferedImage samePPM = this.model.load("res/SamePPM.ppm");
    //loops test that the PPM file was created successfully
    //and is the same as the one it is meant to save
    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(myPPM.getRGB(i, j), samePPM.getRGB(i, j));
      }
    }
    BufferedImage brighten = this.model.changeBrightness("FirstPPM", 20);
    this.model.saveImage("res/BrightenedFirst.ppm", "FirstPPM");
    BufferedImage brightenedFirst = this.model.load("res/BrightenedFirst.ppm");

    //this loop also tests that even after a change save will keep that change and still works
    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(myPPM.getRGB(i, j), brightenedFirst.getRGB(i, j));
      }
    }
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);

    try {
      this.model.saveImage(null, "koala");
      fail("Should throw exception");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      this.model.saveImage("Users/michaelhaile/Downloads", "koala");
      fail("Should throw exception");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      this.model.saveImage("res/NewFile.ppm", "Doesn't exist");
      fail("Should throw exception");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      this.model.saveImage("res/NewFile.ppm", null);
      fail("Should throw exception");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

  }

  //to test that the put method works correctly
  @Test
  public void put() {
    assertTrue(new File("src/Koala.ppm").exists());
    //shows that once we put, we can utilize the image
    BufferedImage koala = this.model.load("src/Koala.ppm");
    this.model.put("koala", koala);
    BufferedImage actual = this.model.flipVertical("koala");

    try {
      BufferedImage firstPPm = this.model.load("res/FirstPPM.ppm");
      BufferedImage fail = this.model.flipVertical("FirstPPM");
      fail("should fail");
    } catch (IllegalArgumentException e) {
      //should fail because while FirstPPM exists,
      //we never put it, so it isn't in our hashMap of images
    }

    assertTrue(new File("res/RedChannel3.ppm").exists());
    BufferedImage redChannel = this.model.load("res/RedChannel3.ppm");
    this.model.put("RedChannel", redChannel);
    BufferedImage redFlipVer = this.model.flipVertical("RedChannel");

    try {
      this.model.saveImage("res/NewFile", null);
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

  }

  //to test a valid initialization of the constructor
  @Test
  public void testValidConstructor() {
    ImageProcessingModel model2 = new ImageProcessingModelImpl();
    BufferedImage myPPM = model2.load("res/FirstPPM.ppm");
    model2.put("FirstPPM", myPPM);
    model2.saveImage("res/SamePPM.ppm", "FirstPPM");

    BufferedImage samePPM = model2.load("res/SamePPM.ppm");
    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(myPPM.getRGB(i, j), samePPM.getRGB(i, j));
      }
    }

    ImageProcessingModel model3 = new ImageProcessingModelImpl();
    BufferedImage myPPM2 = model2.load("res/FirstPPM.ppm");
    model2.put("FirstPPM2", myPPM2);
    model2.saveImage("res/SamePPM2.ppm", "FirstPPM2");

    BufferedImage samePPM2 = model2.load("res/SamePPM2.ppm");
    for (int i = 0; i < myPPM.getWidth(); i += 1) {
      for (int j = 0; j < myPPM.getHeight(); j += 1) {
        assertEquals(myPPM.getRGB(i, j), samePPM.getRGB(i, j));
      }
    }
  }

}