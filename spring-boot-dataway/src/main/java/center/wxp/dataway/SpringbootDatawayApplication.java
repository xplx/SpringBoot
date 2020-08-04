package center.wxp.dataway;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wxp
 */
@EnableHasor
@EnableHasorWeb
@SpringBootApplication(scanBasePackages = {"center.wxp.dataway"})
public class SpringbootDatawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatawayApplication.class, args);
    }
}
