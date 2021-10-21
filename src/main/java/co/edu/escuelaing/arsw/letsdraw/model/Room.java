/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.model;

import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import java.util.ArrayList;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jgarc
 */
public class Room {
    @Autowired
    LetsDrawServiceImpl letsDrawServiceImpl; 
    
    private int id; 
    private String name; 
    private String lenguaje; 
    private boolean priv; 
    private int limit; 
    private String password;
    private ArrayList<User> users = new ArrayList<User>(); 
    private ArrayList<Pair<User,String>> messages = new ArrayList<Pair<User,String>>(); 
    private int timer; 
    private Board board; 
    private final int maxUsers = 10 ;
    
    public Room(String name , String lenguaje , boolean priv , int limit , String password) throws LetsDrawServiceException{
        this.name = name ;
        this.timer = 60; 
        this.lenguaje = lenguaje; 
        this.limit = limit; 
        this.priv = priv; 
        this.password = password; 
        board = new Board(); 
    }
    
    public void setId(int id){
        this . id = id; 
    }
    
    public int getMaxUsers(){
        return maxUsers; 
    }
    
    public int getId(){
        return id; 
    }
    
    public void setMessages(ArrayList<Pair<User,String>> messages){
        this.messages = messages; 
    }
    
    public ArrayList<Pair<User,String>> getMessages(){
        return messages;  
    }
    
    public int gettimer(){
        return timer; 
    }
    
    public void setTimer(int timer){
        this.timer = timer; 
    }
    
    public void setUsers(ArrayList<User> users){
        this.users = users; 
    }
    
    public ArrayList<User> getUsers (){
        return users;  
    } 
    
    public String getName(){
        return name; 
    }
    public void setName(String name){
        this.name = name; 
    }
    
    public String getLenguaje(){
        return lenguaje; 
    }
    
    public void setLenguaje(String lenguaje){
        this.lenguaje = lenguaje; 
    }
    
    public int getLimit(){
        return limit;  
    }
    
    public boolean getPriv(){
        return priv; 
    }
    
    public void setPriv(boolean priv){
        this.priv = priv; 
    }
    
    public Board getBoard(){
        return board; 
    }
    
    public void setBoard(Board board){
        this.board = board; 
    } 
    
    
    
    
}
    
    
 
