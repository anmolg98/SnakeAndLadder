import GameFactory.GameContext;
import GameFactory.GameGenerator;
import Game.Props;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String [] playersArray = {"Player1","Player2"};
        List<String> players = Arrays.asList(playersArray);
        List<Props> props = new ArrayList<>();

        props.add(new Props(99,8));
        props.add(new Props(10,88));
        props.add(new Props(4,14));
        props.add(new Props(70,50));
        props.add(new Props(22,63));
        props.add(new Props(47,12));
        props.add(new Props(17,57));
       props.add(new Props(25,71));
        props.add(new Props(81,23));
        props.add(new Props(3,12));
        props.add(new Props(21,72));
        props.add(new Props(73,27));
        props.add(new Props(62,44));
        int totalMoves=0;
       GameContext game =  GameGenerator.generateGame(players,3,props);
        String currentPlayer = "Player1";
        String currentOutput="";
        while(!currentOutput.equals("GameFinish")){
           currentOutput =  game.play(currentPlayer);
           if(currentPlayer=="Player1"){
               currentPlayer="Player2";
           }
           else{
               currentPlayer="Player1";
           }
           totalMoves++;
        }
        System.out.println(totalMoves);



    }
}