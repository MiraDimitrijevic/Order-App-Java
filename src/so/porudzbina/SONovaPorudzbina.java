/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.porudzbina;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Porudzbina;
import domain.StavkaPorudzbine;
import so.AbstractSO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 38169
 */
public class SONovaPorudzbina extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
         if(!(ado instanceof Porudzbina))
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina !");
    
         Porudzbina porudzbina= (Porudzbina) ado;
         
         if(porudzbina.getStavkePorudzbine().isEmpty())
             throw new Exception("Porudzbina mora imati stavke!");
    
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Porudzbina porudzbina=(Porudzbina) ado;
        PreparedStatement ps= DBBroker.getInstance().insert(ado);
        ResultSet keys=ps.getGeneratedKeys();
        keys.next();
        long pID= keys.getLong(1);
        System.out.println("kljuc porudzbine: "+ pID);
        porudzbina.setPorudzbinaID(pID);
        
        for (StavkaPorudzbine stavkaPorudzbine : porudzbina.getStavkePorudzbine()) {
            stavkaPorudzbine.setPorudzbina(porudzbina);
            DBBroker.getInstance().insert(stavkaPorudzbine);
        }
    }
    
}
