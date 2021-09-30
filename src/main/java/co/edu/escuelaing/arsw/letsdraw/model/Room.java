/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.model;

import co.edu.escuelaing.arsw.letsdraw.services.LetsDrawService;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jgarc
 */
public class Room {
    @Autowired
    LetsDrawService letsDrawService; 
    
    private int id; 
    private String name; 
    private String lenguaje; 
    private boolean priv; 
    private int limit; 
    private String password;
    
    public Room(String name , String lenguaje , boolean priv , int limit , String password) throws LetsDrawServiceException{
        this.name = name ; 
        this.lenguaje = lenguaje; 
        this.limit = limit; 
        this.priv = priv; 
        this.password = password; 
        id = letsDrawService.getRooms().size()+1; 
    }
}
