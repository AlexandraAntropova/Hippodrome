package Hippodrome;

import java.util.ArrayList;
import java.util.List;


public class Hippodrome {

    public static Hippodrome game;
    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("Horse1", 3, 0));
        game.horses.add(new Horse("Horse2", 3, 0));
        game.horses.add(new Horse("Horse3", 3, 0));
        game.run();
        game.printWinner();
    }
    public List<Horse> getHorses() {
        return horses;
    }
    public void run() throws InterruptedException {
        for (int i = 1; i <=100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse horse:horses){
            horse.move();
        }
    }
    public void print(){
        for(Horse horse:horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        int index = 0;
        for (int i = 1; i < horses.size(); i++) {
            if(horses.get(i).getDistance()>horses.get(index).getDistance()){
                index = i;
            }
        }
        return horses.get(index);
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
