package pl.edu.agh.model;

import javax.persistence.*;

/**
 * Created by Ace on 06.04.2016.
 */
@Entity
@Table(name = "battery_charges")
public class BatteryChargesEntity {
    private Integer id;
    private Double timestamp;
    private String deviceId;
    private Integer batteryStart;
    private Integer batteryEnd;
    private Double doubleEndTimestamp;

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
    @Column(name = "battery_start")
    public Integer getBatteryStart() {
        return batteryStart;
    }

    public void setBatteryStart(Integer batteryStart) {
        this.batteryStart = batteryStart;
    }

    @Basic
    @Column(name = "battery_end")
    public Integer getBatteryEnd() {
        return batteryEnd;
    }

    public void setBatteryEnd(Integer batteryEnd) {
        this.batteryEnd = batteryEnd;
    }

    @Basic
    @Column(name = "double_end_timestamp")
    public Double getDoubleEndTimestamp() {
        return doubleEndTimestamp;
    }

    public void setDoubleEndTimestamp(Double doubleEndTimestamp) {
        this.doubleEndTimestamp = doubleEndTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BatteryChargesEntity that = (BatteryChargesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (batteryStart != null ? !batteryStart.equals(that.batteryStart) : that.batteryStart != null) return false;
        if (batteryEnd != null ? !batteryEnd.equals(that.batteryEnd) : that.batteryEnd != null) return false;
        if (doubleEndTimestamp != null ? !doubleEndTimestamp.equals(that.doubleEndTimestamp) : that.doubleEndTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (batteryStart != null ? batteryStart.hashCode() : 0);
        result = 31 * result + (batteryEnd != null ? batteryEnd.hashCode() : 0);
        result = 31 * result + (doubleEndTimestamp != null ? doubleEndTimestamp.hashCode() : 0);
        return result;
    }
}
