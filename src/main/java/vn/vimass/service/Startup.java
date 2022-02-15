package vn.vimass.service;

import vn.vimass.service.mayTram.ServiceWebService2;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/services")
public class Startup extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> result = new HashSet<>();

        result.add(ServiceWebService2.class);

        return result;
    }
}
