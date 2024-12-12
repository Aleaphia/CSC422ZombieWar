/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zombiewar;

/**
 *
 * @author shosh
 */
public class Teacher extends Human {
    public Teacher(String name){
        super(name);
        health = 50;
        attack = 5;
    }
    public Teacher(String name, Weapon weapon){
        super(name, weapon);
        health = 50;
        attack = 5;
    }
}
