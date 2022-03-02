import java.util.Scanner;

public class enigmaProject {
  Scanner in = new Scanner(System.in);
  String alphabet =" ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";


  public static void main(String[] args) {
    new enigmaProject().go();
  }

  public void go(){
    String text = inputTextToIncrypt();
    int shift = inputShift();

  }

  private String inputTextToIncrypt() {

    String textInput =in.nextLine();
    return textInput;
  }

  private int inputShift() {

    int shiftInPut = in.nextInt();
    return shiftInPut;
  }
}
