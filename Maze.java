import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
  private int sr, sc, er, ec, r, c;
  private char[][] maze;
  private File text;
  private boolean animate;//false by default

    /*
    Constructor loads a maze text file, and sets animate to false by default.
    1. The file contains a rectangular ascii maze, made with the following 4 characters:
    '#' - Walls - locations that cannot be moved onto
    ' ' - Empty Space - locations that can be moved onto
    'E' - the location of the goal (exactly 1 per file)
    'S' - the location of the start(exactly 1 per file)
    2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
    3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
    throw a FileNotFoundException or IllegalStateException
    */
  public Maze(String file) throws FileNotFoundException {
    text = new File(file);
    wrArray();

  }
  private void wrArray() throws FileNotFoundException {
    Scanner inf = new Scanner(text);
    int r = 0;
    int c = 0;
    //read through the text, initialize the right size array
    while (inf.hasNextLine()) {
      r++;
      String line = inf.nextLine();
      if (line.length() > c) c = line.length();
    }
    maze = new char[r][c];

    //read again to fill in the array spots.
    boolean sCheck = false;
    boolean eCheck = false;

    Scanner in = new Scanner(text);
    for (int row = 0; row < r; row++) {
      String line = in.nextLine();
      for (int col = 0; col < c; col++) {
        char ch = line.charAt(col);
        if (ch == 'S') {
          sCheck = true;
          sr = row;
          sc = col;
        }
        if (ch == 'E') {
          eCheck = true;
          er = row;
          sc = col;
        }
        maze[row][col] = ch;
      }
    }
    if (!(eCheck && sCheck)) throw new IllegalStateException("missing End or Start");
  }

  private void wait(int millis){
     try {
         Thread.sleep(millis);
     }
     catch (InterruptedException e) {
     }
   }
  public void setAnimate(boolean b){
    animate = b;
  }
  public void clearTerminal(){
    //erase terminal, go to top left of screen.
    System.out.println("\033[2J\033[1;1H");
  }

  /*
  Return the string that represents the maze.
  It should look like the text file with some characters replaced.
  */
  public String toString() {
    String out = "";
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        out+= maze[i][j];
      }
      out += "\n";
    }
    return out;
  }

  /*
  Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve(){
    return solveH(sr, sc);
    }
  //find the location of the S.
  //erase the S
  //and start solving at the location of the s.
  //return solve(???,???);

  /*
  Recursive Solve function:
  A solved maze has a path marked with '@' from S to E.
  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.

  Postcondition:
  The S is replaced with '@' but the 'E' is not.
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private int solveH(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }
    //COMPLETE SOLVE
    return -1; //so it compiles
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
    else {
      System.out.println("I need a maze file to operate! Enter one in as an argument!");
    }
  }

}
