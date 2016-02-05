package example;

import example.resources.ExampleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "Example";
    }

    @Override
    public void initialize(final Bootstrap<ExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ExampleConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(MultiPartFeature.class);
        environment.jersey().register(new ExampleResource());
    }

}
