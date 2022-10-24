/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.exception;

/**
 *
 * @author june
 */
public class UpdateException extends Exception{

    public UpdateException(String message) {
        super("Update Exception: " + message);
    }
    
    
}
