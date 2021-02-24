package m6_p4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlosromvel
 */
public abstract class DAOFactory {
     //Esta fábrica soportará conexiones MYSQL y NEODATIS
    public static final int MYSQL = 1;
    public static final int NEODATIS = 2;
    
    public abstract MenuSQLDAO getMenuSQLDAO();
    
    public static  DAOFactory getDAOFactory(int db){
        switch (db) {
            case MYSQL :
                return new SqlDaoFactory();
            case NEODATIS :
                return new NEOdatosDAOfactory();
            default :
                return null;
        }
    }
}
