package flight.manage.project.Airport;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// This is a interface to query of all airport tables data
public interface AirportRepository extends JpaRepository<Airport, Long>{

    // Custom query
    @Query("SELECT air FROM Airport air WHERE air.name = ?1")
    Optional<Airport> findAirportByName(String name);
}
