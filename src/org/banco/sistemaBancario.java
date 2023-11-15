package org.banco;

import java.sql.*;

public class sistemaBancario {

    public static final String URL = "jdbc:mysql://localhost:3306/contaBancaria";
    public static final String USER = "admin";
    public static final String PASSWORD = "aurenice1";

    public int numConta;
    public String tipo;
    public String dono;
    public double saldo;
    public boolean status;

    // Método para conectar ao banco de dados
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para abrir uma conta
    public void abrirConta(int numConta, String tipo, String dono, double saldo) {
        try (Connection conn = conectar()) {
            String query = "INSERT INTO contas (num_conta, tipo, dono, saldo, status) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, numConta);
                stmt.setString(2, tipo);
                stmt.setString(3, dono);
                stmt.setDouble(4, saldo);
                stmt.setBoolean(5, true); // Status inicial
                stmt.executeUpdate();
            }
            System.out.println("Conta aberta com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para fechar uma conta
    public void fecharConta(int numConta) {
        try (Connection conn = conectar()) {
            String query = "UPDATE contas SET status = false WHERE num_conta = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, numConta);
                stmt.executeUpdate();
            }
            System.out.println("Conta fechada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para depositar em uma conta
    public void depositar(int numConta, double valor) {
        try (Connection conn = conectar()) {
            String query = "UPDATE contas SET saldo = saldo + ? WHERE num_conta = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setDouble(1, valor);
                stmt.setInt(2, numConta);
                stmt.executeUpdate();
            }
            System.out.println("Depósito realizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para sacar de uma conta
    public void sacar(int numConta, double valor) {
        try (Connection conn = conectar()) {
            String query = "UPDATE contas SET saldo = saldo - ? WHERE num_conta = ? AND status = true";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setDouble(1, valor);
                stmt.setInt(2, numConta);
                stmt.executeUpdate();
            }
            System.out.println("Saque realizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para pagar mensalidade
    public void pagarMensalidade(int numConta) {
        try (Connection conn = conectar()) {
            String query = "UPDATE contas SET saldo = saldo - 10 WHERE num_conta = ? AND status = true";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, numConta);
                stmt.executeUpdate();
            }
            System.out.println("Mensalidade paga com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sistemaBancario sistema = new sistemaBancario();
        sistema.abrirConta(40, "Poupança", "<Matheus>", 1000.0);
        sistema.depositar(40, 500.0);
        sistema.sacar(40, 200.0);
        sistema.pagarMensalidade(150);
        sistema.fecharConta(150);
    }
}
