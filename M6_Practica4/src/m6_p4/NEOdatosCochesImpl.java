/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_p4;
import m6_p4.MenuSQLDAO;
import m6_p4.Coches;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import java.util.ArrayList;
/**
 *
 * @author carlosromvel
 */
public class NEOdatosCochesImpl implements MenuSQLDAO{
    static ODB db;
    
    public NEOdatosCochesImpl(){
        db = NEOdatosDAOfactory.crearConexion();
    }
    @Override
    public boolean InsertarCoche(Coches co){
        db.store(co);
        db.commit();
        System.out.printf("Coche NEO: %s Insertado", co.getMatricula_id());
        return true;
    }
    @Override
    public boolean EliminarCoche(String matricula_id){
        boolean valor = false;
        IQuery query = new CriteriaQuery(Coches.class, Where.equal("matricula_id", matricula_id));
        Objects<Coches> objetos_coches = db.getObjects(query);
        try{
            Coches coch = (Coches) objetos_coches.getFirst();
            db.delete(coch);
            db.commit();
            valor = true;
            System.out.printf("Coche: %s eliminado %n", matricula_id);
        } catch (IndexOutOfBoundsException i){
             System.out.printf("Coche a eliminar: %s No existe %n", matricula_id);
        }
        return valor;
    }
    @Override
    public boolean ModificarCoche(String matricula, Coches co){
          boolean valor = false;
        IQuery query = new CriteriaQuery(Coches.class, Where.equal("matricula", matricula));
        Objects<Coches> objetos_coches = db.getObjects(query);
        try{
            Coches coch = (Coches) objetos_coches.getFirst();
            coch.setColor(co.getColor());
            coch.setModelo(co.getModelo());
            coch.setPrecio(co.getPrecio());
            db.store(coch);
            valor = true;
            db.commit();
        } catch (IndexOutOfBoundsException i){
            System.out.printf("Coche: %s No existe %n", matricula);
        }
        return valor;
    }
    
    @Override
       public Coches ConsultarCoche(String matricula_id){
        IQuery query = new CriteriaQuery(Coches.class, Where.equal("matricula_id", matricula_id));
        Objects<Coches> objetos_coches = db.getObjects(query);
        Coches co = new Coches();
        if (objetos_coches != null){
            try {
                co = (Coches) objetos_coches.getFirst();
            } catch (IndexOutOfBoundsException i) {
                System.out.printf("Coche: %s No existe %n", matricula_id);
                co.setColor("no existe");
                co.setMatricula_id(matricula_id);
                co.setModelo("No existe");
                co.setPrecio(0);
            }
        
        }
        return co;
    }
}
