package pl.edu.agh.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ace on 10.05.2016.
 */
public interface GravityRepo extends JpaRepository<GravityEntity, Long> {
    GravityEntity findNear();
}
