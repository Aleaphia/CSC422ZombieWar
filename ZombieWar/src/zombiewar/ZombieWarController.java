/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zombiewar;

/**
 *
 * @author shosh
 */
public class ZombieWarController {

    //Attributes ---------------------------------------------------------------
    private HumanArmy humanArmy = new HumanArmy();
    private ZombieArmy zombieArmy = new ZombieArmy();
    
    //Methods ------------------------------------------------------------------
    public HumanArmy getHumanArmy(){return humanArmy;}
    public ZombieArmy getZombieArmy(){return zombieArmy;}
    
    public void simulateZombieWar(){}
    
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
