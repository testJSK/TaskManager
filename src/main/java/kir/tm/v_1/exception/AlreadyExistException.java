/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.exception;

/**
 *
 * @author june
 */
public class AlreadyExistException extends Exception{

    public AlreadyExistException(String message) {
        super("Already Exist Exception: " + message);
    }
    
    
}
