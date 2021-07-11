package flight.manage.project.Runway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Hadle all user requet for runway endpoints
@RestController
@RequestMapping(path = "api/v1/runways")
public class RunwayController {

    private final RunwayService runwayService;
    // Dependency inject to spring
    @Autowired
    public RunwayController(RunwayService runwayService) {
        this.runwayService = runwayService;
    }

    // This endpoint will be help to get all runway with related surface
    @GetMapping
    public List<Runway> getRunways() {
        return runwayService.getAllRunway();
    }

    // New runway
    @PostMapping
    public void postRunway(@RequestBody Runway runway){
        runwayService.addNewRunway(runway);
    }

    // Update exist runway and airport
    @PutMapping("/{airportId}/{runwayId}")
    public void putAirportAndRunway(
            @PathVariable("airportId") Long airportI, 
            @PathVariable("runwayId") Long runwayId
    ) {
        runwayService.updateAirportAndRunway(airportI, runwayId);
    }
}
