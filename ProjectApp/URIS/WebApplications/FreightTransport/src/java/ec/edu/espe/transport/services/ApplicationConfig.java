/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transport.services;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("project")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.transport.services.CarrierResource.class);
        resources.add(ec.edu.espe.transport.services.ClientResource.class);
        resources.add(ec.edu.espe.transport.services.CustomerResource.class);
        resources.add(ec.edu.espe.transport.services.GuideResource.class);
        resources.add(ec.edu.espe.transport.services.ProductResource.class);
        resources.add(ec.edu.espe.transport.services.ZoneResource.class);
    }

}
