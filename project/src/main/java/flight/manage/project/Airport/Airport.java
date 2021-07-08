package flight.manage.project.Airport;

import java.util.HashSet;
// import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import flight.manage.project.Runway.Runway;

@Entity(name = "Airport")
@Table
public class Airport {

    @Id
    @SequenceGenerator(
        name = "airport_sequence",
        sequenceName = "airport_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "airport_sequence"
    )
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "airport")
    private Set<Runway> runways = new HashSet<>();

    public Airport() {
    }
    
    public Airport(String name) {
        this.name = name;
    }

    public Airport(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Runway> getRunways() {
        return this.runways;
    }

    // public List<Runway> getRunways() {
    //     return this.runways;
    // }

    // public void setRunways(List<Runway> runways) {
    //     this.runways = runways;
    // }
}
