package flight.manage.project.Surface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// All user request handle for surface
@RestController
@RequestMapping(path = "api/v1/surfaces")
public class RurfaceController {
    
    private final SurfaceService surfaceService;

    // Dependency inject
    @Autowired
    public RurfaceController(SurfaceService surfaceService) {
        this.surfaceService = surfaceService;
    }

    // Get all the surface from surface table
    @GetMapping
    public List<Surface> getSurfaces() {
        return surfaceService.getAllSurface();
    }

    // Create new surface
    @PostMapping
    public void postSurface(@RequestBody Surface surface) {
        surfaceService.addNewSu8rface(surface);
    }

    // Update existing surface and  join with runway
    @PutMapping("/{surfaceId}/{runwayId}")
    public void updateRunwayAndSurface(@PathVariable Long surfaceId, @PathVariable Long runwayId ) {
        surfaceService.putRunAndSurf(surfaceId, runwayId);
    }

}
