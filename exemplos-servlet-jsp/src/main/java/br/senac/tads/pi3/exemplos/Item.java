/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplos;

public class Item {
    
    private String texto;
    
    private int numero;
    
    private boolean par;
    
    public Item() {

    }
    
    public Item(String texto, int numero) {
        this.texto = texto;
        this.numero = numero;
        this.par = (numero % 2 == 0);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isPar() {
        return par;
    }

    public void setPar(boolean par) {
        this.par = par;
    }
    
}
