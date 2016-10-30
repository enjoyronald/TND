/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp11;

/**
 *
 * @author enjoy
 */
public enum Genre {
    STUDIO ("studio"),
    APPARTEMENT ("appartement"),
    MAISON ("maison");
    
    private String name= "";
    
    Genre(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }   
}
