/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;

/**
 *
 * @author jgarc
 */
public interface InterfaceRoomService{
    
    public void addUser(User u); 
    public void delUser(User u ); 
    public void changeLenguaje(String lenguaje); 
    public void startTimer(); 
    public void stopTimer(); 
    public void changeTurn(); 
    public void sendMessage(User u , String message); 
    public void endRound();
    public void startRound();
    public String getWord(); 
    public Room getRoom(); 
    public void setroom(Room room); 
    
}
