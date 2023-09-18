/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.gost;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Gost;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38169
 */
public class SONoviGost extends AbstractSO{

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Gost))
            throw  new Exception("Prosledjeni objekat nije instanca klase Gost!");
       
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
    
}
