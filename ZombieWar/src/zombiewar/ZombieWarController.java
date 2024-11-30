/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zombiewar;
import java.util.*;
/**
 *
 * @author shosh
 */
public class ZombieWarController {

    //Attributes ---------------------------------------------------------------
    private Random rand = new Random();
    private static final int MAX_ARMY_SIZE = 15;
    private static enum Humans {Child, Teacher, Soldier};
    private static enum Zombies {CommonInfect, Tank};
 
    
    private int humanArmySize;
    private int zombieArmySize;
    private Human[] humanArmy;
    private Zombie[] zombieArmy;
    
    //Methods ------------------------------------------------------------------
    public Human[] getHumanArmy(){return humanArmy;}
    public Zombie[] getZombieArmy(){return zombieArmy;}
    
    public void simulateZombieWar(){
        generateHumanArmy();
        generateZombieArmy();
        
        System.out.printf("We have " + humanArmySize + " survivors trying to escape.");
        
        System.out.println();
        
        //if statement is to change the verbiage if there is only 1 zombie
        if (zombieArmySize == 1) {
            System.out.printf("There is " + zombieArmySize + " zombie between them and escape.");
        }
        else {
            System.out.printf("There are " + zombieArmySize + " zombies between them and escape.");
        }
        
        //used to control the loops in the attack phase
        int startZArmySize = zombieArmySize;
        int startHArmySize = humanArmySize;
        
        //attack phase, ends when an army size reaches 0
        while(humanArmySize != 0 && zombieArmySize != 0) {
            
           //humans take first turn attacking
            for(int i = 0; i < startHArmySize; i++) {
               //gets current humans atk
               int humanAtk = humanArmy[i].getAttack();
               for(int j = 0; j < startZArmySize; j++) {
                   //checks for live zombie to atk
                   if(zombieArmy[j].isAlive()) {
                      zombieArmy[j].takeDamage(humanAtk);
                      //if the zombe died from atk, they are removed from the zombie army count
                      if(!zombieArmy[j].isAlive()) {
                        zombieArmySize -= 1;
                      }
                      break;
                   }                   
               }
               
           }
           
           //zombies take second turn attacking
           for(int i = 0; i < startZArmySize; i++) {
               // get atk for current attacking zombie
               int zombieAtk = zombieArmy[i].getAttack();
               
               for(int j = 0; j < startHArmySize; j++) {
                   //checks for live human to atk
                   if (humanArmy[j].isAlive()) {
                       humanArmy[j].takeDamage(zombieAtk);
                       //if the human died, they are removed from the count for the army size
                       if(!humanArmy[j].isAlive()) {
                           humanArmySize -= 1;
                       }
                       break;
                   }
               }
               
           }
         
        }
        
        System.out.printf( humanArmySize + " survivors were able to escape.");
        
        System.out.println();
        
    }
    
    
    private void generateHumanArmy(){
        //Select random size and make array
        humanArmySize = rand.nextInt(1, MAX_ARMY_SIZE);
        humanArmy = new Human[humanArmySize];
        
        //Array of human types used for random selection
        Humans[] humanTypes = Humans.values();
        
        for (int i = 0; i < humanArmySize; i++){
            Human human;
            switch (humanTypes[rand.nextInt(humanTypes.length)]){
                case Child ->  human = new Child();
                case Teacher -> human = new Teacher();
                default -> human = new Soldier();
            }
            
            humanArmy[i] = human;
        }
    }
    private void generateZombieArmy(){
        zombieArmySize = rand.nextInt(1, MAX_ARMY_SIZE);
        zombieArmy = new Zombie[zombieArmySize];
        
        //Array of zombie types used for random selection
        Zombies[] zombieTypes = Zombies.values();
        
        for (int i = 0; i < zombieArmySize; i++){
            Zombie zombie;
            switch (zombieTypes[rand.nextInt(zombieTypes.length)]){
                case CommonInfect ->  zombie = new CommonInfect();
                default -> zombie = new Tank();
            }
            
            zombieArmy[i] = zombie;
        }
    }
}
