/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Gost;
import domain.Sanker;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author 38169
 */
public class SOLogin extends AbstractSO{
    Sanker ulogovani;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if(!(ado instanceof Sanker))
            throw  new Exception("Prosledjeni objekat nije instanca klase Sanker!");
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Sanker g= (Sanker) ado;
        ArrayList<Sanker> listaSankera= (ArrayList<Sanker>) (ArrayList<?>)
                DBBroker.getInstance().select(ado);
        for (Sanker sanker : listaSankera) {
            if(sanker.getEmail().equals(g.getEmail()) &&
                    sanker.getPassword().equals(g.getPassword())){
                ulogovani=sanker;
                return;
            } 
        }
        
        throw new Exception("Pogresni kredencijali!");
    }

    public Sanker getUlogovani() {
        return ulogovani;
    }
 
    
}
