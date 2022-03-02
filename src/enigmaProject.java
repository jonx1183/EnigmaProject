import java.util.Scanner;

public class enigmaProject {
  Scanner in = new Scanner(System.in);
  String alphabet =" ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";


  public static void main(String[] args) {
    new enigmaProject().go();
  }

  public void go(){

    chooseToEncryptOrDecrypt();
    inputTextToEncrypt();
    inputShift();
  }

  public String chooseToEncryptOrDecrypt(){
    System.out.println("Would you like to encrypt a messeage or decrypt messeage?: ");
    String choice = in.nextLine();
    return choice;
  }

  public String inputTextToEncrypt() {

    System.out.print("Pleace enter the sentance you would like to encrypt: ");
    String textInput = in.nextLine();
    return textInput;
  }

  public int inputShift() {

    System.out.print("Please enter the shift value to use: ");
    int shiftInPut = in.nextInt();
    return shiftInPut;
  }
}
