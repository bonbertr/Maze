package maze;


/**
 * This class represents a maze.
 * @author Bertrand
 */
public class Maze {
    
    /**
     * This constant represents the code for an empty space.
     */
    private static final int EMPTYSPACE = 0;
    
    /**
     * This constant represents the code for a wall.
     */
    private static final int WALLCODE = 1;
    
    /**
     * This constant represents the code for the current mouse's position.
     */
    private static final int MOUSECODE = 2;
    
    /**
     * This constant represents the code for the cheese's position.
     */
    private static final int CHEESECODE = 3;
    
    /**
     * The maze is represented by a 2D integer matrix.
     * @see Maze#getMaze() 
     * @see Maze#Maze(maze.Position, maze.Position) 
     */
    private int maze[][] =  {
        {0,0,0,0,0,1,0,0,0,1},
        {0,1,0,1,0,1,0,1,0,0},
        {0,1,0,1,0,0,0,1,0,1},
        {1,0,0,0,1,1,1,0,0,0},
        {0,0,1,0,0,0,0,1,1,0},
        {1,1,0,0,1,0,1,0,0,1},
        {0,0,0,1,0,0,1,1,0,1},
        {0,1,0,0,1,1,0,0,0,0},
        {0,0,1,1,0,0,0,1,0,1},
        {1,0,0,0,0,1,1,0,0,0},
    };
    
    /**
     * The mouse.
     * @see Mouse
     * @see Maze#Maze(maze.Position, maze.Position) 
     * @see Maze#getMouse() 
     */
    private Mouse mouse;
    
    /**
     * The cheese.
     * @see Cheese
     * @see Maze#Maze(maze.Position, maze.Position) 
     * @see Maze#getCheese() 
     */
    private Cheese cheese;
    
    /**
     * Maze constructor. It takes the mouse's position as first argument
     * and the cheese's position as second argument.
     * @param mousePos the mouse's position in the maze
     * @param cheesePos the cheese's position in the maze
     * @see Maze#mouse
     * @see Maze#cheese
     * @see Maze#maze
     * @see Position
     */
    public Maze(Position mousePos, Position cheesePos) throws Exception {
        if (! (isValidPosition(mousePos) && isValidPosition(cheesePos)) ) {
            throw new Exception("Invalid mouse or cheese position");
        }
        mouse = new Mouse(mousePos, this);
        cheese = new Cheese(cheesePos);
        maze[mousePos.getX()][mousePos.getY()] = MOUSECODE;
        maze[cheesePos.getX()][cheesePos.getY()] = CHEESECODE;
    }
    
    /**
     * Returns the maze.
     * @return the 2D integer matrix representing the maze
     */
    public int[][] getMaze() {
        return maze;
    }
    
    /**
     * Returns the maze's dimension.
     * @return an array of two integers representing the maze's dimension
     */
    public int[] getMazeDim() {
        int dim[] = new int[2];
        dim[0] = maze[0].length;
        dim[1] = maze.length;
        return dim;
    }
    
    /**
     * Returns the mouse inside the maze.
     * @return a Mouse
     * @see Mouse
     */
    public Mouse getMouse() {
        return mouse;
    }
    
    /**
     * Returns the cheese inside the maze.
     * @return a Cheese
     * @see Cheese
     */
    public Cheese getCheese() {
        return cheese;
    }
    
    /**
     * Displays the maze on standard output.
     */
    public void displayMaze() {
        for (int i = 0; i < getMazeDim()[1]; i++)
            System.out.print("___");
        
        System.out.println();
         for (int i = 0; i < getMazeDim()[0]; i++) {
             for (int j = 0; j < getMazeDim()[1]; j++) {
                 switch (maze[i][j]) {
                     case EMPTYSPACE:
                         System.out.print(" " + maze[i][j]+" ");
                         break;
                     case WALLCODE:
                         System.out.print(" | ");
                         break;
                     case MOUSECODE:
                         System.out.print(" M ");
                         break;
                     case CHEESECODE:
                         System.out.print(" C ");
                         break;
                 }
             }
             System.out.println();
         }
         for (int i = 0; i < getMazeDim()[1]; i++)
            System.out.print("¯¯¯");
         System.out.println();
    }
    
    /**
     * Updates the maze matrix to clear previous mouse's position and
     * set new mouse's position
     * @param previous the previous mouse position 
     * @see Position
     */
    public void updateMousePosition(Position previous) {
        Position mousePosition = mouse.getPosition();
        maze[previous.getX()][previous.getY()] = EMPTYSPACE;
        maze[mousePosition.getX()][mousePosition.getY()] = MOUSECODE;
        if (this.getCheese().getPosition().equals(this.getMouse().getPosition())) {
            this.getCheese().setCheeseFound();
        }
    }
    
    /**
     * Tests if the position pos is valid (e.g the position pos is not a wall
     * or out of bounds)
     * @param pos the position to evaluate
     * @return a boolean which represents the position validity
     * @see Position
     */
    public boolean isValidPosition(Position pos) {
        if (pos.getX() < 0 || pos.getY() < 0
                || pos.getX() >= getMazeDim()[0] || pos.getY() >= getMazeDim()[1]) {
            return false;
        } else {
            if (maze[pos.getX()][pos.getY()] == WALLCODE) {
                return false;
            } else {
                return true;
            }
        }
    }
    
}
