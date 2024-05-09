package controller.commands;

/**
 * Represents an abstract Image Processing Command to reduce duplicate code.
 */
public abstract class AbstractIPCommand implements ImageProcessingCommands {
  protected final String filename;
  protected final String newName;

  public AbstractIPCommand(String filename, String newName) {
    this.filename = filename;
    this.newName = newName;
  }
}
