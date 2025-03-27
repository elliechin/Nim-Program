/*
 * @Author Ellie Chin
 */

 import java.util.Scanner;  // Import the Scanner class

public class Game{

    private Player player1, player2;
    // private Computer cpu;
    // Scanner scanner = new Scanner(System.in);

    // game creates players
    public Game(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play against another player or a computer?");
        String gameType = scanner.nextLine().toLowerCase();
        if (gameType.equals("player")){
            this.player1 = new Player();
            this.player2 = new Player();
            System.out.println("Game: Player vs Player");
        } else if (gameType.equals("computer") || gameType.equals("cpu")){
            this.player1 = new Player();
            this.player2 = new Computer();
            System.out.println("Game: Player vs CPU");
        }
        
    }

    public void play(){
        
    
        int start = (int) (Math.random() * 2);
       
        // sets initial turn booleans in respective Player classes
        if (start == 0) {
            player1.setTurn(true);
            player2.setTurn(false);
            System.out.println(player1.getName() + " goes first.\n");
        } 
        else {
            player1.setTurn(false);
            player2.setTurn(true);
            System.out.println(player2.getName() + " goes first.\n");
        }

        boolean gameover = false;
    
        while (!gameover){

            // lets player1 take their turn
            if (player1.getTurn() == true) {
                // if there is one tile left on the board
                if (Board.getBoardTiles() == 1) {
                    // the other player wins
                    gameover = true;
                    player2.win();
                    // player finishes last turn
                    player1.nextTurn();
                    System.out.println(player2.getName() + " won!");
                } else {
                    player1.nextTurn();
                }
               
                // switches the turn to player2
                if (player1.getTurn() == false) {
                    player2.setTurn(true);
                }
            } else {

                // lets player2 take their turn
                if (Board.getBoardTiles() == 1) {
                    gameover = true;
                    player1.win();
                    player2.nextTurn();
                    System.out.println(player1.getName() + " won!");
                } else {
                    player2.nextTurn();
                }

                // switches the turn to player1
                if (player2.getTurn() == false) {
                    player1.setTurn(true);
                }
            }

            
        }
        

    }
    
}
