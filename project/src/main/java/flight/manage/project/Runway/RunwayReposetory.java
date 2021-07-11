package flight.manage.project.Runway;

import org.springframework.data.jpa.repository.JpaRepository;

// This inserface help to query runway table
public interface RunwayReposetory extends JpaRepository<Runway, Long> {
    
}
