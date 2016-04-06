package pl.edu.agh.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Ace on 06.04.2016.
 */
@Entity
@Table(name = "aware_device")
public class AwareDeviceEntity {
    private Integer id;
    private Double timestamp;
    private String deviceId;
    private String board;
    private String brand;
    private String device;
    private String buildId;
    private String hardware;
    private String manufacturer;
    private String model;
    private String product;
    private String serial;
    private String release;
    private String releaseType;
    private Integer sdk;
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
    @Type(type="text")
    @Column(name = "board")
    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    @Basic
    @Type(type="text")
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Type(type="text")
    @Column(name = "device")
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Basic
    @Type(type="text")
    @Column(name = "build_id")
    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

    @Basic
    @Type(type="text")
    @Column(name = "hardware")
    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    @Basic
    @Type(type="text")
    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Type(type="text")
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Type(type="text")
    @Column(name = "product")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Type(type="text")
    @Column(name = "serial")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Type(type="text")
    @Column(name = "release")
    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @Basic
    @Type(type="text")
    @Column(name = "release_type")
    public String getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    @Basic
    @Column(name = "sdk")
    public Integer getSdk() {
        return sdk;
    }

    public void setSdk(Integer sdk) {
        this.sdk = sdk;
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

        AwareDeviceEntity that = (AwareDeviceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (board != null ? !board.equals(that.board) : that.board != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (buildId != null ? !buildId.equals(that.buildId) : that.buildId != null) return false;
        if (hardware != null ? !hardware.equals(that.hardware) : that.hardware != null) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (serial != null ? !serial.equals(that.serial) : that.serial != null) return false;
        if (release != null ? !release.equals(that.release) : that.release != null) return false;
        if (releaseType != null ? !releaseType.equals(that.releaseType) : that.releaseType != null) return false;
        if (sdk != null ? !sdk.equals(that.sdk) : that.sdk != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (board != null ? board.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (buildId != null ? buildId.hashCode() : 0);
        result = 31 * result + (hardware != null ? hardware.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (serial != null ? serial.hashCode() : 0);
        result = 31 * result + (release != null ? release.hashCode() : 0);
        result = 31 * result + (releaseType != null ? releaseType.hashCode() : 0);
        result = 31 * result + (sdk != null ? sdk.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }
}
