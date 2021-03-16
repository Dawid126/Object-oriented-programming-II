package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.Rooms.Room;

public class Player {
    private boolean alive;
    private Direction direction;
    private Room room;

    public Player(Direction direction, Room room) {
        this.alive = true;
        this.direction = direction;
        this.room = room;
    }

    public void turnLeft() {
        this.direction = Direction.getPrevious(this.direction);
    }

    public void turnRight() {
        this.direction = Direction.getNext(this.direction);
    }

    public void moveAhead() {
        MapSite mapSite = room.getSide(this.direction);
        mapSite.Enter(this);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
