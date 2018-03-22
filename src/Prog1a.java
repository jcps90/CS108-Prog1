/**
 * Program #1
 * @description This program takes a predetermined array of values 
 * 				and weighs each cell in the array. The program will 
 * 				also locate the lowest values in each row and print 
 * 				them next to the corresponding
 * 				row.
 * CS108-3
 * @date 1/30/2017
 * @author Juan Pina-Sanz
 */

public class Prog1a {

	final static int ROWS = 5;
	final static  int COLS = 7;
	static double lowestValue = 0;

	public static void main(String[] args){
		
		int [][] arrayOne = initializeArray();
		double [][] arrayTwo = createWeightedArray(arrayOne);
		
		System.out.println("Program 1, Juan Pina-Sanz, sccsxxxx");
		printArray(arrayTwo);
		
		
		}

	/**
	 * Initializes the array to be used with the predetermined 
	 * values. This method can be called within main to create 
	 * multiple versions of the array.
	 * 
	 * @return int[][] array : The array created by the method 
	 * 						   to be used in main.
	 */
	public static int[][] initializeArray(){

		int[][] array = {{ 245, 248, 366, 255, 216, 213, 211},
						 { 245, 158, 158, 158, 101, 100,  85},
						 { 245, 158, 160, 160, 160, 100, 100},
						 { 245, 245, 245, 200, 200, 130, 100},
						 { 245, 245, 245, 245, 240, 240, 130}};   
		return array;
	}
	
	/**
	 * This method will create a weighted array composed of 
	 * double type values. It calls on the method getWeight 
	 * to find the weighted values of the array passed through 
	 * the method.
	 * 
	 * @param array : The array that is to be weighed
	 * @return double[][] : A new array of weighed values.
	 */
	public static double [][] createWeightedArray(int[][] array){
		
		double [][] weightedArray = new double[ROWS][COLS];
		for (int i=0; i < ROWS; i++){
			for (int j = 0; j < COLS; j++){
				weightedArray[i][j] = getWeight(array,i,j);
			}
		}
		return weightedArray;
	}
	
	/**
	 * This method will retrieve the adjacent values of the array 
	 * given. By utilizing a switch statement this method will 
	 * return values based on their location and the direction of 
	 * the adjacent cell in question.
	 * 
	 * @param int[][] array : An array of type int is passed through 
	 * 						  the method to locate adjacent values.
	 * @param i : Represents the 'x' coordinate in the array being passed.
	 * @param j : Represents the 'y' coordinate in the array being passed.
	 * @param direction : The direction the method looks in at the current 
	 * 					  reference point.
	 * @return int : The method returns the value found.
	 */
	public static int getAdjacentValue(int array[][], int i, int j, char direction) {
		
		switch (direction) {
		case 'n': if (i == 0) 		  {	return array[ROWS - 1][j];}
		else 	 					  { return array[i - 1][j];}

		case 's': if (i == (ROWS - 1)){	return array[0][j];	}
		else 						  {	return array[i + 1][j];}

		case 'w': if ( j == 0)		  { return array[i][COLS-1]; }
		else						  {	return array[i][j-1];}

		case 'e': if (j == (COLS-1))  {return array[i][0];}
		else						  {return array[i][j+1];}
		}
		return 0;
	}
	
	/**
	 * This method retrieves the weight of each cell.
	 * 
	 * @param int array [][] : The array passed through the getWeight.
	 * @param i : Represents the 'x' coordinate in the array being passed.
	 * @param j : Represents the 'y' coordinate in the array being passed.
	 * @return int : The method will return an int value of the weight 
	 * 				 of the current cell.
	 */
	public static int getWeight(int array[][], int i, int j){
		double deltaX, deltaY;
		int weight;
              	
        deltaX = Math.pow(Math.abs(getAdjacentValue(array, i, j, 'w') - getAdjacentValue(array, i, j, 'e')), 2);
        deltaY = Math.pow(Math.abs(getAdjacentValue(array, i, j, 'n') - getAdjacentValue(array, i, j, 's')), 2);
				
		weight = (int)(deltaX + deltaY);
		return weight;
	}

	/**
	 * This method retrieves the lowest value within a given array 
	 * and a given row.
	 * 
	 * @param double [][] : An array composed of double type numbers.
	 * @param row : The row of the array currently being searched.
	 * @return double : The lowest value in the current row of the array. 
	 */
	public static double getMin(double array [][], double row){
		double minValue = Integer.MAX_VALUE; 
		for (int j= 0; j < COLS; j++){
			if(minValue > array[(int)row][j]){
				minValue = array[(int)row][j];
			}
		}
		return minValue;
	}
	
	/**
	 * This method will format and print the array passed through. 
	 * Additionally it will call on methods that retrieve the lowest 
	 * values in each row of the passed method.
	 * 
	 * @param int array[][]: An int array being passed through to be 
	 * 						 printed.
	 */
	public static void printArray(double array[][]){
		for( int i = 0; i<ROWS; ++i){
			System.out.printf("Row %d:", i+1);
			for(int j = 0; j<COLS; ++j){
				System.out.printf("%10.1f", array[i][j]);
			}
			System.out.print("|");
			printMin(array, i);
		}
	}
	
	/**
	 * This simple method prints the value of the lowest number 
	 * in the specified row. Within this method the method 'getMin' 
	 * is called to retrieve that lowest value in the row.
	 * 
	 * @param double array[][] : An array is passed through the 
	 * 							 method to be printed
	 * @param row : a row is specified so the method knows where 
	 * 				to look.
	 */
	public static void printMin(double array[][], int row){
	                System.out.printf("%10.1f%n", getMin(array, row));
	}
}
