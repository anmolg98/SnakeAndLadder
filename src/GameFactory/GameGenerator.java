package GameFactory;

import Game.Props;

import java.util.List;

public class GameGenerator {

    public static GameContext generateGame(List<String> playerNames, int numberOfDice,List<Props> props){

        return new GameContext(playerNames, numberOfDice,props);
    }
}
