/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.controllers;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import co.edu.escuelaing.arsw.letsdraw.services.impl.RoomServiceImpl;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author jgarc
 */

@RestController
public class GameControler {
    @Autowired
    LetsDrawServiceImpl letsDrawServiceImpl; 
    
    
    @RequestMapping("/HelloWorld")
    private String testing() throws LetsDrawServiceException{
        return "Hello World ARSW";   
    }
    
    @RequestMapping("/rooms")
    private String rooms() throws LetsDrawServiceException{
        String salida = ""; 
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala","En", false, 10 , " " ));
        letsDrawServiceImpl.getRooms().get(0).addUser(new User("jugador1" , "skin 1"));
        
        for(RoomServiceImpl i : letsDrawServiceImpl.getRooms()){
            salida += i.getRoom().getId() + " - " +  i.getRoom().getName() + " - " + i.getRoom().getLenguaje() + " - " + i.getRoom().getLimit() + " - " + i.getRoom().getUsers().size() +"   --------   "; 
        }
        
        return salida;   
    }
}
