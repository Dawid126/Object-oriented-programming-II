package pl.agh.edu.dp.labirynth.Factory;

import pl.agh.edu.dp.labirynth.Doors.Door;
import pl.agh.edu.dp.labirynth.Rooms.Room;
import pl.agh.edu.dp.labirynth.Walls.Wall;

public class MazeFactory {

    private static MazeFactory factory;

    public static MazeFactory getFactory() {
        if(factory == null)
            factory = new MazeFactory();
        return factory;
    }

    public Room makeRoom(int number){
        return new Room(number);
    }

    public Wall makeWall(){
        return new Wall();
    }

    public Door makeDoor(Room room1, Room room2){
        return new Door(room1, room2);
    }
}
