package flight.manage.project.Airport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Handle user request for airport database table
@RestController
@RequestMapping(path = "api/v1/airports")
public class AirportContorller {

    private final AirportSevice airportService;

    // Dependency injection
    @Autowired
    public AirportContorller(AirportSevice airportService) {
        this.airportService = airportService;
    }

    
    // Get all airports from database airport table
    @GetMapping
    public List<Airport> getAirports() {
        return airportService.getAirports();
    }

    // Create new airport
    @PostMapping
    public void postAirport(@RequestBody Airport airport) {
        // System.out.println("It's new airport: " + airport);
        airportService.addNewAirport(airport);
    }

    // Update existing airport
    @PutMapping(path = "{airportId}")
    public void updateAirportById(
        @PathVariable("airportId") Long airportId,
        @RequestParam(required = false) String name
    ) {
        airportService.updateAirport(airportId, name);
    }

    // Delete existing airport use airport id
    @DeleteMapping(path = "{airportId}")
    public void deleteAirport(@PathVariable("airportId") Long airportId) {
        airportService.deleteAirportById(airportId);
    }
}
