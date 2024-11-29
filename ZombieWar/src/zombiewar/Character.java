package zombiewar;

/**
 *
 * @author shosh
 */
public abstract class Character {
    //Attributes ---------------------------------------------------------------
    protected int health;
    protected int attack;
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
    @Override public String toString(){
        return this.getClass().getSimpleName() + "(" + health + " hp, " + attack + " atk)";
    }
}
