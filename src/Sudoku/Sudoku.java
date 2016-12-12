/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sudoku;

import Controlador.ControladorMenuSudoku;
import Modelo.TableroSudoku;
import java.io.FileNotFoundException;
import java.io.IOException;
//Atributos







/**
 *
 * @author Carlos
 */
public class Sudoku {
    
    private String archivo;
    
    public Sudoku() throws FileNotFoundException,IOException{
        
        ControladorMenuSudoku cms= new ControladorMenuSudoku();

    }
}
