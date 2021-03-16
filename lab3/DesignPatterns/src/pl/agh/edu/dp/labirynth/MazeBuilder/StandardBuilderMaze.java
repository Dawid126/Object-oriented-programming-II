package pl.agh.edu.dp.labirynth.MazeBuilder;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.Doors.Door;
import pl.agh.edu.dp.labirynth.Factory.MazeFactory;
import pl.agh.edu.dp.labirynth.Rooms.Room;
import pl.agh.edu.dp.labirynth.Walls.Wall;

public class StandardBuilderMaze implements MazeBuilder {

    private Maze currentMaze;
    private MazeFactory factory;

    public StandardBuilderMaze(MazeFactory factory) {
        this.currentMaze = new Maze();
        this.factory = factory;
    }

    public Maze getCurrentMaze() {
        return currentMaze;
    }

    @Override
    public Room createRoom() {
        Room room = factory.makeRoom(currentMaze.getRoomNumbers());
        for(Direction direction : Direction.values()) {
            room.setSide(direction, factory.makeWall());
        }
        currentMaze.addRoom(room);
        return room;
    }

    @Override
    public void addDoor(Room room1, Room room2) {
        Direction direction = commonWall(room1, room2);
        if(direction == null) {
            return;
        }
        Door door = factory.makeDoor(room1, room2);
        room1.setSide(direction, door);
        room2.setSide(Direction.getOpposite(direction), door);
    }

    @Override
    public void addWall(Room room1, Room room2, Direction direction) {
        Wall wall = factory.makeWall();
        room1.setSide(direction, wall);
        room2.setSide(Direction.getOpposite(direction), wall);
    }

    private Direction commonWall(Room room1, Room room2) {
        for (Direction direction : Direction.values()) {
            if (room1.getSide(direction).equals(room2.getSide(Direction.getOpposite(direction)))) {
                return direction;
            }
        }
        return null;
    }
}
