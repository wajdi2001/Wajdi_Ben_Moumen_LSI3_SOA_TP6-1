import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import web.CompteRestJaxRESAPI1;

@Configuration
public class Myconfig {
    @Bean
    public ResourceConfig resourceConfig()
    {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRESAPI1.class);
        return jerseyServlet;
    }
}
