import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("api")
public class LibraryApplication extends ResourceConfig {
    public LibraryApplication() {
        packages("api");
    }
}