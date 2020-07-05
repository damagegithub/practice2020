package itmo.jph.hotwords.client;

import itmo.jph.hotwords.api.GetHotWordsService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Hashtable;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {

        Hashtable props = new Hashtable();
        props.put("osgi.command.scope", "news");
        props.put("osgi.command.function", new String[]{"stats", "stats"});
        context.registerService(HotWords.class.getName(), new HotWords(context), props);
    }
    public void stop(BundleContext context) throws Exception {
    }
}

