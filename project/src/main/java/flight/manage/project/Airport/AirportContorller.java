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

@RestController
@RequestMapping(path = "api/v1/airports")
public class AirportContorller {

    private final AirportSevice airportService;

    @Autowired
    public AirportContorller(AirportSevice airportService) {
        this.airportService = airportService;
    }

    
    @GetMapping
    public List<Airport> getAirports() {
        return airportService.getAirports();
    }

    @PostMapping
    public void postAirport(@RequestBody Airport airport) {
        // System.out.println("It's new airport: " + airport);
        airportService.addNewAirport(airport);
    }

    @PutMapping(path = "{airportId}")
    public void updateAirportById(
        @PathVariable("airportId") Long airportId,
        @RequestParam(required = false) String name
    ) {
        airportService.updateAirport(airportId, name);
    }

    @DeleteMapping(path = "{airportId}")
    public void deleteAirport(@PathVariable("airportId") Long airportId) {
        airportService.deleteAirportById(airportId);
    }
}
