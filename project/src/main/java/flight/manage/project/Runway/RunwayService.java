package flight.manage.project.Runway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flight.manage.project.Airport.Airport;
import flight.manage.project.Airport.AirportRepository;

@Service
public class RunwayService {
    
    private final RunwayReposetory runwayReposetory;
    private final AirportRepository airportRepository;

    @Autowired
    public RunwayService(RunwayReposetory runwayReposetory, AirportRepository airportRepository) {
        this.runwayReposetory = runwayReposetory;
        this.airportRepository = airportRepository;
    }
   

    public List<Runway> getAllRunway() {
        return runwayReposetory.findAll();
    }

    public void addNewRunway(Runway runway) {
        // boolean exist = airportRepository.existsById(airportId);
        // if (exist) {
            // }
            runwayReposetory.save(runway);
    }

    Runway updateAirportAndRunway(Long airportI, Long runwayId) {
        Runway runway = runwayReposetory.findById(runwayId).get();
        Airport airport = airportRepository.findById(airportI).get();
        runway.setAirport(airport);
        return runwayReposetory.save(runway);
    }

}
