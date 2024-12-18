package josehomenhuck.gps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "point_of_interest")
public class PointOfInterest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(nullable = false)
  private Long x;

  @Column(nullable = false)
  private Long y;

  public PointOfInterest() {
  }

  public PointOfInterest(String name, Long x, Long y) {
    this.name = name;
    this.x = x;
    this.y = y;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getX() {
    return x;
  }

  public void setX(Long x) {
    this.x = x;
  }

  public Long getY() {
    return y;
  }

  public void setY(Long y) {
    this.y = y;
  }

}
