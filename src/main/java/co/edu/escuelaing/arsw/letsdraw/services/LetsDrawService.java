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
import org.springframework.stereotype.Service;

/**
 *
 * @author jgarc
 */
@Service 
public class LetsDrawService implements InterfaceLetsDrawService {

    @Override
    public void createUser(String nickname) throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createRoom(String name, boolean priv, String password) throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logRoom(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addUserRoom(String idSala) throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUserRoom(String idSala) throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeUserName(String name) throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWord() throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Room> getRooms() throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ArrayList<User> getUsers() throws LetsDrawServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
