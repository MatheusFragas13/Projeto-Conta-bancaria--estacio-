/**
*
* @author  Grupo
* @version 1.0
* @since   20/10/2023
*/

package org.banco.model;
public class UsuarioBanco {
    private int numConta; //
    private String tipo; //
    private String dono; //
    private double saldo; //
    private boolean status; //

public int getNumconta(){
    return numConta;
}

public void setNumconta(int newNumConta){
    numConta = newNumConta;
}

public String getTipo(){
    return tipo;
}

public void setTipo(String newTipo){
    tipo = newTipo;
}
public String getDono(){
    return dono;
}

public void setDono(String newDono){
    dono = newDono;
}
public double getSaldo(){
    return saldo;
}

public void SetSaldo(double newSaldo){
    saldo = newSaldo;
}

public boolean getStatus(){
    return status;
}

public void setStatus(boolean newStatus){
    status = newStatus;
}
}
