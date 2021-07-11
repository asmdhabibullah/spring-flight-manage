package flight.manage.project.Surface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flight.manage.project.Runway.Runway;
import flight.manage.project.Runway.RunwayReposetory;

// Dependency provider
@Service
public class SurfaceService {
    
    private final SurfaceReposetory surfaceReposetory;
    private final RunwayReposetory runwayReposetory;

    // Dependency inject
    @Autowired
    public SurfaceService(SurfaceReposetory surfaceReposetory, RunwayReposetory runwayReposetory) {
        this.surfaceReposetory = surfaceReposetory;
        this.runwayReposetory = runwayReposetory;
    }

    // Get all the surface from surface table
    public List<Surface> getAllSurface() {
        return surfaceReposetory.findAll();
    }

    // Create new surface
    public void addNewSu8rface(Surface surface) {
        surfaceReposetory.save(surface);
    }

    // Update existing surface and join with runway
    Surface putRunAndSurf(Long surfaceId, Long runwayId) {
        Runway runway = runwayReposetory.findById(runwayId).get();
        Surface surface = surfaceReposetory.findById(surfaceId).get();
        surface.setRunway(runway);
        return surfaceReposetory.save(surface);
    }

}
