package com.hzzz.application;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class DropWizardApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new DropWizardApplication().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new QueryCommodities());
        environment.jersey().register(new QueryCategories());
        environment.jersey().register(new ListAllCategories());
    }

    @Override
    public String getName() {
        return "configuration";
    }
}
