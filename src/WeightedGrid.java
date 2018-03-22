
public class WeightedGrid {

	final static int NUM_ROWS = 3;
	final static int NUM_COLS = 4;

	public static void main(String[] args) {

		//Calling
		initializeGrid();
		printArray();
	}

	public static int[][] initializeGrid(){
		// Create array
		int[][] grid;
		grid = new int[NUM_ROWS][NUM_COLS];
		return grid;
	}
	public static void printArray(int[][] grid){
		for (int i=0; i< NUM_ROWS; i++){
			for (int j =0; j<NUM_COLS; j++){
				System.out.print(grid [i][j]);
			}
			System.out.println();
		}
	}
}
