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
 
    private int childCount;
    private int teacherCount;
    private int soldierCount;
    private int commonInfectedCount;
    private int tankCount;
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

        // Dynamic labeling
        String childLabel = (this.childCount == 1) ? " child, " : " children, ";
        String teacherLabel = (this.teacherCount == 1) ? " teacher, " : " teachers, ";
        String soldierLabel = (this.soldierCount == 1) ? " soldier" : " soldiers";
        String survivorLabel = (this.humanArmySize == 1) ? " survivor " : " survivors ";
        String tankLabel = (this.tankCount == 1) ? " tank" : " tanks";
        String zombieLabel = (this.zombieArmySize == 1) ? " zombie " : " zombies ";
        String isAre = (this.zombieArmySize == 1) ? "is" : "are";

        System.out.println("We have " + humanArmySize + survivorLabel + "trying to escape.(" + this.childCount + childLabel
                                                                                        + this.teacherCount + teacherLabel 
                                                                                        + this.soldierCount + soldierLabel + ")");
        
        System.out.println();
        
        System.out.println("There " + isAre + " " + zombieArmySize  + zombieLabel + "between them and escape.(" + this.commonInfectedCount + 
                                                                                                " common infected, "
                                                                                                + this.tankCount 
                                                                                                + tankLabel + ")");
        
        System.out.println();
        
        //used to control the loops in the attack phase
        int startZArmySize = zombieArmySize;
        int startHArmySize = humanArmySize;
        
        //attack phase, ends when an army size reaches 0
        while(humanArmySize != 0 && zombieArmySize != 0) {
            
           //humans take first turn attacking
            for(int i = 0; i < startHArmySize; i++) {
                //check to prevent dead humans from attacking
               if(humanArmy[i].isAlive()){
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
           }
           
           //zombies take second turn attacking
           for(int i = 0; i < startZArmySize; i++) {
               //check to prevent dead zombies from attacking
               if(zombieArmy[i].isAlive()) {
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
        }
        
        System.out.println( humanArmySize + " survivors were able to escape.");
        
        System.out.println();
        
    }
    
    
    private void generateHumanArmy(){
        //Select random size and make array
        humanArmySize = rand.nextInt(1, MAX_ARMY_SIZE);
        humanArmy = new Human[humanArmySize];

        this.childCount = 0;
        this.teacherCount = 0;
        this.soldierCount = 0;
        
        //Array of human types used for random selection
        Humans[] humanTypes = Humans.values();
        
        for (int i = 0; i < humanArmySize; i++){
            Human human;
            switch (humanTypes[rand.nextInt(humanTypes.length)]){
                case Child ->  {human = new Child();
                                this.childCount += 1;}
                case Teacher -> {human = new Teacher();
                                 this.teacherCount += 1;}
                default -> {human = new Soldier();
                            this.soldierCount += 1;}
            }
            
            humanArmy[i] = human;
        }
    }
    private void generateZombieArmy(){
        zombieArmySize = rand.nextInt(1, MAX_ARMY_SIZE);
        zombieArmy = new Zombie[zombieArmySize];

        this.commonInfectedCount = 0;
        this.tankCount = 0;
        
        //Array of zombie types used for random selection
        Zombies[] zombieTypes = Zombies.values();
        
        for (int i = 0; i < zombieArmySize; i++){
            Zombie zombie;
            switch (zombieTypes[rand.nextInt(zombieTypes.length)]){
                case CommonInfect ->  {zombie = new CommonInfect();
                                       this.commonInfectedCount += 1;}
                default -> {zombie = new Tank();
                            this.tankCount += 1;}
            }
            
            zombieArmy[i] = zombie;
        }
    }
}
