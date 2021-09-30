/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import java.util.ArrayList;



/**
 *
 * @author jgarc
 */
public interface InterfaceLetsDrawService {
    public void createUser(String nickname) throws LetsDrawServiceException;
    public void createRoom(String name, boolean priv , String password )throws LetsDrawServiceException; 
    public void logRoom(String name); 
    public String addUserRoom(String idSala) throws LetsDrawServiceException;
    public void removeUserRoom(String idSala) throws LetsDrawServiceException;
    public void changeUserName(String name) throws LetsDrawServiceException; 
    public String getWord() throws LetsDrawServiceException;
    public ArrayList<User> getUsers() throws LetsDrawServiceException;
    public ArrayList<Room> getRooms() throws LetsDrawServiceException;
}
