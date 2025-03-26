public class Computer extends Player{
    public int calculateMove(int tiles) {
        int target = 1;
        int power = -1;
        while(target - 1 < tiles) {
            target *= 2;
            power++;
        }
        if(tiles - Math.pow(2, power) + 1 == 0) {
            return 1;
        } else {
            return tiles - Math.pow(2, power) + 1;
        }
    }
}
