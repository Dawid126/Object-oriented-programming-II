package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.Rooms.Room;

import java.util.ArrayList;
import java.util.Vector;

public class Maze {
    private ArrayList<Room> rooms;

    public Maze() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }
}
