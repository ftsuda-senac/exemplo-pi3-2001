/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.model.servicos;

/**
 *
 * @author fedts
 */
public class AppException extends Exception {
    
    public AppException(String msg, Throwable e) {
        super(msg, e);
    }
    
}
