import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		try {
			// generate a maze
			MazeGen g = new MazeGen(10, 20); // create new blank maze
			g.generate(); // note: you can call generate() multiple times to re-generate a maze of the same size
			g.writeToFile("maze.txt"); // self-explanatory

			// solve the maze
			Maze m = new Maze("maze.txt");
			m.solve();
			System.out.println(m);


      MazeGen t = new MazeGen(10, 20); // create new blank maze
      t.generate(); // note: you can call generate() multiple times to re-generate a maze of the same size
      t.writeToFile("maze3.txt"); // self-explanatory

      // solve the maze
      Maze d = new Maze("maze3.txt");
      d.solve();
      System.out.println(d);

		} catch (IOException e) {}
	}
}
