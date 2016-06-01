package pl.edu.agh.prediction;

import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;
import pl.edu.agh.model.GravityEntity;
import pl.edu.agh.model.LocationsEntity;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by Ace on 10.05.2016.
 */
@Component
public class Calculator {
    public Point predict(GravityEntity gravityEntity, LocationsEntity locationsEntity, int seconds) {
        double speed = locationsEntity.getDoubleSpeed(); //m/2
        if (speed == 0) {
            System.out.println("WARNING SPEED = 0");
        }
        double distanceTravelled = speed * seconds; //meters

        double azimut = gravityEntity.getDoubleValues0();
        double yOffset = sin(azimut) * distanceTravelled;
        double xOffset = cos(azimut) * distanceTravelled;

        //Earth’s radius, sphere
        double R = 6378137;
        double latitude = locationsEntity.getDoubleLatitude();
        double longtitude = locationsEntity.getDoubleLongitude();

        double dLat = yOffset / R;
        double dLon = xOffset / (R * cos(Math.PI * latitude / 180));

        double latO = latitude + dLat * 180 / Math.PI;
        double lonO = longtitude + dLon * 180 / Math.PI;

        return new Point(latO, lonO);
    }
}
