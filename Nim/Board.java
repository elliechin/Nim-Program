/*
 * @Author Ellie Chin
 */

public class Board {

    private static int boardTiles;

    public static void populate(){
        boardTiles = (int) (Math.random() * 40 + 10);
        System.out.println("There are " + boardTiles + " tiles on the board.\n");
    }

    // updates board after player makes a turn
    // player uses this method
    public static void takeBoardTiles(int num){
    boardTiles = boardTiles - num; 
    System.out.println("There are " + boardTiles + " left.\n");
    }

    // returns number of tiles after each turn
    public static int getBoardTiles(){
        return boardTiles; 
    }

    

}
