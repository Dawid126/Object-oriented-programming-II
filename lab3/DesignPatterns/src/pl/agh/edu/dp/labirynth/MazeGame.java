package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.Factory.MazeFactory;
import pl.agh.edu.dp.labirynth.MazeBuilder.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.Rooms.Room;

import java.util.Scanner;

public class MazeGame {

    private Maze maze;


    public void createMaze(MazeFactory factory) {

        StandardBuilderMaze mazeBuilder = new StandardBuilderMaze(factory);
        Room r1 = mazeBuilder.createRoom();
        Room r2 = mazeBuilder.createRoom();

        mazeBuilder.addDoor(r1, r2);

        mazeBuilder.addWall(r1, r2, Direction.East);

        mazeBuilder.addDoor(r1, r2);

        this.maze = mazeBuilder.getCurrentMaze();
    }

    public void startGame() {
        this.createMaze(MazeFactory.getFactory());
        Player player = new Player(Direction.North, this.maze.getRooms().get(0));
        while(player.isAlive() && !player.getRoom().equals(this.maze.getRooms().get(this.maze.getRoomNumbers() - 1))){
            cycle(player);
        }
        if(player.getRoom().equals(this.maze.getRooms().get(this.maze.getRoomNumbers() - 1)))
            System.out.println("You've explored all the rooms");
        System.out.println("Game over");
    }

    private void cycle(Player player) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPress: \na - to turn left\nd - to turn right\nw - to go forward");
        String choice = scan.nextLine();
        switch(choice){
            case "a":
                player.turnLeft();
                break;
            case "d":
                player.turnRight();
                break;
            case "w":
                player.moveAhead();
                break;
            default:
                System.out.println("You pressed wrong key");
                break;
        }
    }
}
