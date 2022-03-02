import java.util.Locale;
import java.util.Scanner;

public class enigmaProject {
  Scanner in = new Scanner(System.in);
  String alphabet =" ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";



  public static void main(String[] args) {
    //enigmaProject project = new enigmaProject();
    new enigmaProject().go();
    /*
    String answer = project.chooseToEncryptOrDecrypt();
    String text = project.inputTextToEncrypt();
    int shiftValue = project.inputShift();
     */
  }

  public void go(){
    chooseToEncryptOrDecrypt();
    inputTextToEncrypt();
    inputShift();

  }

  public String chooseToEncryptOrDecrypt(){
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

  public int[] textInputToNumbers(String textInput){
    int[] arrayStoreTextInput = new int[textInput.length()];
    for (int i = 0; i < textInput.length(); i++){

      arrayStoreTextInput[i] = charToInt(textInput.charAt(i));
    }
    return arrayStoreTextInput;
  }

  public int charToInt(char letter){
    int indexOfChar = alphabet.indexOf(letter);
    return indexOfChar;
  }
}
