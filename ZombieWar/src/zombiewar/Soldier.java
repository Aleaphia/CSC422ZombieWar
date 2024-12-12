/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombiewar;

/**
 *
 * @author shosh
 */
public class Soldier extends Human{
    public Soldier(String name){
        super(name);
        health = 100;
        attack = 10;
    }
    public Soldier(String name, Weapon weapon){
        super(name, weapon);
        health = 100;
        attack = 10;
    }
}
