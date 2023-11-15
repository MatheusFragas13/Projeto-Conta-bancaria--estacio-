package org.banco.service;


import org.banco.model.UsuarioBanco;

public class ContaBanco {
    public static void main(String[] args) {
        UsuarioBanco user1 = new UsuarioBanco(); //usuario tem o prefixo User e o numero do id
        user1.setNumconta(461956);
        user1.setTipo("CC");
        user1.setDono("Matheus Fragas");
        user1.SetSaldo(100.00);
        user1.setStatus(true);
        user1.AbrirConta();
        

       UsuarioBanco user2 = new UsuarioBanco();
        user2.setNumconta(284024);
        user2.setTipo("CC");
        user2.setDono("Felipe Pereira");
        user2.SetSaldo(0);
        user2.setStatus(false);
        user2.AbrirConta();
    }

    
}       
      
