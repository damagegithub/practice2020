package itmo.jph.hello.ClientSCR;

import itmo.jph.hello.serviceSCR.SayHelloServiceSCR;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class SayHelloSCR {
    @Reference(bind = "bind", unbind = "unbind")
    public void bind(SayHelloServiceSCR service) {
        System.out.println("start...");
        service.hello();
    }

    public void unbind(SayHelloServiceSCR service) {
        System.out.println("end...");

    }
}
