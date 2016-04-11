package pl.edu.agh.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Radek on 11.04.2016.
 */
public interface LocationsRepo extends JpaRepository<LocationsEntity, Long> {
}
