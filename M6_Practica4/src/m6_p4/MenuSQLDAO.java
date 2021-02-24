package m6_p4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author carlosromvel
 */
public interface MenuSQLDAO {
    public boolean InsertarCoche(Coches co);
    public boolean EliminarCoche(String matricula_id);
    public boolean ModificarCoche(String matricula_id, Coches co);
    public Coches ConsultarCoche(String matricula_id);
}
