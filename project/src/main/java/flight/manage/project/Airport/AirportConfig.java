package flight.manage.project.Airport;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import flight.manage.project.Runway.Runway;

@Configuration
public class AirportConfig {

    @Bean
    CommandLineRunner commandLineRunner(AirportRepository repository) {
        return args -> {
            Airport dk = new Airport("DAC - Hazrat Shahjalal International Airport");
            Airport km = new Airport("KMG - Kunming Changshui International Airport");
            Airport hk = new Airport("HKG - Hong Kong International Airport");
            Airport bj = new Airport("PEK - Beijing Capital International Airport");
            Airport sh = new Airport("PVG - Shanghai Pudong International Airport");

            // Runway run1dk = new Runway(4522512, 452542354);
            // Runway run2dk = new Runway(45235356, 4577852);
            // Runway run3dk = new Runway(4532453, 52345344);

            // Runway run1km = new Runway(565, 36563);
            // Runway run2km = new Runway(5634536, 453645);
            // Runway run3km = new Runway(4678, 78567856);

            // Runway run1hk = new Runway(7857, 7856785);
            // Runway run2hk = new Runway(75678, 785678);
            // Runway run3hk = new Runway(785678, 785678);

            // dk.getRunways().add(run1dk);
            // dk.getRunways().add(run2dk);
            // dk.getRunways().add(run3dk);

            // dk.getRunways().add(run1km);
            // dk.getRunways().add(run2km);
            // dk.getRunways().add(run3km);

            // dk.getRunways().add(run1hk);
            // dk.getRunways().add(run2hk);
            // dk.getRunways().add(run3hk);
   
            repository.saveAll(
               List.of(dk, km, hk, bj, sh)
            );
        };
    }
}
