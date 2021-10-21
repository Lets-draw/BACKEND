/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.services.impl;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.InterfaceLetsDrawService;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgarc
 */
@Service 
public class LetsDrawServiceImpl implements InterfaceLetsDrawService {
    private ArrayList<RoomServiceImpl> rooms = new ArrayList<RoomServiceImpl>(); 
    
    @Override
    public void setLenguaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RoomServiceImpl> getRooms() {
        return rooms; 
    }
    /**
    @Override
    public ArrayList<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    **/ 

    @Override
    public void createRoom(RoomServiceImpl r) {
        r.getRoom().setId(rooms.size() +1 );
        rooms.add(r);
    }

    @Override
    public void createUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
