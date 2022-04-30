package Wargames.backend.filehandler;

public class UnitFormatException extends IllegalArgumentException {
  /**
   * Constructs a ContactDetailsFormatException with no detail message.
   */
  public UnitFormatException() {
    super("Could not convert the string to an ContactDetails-object..");
  }

  /**
   * Constructs a ContactDetailsFormatException with the specified detail message.
   *
   * @param s the detail message
   */
  public UnitFormatException(String s) {
    super(s);
  }
}
