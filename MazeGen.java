import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MazeGen{
  private int r, c, er, ec, sr, sc;
  private char[][] maze;
  public MazeGen(String name,int row, int col, int endR, int endC, int startR, int startC ) {
    File txt = new File(name);
    gen(row, col, endR, endC, startR, startC);
  }

  public void gen(int row, int col, int endR, int endC, int startR, int startC){
    if (!(row >= 0 || col >= 0 ||
        endR >= 1 || endR < row - 1 ||
        startR >=1|| startR < row -1||
        endC >= 1 || endC < col -1  ||
        startC >=1|| startC< col -1)){
        throw new IllegalArgumentException("Rows and Cols can't be 0; The location of the start and End must be within the walls!");
    }
    r = row;
    c = col;
    er = endR;
    ec = endC;
    sr = startR;
    sc = startC;

    //wall off!
    for (int co = 0; co < c; co++) {
      maze[0][co] = '#';
      maze[r-1][co] = '#';
    }
    for (int ro = 0; ro < r; ro++) {
      maze[ro][0] = '#';
      maze[ro][c-1] = '#';
    }
    //add start and end
    maze[sr][sc] = 'S';
    maze[er][ec] = 'E';
  }

  public String toString() {
    String out = "";
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        out+= maze[i][j];
      }
      out+= "\n";
    }
    return out;
  }

  public static void main(String[]args) {
    if (args.length == 7) {
      MazeGen a = new MazeGen(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]),
                              Integer.parseInt(args[4]),Integer.parseInt(args[5]),Integer.parseInt(args[6]));
      System.out.println(a);
    }
    else {
      System.out.println("list the filename, row size, col size, end row location, end col location, start row location, and start col location");
    }
  }

}
