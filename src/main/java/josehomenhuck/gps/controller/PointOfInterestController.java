package josehomenhuck.gps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import josehomenhuck.gps.controller.dto.CreatePointOfInterest;
import josehomenhuck.gps.entity.PointOfInterest;
import josehomenhuck.gps.service.PointOfInterestService;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/v1/gps")
public class PointOfInterestController {
  private final PointOfInterestService pointOfInterestService;

  public PointOfInterestController(PointOfInterestService pointOfInterestService) {
    this.pointOfInterestService = pointOfInterestService;
  }

  @GetMapping
  public ResponseEntity<Page<PointOfInterest>> findAll(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int pageSize)
  {
    Page<PointOfInterest> result = pointOfInterestService.findAll(page, pageSize);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PointOfInterest> findById(@PathVariable Long id) {
    PointOfInterest poi = pointOfInterestService.findById(id);
    if (poi == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(poi);
  }

  @GetMapping("/name/{name}")
  public List<PointOfInterest> findByName(@PathVariable String name) {
    return pointOfInterestService.findByName(name);
  }

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody CreatePointOfInterest poi) {
    try {
      PointOfInterest newPOI = new PointOfInterest(poi.name(), poi.x(), poi.y());

      pointOfInterestService.save(newPOI);

      return ResponseEntity
              .created(URI.create("/v1/gps/" + newPOI.getId()))
              .body(newPOI);
    } catch(Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    try {
      pointOfInterestService.delete(id);
      return ResponseEntity.ok().build();
    } catch(Exception e) {
      return ResponseEntity.badRequest().build();
    }

  }

  @GetMapping("/distance")
  public ResponseEntity<List<PointOfInterest>> findByDistance(
            @RequestParam Long x, 
            @RequestParam Long y, 
            @RequestParam Long distance) {
        
        if (x == null || y == null || distance == null) {
            return ResponseEntity.badRequest().build();
        }

        if (distance <= 0) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        List<PointOfInterest> nearbyPoints = pointOfInterestService.findByDistance(x, y, distance);
        
        if (nearbyPoints.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(nearbyPoints);
    }
}
