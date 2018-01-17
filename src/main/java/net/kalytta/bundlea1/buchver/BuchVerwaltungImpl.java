/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kalytta.bundlea1.buchver;

import de.thkoeln.eks.osgi.basic.Buch;
import de.thkoeln.eks.osgi.buchverw.BuchVerwaltung;
import java.util.ArrayList;

/**
 *
 * @author Philipp Kalytta <endlesscrafter at g m a i l . c o m>
 */
public class BuchVerwaltungImpl implements BuchVerwaltung {
    
    private static final ArrayList<Buch> buecher = new ArrayList<Buch>();

    public int neuesBuch(String string, int i) {
        
        Buch neu = new Buch();
        int id = getNeueBuchRegNr();
        neu.setTitel(string);
        neu.setPreis(i);
        neu.setRegistrierungsnummer(id);
        buecher.add(neu);
        return id;
    }

    public Buch getBuch(int i) {
        
        for(Buch b:buecher)
        {
            
            if(b.getRegistrierungsnummer()==i)
                return b;
        
        }
        
        return null;
    }

    public ArrayList<Buch> alleBuecher() {
        return buecher;
    }

    public void lieferbar(int i) {
       
        for(Buch b: buecher)
        {
            if(b.getRegistrierungsnummer()==i)
                aufWebseiteStellen(b);
        }
        
    }
    
}
