package flight.manage.project.Runway;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import flight.manage.project.Airport.Airport;
import flight.manage.project.Surface.Surface;


@Entity(name = "Runway")
@Table()
public class Runway {
    
    @Id
    @SequenceGenerator(
        name = "runway_sequence", 
        sequenceName = "runway_sequence", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "runway_sequence"
    )
    private Long id;

    private double width;
    private double length;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airport_id", referencedColumnName = "id")
    private Airport airport;

    @JsonIgnore
    @OneToMany(mappedBy = "runway")
    private Set<Surface> surface = new HashSet<>();

    public Runway() {
    }

    public Runway(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Airport getAirport() {
        return this.airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
    

    public Set<Surface> getSurface() {
        return this.surface;
    }

    public void setSurface(Set<Surface> surface) {
        this.surface = surface;
    }

}