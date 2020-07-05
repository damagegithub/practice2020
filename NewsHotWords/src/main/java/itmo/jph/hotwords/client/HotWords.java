package itmo.jph.hotwords.client;


import itmo.jph.hotwords.api.GetHotWordsService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import java.util.Objects;

public class HotWords {
    BundleContext bundleContext;

    public HotWords(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public void stats() {
        System.out.println("Please select a source");
        ServiceReference<?>[] refs;

        try {
            refs = bundleContext.getAllServiceReferences(GetHotWordsService.class.getName(), null);
            if (refs != null) {
                for (ServiceReference ref : refs) {
                    System.out.println(ref.getBundle().getSymbolicName());
                }
            }
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void stats(String website) {
        System.out.println(website + " Top 10 Hot Words:");
        useService(website);
    }

    private void useService(String source) {
        ServiceReference<?>[] refs;
        try {
            refs = bundleContext.getAllServiceReferences(GetHotWordsService.class.getName(), null);
            if (refs != null) {
                for (ServiceReference ref : refs) {
                    if (Objects.equals(ref.getBundle().getSymbolicName(), "itmo.jph.hotwords.service.".concat(source))) {
                        GetHotWordsService service = (GetHotWordsService) bundleContext.getService(ref);
                        service.getHotWords();
                        return;
                    }
                }
            }
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("Service can not be used ,Please change another one");
    }
}
