package co.edu.escuelaing.arsw.letsdraw.controllers;

import co.edu.escuelaing.arsw.letsdraw.model.Room;
import co.edu.escuelaing.arsw.letsdraw.model.User;
import co.edu.escuelaing.arsw.letsdraw.services.impl.LetsDrawServiceImpl;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
import co.edu.escuelaing.arsw.letsdraw.services.impl.RoomServiceImpl;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jgarc
 */

@RestController
public class RoomController {

    @Autowired
    LetsDrawServiceImpl letsDrawServiceImpl;
    
    @CrossOrigin
    @RequestMapping("/")
    private String testing() throws LetsDrawServiceException {
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        letsDrawServiceImpl.addUserToRoomById(new User("pepe" , "pepe") , 1);
        return "Hello World ARSW";
    }
    
    // retornar la plabra con  _ _ _ solo si el usuario no esta dibujando  
    /*
    @CrossOrigin
    @RequestMapping(value = "/getWord2/{id}/{user}/", method = RequestMethod.GET)
    
    public String getWord2(@PathVariable("id") int id , @PathVariable("user") String user  ) throws LetsDrawServiceException {
        
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        letsDrawServiceImpl.addUserToRoomById(new User("pepe" , "pepe") , 1);
        letsDrawServiceImpl.addUserToRoomById(new User("ana" , "ana") , 1);
        letsDrawServiceImpl.getRooms().get(id - 1 ).getRoom().getUsers().get(0).setPainter();
        
        String word = "N O N E";
        for(RoomServiceImpl i : letsDrawServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                word = i.getRoom().getWord(); 
            }
        }
        
        String word2 = ""; 
        for(User i : letsDrawServiceImpl.getRooms().get(id- 1 ).getRoom().getUsers()){
            if(i.getNickname().equals(user )){
                if(i.getIsDrawing()){
                    word2 = word; 
                }else{
                    for(char j : word.toCharArray()){
                        System.out.println(j);
                        word2 += "_ " ;
                    }
                }
                break; 
            }
        }
        return "{\n"
                + "    \"name\": " + "\"" + word2 +"\"\n"
                + "}";
    }
    */ 
    
