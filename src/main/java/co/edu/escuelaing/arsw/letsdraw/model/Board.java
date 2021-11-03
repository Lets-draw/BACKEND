/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arsw.letsdraw.model;

import java.util.ArrayList;
//import javafx.util.Pair;

/**
 *
 * @author jgarc
 */
public class Board {
    private String color; 
    private boolean eraser; 
    private ArrayList<int[]> points; 
    //private ArrayList<Pair<int, int>>; 
    public Board(){
        color = "black"; 
    }
    
    public void setColor( String color){
        this.color = color; 
    }
    
    public String getColor(){
        return color; 
    }
    
    public void setEraser(boolean eraser){
        this.eraser = eraser; 
    } 
    
    public boolean getEraser(){
        return eraser; 
    } 
}
