package pl.edu.agh.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Ace on 06.04.2016.
 */
@Entity
@Table(name = "accelerometer", schema = "Wawro_667")
public class AccelerometerEntity {
    private Integer id;
    private Double timestamp;
    private String deviceId;
    private Double doubleValues0;
    private Double doubleValues1;
    private Double doubleValues2;
    private Integer accuracy;
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
    @Column(name = "double_values_0")
    public Double getDoubleValues0() {
        return doubleValues0;
    }

    public void setDoubleValues0(Double doubleValues0) {
        this.doubleValues0 = doubleValues0;
    }

    @Basic
    @Column(name = "double_values_1")
    public Double getDoubleValues1() {
        return doubleValues1;
    }

    public void setDoubleValues1(Double doubleValues1) {
        this.doubleValues1 = doubleValues1;
    }

    @Basic
    @Column(name = "double_values_2")
    public Double getDoubleValues2() {
        return doubleValues2;
    }

    public void setDoubleValues2(Double doubleValues2) {
        this.doubleValues2 = doubleValues2;
    }

    @Basic
    @Column(name = "accuracy")
    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    @Basic
    @Type(type="text")
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

        AccelerometerEntity that = (AccelerometerEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (doubleValues0 != null ? !doubleValues0.equals(that.doubleValues0) : that.doubleValues0 != null)
            return false;
        if (doubleValues1 != null ? !doubleValues1.equals(that.doubleValues1) : that.doubleValues1 != null)
            return false;
        if (doubleValues2 != null ? !doubleValues2.equals(that.doubleValues2) : that.doubleValues2 != null)
            return false;
        if (accuracy != null ? !accuracy.equals(that.accuracy) : that.accuracy != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (doubleValues0 != null ? doubleValues0.hashCode() : 0);
        result = 31 * result + (doubleValues1 != null ? doubleValues1.hashCode() : 0);
        result = 31 * result + (doubleValues2 != null ? doubleValues2.hashCode() : 0);
        result = 31 * result + (accuracy != null ? accuracy.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }
}
