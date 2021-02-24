/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_p4;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import m6_p4.MenuSQLDAO;
import static m6_p4.SqlDaoFactory.URLDB;

/**
 *
 * @author carlosromvel
 */
public class NEOdatosDAOfactory extends DAOFactory{
    static ODB odb = null;
         static String URLDB = "";
    static String USUARIO = "root";
    static String CLAVE = null;
    public NEOdatosDAOfactory(){
          URLDB = "coches.basem6";
    }
    public static ODB crearConexion(){
        if(odb == null){
            odb = ODBFactory.open("basem6.localhost");
        }
        return odb;
    }
    @Override
    public MenuSQLDAO getMenuSQLDAO(){
        return new NEOdatosCochesImpl();
    }
}
