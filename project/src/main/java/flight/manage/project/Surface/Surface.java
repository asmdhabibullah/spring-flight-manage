package flight.manage.project.Surface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import flight.manage.project.Runway.Runway;

// Entity is a table of the database 
@Entity(name = "Surface")
@Table()
public class Surface {

    // Auto genarate ID
    @Id
    @SequenceGenerator(
        name = "surface_sequence", 
        sequenceName = "surface_sequence", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "surface_sequence"
    )
    private Long id;

    private String type;
    private String condition;

    // Relationship with runway table
    @ManyToOne
    @JoinColumn(name = "runway_id", referencedColumnName = "id")
    private Runway runway;

    // Empty constructore
    public Surface() {
    }

    // Constructore with member variable
    public Surface(String type, String condition) {
        this.type = type;
        this.condition = condition;
    }


    // Getter & Setter method of the local variable
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


    public Runway getRunway() {
        return this.runway;
    }

    public void setRunway(Runway runway) {
        this.runway = runway;
    }

}
