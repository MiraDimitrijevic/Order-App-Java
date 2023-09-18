/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.stavkaPorudzbine;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.StavkaPorudzbine;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38169
 */
public class SOSveStavkePorudzbine extends AbstractSO{
    private ArrayList<StavkaPorudzbine> lista;

    public ArrayList<StavkaPorudzbine> getLista() {
        return lista;
    }

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof StavkaPorudzbine))
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaPorudzbine!");
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
lista=  (ArrayList<StavkaPorudzbine>) (ArrayList<?>)DBBroker.getInstance().select(ado);

    }
    
    
}
