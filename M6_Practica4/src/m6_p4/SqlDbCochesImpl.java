package m6_p4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlosromvel
 */
public class SqlDbCochesImpl implements MenuSQLDAO {
     Connection conexion;
    public SqlDbCochesImpl() {
        conexion = SqlDaoFactory.crearConexion();
    }
  
    @Override
    public boolean InsertarCoche(Coches co){
    boolean valor = false;
    String sql = "INSERT INTO coches VALUES(?,?,?,?)";
    PreparedStatement sentencia;
    try{
        sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, co.getMatricula_id());
        sentencia.setString(2, co.getColor());
        sentencia.setString(3, co.getModelo());
        sentencia.setInt(4, co.getPrecio());
        int filas = sentencia.executeUpdate();
        if (filas > 0){
            valor = true;
            System.out.printf("Coche %s insertado %n", co.getMatricula_id());
            }
        sentencia.close();
        } catch(SQLException e) { MensajeExcepcion (e);}
    return valor;
    }
    
    @Override
    public boolean EliminarCoche(String matricula_id){
        boolean valor = false;
        String sql = "DELETE FROM coches WHERE matricula_id = ? ";
        PreparedStatement sentencia;
        try{
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, matricula_id);
            int filas = sentencia.executeUpdate();
            if(filas > 0){
                valor = true;
                System.out.printf("Coche %s eliminado %n", matricula_id);
            }
            sentencia.close();
        } catch (SQLException e) {MensajeExcepcion(e); }
    return valor;
    }
    
    @Override
    public boolean ModificarCoche(String matricula, Coches co){
        boolean valor = false;
        String sql = "UPDATE coches SET color = ?, modelo = ?, precio = ? WHERE matricula_id = ? ";
        PreparedStatement sentencia;
        try{
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(4, matricula);
            sentencia.setString(1, co.getColor());
            sentencia.setString(2, co.getModelo());
            sentencia.setInt(3, co.getPrecio());
            int filas = sentencia.executeUpdate();
            if(filas > 0){
                valor = true;
                System.out.printf("Coche %s modificado %n", matricula);
            }
            sentencia.close();
        } catch (SQLException e) {MensajeExcepcion(e); }
    return valor;
    }    


    @Override
    public Coches ConsultarCoche(String matricula_id){
    String sql = "SELECT matricula_id, color, modelo, precio FROM coches WHERE matricula_id = ?";
    PreparedStatement sentencia;
    Coches co = new Coches();
    try{
        sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, matricula_id);
        ResultSet rs = sentencia.executeQuery();
        if (rs.next()) {
            co.setMatricula_id(rs.getString("matricula_id"));
            co.setColor(rs.getString("color"));
            co.setModelo(rs.getString("modelo"));
            co.setPrecio(rs.getInt("precio"));
             System.out.printf("Matricula: %s, Color: %s, Modelo: %s, Precio: %d %n", co.getMatricula_id(), co.getColor(), co.getModelo(), co.getPrecio());
        }
        else
            System.out.printf("Coche id: %s No existe %n", matricula_id);
        
        rs.close();
        sentencia.close();
        } catch(SQLException e) { MensajeExcepcion (e);}
    return co;
    }    


    
    private void MensajeExcepcion(SQLException e){
        System.out.printf("HA OCURRIDO UNA EXCEPCIÓN: %n");
	System.out.printf("Mensaje: %s %n", e.getMessage());
	System.out.printf("SQL Estado: %s %n", e.getSQLState());
	System.out.printf("Mensaje: %s %n", e.getErrorCode());
    }    
    
    
    
}

