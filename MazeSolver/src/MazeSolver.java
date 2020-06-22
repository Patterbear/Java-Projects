import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MazeSolver {
	
	//Main Class
	public static void main(String[] args) throws FileNotFoundException {
		
		//Method called to return an ArrayList of mazes in the text file
		ArrayList<Maze> mazes = readMazes();
		
		//Key
		//0 = wall
		//1 = path
		//2 = destination
		
		//While loop used with index variable 'i' to iterate through ArrayList 'mazes'
		int i = 0;
		while(i < mazes.size()) {
			
			//SolveMaze method called with starting coordinates
			if(solveMaze(mazes.get(i))) {
				System.out.println("You won");
				System.out.println();
			}else {
				System.out.println("No path.");
				System.out.println();
			}
			i++;
		}
	
	}

	//Method to output the final path taken by the solver
	private static void outputPath(Maze m) {
		
		//Prints out contents of Queue and removes square brackets
		System.out.println("Final path: " + m.finalPath.toString().replaceAll("\\[", "").replaceAll("]", ""));
	}
		
	//Method to read the mazes from the text file
	private static ArrayList<Maze> readMazes() throws FileNotFoundException {
		
		//ArrayList created containing type 'Maze'
		ArrayList <Maze> mazes = new ArrayList<Maze>();
		
		//Scanner instantiated to scan .txt file
		Scanner in = new Scanner(new File("Mazes.txt"));
		
		//Object 'm' instantiated from class 'Maze'
		while(in.hasNext()) {
			Maze m = new Maze();
			
			//Number of rows established from reading first line of .txt file
			int rows = Integer.parseInt( in.nextLine());
			
			//New maze created as a 2D array with rows determined by variable 'rows'
			m.maze = new int[rows][];
			
			//For loop to add each line of the text file into a row of the 3D array 'm.maze'
			for(int i = 0; i < rows; i++) {
				String line = in.nextLine();
				m.maze[i] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();
			}
			
			//Starting position assigned by the last 2 lines rows of the .txt file
			m.start = new Position(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
			
			//Ignores '-' divider betwen mazes in text file
			in.nextLine();
			
			//Object 'm' added to the 'mazes' ArrayList
			mazes.add(m);
		}
		in.close();
		
		
		//ArrayList variable returned
		return mazes;

	}

	//Method to solve maze with given position
	private static boolean solveMaze(Maze m) {
		Position p = m.start;
		m.path.push(p);
		m.finalPath.add("(" + p.y + ", " + p.y + ")");
		
		//While loop to search the maze
		while(true) {
			
			//Assigning stack values to variables
			int y = m.path.peek().y;
			int x = m.path.peek().x;

			//Marking visited positions with a 0
			m.maze[y][x] = 0;
			
			//If statement to check whether a move down is possible
			if(isValid(y+1, x, m)) {
				
				//Checking value below position
				if(m.maze[y+1][x] == 2) {
					System.out.println("Moved down");
					outputPath(m);
					return true;
				} else if(m.maze[y+1][x] == 1) {
					System.out.println("Moved down");
					m.path.push(new Position(y+1, x));
					m.finalPath.add("(" + (y+1) + ", " + x + ")");
					continue;
				}
			}

			//If statement to check whether a move left is possible
			if(isValid(y, x-1, m)) {
				
				//Checking value left of position
				if(m.maze[y][x-1] == 2) {
					System.out.println("Moved left");
					outputPath(m);
					return true;
				} else if(m.maze[y][x-1] == 1) {
					System.out.println("Moved left");
					m.path.push(new Position(y, x-1));
					m.finalPath.add("(" + y + ", " + (x-1) + ")");
					continue;
				}
			}
			
			//If statement to check whether a move up is possible
			if(isValid(y-1, x, m)) {
				
				//Checking value above position
				if(m.maze[y-1][x] == 2) {
					System.out.println("Moved up");
					outputPath(m);
					return true;
				} else if(m.maze[y-1][x] == 1) {
					System.out.println("Moved up");
					m.path.push(new Position(y-1, x));
					m.finalPath.add("(" + (y-1) + ", " + x + ")");
					continue;
				}
			}
			
			//If statement to check whether a move right is possible
			if(isValid(y, x+1, m)) {
				
				//Checking value right of position
				if(m.maze[y][x+1] == 2) {
					System.out.println("Moved right");
					outputPath(m);
					return true;
				} else if(m.maze[y][x+1] == 1) {
					System.out.println("Moved right");
					m.path.push(new Position(y, x+1));
					m.finalPath.add("(" + y + ", " + (x-1) + ")");
					continue;
				}
			}
			
			//Popping latest coordinates from stack
			m.path.pop();
			m.finalPath.remove();
			System.out.println("Backtracking...");
			
			//Message output if stack is empty
			if(m.path.size() <= 0) {
				return false;
			}
		}
	}

	//Method to check whether the current coordinate is out bounds
	public static boolean isValid(int y, int x, Maze m) {
		if(y < 0 ||
				y >= m.maze.length ||
				x < 0 ||
				x >= m.maze[y].length
				) {
			return false;
		}
		return true;
	}
}
