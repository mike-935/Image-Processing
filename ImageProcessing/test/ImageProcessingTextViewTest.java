import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import view.ImageProcessingTextView;
import view.ImageProcessingView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * To represent the test class for tests on the view's functionality.
 */
public class ImageProcessingTextViewTest {

  private ImageProcessingView view1;
  private Appendable stringBuilder1;
  private ImageProcessingView view2;
  private Appendable stringBuilder2;

  //to set up our data
  @Before
  public void setup() {
    this.stringBuilder1 = new StringBuilder();
    this.view1 = new ImageProcessingTextView(this.stringBuilder1);
    this.stringBuilder2 = new StringBuilder("Hello ");
    this.view2 = new ImageProcessingTextView(this.stringBuilder2);
  }

  //to test renderMessage
  @Test
  public void renderMessage() throws IOException {
    assertEquals("",this.stringBuilder1.toString());
    assertEquals("Hello ",this.stringBuilder2.toString());
    this.view1.renderMessage("Uh oh");
    assertEquals("Uh oh", this.stringBuilder1.toString());
    this.view2.renderMessage("my friend");
    assertEquals("Hello my friend", this.stringBuilder2.toString());

    try {
      MyAppendObject failAppend1 = new MyAppendObject();
      ImageProcessingView failView1 = new ImageProcessingTextView(failAppend1);
      failView1.renderMessage("Will fail :(");
      fail("Should throw an exception");
    } catch (IOException e) {
      //do nothing
    }

    try {
      MyAppendObject failAppend2 = new MyAppendObject();
      ImageProcessingView failView2 = new ImageProcessingTextView(failAppend2);
      failView2.renderMessage("");
      fail("Should throw an exception");
    } catch (IOException e) {
      //do nothing
    }
  }

  //to test a valid initialization of the constructor.
  @Test
  public void testValidConstructor() throws IOException {
    this.view1.renderMessage("Should pass");
    assertEquals("Should pass", this.stringBuilder1.toString());
    this.view2.renderMessage("If it didn't test would fail");
    assertEquals("Hello If it didn't test would fail", this.stringBuilder2.toString());
  }

  //to test an invalid constructor.
  @Test
  public void testInvalidConstructor() {
    try {
      ImageProcessingView failView3 = new ImageProcessingTextView(null);
      fail("Should have failed");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

    try {
      ImageProcessingView failView4 = new ImageProcessingTextView(null);
      fail("Should have failed");
    } catch (IllegalArgumentException e) {
      //do nothing
    }

  }



}