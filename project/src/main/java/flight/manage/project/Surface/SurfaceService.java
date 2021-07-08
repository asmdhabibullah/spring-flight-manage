package flight.manage.project.Surface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flight.manage.project.Runway.Runway;
import flight.manage.project.Runway.RunwayReposetory;

@Service
public class SurfaceService {
    
    private final SurfaceReposetory surfaceReposetory;
    private final RunwayReposetory runwayReposetory;

    @Autowired
    public SurfaceService(SurfaceReposetory surfaceReposetory, RunwayReposetory runwayReposetory) {
        this.surfaceReposetory = surfaceReposetory;
        this.runwayReposetory = runwayReposetory;
    }


    public List<Surface> getAllSurface() {
        return surfaceReposetory.findAll();
    }

    public void addNewSu8rface(Surface surface) {
        surfaceReposetory.save(surface);
    }

    Surface putRunAndSurf(Long surfaceId, Long runwayId) {
        Runway runway = runwayReposetory.findById(runwayId).get();
        Surface surface = surfaceReposetory.findById(surfaceId).get();
        surface.setRunway(runway);
        return surfaceReposetory.save(surface);
    }

}
