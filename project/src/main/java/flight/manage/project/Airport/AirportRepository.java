package flight.manage.project.Airport;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AirportRepository extends JpaRepository<Airport, Long>{

    @Query("SELECT air FROM Airport air WHERE air.name = ?1")
    Optional<Airport> findAirportByName(String name);
}
