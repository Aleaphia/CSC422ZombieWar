package zombiewar;

/**
 *
 * @author shosh
 */
public abstract class Character {
    //Attributes ---------------------------------------------------------------
    private int health;
    private int attack;
    //Methods ------------------------------------------------------------------
    /**
     * @param damage
     * 
     * context Character::takeDamage(damage : int) pre:
     *      damage >= 0
     */
    public void takeDamage(int damage){
        
        health -= damage;
    }
    public boolean isAlive(){
        return health > 0;
    }
    public int getAttack(){
        return attack;
    }
    @Override abstract public String toString();
}
