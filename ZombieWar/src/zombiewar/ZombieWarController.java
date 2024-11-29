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
    /*Note:
    To use directAttackDamage() we would need to have Army be aware of the 
    ZombieWarController instance, which seems like unnessiary coupling.
    
    Instead we can have Armies or Characters return damage values and
    simulateZombieWar iterate through the armies.
    */
    //public void directAttackDamage(int damage){}
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
