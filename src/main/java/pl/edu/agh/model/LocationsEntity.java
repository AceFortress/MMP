package pl.edu.agh.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Ace on 06.04.2016.
 */
@Entity
@Table(name = "locations", schema = "Wawro_667", catalog = "")
public class LocationsEntity {
    private Integer id;
    private Double timestamp;
    private String deviceId;
    private Double doubleLatitude;
    private Double doubleLongitude;
    private Double doubleBearing;
    private Double doubleSpeed;
    private Double doubleAltitude;
    private String provider;
    private Double accuracy;
    private String label;

    @Id
    @Column(name = "_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "timestamp")
    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "double_latitude")
    public Double getDoubleLatitude() {
        return doubleLatitude;
    }

    public void setDoubleLatitude(Double doubleLatitude) {
        this.doubleLatitude = doubleLatitude;
    }

    @Basic
    @Column(name = "double_longitude")
    public Double getDoubleLongitude() {
        return doubleLongitude;
    }

    public void setDoubleLongitude(Double doubleLongitude) {
        this.doubleLongitude = doubleLongitude;
    }

    @Basic
    @Column(name = "double_bearing")
    public Double getDoubleBearing() {
        return doubleBearing;
    }

    public void setDoubleBearing(Double doubleBearing) {
        this.doubleBearing = doubleBearing;
    }

    @Basic
    @Column(name = "double_speed")
    public Double getDoubleSpeed() {
        return doubleSpeed;
    }

    public void setDoubleSpeed(Double doubleSpeed) {
        this.doubleSpeed = doubleSpeed;
    }

    @Basic
    @Column(name = "double_altitude")
    public Double getDoubleAltitude() {
        return doubleAltitude;
    }

    public void setDoubleAltitude(Double doubleAltitude) {
        this.doubleAltitude = doubleAltitude;
    }

    @Basic
    @Type(type = "text")
    @Column(name = "provider")
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Basic
    @Column(name = "accuracy")
    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    @Basic
    @Type(type = "text")
    @Column(name = "label")
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationsEntity that = (LocationsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (doubleLatitude != null ? !doubleLatitude.equals(that.doubleLatitude) : that.doubleLatitude != null)
            return false;
        if (doubleLongitude != null ? !doubleLongitude.equals(that.doubleLongitude) : that.doubleLongitude != null)
            return false;
        if (doubleBearing != null ? !doubleBearing.equals(that.doubleBearing) : that.doubleBearing != null)
            return false;
        if (doubleSpeed != null ? !doubleSpeed.equals(that.doubleSpeed) : that.doubleSpeed != null) return false;
        if (doubleAltitude != null ? !doubleAltitude.equals(that.doubleAltitude) : that.doubleAltitude != null)
            return false;
        if (provider != null ? !provider.equals(that.provider) : that.provider != null) return false;
        if (accuracy != null ? !accuracy.equals(that.accuracy) : that.accuracy != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (doubleLatitude != null ? doubleLatitude.hashCode() : 0);
        result = 31 * result + (doubleLongitude != null ? doubleLongitude.hashCode() : 0);
        result = 31 * result + (doubleBearing != null ? doubleBearing.hashCode() : 0);
        result = 31 * result + (doubleSpeed != null ? doubleSpeed.hashCode() : 0);
        result = 31 * result + (doubleAltitude != null ? doubleAltitude.hashCode() : 0);
        result = 31 * result + (provider != null ? provider.hashCode() : 0);
        result = 31 * result + (accuracy != null ? accuracy.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }
}
