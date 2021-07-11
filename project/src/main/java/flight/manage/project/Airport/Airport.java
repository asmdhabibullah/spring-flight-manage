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


// Entity is a table of the database 
@Entity(name = "Airport")
@Table
public class Airport {

    // Auto genarate ID
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

    // Relationship with runway table
    @JsonIgnore
    @OneToMany(mappedBy = "airport")
    private Set<Runway> runways = new HashSet<>();

    // Empty constructore
    public Airport() {
    }
    
    // Constructore with member variable
    public Airport(String name) {
        this.name = name;
    }

    // Getter & Setter method of the local variable
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
}
