package br.com.astromonitor.astromonitor.resources.service.api.config;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("br.com.astromonitor.astromonitor.resources.service.api");
        register(WebConfig.class);
    }
}
