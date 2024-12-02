package zombiewar;

/**
 *
 * @author shosh
 */
public abstract class Character {
    //Attributes ---------------------------------------------------------------
    protected int health;
    protected int attack;
    protected String name;
    //Methods ------------------------------------------------------------------
    public Character(String name){
        this.name = name;
    }
    
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
    public String getName(){
        return name;
    }
    @Override public String toString(){
        return this.getClass().getSimpleName() + " " + name + "(" + health + " hp, " + attack + " atk)";
    }
}
