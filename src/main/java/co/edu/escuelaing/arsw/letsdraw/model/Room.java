/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.model;

import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import java.security.SecureRandom;
import java.util.ArrayList;
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
    private ArrayList<String[]> messages = new ArrayList<String[]>(); 
    private int timer; 
    private Board board;
    private String word; 
    private final int maxUsers = 10 ;
    private String[] palabrasEs = {"caballo", "zanahoria", "pollo","carro" , "celular", "cabello", "lapiz"}; 
    private String[] palabrasIn = {"horse", "carrot", "chicken", "car", "phone", "hair", "pencil"}; 
    private int actualPainter; 
    
    public Room(String name , String lenguaje , boolean priv , int limit ) throws LetsDrawServiceException{
        this.name = name ;
        this.timer = 60; 
        this.lenguaje = lenguaje; 
        this.limit = limit; 
        validLimit(); 
        this.priv = priv;
        word = randomWord(); 
        randomPassword(); 
        board = new Board(); 
        actualPainter = 0; 
    }
    
    private String randomWord(){
        String w = ""; 
        SecureRandom random = new SecureRandom();
        if(lenguaje.equals("Español")){
            int randomIndex = random.nextInt(palabrasEs.length);
            w = palabrasEs[randomIndex];
        }else{
            int randomIndex = random.nextInt(palabrasIn.length);
            w = palabrasIn[randomIndex]; 
        }
        return w; 
    }
    
    public void changeWord(){
        String nword = randomWord(); 
        while(nword.equals(word)){
            nword = randomWord(); 
        }
        word = nword; 
    }
    
    private void randomPassword(){
        if(priv){
                // ASCII range – alphanumeric (0-9, a-z, A-Z)
            final String chars = "abcdefghijklmnopqrstuvwxyz0123456789";

            SecureRandom random = new SecureRandom();
            StringBuilder sb = new StringBuilder();

            // each iteration of the loop randomly chooses a character from the given
            // ASCII range and appends it to the `StringBuilder` instance


            for (int i = 0; i < 5; i++)
            {
                int randomIndex = random.nextInt(chars.length());
                sb.append(chars.charAt(randomIndex));
            }
        
            password =  sb.toString();
        }else{
            password = null; 
        }
       
    }
    private void validLimit(){
        if(limit > maxUsers){
            limit = maxUsers; 
        } 
    }
    
    public void setWord(String word ){
        this.word = word; 
    } 
    
    public String getWord(){
        return word; 
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
    
    public void setMessages(ArrayList<String[]> messages){
        this.messages = messages; 
    }
    
    public ArrayList<String[]> getMessages(){
        return messages;  
    }
    
    public int getTimer(){
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
    
    public String getPassword(){
        return password; 
    }
    
    public void sendMessage(String user, String message){
           messages.add( new String[] {user , message} ); 
    }
    
    public void changeTurn(){
        users.get(actualPainter).stopPainting(); 
        System.out.println(actualPainter); 
        if((actualPainter + 1) < users.size()){ 
            actualPainter ++ ; 
        }else{
            actualPainter = 0; 
        }   
        System.out.println(actualPainter); 
        users.get(actualPainter).setPainter();
    }
    
    public void changeTimer(){
        if(timer - 1  <= 0){
            timer = 60 ; 
        }else{
            timer -- ; 
        }
    }
    
}
    
    
 
