package maze;

/**
 * Main class of the maze game.
 * @author Bertrand
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Maze maze = new Maze("maze1.txt", new Position(6,4), new Position(4,9));
            maze.displayMaze();
            maze.getMouse().startFollowRight();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
