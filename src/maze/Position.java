package maze;

/**
 * This class represents an x - y position.
 * @author Bertrand
 */
public class Position {
    
    /**
     * The x component of a position.
     * @see Position#Position(int, int) 
     * @see Position#getX() 
     * @see Position#setX(int) 
     */
    private int x;
    
    /**
     * The y component of a position.
     * @see Position#Position(int, int) 
     * @see Position#getY() 
     * @see Position#setY(int) 
     */
    private int y;
    
    /**
     * Position constructor.
     * @param x the x component
     * @param y the y component
     * @see Position#x
     * @see Position#y
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the x component.
     * @return an int representing the x component
     */
    public int getX() {
        return x;
    }
    
    /**
     * Returns the y component.
     * @return an int representing the y component
     */
    public int getY() {
        return y;
    }
    
    /**
     * Updates the x component.
     * @param x the new value for x
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Updates the y component.
     * @param y the new value for y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Comparison between the position and another position.
     * @param pos the position to compare with
     * @return the statement's evaluation
     */
    public boolean equals(Position pos) {
        return this.getX() == pos.getX() && this.getY() == pos.getY();
    }
    
}
