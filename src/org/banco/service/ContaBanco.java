package org.banco.service;

import java.io.ObjectInputFilter.Status;

import org.banco.model.UsuarioBanco;

public class ContaBanco {
    public static void main(String[] args) {
        UsuarioBanco user1 = new UsuarioBanco(); //usuario tem o prefixo User e o numero do id
        user1.setNumconta(461956);
        user1.setTipo("CC");
        user1.setDono("Matheus Fragas");
        user1.SetSaldo(100.00);
        user1.setStatus(true);

       
    }

    private void AbrirConta(boolean status){

        
    }
    
    private void fecharConta(double saldo, boolean status){

        
    }

    private void sacar(double saldo, boolean status){

        
    }

    private void pagarMensal(double saldo, String tipo){

    }

}

