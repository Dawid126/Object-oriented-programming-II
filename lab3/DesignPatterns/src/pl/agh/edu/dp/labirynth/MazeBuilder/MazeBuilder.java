package pl.agh.edu.dp.labirynth.MazeBuilder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Rooms.Room;

public interface MazeBuilder {

    Room createRoom();

    void addDoor(Room room1, Room room2);

    void addWall(Room room1, Room room2, Direction direction);
}
