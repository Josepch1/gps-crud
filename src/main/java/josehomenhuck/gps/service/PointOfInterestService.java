package josehomenhuck.gps.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import josehomenhuck.gps.entity.PointOfInterest;
import josehomenhuck.gps.repository.PointOfInterestRepository;

@Service
public class PointOfInterestService {
  private final PointOfInterestRepository pointOfInterestRepository;

  public PointOfInterestService(PointOfInterestRepository pointOfInterestRepository) {
    this.pointOfInterestRepository = pointOfInterestRepository;
  }

  public PointOfInterest save(PointOfInterest pointOfInterest) {
    return pointOfInterestRepository.save(pointOfInterest);
  }

  public void delete(Long id) {
    pointOfInterestRepository.deleteById(id);
  }

  public Page<PointOfInterest> findAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return pointOfInterestRepository.findAll(pageable);
  }

  public PointOfInterest findById(Long id) {
    return pointOfInterestRepository.findById(id).orElse(null);
  }

  public void update(PointOfInterest pointOfInterest) {
    pointOfInterestRepository.save(pointOfInterest);
  }

  public void deleteAll() {
    pointOfInterestRepository.deleteAll();
  }

  public List<PointOfInterest> findByName(String name) {
    return pointOfInterestRepository.findByName(name);
  }

  public List<PointOfInterest> findByDistance(Long x, Long y, Long distance) {
    List<PointOfInterest> allPoints = pointOfInterestRepository.findAll();

    return allPoints.stream()
        .filter(point -> calculateDistance(x, y, point.getX(), point.getY()) <= distance)
        .collect(Collectors.toList());
  }

  public double calculateDistance(Long x1, Long y1, Long x2, Long y2) {
    return Math.sqrt(
        Math.pow(x2 - x1, 2) +
            Math.pow(y2 - y1, 2));
  }
}
