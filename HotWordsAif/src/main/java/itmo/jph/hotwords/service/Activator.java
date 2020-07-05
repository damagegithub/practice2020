package itmo.jph.hotwords.service;

import itmo.jph.hotwords.api.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator{
    ServiceRegistration<GetHotWordsService> serviceRegistration;
    public void start(BundleContext context) {
        serviceRegistration = context.registerService(GetHotWordsService.class,new HotWordsAif(),null);
        System.out.println("Started Hot Words Service Aif");
    }

    public void stop(BundleContext context) {
        System.out.println("Stopped Hot Words Service Aif");
        serviceRegistration.unregister();
    }
}
