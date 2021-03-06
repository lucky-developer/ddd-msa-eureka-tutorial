package lucky.server.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = { // create beans and add to Spring container for DI
        "lucky.server.product",
        "lucky.server.common"
})
@EntityScan(basePackages = { // identifies which classes should be used by a Jpa persistence contenxt.
        "lucky.server.common"
})

@EnableJpaRepositories(basePackages = { // used to create repository classes from Spring Data interfaces.
        "lucky.server.common"
})
public class App {
    public static void main(String[] args) {
        System.setProperty("lucky.server.home", "/Users/hwanseok/lucky-developer");
        System.setProperty("logging.path", System.getProperty("lucky.server.home")+ File.separator + "logs");
        System.setProperty("logging.file", "product.log");
        SpringApplication.run(App.class, args);
    }
}