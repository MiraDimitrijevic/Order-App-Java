/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbina;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Porudzbina;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38169
 */
public class SOSvePorudzbine extends AbstractSO{
private ArrayList<Porudzbina> lista;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Porudzbina))
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina !");
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        lista=  (ArrayList<Porudzbina>) (ArrayList<?>)DBBroker.getInstance().select(ado);
    }

    public ArrayList<Porudzbina> getLista() {
        return lista;
    }
    
    
    
}
