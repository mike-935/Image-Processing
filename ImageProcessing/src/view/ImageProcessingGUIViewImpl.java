package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 * Represents an implementation of a GUI view for an image processing program.
 */
public class ImageProcessingGUIViewImpl extends JFrame implements ImageProcessingGUIView {
  private final ArrayList<JButton> buttons;
  private final JLabel imagePanel;
  private final ImageHistogramPanel histogram;
  private final JTextField brightenInput;
  private final JTextField darkenInput;
  private final JLabel messageLabel;
  private final JList<String> imageListPanel;
  private final DefaultListModel<String> imageList;

  /**
   * Constructs a new ImageProcessingGUIView implementation.
   */
  public ImageProcessingGUIViewImpl() {
    this.setTitle("Image Processing");
    this.setSize(640, 480);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    JScrollPane mainScrollPane = new JScrollPane(mainPanel);
    this.add(mainScrollPane);

    this.imagePanel = new JLabel();
    mainPanel.add(this.imagePanel);

    this.histogram = new ImageHistogramPanel(new BufferedImage(1, 1, 1));
    mainPanel.add(this.histogram);

    this.buttons = new ArrayList<JButton>();
    this.buttons.add(new JButton("load"));
    this.buttons.add(new JButton("save"));
    this.buttons.add(new JButton("red-component"));
    this.buttons.add(new JButton("green-component"));
    this.buttons.add(new JButton("blue-component"));
    this.buttons.add(new JButton("value-component"));
    this.buttons.add(new JButton("intensity-component"));
    this.buttons.add(new JButton("luma-component"));
    this.buttons.add(new JButton("horizontal-flip"));
    this.buttons.add(new JButton("vertical-flip"));
    this.buttons.add(new JButton("blur"));
    this.buttons.add(new JButton("sharpen"));
    this.buttons.add(new JButton("greyscale"));
    this.buttons.add(new JButton("sepia"));
    this.buttons.add(new JButton("brighten"));
    this.buttons.add(new JButton("darken"));

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
    for (JButton button : this.buttons) {
      button.setActionCommand(button.getName());
    }

    for (int i = 0; i < this.buttons.size() - 2; i += 1) {
      buttonPanel.add(this.buttons.get(i));
    }
    this.brightenInput = new JTextField(3);
    this.darkenInput = new JTextField(3);

    for (int i = this.buttons.size() - 2; i < this.buttons.size(); i += 1) {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      buttonPanel.add(panel);
      panel.add(this.buttons.get(i));
      if (i == this.buttons.size() - 1) {
        panel.add(this.darkenInput);
      } else {
        panel.add(this.brightenInput);
      }
    }
    JPanel gridPanel = new JPanel();
    gridPanel.setLayout(new GridLayout(1, 0, 10, 10));
    gridPanel.add(buttonPanel);
    this.imageList = new DefaultListModel<String>();
    this.imageListPanel = new JList<String>(this.imageList);
    gridPanel.add(this.imageListPanel);
    mainPanel.add(gridPanel);
    JPanel outerPanel = new JPanel();
    outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));
    this.messageLabel = new JLabel();
    outerPanel.add(mainScrollPane);
    outerPanel.add(this.messageLabel);
    this.add(outerPanel);
  }

  @Override
  public void setImage(BufferedImage image) {
    this.imagePanel.setIcon(new ImageIcon(image));
    this.histogram.setImage(image);
  }

  @Override
  public int getBrightenInput() throws IllegalStateException {
    try {
      return Integer.parseInt(this.brightenInput.getText());
    } catch (NumberFormatException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  @Override
  public int getDarkenInput() throws IllegalStateException {
    try {
      return Integer.parseInt(this.darkenInput.getText());
    } catch (NumberFormatException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  @Override
  public void setActionListener(ActionListener listener) {
    for (JButton button : this.buttons) {
      button.addActionListener(listener);
    }
  }

  @Override
  public void setListListener(ListSelectionListener listener) {
    this.imageListPanel.addListSelectionListener(listener);
  }

  @Override
  public void addImageName(String name) {
    if (!this.imageList.contains(name)) {
      this.imageList.addElement(name);
    }
    this.imageListPanel.setSelectedValue(name, true);
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.messageLabel.setText(message);
  }

  @Override
  public String getSelectedImage() {
    return this.imageListPanel.getSelectedValue();
  }
}
