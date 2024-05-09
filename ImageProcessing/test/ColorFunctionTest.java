import org.junit.Test;

import java.awt.Color;
import java.awt.image.BufferedImage;

import colorfunction.BlurFunction;
import colorfunction.ColorFunction;
import colorfunction.GreyscaleFunction;
import colorfunction.RedChannelFunction;
import colorfunction.GreenChannelFunction;
import colorfunction.BlueChannelFunction;
import colorfunction.ChangeBrightnessFunction;
import colorfunction.LumaComponentFunction;
import colorfunction.IntensityComponentFunction;
import colorfunction.SepiaFunction;
import colorfunction.SharpenFunction;
import colorfunction.ValueComponentFunction;
import colorfunction.FlipHorizontalFunction;
import colorfunction.FlipVerticalFunction;

import static org.junit.Assert.assertEquals;

/**
 * Tests for ColorFunctions.
 */
public class ColorFunctionTest {

  private BufferedImage image2;
  private BufferedImage image3;


  //to test the getRedChannel operation.
  @Test
  public void testRedChannelFunction() {
    this.testColorFunction(new RedChannelFunction(), new Color(85, 85, 85));

    this.image2 = new BufferedImage(2,2,1);
    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        this.image2.setRGB(i, j, new Color(85, 170, 255).getRGB());
      }
    }

    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        Color color = new RedChannelFunction().apply(i,j,this.image2);
        assertEquals(color, new Color(85,85,85));
      }
    }

    this.image3 = new BufferedImage(3,3,1);

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        this.image3.setRGB(i, j, new Color(0, 170, 255).getRGB());
      }
    }

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        Color color = new RedChannelFunction().apply(i,j,this.image3);
        assertEquals(color, new Color(0,0,0));
      }
    }

  }

  //to test the getGreenChannel operation.
  @Test
  public void testGreenChannelFunction() {
    this.testColorFunction(new GreenChannelFunction(), new Color(170, 170, 170));

    this.image2 = new BufferedImage(2,2,1);
    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        this.image2.setRGB(i, j, new Color(85, 170, 255).getRGB());
      }
    }

    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        Color color = new GreenChannelFunction().apply(i,j,this.image2);
        assertEquals(color, new Color(170,170,170));
      }
    }

    this.image3 = new BufferedImage(3,3,1);

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        this.image3.setRGB(i, j, new Color(85, 0, 255).getRGB());
      }
    }

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        Color color = new GreenChannelFunction().apply(i,j,this.image3);
        assertEquals(color, new Color(0,0,0));
      }
    }

  }

  //to test the getBlueChannel operation.
  @Test
  public void testBlueChannelFunction() {
    this.testColorFunction(new BlueChannelFunction(), new Color(255, 255, 255));

    this.image2 = new BufferedImage(2,2,1);
    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        this.image2.setRGB(i, j, new Color(85, 170, 255).getRGB());
      }
    }

    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        Color color = new BlueChannelFunction().apply(i,j,this.image2);
        assertEquals(color, new Color(255,255,255));
      }
    }

    this.image3 = new BufferedImage(3,3,1);

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        this.image3.setRGB(i, j, new Color(85, 170, 0).getRGB());
      }
    }

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        Color color = new BlueChannelFunction().apply(i,j,this.image3);
        assertEquals(color, new Color(0,0,0));
      }
    }
  }

  private void testColorFunction(ColorFunction func, Color expected) {
    BufferedImage image = new BufferedImage(1, 1, 1);
    image.setRGB(0, 0, new Color(85, 170, 255).getRGB());
    assertEquals(expected, func.apply(0, 0, image));
  }

  //to test the changeBrightness function that can darken or brighten an image.
  @Test
  public void testChangeBrightnessFunction() {
    this.testColorFunction(new ChangeBrightnessFunction(10), new Color(95,180,255));
    this.testColorFunction(new ChangeBrightnessFunction(0), new Color(85,170,255));

    this.image2 = new BufferedImage(2,2,1);
    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        this.image2.setRGB(i, j, new Color(85, 170, 255).getRGB());
      }
    }

    for (int i = 0; i < this.image2.getWidth(); i += 1) {
      for (int j = 0; j < this.image2.getHeight(); j += 1) {
        Color color = new ChangeBrightnessFunction(20).apply(i,j,this.image2);
        assertEquals(color, new Color(105,190,255));
      }
    }

    this.image3 = new BufferedImage(3,3,1);

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        this.image3.setRGB(i, j, new Color(85, 170, 0).getRGB());
      }
    }

    for (int i = 0; i < this.image3.getWidth(); i += 1) {
      for (int j = 0; j < this.image3.getHeight(); j += 1) {
        Color color = new ChangeBrightnessFunction(255).apply(i,j,this.image3);
        assertEquals(color, new Color(255,255,255));
      }
    }

    BufferedImage image4 = new BufferedImage(2, 2, 1);
    for (int i = 0; i < image4.getWidth(); i += 1) {
      for (int j = 0; j < image4.getHeight(); j += 1) {
        image4.setRGB(i, j, new Color(85, 170, 255).getRGB());
      }
    }

    for (int i = 0; i < image4.getWidth(); i += 1) {
      for (int j = 0; j < image4.getHeight(); j += 1) {
        Color color = new ChangeBrightnessFunction(-10).apply(i,j, image4);
        assertEquals(color, new Color(75,160,245));
      }
    }

    BufferedImage image5 = new BufferedImage(3, 3, 1);

    for (int i = 0; i < image5.getWidth(); i += 1) {
      for (int j = 0; j < image5.getHeight(); j += 1) {
        image5.setRGB(i, j, new Color(85, 170, 0).getRGB());
      }
    }

    for (int i = 0; i < image5.getWidth(); i += 1) {
      for (int j = 0; j < image5.getHeight(); j += 1) {
        Color color = new ChangeBrightnessFunction(-255).apply(i,j, image5);
        assertEquals(color, new Color(0,0,0));
      }
    }
  }

  //to test the horizontal flip command
  @Test
  public void testFlipVertical() {
    this.image2 = new BufferedImage(2,2,1);
    this.image2.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    this.image2.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    this.image2.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    this.image2.setRGB(1, 1, new Color(255, 25, 238).getRGB());

    assertEquals(new Color(80, 255, 56),
            new FlipVerticalFunction().apply(0,0,this.image2));
    assertEquals(new Color(255, 25, 238),
            new FlipVerticalFunction().apply(1,0,this.image2));
    assertEquals(new Color(52, 255, 245),
            new FlipVerticalFunction().apply(0,1,this.image2));
    assertEquals(new Color(255, 19, 24),
            new FlipVerticalFunction().apply(1,1,this.image2));

    this.image3 = new BufferedImage(1,1,1);
    this.image3.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    assertEquals(new Color(52, 255, 245),
            new FlipVerticalFunction().apply(0,0,this.image3));
  }

  //to test our horizontal flip operation.
  @Test
  public void testFlipHorizontal() {
    this.image2 = new BufferedImage(2,2,1);
    this.image2.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    this.image2.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    this.image2.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    this.image2.setRGB(1, 1, new Color(255, 25, 238).getRGB());

    assertEquals(new Color(255, 19, 24),
            new FlipHorizontalFunction().apply(0,0,this.image2));
    assertEquals(new Color(52, 255, 245),
            new FlipHorizontalFunction().apply(1,0,this.image2));
    assertEquals(new Color(255, 25, 238),
            new FlipHorizontalFunction().apply(0,1,this.image2));
    assertEquals(new Color(80, 255, 56),
            new FlipHorizontalFunction().apply(1,1,this.image2));

    this.image3 = new BufferedImage(1,1,1);
    this.image3.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    assertEquals(new Color(52, 255, 245),
            new FlipHorizontalFunction().apply(0,0,this.image3));
  }

  @Test
  public void testIntensityComponent() {
    this.testColorFunction(new IntensityComponentFunction(), new Color(170, 170, 170));

    this.image2 = new BufferedImage(2,2,1);
    this.image2.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    this.image2.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    this.image2.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    this.image2.setRGB(1, 1, new Color(255, 25, 238).getRGB());

    assertEquals(new Color(184, 184, 184),
            new IntensityComponentFunction().apply(0,0,this.image2));
    assertEquals(new Color(99, 99, 99),
            new IntensityComponentFunction().apply(1,0,this.image2));
    assertEquals(new Color(130, 130, 130),
            new IntensityComponentFunction().apply(0,1,this.image2));
    assertEquals(new Color(172, 172, 172),
            new IntensityComponentFunction().apply(1,1,this.image2));
  }

  //to test the luma component operation.
  @Test
  public void testLumaComponent() {
    this.testColorFunction(new LumaComponentFunction(), new Color(158,158,158));

    this.image2 = new BufferedImage(2,2,1);
    this.image2.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    this.image2.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    this.image2.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    this.image2.setRGB(1, 1, new Color(255, 25, 238).getRGB());

    assertEquals(new Color(211, 211, 211),
            new LumaComponentFunction().apply(0,0,this.image2));
    assertEquals(new Color(69, 69, 69),
            new LumaComponentFunction().apply(1,0,this.image2));
    assertEquals(new Color(203, 203, 203),
            new LumaComponentFunction().apply(0,1,this.image2));
    assertEquals(new Color(89, 89, 89),
            new LumaComponentFunction().apply(1,1,this.image2));
  }

  //to test the value component operation.
  @Test
  public void testValueComponent() {
    this.testColorFunction(new ValueComponentFunction(), new Color(255,255,255));

    this.image2 = new BufferedImage(2,2,1);
    this.image2.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    this.image2.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    this.image2.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    this.image2.setRGB(1, 1, new Color(255, 25, 238).getRGB());

    assertEquals(new Color(255, 255, 255),
            new ValueComponentFunction().apply(0,0,this.image2));
    assertEquals(new Color(255, 255, 255),
            new ValueComponentFunction().apply(1,0,this.image2));
    assertEquals(new Color(255, 255, 255),
            new ValueComponentFunction().apply(0,1,this.image2));
    assertEquals(new Color(255, 255, 255),
            new ValueComponentFunction().apply(1,1,this.image2));

    this.image3 = new BufferedImage(2,2,1);
    this.image3.setRGB(0, 0, new Color(52, 2, 0).getRGB());
    assertEquals(new Color(52,52,52),
            new ValueComponentFunction().apply(0,0,this.image3));
  }

  //to test blur
  @Test
  public void testBlur() {

    this.image2 = new BufferedImage(3,3,1);
    this.image2.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    this.image2.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    this.image2.setRGB(2, 0, new Color(255, 250, 1).getRGB());
    this.image2.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    this.image2.setRGB(0, 2, new Color(78, 90, 238).getRGB());
    this.image2.setRGB(1, 1, new Color(255, 25, 238).getRGB());
    this.image2.setRGB(1, 2, new Color(79, 0, 0).getRGB());
    this.image2.setRGB(2, 2, new Color(5, 113, 9).getRGB());
    this.image2.setRGB(2, 1, new Color(0, 37, 90).getRGB());

    assertEquals(new Color(70, 99, 86),
            new BlurFunction().apply(0,0,this.image2));
    assertEquals(new Color(89, 111, 105),
            new BlurFunction().apply(0,1,this.image2));
    assertEquals(new Color(111, 71, 29),
            new BlurFunction().apply(2,0,this.image2));
    assertEquals(new Color(139, 89, 75),
            new BlurFunction().apply(1,0,this.image2));
    assertEquals(new Color(55, 55, 81),
            new BlurFunction().apply(0,2,this.image2));
    assertEquals(new Color(139, 89, 111),
            new BlurFunction().apply(1,1,this.image2));
    assertEquals(new Color(67, 46, 69),
            new BlurFunction().apply(1,2,this.image2));
    assertEquals(new Color(27, 34, 28),
            new BlurFunction().apply(2,2,this.image2));
    assertEquals(new Color(85, 58, 55),
            new BlurFunction().apply(2,1,this.image2));

  }

  //to test to sharpen
  @Test
  public void testSharpen() {

    this.image2 = new BufferedImage(5,5,1);
    this.image2.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    this.image2.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    this.image2.setRGB(0, 2, new Color(78, 90, 238).getRGB());
    this.image2.setRGB(0, 3, new Color(90, 70, 112).getRGB());
    this.image2.setRGB(0, 4, new Color(78, 90, 238).getRGB());
    this.image2.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    this.image2.setRGB(2, 0, new Color(255, 250, 1).getRGB());
    this.image2.setRGB(1, 1, new Color(255, 25, 238).getRGB());
    this.image2.setRGB(1, 2, new Color(79, 0, 0).getRGB());
    this.image2.setRGB(2, 2, new Color(5, 113, 9).getRGB());
    this.image2.setRGB(2, 1, new Color(0, 37, 90).getRGB());
    this.image2.setRGB(1, 3, new Color(100, 100, 100).getRGB());
    this.image2.setRGB(1, 4, new Color(100, 2, 0).getRGB());
    this.image2.setRGB(2, 3, new Color(30, 29, 60).getRGB());
    this.image2.setRGB(2, 4, new Color(97, 234, 135).getRGB());
    this.image2.setRGB(3, 0, new Color(100, 100, 100).getRGB());
    this.image2.setRGB(3, 1, new Color(0, 0, 0).getRGB());
    this.image2.setRGB(3, 3, new Color(200, 137, 37).getRGB());
    this.image2.setRGB(3, 2, new Color(200, 137, 37).getRGB());
    this.image2.setRGB(3, 4, new Color(200, 0, 90).getRGB());
    this.image2.setRGB(4, 0, new Color(255, 100, 100).getRGB());
    this.image2.setRGB(4, 1, new Color(170, 170, 170).getRGB());
    this.image2.setRGB(4, 2, new Color(190, 200, 100).getRGB());
    this.image2.setRGB(4, 3, new Color(200, 137, 37).getRGB());
    this.image2.setRGB(4, 4, new Color(100, 200, 0).getRGB());

    assertEquals(new Color(147, 255, 255),
            new SharpenFunction().apply(0,0,this.image2));
    assertEquals(new Color(255, 169, 133),
            new SharpenFunction().apply(1,0,this.image2));
    assertEquals(new Color(255, 130, 0),
            new SharpenFunction().apply(2,0,this.image2));
    assertEquals(new Color(199, 255, 195),
            new SharpenFunction().apply(0,1,this.image2));
    assertEquals(new Color(120, 73, 255),
            new SharpenFunction().apply(0,2,this.image2));
    assertEquals(new Color(255, 208, 255),
            new SharpenFunction().apply(1,1,this.image2));
    assertEquals(new Color(46, 26, 112),
            new SharpenFunction().apply(1,2,this.image2));
    assertEquals(new Color(0, 0, 0),
            new SharpenFunction().apply(2,2,this.image2));
    assertEquals(new Color(106, 5, 35),
            new SharpenFunction().apply(2,1,this.image2));
    assertEquals(new Color(122, 183, 229),
            new SharpenFunction().apply(1,3,this.image2));
    assertEquals(new Color(103, 73, 109),
            new SharpenFunction().apply(1,4,this.image2));
    assertEquals(new Color(120, 50, 2),
            new SharpenFunction().apply(2,3,this.image2));
    assertEquals(new Color(127, 171, 110),
            new SharpenFunction().apply(2,4,this.image2));
    assertEquals(new Color(147, 177, 139),
            new SharpenFunction().apply(3,0,this.image2));
    assertEquals(new Color(153, 220, 89),
            new SharpenFunction().apply(3,1,this.image2));
    assertEquals(new Color(174, 214, 64),
            new SharpenFunction().apply(3,2,this.image2));
    assertEquals(new Color(255, 255, 79),
            new SharpenFunction().apply(3,3,this.image2));
    assertEquals(new Color(255, 115, 126),
            new SharpenFunction().apply(3,4,this.image2));
    assertEquals(new Color(241, 75, 137),
            new SharpenFunction().apply(4,0,this.image2));
    assertEquals(new Color(255, 216, 225),
            new SharpenFunction().apply(4,1,this.image2));
    assertEquals(new Color(252, 212, 97),
            new SharpenFunction().apply(4,2,this.image2));
    assertEquals(new Color(255, 232, 45),
            new SharpenFunction().apply(4,3,this.image2));
    assertEquals(new Color(184, 179, 0),
            new SharpenFunction().apply(4,4,this.image2));

  }

  //used to test methods with a 2 by 2 board, so 4 pixels
  private void test2x2Color(ColorFunction func, Color ex1, Color ex2, Color ex3, Color ex4) {
    BufferedImage image = new BufferedImage(2, 2, 1);
    image.setRGB(0, 0, new Color(52, 255, 245).getRGB());
    image.setRGB(1, 0, new Color(255, 19, 24).getRGB());
    image.setRGB(0, 1, new Color(80, 255, 56).getRGB());
    image.setRGB(1, 1, new Color(255, 25, 238).getRGB());
    assertEquals(ex1, func.apply(0, 0, image));
    assertEquals(ex2, func.apply(1, 0, image));
    assertEquals(ex3, func.apply(0, 1, image));
    assertEquals(ex4, func.apply(1, 1, image));
  }

  //to test the Greyscale operation.
  @Test
  public void testGreyscale() {
    this.testColorFunction(new GreyscaleFunction(), new Color(158,158,158));
    Color color1 = new Color(211,211,211);
    Color color2 = new Color(69,69,69);
    Color color3 = new Color(203,203,203);
    Color color4 = new Color(89,89,89);

    this.test2x2Color(new GreyscaleFunction(), color1, color2, color3, color4);

    Color color5 = new Color(12,12,12);
    this.image3 = new BufferedImage(1,1,1);
    this.image3.setRGB(0, 0, new Color(52, 2, 0).getRGB());
    assertEquals(color5,
            new GreyscaleFunction().apply(0,0,this.image3));
  }


  //to test the Sepia operation.
  @Test
  public void testSepia() {
    this.testColorFunction(new SepiaFunction(), new Color(212,189,147));
    Color color1 = new Color(255,234,182);
    Color color2 = new Color(119,106,82);
    Color color3 = new Color(238,212,165);
    Color color4 = new Color(164,146,113);

    this.test2x2Color(new SepiaFunction(), color1, color2, color3, color4);

    Color color5 = new Color(63,56,43);
    this.image3 = new BufferedImage(1,1,1);
    this.image3.setRGB(0, 0, new Color(90, 6, 123).getRGB());
    assertEquals(color5,
            new SepiaFunction().apply(0,0,this.image3));
  }


}
