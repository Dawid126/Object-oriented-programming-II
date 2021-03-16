package pl.agh.edu.dp.labirynth;


public enum Direction {
    North, South, East, West;


    public static Direction getOpposite(Direction direction) {
        switch (direction) {
            case North: return South;
            case East: return West;
            case South: return North;
            default: return East;
        }
    }

    public static Direction getPrevious(Direction direction) {
        switch (direction) {
            case North: return West;
            case East: return North;
            case South: return East;
            default: return South;
        }
    }

    public static Direction getNext(Direction direction) {
        switch (direction) {
            case North: return East;
            case East: return South;
            case South: return West;
            default: return North;
        }
    }
}
