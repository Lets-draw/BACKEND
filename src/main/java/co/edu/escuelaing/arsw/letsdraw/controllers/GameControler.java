/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.controllers;

import co.edu.escuelaing.arsw.letsdraw.services.LetsDrawService;
import co.edu.escuelaing.arsw.letsdraw.services.exceptions.LetsDrawServiceException;
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
    LetsDrawService letsDrawService; 
    
    @RequestMapping("/init")
    private String testing() throws LetsDrawServiceException{
        return "Hello World ARSW";   
    }
}
