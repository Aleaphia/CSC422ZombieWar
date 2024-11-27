/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombiewar;

/**
 *
 * @author shosh
 */
public abstract class Army {
    //Attributes ---------------------------------------------------------------
    private Character[] members;
    private int size;
    //Methods ------------------------------------------------------------------
    public int getAttack(int i){
        return members[i].getAttack();
    }
    
    public void applyAttackDamage(int damage){
        for (int i = 0; i < size; i++){
            members[i].takeDamage(damage);
        }
    }
    
    public int getSize(){
        return size;
    }
    
    public Character getMemeber(int i){
        return members[i];
    }
    
    public void printMembers(){
        
    }
}
