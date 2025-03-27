/*
 * @Author Megan
 */

public class Computer extends Player{

    public Computer(){
        System.out.println("Computer created");
        
    }

    @Override
    public void nextTurn() {
        Board.takeBoardTiles(calculateMove(Board.getBoardTiles()));
        setTurn(false);
    }
    
    public int calculateMove(int tiles) {
        int target = 1;
        int power = -1;
        while(target - 1 < tiles) {
            target *= 2;
            power++;
        }
        int num = (int) Math.pow(2, power) - 1;
        if(tiles - num == 0 || tiles - num > tiles / 2) {
            return 1;
        } else {
            System.out.println("Computer took " + (tiles - num) + "tiles");
            return tiles - num;
        }   
    }
}
