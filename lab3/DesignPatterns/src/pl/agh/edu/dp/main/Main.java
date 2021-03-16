package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.Factory.MazeFactory;
import pl.agh.edu.dp.labirynth.MazeBuilder.StandardBuilderMaze;

public class Main {

    public static void main(String[] args) {

        //MazeGame mazeGame = new MazeGame();
        //mazeGame.startGame();
        MazeFactory m1 = MazeFactory.getFactory();
        MazeFactory m2 = MazeFactory.getFactory();
        System.out.println(m1 == m2);
    }
}
