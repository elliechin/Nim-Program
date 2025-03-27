/*
 * @Author Ellie Chin
 */

import java.util.Scanner;  // Import the Scanner class

public class Player{
    
    private String name;
    private int score;

    // when turn = true; this player can nim
    // no two players can have the same "turn" value
    private boolean turn;

    public Player(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username");
        this.name = scanner.nextLine();
        System.out.println("Welcome " + name  + "!\n");
        this.score = 0;
    }

    public String getName(){
        return name;
    }

    public boolean getTurn(){
        return turn;
    }

    public int getScore(){
        return score;
    }
    public void win(){
        score++;
    }



    public void setTurn(boolean bool){
        this.turn = bool;
    }
    /*
     * allows player to grab a certain number of tiles
     * must update the board
     * then transitions turn to the next player
     */
    public void nextTurn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + "'s turn: Nim tiles");
        int tiles = scanner.nextInt();
        int currentTiles = Board.getBoardTiles();
        if (tiles <= currentTiles / 2 && tiles >= 1){
            Board.takeBoardTiles(tiles); 

            // this Player ends their turn
            // the OTHER Player's turn is manipulated in the Game class
            turn = false;
        } else if (Board.getBoardTiles() <= 1) {
            System.out.println(name + " lost!");
        }
        else {
            // remains on the same player's turn
            // the same player chooses another number that fits the requirements
            System.out.println("You must take less than or equal to half of the tiles on the board.\n");
            
        }
    }


    public String toString(){
        return "Player " + name + "\nScore: " + score;
    }
}