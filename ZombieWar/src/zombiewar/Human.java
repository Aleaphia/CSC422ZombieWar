

package zombiewar;

/**
 *
 * Abstract class representing all human characters in the Zombie War simulation.
 * Inherits from Character and adds human-specific functionality.
 * 
 * @author jcoker
 */
public abstract class Human extends Character{
    // Attributes specific to Human characters
    private boolean isInfected = false;
    private String trait;
    private Weapon weapon;
    
    //Methods
    public Human(String name){
        super(name);
    }
    public Human(String name, Weapon weapon){
        super(name);
        this.weapon = weapon;
    }
    /**
     * Gets the infection status of the human.
     * 
     * @return true if the human is infected, false otherwise.
     */
    public boolean isInfected() {
        return isInfected;
    }

    /**
     * Sets the infection status of the human.
     * 
     * @param infected true if the human becomes infected, false otherwise.
     */
    public void setInfected(boolean infected) {
        this.isInfected = infected;
    }

    /**
     * Gets the trait of the human.
     * 
     * @return the trait of the human.
     */
    public String getTrait() {
        return trait;
    }

    /**
     * Sets the trait of the human.
     * 
     * @param trait the trait to assign to the human.
     */
    public void setTrait(String trait) {
        this.trait = trait;
    }

    /**
     * Gets the weapon of the human.
     * 
     * @return the weapon of the human.
     */
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * Returns a string representation of the human for debugging and logging.
     * 
     * @return String representation of the human's health, attack, and type.
     */
    @Override
    public String toString() {
        return "Human(" + this.getClass().getSimpleName() + ", " + health + " hp, " + attack + " atk)";
    }
}
