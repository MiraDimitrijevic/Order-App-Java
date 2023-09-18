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

/**
 *
 * @author 38169
 */
public class SOIzmeniPorudzbinu extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
                        System.out.println("Usao u validate");

 if(!(ado instanceof Porudzbina))
            throw new Exception("Prosledjeni objekat nije instanca klase Porudzbina !");
                           System.out.println("Jeste klase porudzbina");

 Porudzbina porudzbina= (Porudzbina) ado;
         
         if(porudzbina.getStavkePorudzbine().isEmpty())
             throw new Exception("Porudzbina mora imati stavke!");
                                 System.out.println("Izasao iz validate");

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
        Porudzbina porudzbina= (Porudzbina) ado;
        DBBroker.getInstance().delete(porudzbina.getStavkePorudzbine().get(0));

              for (StavkaPorudzbine stavkaPorudzbine : porudzbina.getStavkePorudzbine()) {
            DBBroker.getInstance().insert(stavkaPorudzbine);
        }
    }
    
}
