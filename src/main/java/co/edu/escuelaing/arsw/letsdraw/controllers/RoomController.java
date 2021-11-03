package co.edu.escuelaing.arsw.letsdraw.controllers;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import co.edu.escuelaing.arsw.letsdraw.services.impl.RoomServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author jgarc
 */

@RestController
public class RoomController {
    @Autowired
    LetsDrawServiceImpl letsDrawServiceImpl; 
    
    
    @RequestMapping("/HelloWorld")
    private String testing() throws LetsDrawServiceException{
        return "Hello World ARSW";   
    }
    
    @RequestMapping("/rooms")
    private String rooms() throws LetsDrawServiceException{
        String salida = ""; 
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala","En", false, 10 ));
        letsDrawServiceImpl.getRooms().get(0).addUser(new User("jugador1" , "skin 1"));
        
        for(RoomServiceImpl i : letsDrawServiceImpl.getRooms()){
            if(letsDrawServiceImpl.getRooms().indexOf(i)==letsDrawServiceImpl.getRooms().size()-1){
               salida += "{\n" +
    "           \"id\": \""+i.getRoom().getId()+"\",\n" +
    "           \"name\": \""+i.getRoom().getName()+"\",\n" +
    "           \"users\": \""+i.getRoom().getUsers().size()+"/"+i.getRoom().getLimit()+"\",\n" +
    "           \"lenguaje\": \""+i.getRoom().getLenguaje()+"\",\n" +
    "           \"priv\": \""+i.getRoom().getPriv()+"\"\n"+
    "           }\n"; 
            }
            else{
                salida += "{\n" +
    "           \"id\": \""+i.getRoom().getId()+"\",\n" +
    "           \"name\": \""+i.getRoom().getName()+"\",\n" +
    "           \"users\": \""+i.getRoom().getUsers().size()+"/"+i.getRoom().getLimit()+"\",\n" +
    "           \"lenguaje\": \""+i.getRoom().getLenguaje()+"\",\n" +
    "           \"priv\": \""+i.getRoom().getPriv()+"\"\n"+
    "           },\n";
            }
            //i.getRoom().getId() + " - " +  i.getRoom().getName() + " - " + i.getRoom().getLenguaje() + " - " + i.getRoom().getLimit() + " - " + i.getRoom().getUsers().size() +"   --------   "; 
        }
        
        //return salida;  
        return "{\n" +
"    \"person\": [\n" +
      salida +
"   ]\n" +
"}"; 
    }

    @RequestMapping(value = "/addRoom/{name}/{lenguaje}/{priv}/{limit}/", method = RequestMethod.GET)

    public int addRoom(@PathVariable("name") String name,@PathVariable("lenguaje") String lenguaje ,
            @PathVariable("priv") boolean priv ,@PathVariable("limit") int limit) throws LetsDrawServiceException {
        
        /**
        
        System.out.println("name : " + name);
        System.out.println("lenguaje : " + lenguaje);
        System.out.println("priv : " + priv ); 
        System.out.println("limit : " + limit ); 
        
        **/
        
        letsDrawServiceImpl.createRoom(new RoomServiceImpl(name,lenguaje,priv,limit));
        
        return letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size() -1 ).getRoom().getId();
    }
}

