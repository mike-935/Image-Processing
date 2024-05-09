import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import view.ImageHistogramPanel;
import view.ImageProcessingGUIView;
import view.ImageProcessingGUIViewImpl;

import static org.junit.Assert.*;

public class ImageProcessingGUIViewImplTest {

  private ImageProcessingGUIView guiView1;
  private ImageHistogramPanel histogram1;
  private ImageProcessingGUIView guiView2;
  private ImageHistogramPanel histogram2;
  private BufferedImage image1;
  private BufferedImage oldImage;

  @Before
  public void setup() {
    this.guiView1 = new ImageProcessingGUIViewImpl();
    this.image1 = new BufferedImage(2,2,1);

    for (int i = 0; i < this.image1.getWidth() ; i++) {
      for (int j = 0; j < this.image1.getHeight() ; j++) {
        this.image1.setRGB(i,j, new Color(200,30, 70).getRGB());
      }
    }

    this.oldImage = new BufferedImage(2,2,1);
    for (int i = 0; i < oldImage.getWidth() ; i++) {
      for (int j = 0; j < oldImage.getHeight() ; j++) {
        oldImage.setRGB(i,j, new Color(100,200, 70).getRGB());
      }
    }

    this.histogram1 = new ImageHistogramPanel(this.oldImage);
  }
  @Test
  public void setImage() {

    for (int i = 0; i < oldImage.getWidth() ; i++) {
      for (int j = 0; j < oldImage.getHeight() ; j++) {
        assertNotEquals(oldImage.getRGB(i,j), this.image1.getRGB(i,j));
      }
    }

  }

}