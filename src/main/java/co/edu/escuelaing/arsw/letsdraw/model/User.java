/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.model;

import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jgarc
 */

public class User {
    @Autowired
    LetsDrawServiceImpl letsDrawService;  
    private String nickname; 
    private int points; 
    private int id ; 
    private String skin; 
    
    
    public User(String nickname, String skin) throws LetsDrawServiceException{
        this.nickname = nickname; 
        points = 0 ; 
        id = 0; 
        //id = letsDrawService.getUsers().size() + 1 ;
        this.skin = skin; 
    }
    public int getId(){
        return id; 
    }
    
    public int getPoints(){
        return points; 
    }
    
    public void setPoints(int points){
        this.points = points; 
    }
    
    public String getNickname(){
        return nickname; 
    }
    
    public void setNickname(String nickname){
        this.nickname = nickname; 
    } 
    
    public String getSkin(){
        return skin; 
    }
    
    public void setSkin(String skin){
        this.skin = skin; 
    }
  
}