    @CrossOrigin
    @RequestMapping(value = "/getWord/{id}/", method = RequestMethod.GET)
    public String getWord(@PathVariable("id") int id) throws LetsDrawServiceException {
        String word = "N O N E";
        for(RoomServiceImpl i : letsDrawServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                word = i.getRoom().getWord(); 
            }
        }
        return "{\n"
                + "    \"name\": " + "\"" + word +"\"\n"
                + "}";
    }
            
    @CrossOrigin
    @RequestMapping(value = "/adivinarPalabra/{id}/{palabra}/{usuario}/", method = RequestMethod.GET )
    public void adivinarPalabra(@PathVariable("id") int id , @PathVariable("palabra") String palabra, 
            @PathVariable("usuario") String usuario) throws LetsDrawServiceException{
        
        /** 
        letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        letsDrawServiceImpl.addUserToRoomById(new User("pepe" , "pepe") , 1);
        **/ 
        boolean valid = false; 
        for(RoomServiceImpl i : letsDrawServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                valid = ((i.getRoom().getWord()).equals(palabra)); 
                //System.out.println(palabra + " - " + i.getWord());
                if(valid){
                    for(User j : i.getRoom().getUsers()){
                        if(j.getNickname().equals(usuario) ){
                            int points = j.getPoints();  
                            j.setPoints(points += 10 );
                            //System.out.println("añadio puntos total = "  + j.getPoints()); 
                        }
                        break; 
                    }
                }
                break; 
            }
        }
    }
    
    @CrossOrigin
    @RequestMapping(value = "/addRoom/{name}/{lenguaje}/{priv}/{limit}/", method = RequestMethod.GET)
    public int addRoom(@PathVariable("name") String name, @PathVariable("lenguaje") String lenguaje,
            @PathVariable("priv") boolean priv, @PathVariable("limit") int limit) throws LetsDrawServiceException{

        /**
         *
         * System.out.println("name : " + name); System.out.println("lenguaje :
         * " + lenguaje); System.out.println("priv : " + priv );
         * System.out.println("limit : " + limit );          *
         *
         */
        letsDrawServiceImpl.createRoom(new RoomServiceImpl(name, lenguaje, priv, limit));

        return letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size() - 1).getRoom().getId();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/sendMessage/{id}/{name}/{message}/", method = RequestMethod.GET)
    public void sendMessage(@PathVariable("id") int id , @PathVariable("name") String name, @PathVariable("message") String message) throws LetsDrawServiceException{
        System.out.println("entro el mensaje");
        for(RoomServiceImpl i : letsDrawServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                i.getRoom().sendMessage(name, message);
                

            }
        }
    }
    
    @CrossOrigin
    @RequestMapping(value = "/getMessages/{id}/", method = RequestMethod.GET)
    public String getMessages(@PathVariable("id") int id ) throws LetsDrawServiceException{
        String json = "";  
        for(RoomServiceImpl i : letsDrawServiceImpl.getRooms()){
            if (i.getRoom().getId() == id) {
                
                ArrayList<String[]> mensajes = i.getRoom().getMessages() ;  
                for(String[] j : mensajes ){
                    System.out.println(mensajes.indexOf(j)); 
                    if(mensajes.indexOf(j) == mensajes.size() - 1){
                        json += "{\n"
                        + "           \"user\": \"" + j[0] + "\",\n"
                        + "           \"message\": \"" + j[1] + "\"\n"
                        + "           }\n";
                    }else{
                        json += "{\n"
                        + "           \"user\": \"" + j[0] + "\",\n"
                        + "           \"message\": \"" + j[1] + "\"\n"
                        + "           },\n";
                    }  
                } 
            }
        }
        return "{ \"messages\" : [ " + json + "]} "; 
    }

    /**
     *
     * @param id
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/getRoomInfo/{id}", method = RequestMethod.GET)
    public String getRoomInfo(@PathVariable("id") int id) throws LetsDrawServiceException {
        //letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        //letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("juan", "skin1"));
        //letsDrawServiceImpl.getRooms().get(letsDrawServiceImpl.getRooms().size()-1).addUser(new User("pedro", "skin1"));
        
        ArrayList<User> users = null;
        String sala = "";
        for (RoomServiceImpl i : letsDrawServiceImpl.getRooms()) {
            if (i.getRoom().getId() == id) {
                users = i.getRoom().getUsers();
                sala = i.getRoom().getName();
                break;
            }
        }
        String salida = "";
        for (User i : users) {
            if (users.indexOf(i) == users.size() - 1) {

                salida += "{\n"
                        + "           \"id\": \"" + i.getId() + "\",\n"
                        + "           \"nikname\": \"" + i.getNickname() + "\",\n"
                        + "           \"points\": \"" + i.getPoints() + "\",\n"
                        + "           \"skin\": \"" + i.getSkin() + "\"\n"
                        + "           }\n";
            } else {
                salida += "{\n"
                        + "           \"id\": \"" + i.getId() + "\",\n"
                        + "           \"nikname\": \"" + i.getNickname() + "\",\n"
                        + "           \"points\": \"" + i.getPoints() + "\",\n"
                        + "           \"skin\": \"" + i.getSkin() + "\"\n"
                        + "           },\n";
            }
        }

        return "{\n"
                + "    \"name\": " + "\"" + sala +"\",\n"
                + "    \"user\": [\n"
                + salida
                + "   ]\n"
                + "}";

    }
    @CrossOrigin
    @RequestMapping("/rooms")
    private String rooms() throws LetsDrawServiceException {
        String salida = "";
        //
        //letsDrawServiceImpl.createRoom(new RoomServiceImpl("sala", "En", false, 10));
        //letsDrawServiceImpl.getRooms().get(0).addUser(new User("jugador1", "skin 1"));

        for (RoomServiceImpl i : letsDrawServiceImpl.getRooms()) {
            if (letsDrawServiceImpl.getRooms().indexOf(i) == letsDrawServiceImpl.getRooms().size() - 1) {
                salida += "{\n"
                        + "           \"id\": \"" + i.getRoom().getId() + "\",\n"
                        + "           \"name\": \"" + i.getRoom().getName() + "\",\n"
                        + "           \"users\": \"" + i.getRoom().getUsers().size() + "/" + i.getRoom().getLimit() + "\",\n"
                        + "           \"lenguaje\": \"" + i.getRoom().getLenguaje() + "\",\n"
                        + "           \"priv\": \"" + i.getRoom().getPriv() + "\"\n"
                        + "           }\n";
            } else {
                salida += "{\n"
                        + "           \"id\": \"" + i.getRoom().getId() + "\",\n"
                        + "           \"name\": \"" + i.getRoom().getName() + "\",\n"
                        + "           \"users\": \"" + i.getRoom().getUsers().size() + "/" + i.getRoom().getLimit() + "\",\n"
                        + "           \"lenguaje\": \"" + i.getRoom().getLenguaje() + "\",\n"
                        + "           \"priv\": \"" + i.getRoom().getPriv() + "\"\n"
                        + "           },\n";
            }
            //i.getRoom().getId() + " - " +  i.getRoom().getName() + " - " + i.getRoom().getLenguaje() + " - " + i.getRoom().getLimit() + " - " + i.getRoom().getUsers().size() +"   --------   "; 
        }

        //return salida;  
        return "{\n"
                + "    \"person\": [\n"
                + salida
                + "   ]\n"
                + "}";
    }

}
