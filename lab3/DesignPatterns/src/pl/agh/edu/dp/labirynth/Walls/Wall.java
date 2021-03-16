package pl.agh.edu.dp.labirynth.Walls;

import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.Player;

public class Wall extends MapSite {
    public Wall(){

    }

    @Override
    public void Enter(Player player) {
        System.out.println("You can't enter wall.");
    }
}
