package maze;

import java.util.Random;

/**
 * This class represents a mouse.
 * A mouse has a direction and a position.
 * The direction is convenient for implementing algorithms.
 * @author Bertrand
 */
public class Mouse {
    
    /**
     * This constant represents the code for the up direction.
     */
    public static final int MOUSEDIRECTIONUP = 1;
    
    /**
     * This constant represents the code for the down direction.
     */
    public static final int MOUSEDIRECTIONDOWN = 2;
    
    /**
     * This constant represents the code for the left drection.
     */
    public static final int MOUSEDIRECTIONLEFT = 3;
    
    /**
     * This constant represents the code for the right direction.
     */
    public static final int MOUSEDIRECTIONRIGHT = 4;
    
    /**
     * The current mouse's position.
     * @see Position
     * @see Mouse#Mouse(maze.Position, maze.Maze) 
     * @see Mouse#getPosition() 
     */
    private Position position;
    
    /**
     * The current mouse's direction.
     * @see Mouse#Mouse(maze.Position, maze.Maze) 
     */
    private int direction;
    
    /**
     * The maze the mouse belongs to.
     * @see Mouse#Mouse(maze.Position, maze.Maze) 
     * @see Maze
     */
    private Maze maze;
    
    /**
     * Mouse constructor.
     * @param pos the mouse's start position
     * @param m the maze where the mouse is
     * @see Mouse#position
     * @see Mouse#maze
     * @see Mouse#direction
     */
    public Mouse(Position pos, Maze m) {
        position = pos;
        maze = m;
        direction = MOUSEDIRECTIONUP;
    }
    
    /**
     * Returns the mouse's position.
     * @return a Position that is the mouse's current position
     * @see Position
     */
    public Position getPosition() {
        return position;
    }
    
    /**
     * Updates the mouse's position so the mouse move forward.
     */
    public void moveForward() {
        Position previous = new Position(position.getX(), position.getY());
        switch (direction) {
            case MOUSEDIRECTIONUP:
                position.setX(position.getX()-1);
                break;
            case MOUSEDIRECTIONDOWN:
                position.setX(position.getX()+1);
                break;
            case MOUSEDIRECTIONLEFT:
                position.setY(position.getY()-1);
                break;
            case MOUSEDIRECTIONRIGHT:
                position.setY(position.getY()+1);
                break;
        }
        maze.updateMousePosition(previous);
    }
    
    /**
     * Updates the mouse's direction so the mouse turns back.
     */
    public void moveBackward() {
        switch (direction) {
            case MOUSEDIRECTIONUP:
                direction = MOUSEDIRECTIONDOWN;
                break;
            case MOUSEDIRECTIONDOWN:
                direction = MOUSEDIRECTIONUP;
                break;
            case MOUSEDIRECTIONLEFT:
                direction = MOUSEDIRECTIONRIGHT;
                break;
            case MOUSEDIRECTIONRIGHT:
                direction = MOUSEDIRECTIONLEFT;
                break;
        }
        moveForward();
    }
    
    /**
     * Updates the mouse's direction so the mouse turns left.
     */
    public void turnLeft() {
        switch (direction) {
            case MOUSEDIRECTIONUP:
                direction = MOUSEDIRECTIONLEFT;
                break;
            case MOUSEDIRECTIONDOWN:
                direction = MOUSEDIRECTIONRIGHT;
                break;
            case MOUSEDIRECTIONLEFT:
                direction = MOUSEDIRECTIONDOWN;
                break;
            case MOUSEDIRECTIONRIGHT:
                direction = MOUSEDIRECTIONUP;
                break;
        }
        moveForward();
    }
    
    /**
     * Updates the mouse's direction so the mouse turns right.
     */
    public void turnRight() {
        switch (direction) {
            case MOUSEDIRECTIONUP:
                direction = MOUSEDIRECTIONRIGHT;
                break;
            case MOUSEDIRECTIONDOWN:
                direction = MOUSEDIRECTIONLEFT;
                break;
            case MOUSEDIRECTIONLEFT:
                direction = MOUSEDIRECTIONUP;
                break;
            case MOUSEDIRECTIONRIGHT:
                direction = MOUSEDIRECTIONDOWN;
                break;
        }
        moveForward();
    }
    
    /**
     * Checks if forward position is not a wall or out of bounds.
     * @return a boolean that is true if the position is valid, false otherwise
     */
    public boolean forwardPositionValid() {
        Position forwardPosition = null;
        switch (direction) {
            case MOUSEDIRECTIONUP:
                forwardPosition = new Position(position.getX()-1, position.getY());
                break;
            case MOUSEDIRECTIONDOWN:
                forwardPosition = new Position(position.getX()+1, position.getY());
                break;
            case MOUSEDIRECTIONLEFT:
                forwardPosition = new Position(position.getX(), position.getY()-1);
                break;
            case MOUSEDIRECTIONRIGHT:
                forwardPosition = new Position(position.getX(), position.getY()+1);
                break;
        }
        return maze.isValidPosition(forwardPosition);
    }
    
