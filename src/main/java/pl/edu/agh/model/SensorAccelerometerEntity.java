package pl.edu.agh.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Ace on 06.04.2016.
 */
@Entity
@Table(name = "sensor_accelerometer", schema = "Wawro_667", catalog = "")
public class SensorAccelerometerEntity {
    private Integer id;
    private Double timestamp;
    private String deviceId;
    private Double doubleSensorMaximumRange;
    private Double doubleSensorMinimumDelay;
    private String sensorName;
    private Double doubleSensorPowerMa;
    private Double doubleSensorResolution;
    private String sensorType;
    private String sensorVendor;
    private String sensorVersion;

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
    @Column(name = "double_sensor_maximum_range")
    public Double getDoubleSensorMaximumRange() {
        return doubleSensorMaximumRange;
    }

    public void setDoubleSensorMaximumRange(Double doubleSensorMaximumRange) {
        this.doubleSensorMaximumRange = doubleSensorMaximumRange;
    }

    @Basic
    @Column(name = "double_sensor_minimum_delay")
    public Double getDoubleSensorMinimumDelay() {
        return doubleSensorMinimumDelay;
    }

    public void setDoubleSensorMinimumDelay(Double doubleSensorMinimumDelay) {
        this.doubleSensorMinimumDelay = doubleSensorMinimumDelay;
    }

    @Basic
    @Type(type="text")
    @Column(name = "sensor_name")
    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    @Basic
    @Column(name = "double_sensor_power_ma")
    public Double getDoubleSensorPowerMa() {
        return doubleSensorPowerMa;
    }

    public void setDoubleSensorPowerMa(Double doubleSensorPowerMa) {
        this.doubleSensorPowerMa = doubleSensorPowerMa;
    }

    @Basic
    @Column(name = "double_sensor_resolution")
    public Double getDoubleSensorResolution() {
        return doubleSensorResolution;
    }

    public void setDoubleSensorResolution(Double doubleSensorResolution) {
        this.doubleSensorResolution = doubleSensorResolution;
    }

    @Basic
    @Type(type="text")
    @Column(name = "sensor_type")
    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    @Basic
    @Type(type="text")
    @Column(name = "sensor_vendor")
    public String getSensorVendor() {
        return sensorVendor;
    }

    public void setSensorVendor(String sensorVendor) {
        this.sensorVendor = sensorVendor;
    }

    @Basic
    @Type(type="text")
    @Column(name = "sensor_version")
    public String getSensorVersion() {
        return sensorVersion;
    }

    public void setSensorVersion(String sensorVersion) {
        this.sensorVersion = sensorVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SensorAccelerometerEntity that = (SensorAccelerometerEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (doubleSensorMaximumRange != null ? !doubleSensorMaximumRange.equals(that.doubleSensorMaximumRange) : that.doubleSensorMaximumRange != null)
            return false;
        if (doubleSensorMinimumDelay != null ? !doubleSensorMinimumDelay.equals(that.doubleSensorMinimumDelay) : that.doubleSensorMinimumDelay != null)
            return false;
        if (sensorName != null ? !sensorName.equals(that.sensorName) : that.sensorName != null) return false;
        if (doubleSensorPowerMa != null ? !doubleSensorPowerMa.equals(that.doubleSensorPowerMa) : that.doubleSensorPowerMa != null)
            return false;
        if (doubleSensorResolution != null ? !doubleSensorResolution.equals(that.doubleSensorResolution) : that.doubleSensorResolution != null)
            return false;
        if (sensorType != null ? !sensorType.equals(that.sensorType) : that.sensorType != null) return false;
        if (sensorVendor != null ? !sensorVendor.equals(that.sensorVendor) : that.sensorVendor != null) return false;
        if (sensorVersion != null ? !sensorVersion.equals(that.sensorVersion) : that.sensorVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (doubleSensorMaximumRange != null ? doubleSensorMaximumRange.hashCode() : 0);
        result = 31 * result + (doubleSensorMinimumDelay != null ? doubleSensorMinimumDelay.hashCode() : 0);
        result = 31 * result + (sensorName != null ? sensorName.hashCode() : 0);
        result = 31 * result + (doubleSensorPowerMa != null ? doubleSensorPowerMa.hashCode() : 0);
        result = 31 * result + (doubleSensorResolution != null ? doubleSensorResolution.hashCode() : 0);
        result = 31 * result + (sensorType != null ? sensorType.hashCode() : 0);
        result = 31 * result + (sensorVendor != null ? sensorVendor.hashCode() : 0);
        result = 31 * result + (sensorVersion != null ? sensorVersion.hashCode() : 0);
        return result;
    }
}
