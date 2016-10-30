/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp14;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author enjoy
 */
@XmlType(name = "genre")
@XmlEnum
public enum Genre {
    @XmlEnumValue("studio")
    STUDIO ("studio"),
    @XmlEnumValue("apprtement")
    APPARTEMENT ("appartement"),
    @XmlEnumValue("maison")
    MAISON ("maison");
    
    private String name= "";
    
    Genre(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }   
}
