import java.util.Locale;
import java.util.Scanner;
//Jeg har kun kunne lave ceasar ciphered.
//Programmet skal køres igen for at skifte mellem encrypt og decrypt.
public class enigmaProject {
  Scanner in = new Scanner(System.in);
  String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

  public static void main(String[] args) {
    new enigmaProject().go();
  }

  public void go() {
    String choice = chooseToEncryptOrDecrypt();

    int shiftValue = inputShift();

    if (choice.equalsIgnoreCase("ENCRYPT")) {
      in.nextLine(); //Scanner Bug
      String inputSentence = inputTextToEncrypt();
      String EncryptedWord = encryption(inputSentence, shiftValue);
      System.out.println("Your input: " + inputSentence + " was encrypted to: " + EncryptedWord);
    }
    else if (choice.equalsIgnoreCase("DECRYPT")){
      in.nextLine(); //Scanner Bug
      String cypherInput = inputCipher();
      String decryptedWord = decryption(cypherInput, shiftValue);
      System.out.println("Your input: " + cypherInput + " was decrypted to: " + decryptedWord);
    }
  }

  public String chooseToEncryptOrDecrypt() {
    System.out.println("Would you like to encrypt a message or decrypt message?: ");
    String choice = in.nextLine().toUpperCase(Locale.ROOT);
    return choice;
  }

  public String inputTextToEncrypt() {

    System.out.print("Enter the sentance you would like to encrypt: ");
    String textInput = in.nextLine().toUpperCase(Locale.ROOT);
    return textInput;
  }

  public int inputShift() {

    System.out.print("Enter the shift value to use: ");
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

  public String inputCipher() {
    System.out.println("Input the word you would like to decrypt");
    String userInput = in.nextLine().toUpperCase(Locale.ROOT);
    return userInput;
  }
  public String decryption(String cypherInput, int shiftValue){
    int[] stringIntoNumbersDecrypt = stringIntoNumbersDecrypt(cypherInput);
    int[] shiftednumbersDecrypt = shiftNumbersDecrypt(stringIntoNumbersDecrypt, shiftValue);
    String decryptedMessage = makeStringFromShiftValuesDecrypt(shiftednumbersDecrypt);
    return decryptedMessage;
  }
  public int[] stringIntoNumbersDecrypt(String cypherInput) {
    int[] arrayStoreCipherInput = new int[cypherInput.length()];
    for (int i = 0; i < cypherInput.length(); i++) {
      ;
      arrayStoreCipherInput[i] = letterToNumberDecrypt(cypherInput.charAt(i));
    }
    return arrayStoreCipherInput;
  }
  public int[] shiftNumbersDecrypt(int[] arrayOfNumbersDecrypt, int shiftNumber) {
    for (int i = 0; i < arrayOfNumbersDecrypt.length; i++) {
      arrayOfNumbersDecrypt[i] = arrayOfNumbersDecrypt[i] - shiftNumber;
    }
    return arrayOfNumbersDecrypt;
  }

  public int letterToNumberDecrypt(char letter) {
    int indexOfChar = alphabet.indexOf(letter);
    return indexOfChar;
  }
  public String makeStringFromShiftValuesDecrypt(int[] arrayOfShiftNumbersDecrypt) {
    //String[] stringShiftValues = new String[arrayOfShiftNumbers.length];
    String decryptedMessage = "";
    char x;
    for (int i = 0; i < arrayOfShiftNumbersDecrypt.length; i++) {
      x = numberToLetterDecrypt(arrayOfShiftNumbersDecrypt[i]);
      decryptedMessage += x;
    }
    return decryptedMessage;
  }

  public char numberToLetterDecrypt(int number) {
    char charAtIndexDecrypt = alphabet.charAt(number);
    return charAtIndexDecrypt;
  }
}
