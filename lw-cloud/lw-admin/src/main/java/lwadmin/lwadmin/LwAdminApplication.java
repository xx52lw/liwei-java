package lwadmin.lwadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class LwAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LwAdminApplication.class, args);
    }

}
