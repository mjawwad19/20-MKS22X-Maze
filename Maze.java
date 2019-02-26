import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  public Maze(String file) throws FileNotFoundException {
    File text = new File(file);
    Scanner inf = new Scanner(text);
    while(inf.hasNextLine()){
      String line = inf.nextLine();
      System.out.println(line);
    }
  }
  public static void main(String[] args) {
    if (args.length == 1) {
      try {
        Maze a = new Maze(args[0]);
      }catch (FileNotFoundException e) {
        System.out.println("File does not exist, try another file name");

      }
    }
  }

}
