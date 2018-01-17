/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kalytta.bundlea1.buchver;

import de.thkoeln.eks.osgi.basic.Buch;
import de.thkoeln.eks.osgi.buchverw.BuchVerwaltung;
import de.thkoeln.eks.osgi.zentralverwaltung.NummernVerwaltung;
import de.thkoeln.eks.osgi.zentralverwaltung.WebSeiten;
import java.util.ArrayList;

/**
 *
 * @author Philipp Kalytta <endlesscrafter at g m a i l . c o m>
 */
public class BuchVerwaltungImpl implements BuchVerwaltung {
    
    private static final ArrayList<Buch> buecher = new ArrayList<Buch>();
    private NummernVerwaltung numver;
    private WebSeiten webver;

    public int neuesBuch(String string, int i) {
        
        Buch neu = new Buch();
        
        int id = numver.getNeueBuchRegNr();
        
        
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
                webver.aufWebseiteStellen(b);
        }
        
    }

    public void setWebVer(WebSeiten webseiten) {
        this.webver = webseiten;
    }

    public void setNumVer(NummernVerwaltung nummernverwaltung) {
        this.numver = nummernverwaltung;
    }
    
}
