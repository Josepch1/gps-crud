package josehomenhuck.gps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import josehomenhuck.gps.entity.PointOfInterest;

public interface PointOfInterestRepository extends JpaRepository<PointOfInterest, Long> {
    List<PointOfInterest> findByName(String name);
}
