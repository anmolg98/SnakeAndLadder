package GameFactory;

import Game.Board;
import Game.Dice;
import Game.Player;
import Game.Props;

import java.util.ArrayList;
import java.util.List;

public class GameContext {
    private Board gameBoard;
    private List<Dice> gameDice;

    private List<Player> players;

    private int currentTurn;

    public GameContext(List<String> playerNames, int numberOfDice,List<Props> props){
             gameBoard = new Board(props);
              gameDice = new ArrayList<>();
              players = new ArrayList<>();
              for(int i=0;i<numberOfDice;i++) {
                  gameDice.add(new Dice());
              }
              for(int i=0;i< playerNames.size();i++){
                  this.players.add(new Player(playerNames.get(i)));
              }
              currentTurn=0;

    }
    public String play(String player){
        String out="";
        if(!players.get(currentTurn).getName().equals(player)){
            System.out.println("Wrong Player "+player+ players.get(currentTurn) );
            out = "Wrong Player";
        }
        else{
            int sum=0;
            for(Dice dice:gameDice){
                sum+=dice.roll();
                //System.out.println(sum);
            }
            int tempPos = players.get(currentTurn).getCurrentPosition()+sum;
            if(tempPos==100){
                System.out.println(players.get(currentTurn).getName()+" Won");
               out =  "GameFinish";
            }
            else if(tempPos<100){
                if(gameBoard.isPropStart(tempPos)){
                    int tempPos1 = gameBoard.getEnd(tempPos);
                    if(tempPos1>tempPos){
                        System.out.println("Ladder");
                    }
                    else{
                        System.out.println("Snake");
                    }
                    tempPos=tempPos1;
                }

                players.get(currentTurn).setCurrentPosition(tempPos);

                out =  "Move Succesful";
            }
            System.out.println(players.get(currentTurn).getName()+" is at"+players.get(currentTurn).getCurrentPosition());
            if(currentTurn== players.size()-1) currentTurn=0;
            else currentTurn++;
        }
        return out;
    }


}
