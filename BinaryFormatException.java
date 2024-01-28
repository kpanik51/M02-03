public class BinaryFormatException extends Exception {
  public BinaryFormatException(String message) {
    super(message);
  }
}

public class BinaryConverter {
  public static void main(String[] args) {
    try {
      String binaryString = "1010101";
      int decimalValue = bin2Dec(binaryString);
      System.out.println("Decimal value: " + decimalValue);
    } catch (BinaryFormatException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static int bin2Dec(String binaryString) throws BinaryFormatException {

    if (!isBinaryString(binaryString)) {
      throw new BinaryFormatException("Invalid binary string: " + binaryString);
    }

    int decimalValue = 0;
    for (int i = 0; i < binaryString.length(); i++) {
      char bit = binaryString.charAt(i);
      decimalValue = decimalValue * 2 + (bit - '0');
    }

    return decimalValue;
  }

  private static boolean isBinaryString(String str) {
    for (char c : str.toCharArray()) {
      if (c != '0' && c != '1') {
        return false;
      }
    }
    return true;
  }
}