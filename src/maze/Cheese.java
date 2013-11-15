package maze;

/**
 * This class represents the cheese searched by the mouse.
 * @author Bertrand
 */
public class Cheese {
    
    /**
     * The cheese's position.
     * @see Position
     * @see Cheese#Cheese(maze.Position) 
     * @see Cheese#getPosition() 
     */
    private Position position;
    
    /**
     * The cheese's state, true if it has been found, false otherwise.
     * @see Cheese#Cheese(maze.Position) 
     * @see Cheese#cheeseFound() 
     * @see Cheese#setCheeseFound() 
     */
    private boolean found;
    
    /**
     * Cheese constructor. Default value for found is false.
     * @param pos the cheese's position.
     * @see Cheese#position
     * @see Cheese#found
     */
    public Cheese(Position pos) {
        position = pos;
        found = false;
    }
    
    /**
     * Returns the cheese's position.
     * @return a position
     * @see Position
     */
    public Position getPosition() {
        return position;
    }
    
    /**
     * Used to know if the cheese has been found or not.
     * @return a boolean
     */
    public boolean cheeseFound() {
        return found;
    }
    
    /**
     * Update the cheese to set found attribute to true.
     */
    public void setCheeseFound() {
        found = true;
    }
    
}
