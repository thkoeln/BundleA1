package net.kalytta.bundlea1;

import de.thkoeln.eks.osgi.zentralverwaltung.NummernVerwaltung;
import de.thkoeln.eks.osgi.zentralverwaltung.WebSeiten;
import java.util.Hashtable;
import net.kalytta.bundlea1.buchver.BuchVerwaltungImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    
    private ServiceRegistration buchverwaltungservice;
    
    public void start(BundleContext context) throws Exception {
        
        
        //Nummernverwaltung-Implementierung heranholen
        ServiceReference[] refs = context.getServiceReferences("de.thkoeln.eks.osgi.zentralverwaltung.Nummernverwaltung", "(version=*)");
        NummernVerwaltung nummernverwaltung = (NummernVerwaltung) context.getService(refs[0]);
        
        
        //WebSeiten-Implementierung heranholen
        ServiceReference[] refs2 = context.getServiceReferences("de.thkoeln.eks.osgi.zentralverwaltung.WebSeiten", "(version=*)");
        WebSeiten webseiten = (WebSeiten) context.getService(refs[0]);
        
        //Eigene Service definieren und registrieren
        Hashtable<String,String> properties = new Hashtable<String, String>();
        properties.put("version", "1.0");
        
        BuchVerwaltungImpl bw = new BuchVerwaltungImpl();
        bw.setNumVer(nummernverwaltung);
        bw.setWebVer(webseiten);
        
        buchverwaltungservice = context.registerService(BuchVerwaltungImpl.class.getName(), bw, properties);
        
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
        
    }

}
