package pl.edu.agh.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Ace on 06.04.2016.
 */
@Entity
@Table(name = "battery", schema = "Wawro_667", catalog = "")
public class BatteryEntity {
    private Integer id;
    private Double timestamp;
    private String deviceId;
    private Integer batteryStatus;
    private Integer batteryLevel;
    private Integer batteryScale;
    private Integer batteryVoltage;
    private Integer batteryTemperature;
    private Integer batteryAdaptor;
    private Integer batteryHealth;
    private String batteryTechnology;

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
    @Column(name = "battery_status")
    public Integer getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(Integer batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

    @Basic
    @Column(name = "battery_level")
    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Basic
    @Column(name = "battery_scale")
    public Integer getBatteryScale() {
        return batteryScale;
    }

    public void setBatteryScale(Integer batteryScale) {
        this.batteryScale = batteryScale;
    }

    @Basic
    @Column(name = "battery_voltage")
    public Integer getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Integer batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    @Basic
    @Column(name = "battery_temperature")
    public Integer getBatteryTemperature() {
        return batteryTemperature;
    }

    public void setBatteryTemperature(Integer batteryTemperature) {
        this.batteryTemperature = batteryTemperature;
    }

    @Basic
    @Column(name = "battery_adaptor")
    public Integer getBatteryAdaptor() {
        return batteryAdaptor;
    }

    public void setBatteryAdaptor(Integer batteryAdaptor) {
        this.batteryAdaptor = batteryAdaptor;
    }

    @Basic
    @Column(name = "battery_health")
    public Integer getBatteryHealth() {
        return batteryHealth;
    }

    public void setBatteryHealth(Integer batteryHealth) {
        this.batteryHealth = batteryHealth;
    }

    @Basic
    @Type(type="text")
    @Column(name = "battery_technology")
    public String getBatteryTechnology() {
        return batteryTechnology;
    }

    public void setBatteryTechnology(String batteryTechnology) {
        this.batteryTechnology = batteryTechnology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatteryEntity that = (BatteryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (batteryStatus != null ? !batteryStatus.equals(that.batteryStatus) : that.batteryStatus != null)
            return false;
        if (batteryLevel != null ? !batteryLevel.equals(that.batteryLevel) : that.batteryLevel != null) return false;
        if (batteryScale != null ? !batteryScale.equals(that.batteryScale) : that.batteryScale != null) return false;
        if (batteryVoltage != null ? !batteryVoltage.equals(that.batteryVoltage) : that.batteryVoltage != null)
            return false;
        if (batteryTemperature != null ? !batteryTemperature.equals(that.batteryTemperature) : that.batteryTemperature != null)
            return false;
        if (batteryAdaptor != null ? !batteryAdaptor.equals(that.batteryAdaptor) : that.batteryAdaptor != null)
            return false;
        if (batteryHealth != null ? !batteryHealth.equals(that.batteryHealth) : that.batteryHealth != null)
            return false;
        if (batteryTechnology != null ? !batteryTechnology.equals(that.batteryTechnology) : that.batteryTechnology != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (batteryStatus != null ? batteryStatus.hashCode() : 0);
        result = 31 * result + (batteryLevel != null ? batteryLevel.hashCode() : 0);
        result = 31 * result + (batteryScale != null ? batteryScale.hashCode() : 0);
        result = 31 * result + (batteryVoltage != null ? batteryVoltage.hashCode() : 0);
        result = 31 * result + (batteryTemperature != null ? batteryTemperature.hashCode() : 0);
        result = 31 * result + (batteryAdaptor != null ? batteryAdaptor.hashCode() : 0);
        result = 31 * result + (batteryHealth != null ? batteryHealth.hashCode() : 0);
        result = 31 * result + (batteryTechnology != null ? batteryTechnology.hashCode() : 0);
        return result;
    }
}
