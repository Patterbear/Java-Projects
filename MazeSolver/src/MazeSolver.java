import java.util.LinkedList;

public class MazeSolver {
	
	//Creation of maze as static collection
	static int[][] maze = {
			{2, 0, 1, 1},
			{1, 1, 1, 0},
			{0, 0, 0, 1}
	};
	
	//Key
	//0 = wall
	//1 = path
	//2 = destination
	
	//Static Stack created to store the path the solver has taken
	static LinkedList<Position> path = new LinkedList<Position>();
	
	public static void main(String[] args) {
		
		//Starting position created and added to stack
		Position p = new Position(0, 3);
		path.push(p);
		
		//While loop to search the maze
		while(true) {
			
			//Assigning stack values to variables
			int y = path.peek().y;
			int x = path.peek().x;

			//Marking visited positions with a 0
			maze[y][x] = 0;
			
			//Checking value below position
			if(maze[y+1][x] == 2) {
				System.out.println("Moved down");
				System.out.println("You won");
				return;
			} else if(maze[y+1][x] == 1) {
				System.out.println("Moved down");
				path.push(new Position(y+1, x));
				continue;
			}
			
			//Checking value left of position
			if(maze[y][x-1] == 2) {
				System.out.println("Moved left");
				System.out.println("You won");
				return;
			} else if(maze[y][x-1] == 1) {
				System.out.println("Moved left");
				path.push(new Position(y, x-1));
				continue;
			}
			
			//Checking value above position
			if(maze[y-1][x] == 2) {
				System.out.println("Moved up");
				System.out.println("You won");
				return;
			} else if(maze[y-1][x] == 1) {
				System.out.println("Moved up");
				path.push(new Position(y-1, x));
				continue;
			}
			
			//Checking value right of position
			if(maze[y][x+1] == 2) {
				System.out.println("Moved left");
				System.out.println("You won");
				return;
			} else if(maze[y][x+1] == 1) {
				System.out.println("Moved left");
				path.push(new Position(y, x+1));
				continue;
			}
			path.pop();
			if(path.size() <= 0) {
				System.out.println("No path.");
			}
		}
	}

}
