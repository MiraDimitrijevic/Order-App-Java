/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.sto;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Sto;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38169
 */
public class SOSviStolovi extends AbstractSO{
private ArrayList<Sto> lista;


    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
if(!(ado instanceof Sto))
            throw new Exception("Prosledjeni objekat nije instanca klase Sto!");
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        lista= (ArrayList<Sto>) (ArrayList<?>) DBBroker.getInstance().select(ado);
    }

    public ArrayList<Sto> getLista() {
        return lista;
    }
    
    
}
