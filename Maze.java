import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  private char[][] m;
  private File text;
  public Maze(String file) throws FileNotFoundException {
    text = new File(file);
    wrArray();
  }

  private void wrArray() throws FileNotFoundException {
    Scanner inf = new Scanner(text);
    int r = 0;
    int r2 = 0;
    int c = 0;
    //String save = "";
    while (inf.hasNextLine()) {
      r++;
      String line = inf.nextLine();
      //save = line + "\n";
      c = line.length();
    } //read through the initialize the right size array
    m = new char[r][c];

    //read again to fill in the array spots.
    Scanner in = new Scanner(text);
    while (in.hasNextLine()) {
      String line = in.nextLine();
      for (int i = 0; i < line.length(); i++) {
        m[r2][i] = line.charAt(i);
        //System.out.println(line.charAt(i));
      }
      r2++;
    }
  }
  public String toString() {
    String out = "";
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        out+= m[i][j];
      }
      out += "\n";
    }
    return out;
  }
  public static void main(String[] args) {
    if (args.length == 1) {
      try {
        Maze a = new Maze(args[0]);
        System.out.println(a);
      }catch (FileNotFoundException e) {
        System.out.println("File does not exist");

      }
    }
  }

}
