package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

/**
 * Represents a Panel to view the histogram of the given image.
 */
public class ImageHistogramPanel extends JPanel {
  private Map<Integer, Integer> redChannel;
  private Map<Integer, Integer> greenChannel;
  private Map<Integer, Integer> blueChannel;
  private Map<Integer, Integer> valueComponent;
  private BufferedImage image;

  /**
   * Constructs a new ImageHistogramPanel from the given image.
   *
   * @param image the image to view the histogram of
   */
  public ImageHistogramPanel(BufferedImage image) {
    super();
    this.setImage(image);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);

    int originX = 50;
    int originY = 20;
    int maxY = originY + 250;
    int maxX = originX + 510;

    g.drawLine(originX, maxY, maxX, maxY);
    g.drawLine(originX, maxY, originX, originY);
    int maxFrequency = 0;
    for (int i : this.valueComponent.values()) {
      maxFrequency = Math.max(maxFrequency, i);
    }
    for (int i : this.redChannel.values()) {
      maxFrequency = Math.max(maxFrequency, i);
    }
    for (int i : this.greenChannel.values()) {
      maxFrequency = Math.max(maxFrequency, i);
    }
    for (int i : this.blueChannel.values()) {
      maxFrequency = Math.max(maxFrequency, i);
    }
    g.setColor(new Color(255, 0, 0, 50));
    for (int i = 0; i < 256; i += 1) {
      if (this.redChannel.get(i) != null) {
        g.drawRect(originX + (i * 2),
                maxY,
                2, -(int) (maxY * (this.redChannel.get(i) / (double) maxFrequency)));
      }
    }
    g.setColor(new Color(0, 255, 0, 50));
    for (int i = 0; i < 256; i += 1) {
      if (this.greenChannel.get(i) != null) {
        g.drawRect(originX + (i * 2),
                maxY,
                2, -(int) (maxY * (this.greenChannel.get(i) / (double) maxFrequency)));
      }
    }
    g.setColor(new Color(0, 0, 255, 50));
    for (int i = 0; i < 256; i += 1) {
      if (this.blueChannel.get(i) != null) {
        g.drawRect(originX + (i * 2),
                maxY,
                2, -(int) (maxY * (this.blueChannel.get(i) / (double) maxFrequency)));
      }
    }
    g.setColor(new Color(0, 0, 0, 50));
    for (int i = 0; i < 256; i += 1) {
      if (this.valueComponent.get(i) != null) {
        g.drawRect(originX + (i * 2),
                maxY,
                2, -(int) (maxY * (this.valueComponent.get(i) / (double) maxFrequency)));
      }
    }
  }

  private void initMaps() {
    this.redChannel = new HashMap<Integer, Integer>();
    this.greenChannel = new HashMap<Integer, Integer>();
    this.blueChannel = new HashMap<Integer, Integer>();
    this.valueComponent = new HashMap<Integer, Integer>();
    for (int i = 0; i < 256; i += 1) {
      this.redChannel.put(i, 0);
      this.greenChannel.put(i, 0);
      this.blueChannel.put(i, 0);
      this.valueComponent.put(i, 0);
    }
    for (int x = 0; x < image.getWidth(); x += 1) {
      for (int y = 0; y < image.getHeight(); y += 1) {
        Color color = new Color(image.getRGB(x, y));
        this.redChannel.put(color.getRed(), this.redChannel.get(color.getRed()) + 1);
        this.greenChannel.put(color.getGreen(), this.greenChannel.get(color.getGreen()) + 1);
        this.blueChannel.put(color.getBlue(), this.blueChannel.get(color.getBlue()) + 1);
        int maxValue = Math.max(color.getRed(), Math.max(color.getGreen(), color.getBlue()));
        this.valueComponent.put(maxValue, this.valueComponent.get(maxValue) + 1);
      }
    }
  }

  /**
   * Sets the image to be used to create the histogram for this panel.
   *
   * @param image the image to be set
   */
  public void setImage(BufferedImage image) {
    this.image = image;
    this.setPreferredSize(new Dimension(640, 300));
    this.initMaps();
  }
}
