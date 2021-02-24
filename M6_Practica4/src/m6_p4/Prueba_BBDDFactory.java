/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_p4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author carlosromvel
 */
public class Prueba_BBDDFactory {
    static Scanner keyboard = new Scanner(System.in);
    static String matricula, color, modelo;
    static int precio;
      
        public static void main(String[] args) {
       System.out.println("Author: Monlau");
        
        String option;
        functionDate();
        keyboard.useDelimiter("\n");
        do {
            menu();
            option = keyboard.next();
            switch (option) {
                case"1":
                   consultaDatoRelacional();
                break;
                case"2":
                   InsertarDatoRelacional();
                break;
                case"3":
                   BorrarDatoRelacional();
                break;
                case"4":
                   ActualizarDatoRelacional();
                break;
                case"5":
                   consultaDatoNEO();
                break;
                case"6":
                  InsertarDatoNEO();
                break;
                case"7":
                 BorrarDatoNEO();
                break;
                case"8":
                      ActualizarDatoNEO();
                break;
                
                default: System.out.println("......");
            }
        } while (!option.equals("0"));
    }
        public static void functionDate() {
        Calendar calendario = new GregorianCalendar();
        int hour, minuts, seconds;
        String Date, DateHour, HourMinSec;
        hour = calendario.get(Calendar.HOUR_OF_DAY);
        minuts = calendario.get(Calendar.MINUTE);
        seconds = calendario.get(Calendar.SECOND);
        SimpleDateFormat sdfDateHour = new SimpleDateFormat(" dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdfDate = new SimpleDateFormat(" dd/MM/yyyy");
        SimpleDateFormat sdfHour = new SimpleDateFormat(" HH:mm:ss");
        DateHour = sdfDateHour.format(calendario.getTime());
        Date = sdfDate.format(calendario.getTime());
        HourMinSec = sdfHour.format(calendario.getTime());
        System.out.println("----------------------------------------------------- ");
        //System.out.println(" date: \t" + calendario.getTime());//formato standard
        System.out.println("\tDate And Hour: \t" + DateHour); //fecha y hora min seg juntos
        //System.out.println(" Fecha: \t" + fecha); //solo fecha
        //System.out.println(" Hora Min Seg: \t" + horaMinSeg);//hora min seg juntos
        //System.out.println(" Hora:" + hora + " \t Min:" + minutos + " \tSegundos:" + segundos); //por separado
        System.out.println("----------------------------------------------------- ");
    }
     private static void menu() {
        System.out.println("--------------------------------------------------------");
        System.out.println("1 - Consultar Dato Relacional:");
        System.out.println("2 - Insertar Dato Relacional:");
        System.out.println("3 - Borrar Dato Relacional:");
        System.out.println("4 - Actualizar Dato Relacional:");
        System.out.println("5 - Consultar Dato NEO:");
        System.out.println("6 - Insertar Dato NEO:");
        System.out.println("7 - Borrar Dato NEO:");
        System.out.println("8 - Actualizar Dato NEO:");
        System.out.println("00- Exit");
        System.out.print("Option?: ");
    }
 

    
     private static void consultaDatoRelacional() {
         DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
           MenuSQLDAO cochesDAO = db.getMenuSQLDAO();
        
      
      
        
        
        
         
        
            String matricula;
            System.out.println("Coche:  ");
            Scanner sc = new Scanner(System.in);
            matricula = sc.next();
            cochesDAO.ConsultarCoche(matricula);
     }
     private static void consultaDatoNEO() {
         DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.NEODATIS);
       
        MenuSQLDAO cochesDAO = db.getMenuSQLDAO();
        
      
      
        
        
        
         
        
            String matricula;
            System.out.println("Coche NEO:  ");
            Scanner sc = new Scanner(System.in);
            matricula = sc.next();
            cochesDAO.ConsultarCoche(matricula);
            
    }
           private static void InsertarDatoRelacional() {
            DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
       
        MenuSQLDAO cochesDAO = db.getMenuSQLDAO();
        
        System.out.println("Dime la matricula nueva: ");
        matricula = keyboard.next();
        System.out.println("Dime el color: ");
        color = keyboard.next();
        System.out.println("Dime el modelo: ");
        modelo = keyboard.next();
        System.out.println("Establece un precio: ");
        precio = keyboard.nextInt();
        Coches co = new Coches(matricula, color, modelo, precio);
        cochesDAO.InsertarCoche(co);
        
        
    }
    private static void InsertarDatoNEO() {
            DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.NEODATIS);
       
        MenuSQLDAO cochesDAO = db.getMenuSQLDAO();
        
        System.out.println("Dime la matricula nueva: ");
        matricula = keyboard.next();
        System.out.println("Dime el color: ");
        color = keyboard.next();
        System.out.println("Dime el modelo: ");
        modelo = keyboard.next();
        System.out.println("Establece un precio: ");
        precio = keyboard.nextInt();
        Coches co = new Coches(matricula, color, modelo, precio);
        cochesDAO.InsertarCoche(co);
        
        
    }
 private static void BorrarDatoRelacional() {
     DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
       
        MenuSQLDAO cochesDAO = db.getMenuSQLDAO();

       System.out.print("Matricula a borrar: ");
       matricula = keyboard.next();
       cochesDAO.EliminarCoche(matricula);
             
 
 
 }
  private static void BorrarDatoNEO() {
     DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.NEODATIS);
       
        MenuSQLDAO cochesDAO = db.getMenuSQLDAO();

       System.out.print("Matricula a borrar: ");
       matricula = keyboard.next();
       cochesDAO.EliminarCoche(matricula);
             
 
 
 }
 
 
 private static void ActualizarDatoRelacional() {
     DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
       
        MenuSQLDAO cochesDAO = db.getMenuSQLDAO();
        System.out.println("Introduce la matricula a actualizar: ");
        matricula = keyboard.next();
        System.out.println("--------DATOS A ACTUALIZAR-----------");
        System.out.println("Dime el color: ");
        color = keyboard.next();
        System.out.println("Dime el modelo: ");
        modelo = keyboard.next();
        System.out.println("Establece un precio: ");
        precio = keyboard.nextInt();
        Coches co = new Coches(matricula, color, modelo, precio);
        cochesDAO.ModificarCoche(matricula, co);
 }
  private static void ActualizarDatoNEO() {
     DAOFactory db = DAOFactory.getDAOFactory(DAOFactory.NEODATIS);
       
        MenuSQLDAO cochesDAO = db.getMenuSQLDAO();
        System.out.println("Introduce la matricula a actualizar: ");
        matricula = keyboard.next();
        System.out.println("--------DATOS A ACTUALIZAR-----------");
        System.out.println("Dime el color: ");
        color = keyboard.next();
        System.out.println("Dime el modelo: ");
        modelo = keyboard.next();
        System.out.println("Establece un precio: ");
        precio = keyboard.nextInt();
        Coches co = new Coches(matricula, color, modelo, precio);
        cochesDAO.ModificarCoche(matricula, co);
 }
 
}
