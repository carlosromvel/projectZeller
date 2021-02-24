package m6_p4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author carlosromvel
 */
public class SqlDaoFactory extends DAOFactory{
    static Connection conexion = null;
    static String DRIVER = "";
    static String URLDB = "";
    static String USUARIO = "root";
    static String CLAVE = null;
    
    public SqlDaoFactory() {
        DRIVER = "com.mysql.cj.jdbc.Driver";
        
        URLDB = "jdbc:mysql://localhost/basem6";
    }
    
    public static Connection crearConexion(){
        if (conexion ==null) {
            try{
                Class.forName(DRIVER);
            } catch (ClassNotFoundException ex){
                Logger.getLogger(SqlDaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
           try{
               conexion = DriverManager.getConnection(URLDB, USUARIO, CLAVE);
           } catch (SQLException ex){
                System.out.printf("HA OCURRIDO UNA EXCEPCIÓN: %n");
                System.out.printf("Mensaje: %s %n", ex.getMessage());
                System.out.printf("SQL Estado: %s %n", ex.getSQLState());
                System.out.printf("Mensaje: %s %n", ex.getErrorCode());
           }
        }
        return conexion;
    }
  
    @Override
    public MenuSQLDAO getMenuSQLDAO(){
        return new SqlDbCochesImpl();
    }
}
