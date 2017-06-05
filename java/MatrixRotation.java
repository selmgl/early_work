/*
 * Java Programming : Matrix Rotation
 */

/** rotates a matrix[int][int] by 90deg
 */
public class MatrixRotation {

    /** isValid
     * check if all lines of a matrix have the same size
     */
    public Boolean isValid (int[][] matrix) {
	int mat_width = matrix[1].length;
	for (int[] line : matrix) {
	    if (line.length != mat_width) return false;
	}
	return true;
    }
    
    /** displayMatrix
     * input matrix of int
     * print the matrix on default output
     */
    public void displayMatrix (int[][] matrix) {
	for (int[] line : matrix) {
	    for (int elem : line) {
		System.out.print(elem+",");
	    }
	    System.out.println(";");
	}
    }

    /** main implementing test suite
     */
    public static void main (String[] args) {
	System.out.println("Matrix Rotation in Java");
	MatrixRotation prog = new MatrixRotation();
	// preliminary tests
	int[][] matrix = {{1,1,1},{2,2,2},{3,3,3}};
	System.out.println("Matrix validity Testing");
	System.out.println("Test1, expect true, gets "+prog.isValid(matrix));
	prog.displayMatrix(matrix);
    }

}

