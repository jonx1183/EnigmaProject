import java.util.Scanner;

public class enigmaProject {
  Scanner in = new Scanner(System.in);
  String text;
  int shift;

  public static void main(String[] args) {
    new enigmaProject().go();
  }

  public void go(){
    ceasarCipherInput();

  }

  public void ceasarCipherInput(){
    System.out.print("Please enter text to encrypt:");
    text = in.nextLine();

    System.out.print("Enter shift value: ");
    shift = in.nextInt();
  }


}