    /**
     * Checks if backward position is not a wall or out of bounds.
     * @return a boolean that is true if the position is valid, false otherwise
     */
    public boolean backwardPositionValid() {
        Position backwardPosition = null;
        switch (direction) {
            case MOUSEDIRECTIONUP:
                backwardPosition = new Position(position.getX()+1, position.getY());
                break;
            case MOUSEDIRECTIONDOWN:
                backwardPosition = new Position(position.getX()-1, position.getY());
                break;
            case MOUSEDIRECTIONLEFT:
                backwardPosition = new Position(position.getX(), position.getY()+1);
                break;
            case MOUSEDIRECTIONRIGHT:
                backwardPosition = new Position(position.getX(), position.getY()-1);
                break;
        }
        return maze.isValidPosition(backwardPosition);
    }
    
    /**
     * Checks if left position is not a wall or out of bounds.
     * @return a boolean that is true if the position is valid, false otherwise
     */
    public boolean leftPositionValid() {
        Position leftPosition = null;
        switch (direction) {
            case MOUSEDIRECTIONUP:
                leftPosition = new Position(position.getX(), position.getY()-1);
                break;
            case MOUSEDIRECTIONDOWN:
                leftPosition = new Position(position.getX(), position.getY()+1);
                break;
            case MOUSEDIRECTIONLEFT:
                leftPosition = new Position(position.getX()+1, position.getY());
                break;
            case MOUSEDIRECTIONRIGHT:
                leftPosition = new Position(position.getX()-1, position.getY());
                break;
        }
        return maze.isValidPosition(leftPosition);
    }
    
    /**
     * Checks if right position is not a wall or out of bounds.
     * @return a boolean that is true if the position is valid, false otherwise
     */
    public boolean rightPositionValid() {
        Position rightPosition = null;
        switch (direction) {
            case MOUSEDIRECTIONUP:
                rightPosition = new Position(position.getX(), position.getY()+1);
                break;
            case MOUSEDIRECTIONDOWN:
                rightPosition = new Position(position.getX(), position.getY()-1);
                break;
            case MOUSEDIRECTIONLEFT:
                rightPosition = new Position(position.getX()-1, position.getY());
                break;
            case MOUSEDIRECTIONRIGHT:
                rightPosition = new Position(position.getX()+1, position.getY());
                break;
        }
        return maze.isValidPosition(rightPosition);
    }
    
    /**
     * Random algorithm. The mouse will move forward when possible and move left,
     * right or forward at each intersection. If forward, left and right moves
     * are not possible, she will move backward.
     */
    public void startRandom() {
        while (!maze.getCheese().cheeseFound()) {
            sleep(250);
            boolean directions[] = new boolean[3];
            directions[0] = forwardPositionValid();
            directions[1] = leftPositionValid();
            directions[2] = rightPositionValid();
            if (! (directions[0] || directions[1] || directions[2])) {
                moveBackward();
            } else {
                int x;
                do {
                    Random rand = new Random();
                    x = rand.nextInt(3);
                } while(directions[x] == false);
                if (x == 0) {
                    moveForward();
                } else if (x == 1) {
                    turnLeft();
                } else if (x == 2) {
                    turnRight();
                }
            }
            maze.displayMaze();
        }
    }
    
    /**
     * Left side algorithm. The mouse will follow the left wall.
     */
    public void startFollowLeft() {
        while (!maze.getCheese().cheeseFound()) {
            sleep(250);
            if (leftPositionValid()) {
                turnLeft();
            } else if(forwardPositionValid()) {
                moveForward();
            } else if (rightPositionValid()) {
                turnRight();
            } else if (backwardPositionValid()) {
                moveBackward();
            }
            maze.displayMaze();
        }
    }
    
    /**
     * Right side algorithm. The mouse will follow the right wall.
     */
    public void startFollowRight() {
        while (!maze.getCheese().cheeseFound()) {
            sleep(250);
            if (rightPositionValid()) {
                turnRight();
            } else if(forwardPositionValid()) {
                moveForward();
            } else if (leftPositionValid()) {
                turnLeft();
            } else if (backwardPositionValid()) {
                moveBackward();
            }
            maze.displayMaze();
        }
    }
    
    /**
     * Stop the mouse for time milliseconds.
     * @param time the number of milliseconds the mouse will stop.
     */
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
