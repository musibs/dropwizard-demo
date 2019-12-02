package io.codefountain;

import io.codefountain.configuration.DefaultConfiguration;
import io.codefountain.resource.DefaultResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App extends Application<DefaultConfiguration> {
    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(DefaultConfiguration defaultConfiguration, Environment environment) throws Exception {
        final DefaultResource defaultResource = new DefaultResource(defaultConfiguration.getFirstName(), defaultConfiguration.getLastName());
        environment.jersey().register(defaultResource);
        environment.healthChecks().register("default", new DefaultHealthCheck());
    }
}
