import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze {
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
  private void cPoss() throws FileNotFoundException {
    int[] s = fStart();
    int
  }
  private void wrArray() throws FileNotFoundException {
    Scanner inf = new Scanner(text);
    int r = 0;
    int r2 = 0;
    int c = 0;
    //read through the text, initialize the right size array
    while (inf.hasNextLine()) {
      r++;
      String line = inf.nextLine();
      c = line.length();
    }
    maze = new char[r][c];

    //read again to fill in the array spots.
    Scanner in = new Scanner(text);
    while (in.hasNextLine()) {
      String line = in.nextLine();
      for (int i = 0; i < line.length(); i++) {
        maze[r2][i] = line.charAt(i);
        //System.out.println(line.charAt(i));
      }
      r2++;
    }
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
  private int[] fStart() {
    int[] loc = new int[2]; //store location
    for (int r = 0; r < maze.length; r++) {
      for (int c = 0; c < maze[r].length; c++) {
        if (maze[r][c] == 'S') {
          loc[0] = r;
          loc[1] = c;
          return loc;
        }
        if (r = maze.length -1 && c = maze[r].length -1 && maze[maze.length -1][maze[r].length -1] != 'S') {
          loc[0] = -1;
          loc[1] = -1;
          return loc;
        }
      }
    }
    return loc;
  }
  public int solve(){
    int[] ary = fStart();
    return solve(ary[0], ary[1]);
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
  private int solve(int row, int col){ //you can add more parameters since this is private
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
