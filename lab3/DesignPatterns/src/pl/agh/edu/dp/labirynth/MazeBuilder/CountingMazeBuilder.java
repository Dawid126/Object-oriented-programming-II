package pl.agh.edu.dp.labirynth.MazeBuilder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Rooms.Room;

public class CountingMazeBuilder implements MazeBuilder {

    private int roomsNumber;
    private int wallNumber;
    private int doorNumber;

    public CountingMazeBuilder() {
        this.roomsNumber = 0;
        this.wallNumber = 0;
        this.doorNumber = 0;
    }

    @Override
    public Room createRoom() {
        roomsNumber += 1;
        wallNumber += 4;
        return new Room(1);
    }

    @Override
    public void addDoor(Room room1, Room room2) {
        wallNumber -= 1;
        doorNumber += 1;
    }

    @Override
    public void addWall(Room r1, Room r2, Direction direction) {
        wallNumber -=1;
    }

    public String getCounts(){
        return "Room number: " + this.roomsNumber + "\nDoor number: " + this.doorNumber + "\nWall number: " + this.wallNumber;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public int getWallNumber() {
        return wallNumber;
    }

    public int getDoorNumber() {
        return doorNumber;
    }
}
