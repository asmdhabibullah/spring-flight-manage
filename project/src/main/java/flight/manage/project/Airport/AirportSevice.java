package flight.manage.project.Airport;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Dependency injection for help the controller of airport
@Service
public class AirportSevice {
    
    private final AirportRepository airportRepository;

    // Dependency injection
    @Autowired
    public AirportSevice(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    // Get all airports from database airport table
    public List<Airport> getAirports() {
        return airportRepository.findAll();
    }

    // Create new airport
    public void addNewAirport(Airport airport) {
        Optional<Airport> airOptional = airportRepository.findAirportByName(airport.getName());
        if (airOptional.isPresent()) {
            throw new IllegalStateException("Name already exist");
        }

        // System.out.println(airport.getName());
        airportRepository.save(airport);
    }
    // Update existing airport
    @Transactional
    public void updateAirport(Long airportId, String name) {
        Airport airport = airportRepository.findById(airportId)
            .orElseThrow(() -> new IllegalStateException(
                "This airport id " + airportId + " dosen't exist.")
                );
        if (name != null) {
            airport.setName(name);
        }
    }

    // Delete existing airport use airport id
    public void deleteAirportById(Long airportId) {
        boolean exist = airportRepository.existsById(airportId);
        if (!exist) {
            throw new IllegalStateException("This airport id " + airportId + " dosen't exist.");
        }
        airportRepository.deleteById(airportId);
    }
}
