import java.util.Locale;
import java.util.Scanner;

public class enigmaProject {
  Scanner in = new Scanner(System.in);
  String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

  public static void main(String[] args) {
    new enigmaProject().go();
  }

  public void go() {
    String choice = chooseToEncryptOrDecrypt();
    String inputSentence = inputTextToEncrypt();
    int shiftValue = inputShift();

    if (choice.equalsIgnoreCase("ENCRYPT")) {
      String EncryptedWord = encryption(inputSentence, shiftValue);
      System.out.println("Your input: " + inputSentence + " was encrypted to: " + EncryptedWord);
    }
    else if (choice.equalsIgnoreCase("DECRYPT")){
      System.out.println("Decrypt");
    }
  }

  public String chooseToEncryptOrDecrypt() {
    System.out.println("Would you like to encrypt a messeage or decrypt messeage?: ");
    String choice = in.nextLine().toUpperCase(Locale.ROOT);
    return choice;
  }

  public String inputTextToEncrypt() {

    System.out.print("Pleace enter the sentance you would like to encrypt: ");
    String textInput = in.nextLine().toUpperCase(Locale.ROOT);
    return textInput;
  }

  public int inputShift() {

    System.out.print("Please enter the shift value to use: ");
    int shiftInPut = in.nextInt();
    return shiftInPut;
  }

  public int[] textInputToNumbers(String textInput) {
    int[] arrayStoreTextInput = new int[textInput.length()];
    for (int i = 0; i < textInput.length(); i++) {

      arrayStoreTextInput[i] = charToInt(textInput.charAt(i));
    }
    return arrayStoreTextInput;
  }

  public int charToInt(char letter) {
    int indexOfChar = alphabet.indexOf(letter);
    return indexOfChar;
  }

  public int[] shiftNumbers(int[] arrayOfNumbers, int shiftNumber) {
    for (int i = 0; i < arrayOfNumbers.length; i++) {
      arrayOfNumbers[i] = arrayOfNumbers[i] + shiftNumber;
    }
    return arrayOfNumbers;
  }

  public String shiftValuesToString(int[] arrayOfShiftNumbers) {
    String encryptedText = "";
    char x;
    for (int i = 0; i < arrayOfShiftNumbers.length; i++) {
      x = intToChar(arrayOfShiftNumbers[i]);
      encryptedText += x;
    }
    return encryptedText;
  }

  public char intToChar(int number) {
    char charAtIndex = alphabet.charAt(number);

    return charAtIndex;
  }

  public String encryption(String inputSentence, int shiftValue) {
    int[] stringToNumbers = textInputToNumbers(inputSentence);
    int[] shiftedNumbers = shiftNumbers(stringToNumbers, shiftValue);
    String encryptedText = shiftValuesToString(shiftedNumbers);
    return encryptedText;
  }
}
