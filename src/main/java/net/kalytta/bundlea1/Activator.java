package net.kalytta.bundlea1;

import java.util.Hashtable;
import net.kalytta.bundlea1.buchver.BuchVerwaltungImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    
    private ServiceRegistration<?> buchverwaltungservice;
    
    public void start(BundleContext context) throws Exception {
        // TODO add activation code here
        Hashtable<String,String> properties = new Hashtable<String, String>();
        
        buchverwaltungservice = context.registerService(BuchVerwaltungImpl.class.getName(), new BuchVerwaltungImpl(), properties);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
        
    }

}
