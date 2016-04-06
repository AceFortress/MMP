package pl.edu.agh.model;

import org.hibernate.annotations.Type;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Ace on 06.04.2016.
 */
@Entity
@javax.persistence.Table(name = "esms", schema = "Wawro_667", catalog = "")
public class EsmsEntity {
    private Integer id;

    @Id
    @javax.persistence.Column(name = "_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Double timestamp;

    @Basic
    @javax.persistence.Column(name = "timestamp")
    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    private String deviceId;

    @Basic
    @javax.persistence.Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    private Integer esmType;

    @Basic
    @javax.persistence.Column(name = "esm_type")
    public Integer getEsmType() {
        return esmType;
    }

    public void setEsmType(Integer esmType) {
        this.esmType = esmType;
    }

    private String esmTitle;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_title")
    public String getEsmTitle() {
        return esmTitle;
    }

    public void setEsmTitle(String esmTitle) {
        this.esmTitle = esmTitle;
    }

    private String esmSubmit;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_submit")
    public String getEsmSubmit() {
        return esmSubmit;
    }

    public void setEsmSubmit(String esmSubmit) {
        this.esmSubmit = esmSubmit;
    }

    private String esmInstructions;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_instructions")
    public String getEsmInstructions() {
        return esmInstructions;
    }

    public void setEsmInstructions(String esmInstructions) {
        this.esmInstructions = esmInstructions;
    }

    private String esmRadios;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_radios")
    public String getEsmRadios() {
        return esmRadios;
    }

    public void setEsmRadios(String esmRadios) {
        this.esmRadios = esmRadios;
    }

    private String esmCheckboxes;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_checkboxes")
    public String getEsmCheckboxes() {
        return esmCheckboxes;
    }

    public void setEsmCheckboxes(String esmCheckboxes) {
        this.esmCheckboxes = esmCheckboxes;
    }

    private Integer esmLikertMax;

    @Basic
    @javax.persistence.Column(name = "esm_likert_max")
    public Integer getEsmLikertMax() {
        return esmLikertMax;
    }

    public void setEsmLikertMax(Integer esmLikertMax) {
        this.esmLikertMax = esmLikertMax;
    }

    private String esmLikertMaxLabel;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_likert_max_label")
    public String getEsmLikertMaxLabel() {
        return esmLikertMaxLabel;
    }

    public void setEsmLikertMaxLabel(String esmLikertMaxLabel) {
        this.esmLikertMaxLabel = esmLikertMaxLabel;
    }

    private String esmLikertMinLabel;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_likert_min_label")
    public String getEsmLikertMinLabel() {
        return esmLikertMinLabel;
    }

    public void setEsmLikertMinLabel(String esmLikertMinLabel) {
        this.esmLikertMinLabel = esmLikertMinLabel;
    }

    private Double esmLikertStep;

    @Basic
    @javax.persistence.Column(name = "esm_likert_step")
    public Double getEsmLikertStep() {
        return esmLikertStep;
    }

    public void setEsmLikertStep(Double esmLikertStep) {
        this.esmLikertStep = esmLikertStep;
    }

    private String esmQuickAnswers;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_quick_answers")
    public String getEsmQuickAnswers() {
        return esmQuickAnswers;
    }

    public void setEsmQuickAnswers(String esmQuickAnswers) {
        this.esmQuickAnswers = esmQuickAnswers;
    }

    private Integer esmExpirationThreshold;

    @Basic
    @javax.persistence.Column(name = "esm_expiration_threshold")
    public Integer getEsmExpirationThreshold() {
        return esmExpirationThreshold;
    }

    public void setEsmExpirationThreshold(Integer esmExpirationThreshold) {
        this.esmExpirationThreshold = esmExpirationThreshold;
    }

    private Integer esmStatus;

    @Basic
    @javax.persistence.Column(name = "esm_status")
    public Integer getEsmStatus() {
        return esmStatus;
    }

    public void setEsmStatus(Integer esmStatus) {
        this.esmStatus = esmStatus;
    }

    private Double doubleEsmUserAnswerTimestamp;

    @Basic
    @javax.persistence.Column(name = "double_esm_user_answer_timestamp")
    public Double getDoubleEsmUserAnswerTimestamp() {
        return doubleEsmUserAnswerTimestamp;
    }

    public void setDoubleEsmUserAnswerTimestamp(Double doubleEsmUserAnswerTimestamp) {
        this.doubleEsmUserAnswerTimestamp = doubleEsmUserAnswerTimestamp;
    }

    private String esmUserAnswer;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_user_answer")
    public String getEsmUserAnswer() {
        return esmUserAnswer;
    }

    public void setEsmUserAnswer(String esmUserAnswer) {
        this.esmUserAnswer = esmUserAnswer;
    }

    private String esmTrigger;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_trigger")
    public String getEsmTrigger() {
        return esmTrigger;
    }

    public void setEsmTrigger(String esmTrigger) {
        this.esmTrigger = esmTrigger;
    }

    private Integer esmScaleMin;

    @Basic
    @javax.persistence.Column(name = "esm_scale_min")
    public Integer getEsmScaleMin() {
        return esmScaleMin;
    }

    public void setEsmScaleMin(Integer esmScaleMin) {
        this.esmScaleMin = esmScaleMin;
    }

    private Integer esmScaleMax;

    @Basic
    @javax.persistence.Column(name = "esm_scale_max")
    public Integer getEsmScaleMax() {
        return esmScaleMax;
    }

    public void setEsmScaleMax(Integer esmScaleMax) {
        this.esmScaleMax = esmScaleMax;
    }

    private Integer esmScaleStart;

    @Basic
    @javax.persistence.Column(name = "esm_scale_start")
    public Integer getEsmScaleStart() {
        return esmScaleStart;
    }

    public void setEsmScaleStart(Integer esmScaleStart) {
        this.esmScaleStart = esmScaleStart;
    }

    private String esmScaleMaxLabel;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_scale_max_label")
    public String getEsmScaleMaxLabel() {
        return esmScaleMaxLabel;
    }

    public void setEsmScaleMaxLabel(String esmScaleMaxLabel) {
        this.esmScaleMaxLabel = esmScaleMaxLabel;
    }

    private String esmScaleMinLabel;

    @Basic
    @Type(type = "text")
    @javax.persistence.Column(name = "esm_scale_min_label")
    public String getEsmScaleMinLabel() {
        return esmScaleMinLabel;
    }

    public void setEsmScaleMinLabel(String esmScaleMinLabel) {
        this.esmScaleMinLabel = esmScaleMinLabel;
    }

    private Integer esmScaleStep;

    @Basic
    @javax.persistence.Column(name = "esm_scale_step")
    public Integer getEsmScaleStep() {
        return esmScaleStep;
    }

    public void setEsmScaleStep(Integer esmScaleStep) {
        this.esmScaleStep = esmScaleStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EsmsEntity that = (EsmsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (esmType != null ? !esmType.equals(that.esmType) : that.esmType != null) return false;
        if (esmTitle != null ? !esmTitle.equals(that.esmTitle) : that.esmTitle != null) return false;
        if (esmSubmit != null ? !esmSubmit.equals(that.esmSubmit) : that.esmSubmit != null) return false;
        if (esmInstructions != null ? !esmInstructions.equals(that.esmInstructions) : that.esmInstructions != null)
            return false;
        if (esmRadios != null ? !esmRadios.equals(that.esmRadios) : that.esmRadios != null) return false;
        if (esmCheckboxes != null ? !esmCheckboxes.equals(that.esmCheckboxes) : that.esmCheckboxes != null)
            return false;
        if (esmLikertMax != null ? !esmLikertMax.equals(that.esmLikertMax) : that.esmLikertMax != null) return false;
        if (esmLikertMaxLabel != null ? !esmLikertMaxLabel.equals(that.esmLikertMaxLabel) : that.esmLikertMaxLabel != null)
            return false;
        if (esmLikertMinLabel != null ? !esmLikertMinLabel.equals(that.esmLikertMinLabel) : that.esmLikertMinLabel != null)
            return false;
        if (esmLikertStep != null ? !esmLikertStep.equals(that.esmLikertStep) : that.esmLikertStep != null)
            return false;
        if (esmQuickAnswers != null ? !esmQuickAnswers.equals(that.esmQuickAnswers) : that.esmQuickAnswers != null)
            return false;
        if (esmExpirationThreshold != null ? !esmExpirationThreshold.equals(that.esmExpirationThreshold) : that.esmExpirationThreshold != null)
            return false;
        if (esmStatus != null ? !esmStatus.equals(that.esmStatus) : that.esmStatus != null) return false;
        if (doubleEsmUserAnswerTimestamp != null ? !doubleEsmUserAnswerTimestamp.equals(that.doubleEsmUserAnswerTimestamp) : that.doubleEsmUserAnswerTimestamp != null)
            return false;
        if (esmUserAnswer != null ? !esmUserAnswer.equals(that.esmUserAnswer) : that.esmUserAnswer != null)
            return false;
        if (esmTrigger != null ? !esmTrigger.equals(that.esmTrigger) : that.esmTrigger != null) return false;
        if (esmScaleMin != null ? !esmScaleMin.equals(that.esmScaleMin) : that.esmScaleMin != null) return false;
        if (esmScaleMax != null ? !esmScaleMax.equals(that.esmScaleMax) : that.esmScaleMax != null) return false;
        if (esmScaleStart != null ? !esmScaleStart.equals(that.esmScaleStart) : that.esmScaleStart != null)
            return false;
        if (esmScaleMaxLabel != null ? !esmScaleMaxLabel.equals(that.esmScaleMaxLabel) : that.esmScaleMaxLabel != null)
            return false;
        if (esmScaleMinLabel != null ? !esmScaleMinLabel.equals(that.esmScaleMinLabel) : that.esmScaleMinLabel != null)
            return false;
        if (esmScaleStep != null ? !esmScaleStep.equals(that.esmScaleStep) : that.esmScaleStep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (esmType != null ? esmType.hashCode() : 0);
        result = 31 * result + (esmTitle != null ? esmTitle.hashCode() : 0);
        result = 31 * result + (esmSubmit != null ? esmSubmit.hashCode() : 0);
        result = 31 * result + (esmInstructions != null ? esmInstructions.hashCode() : 0);
        result = 31 * result + (esmRadios != null ? esmRadios.hashCode() : 0);
        result = 31 * result + (esmCheckboxes != null ? esmCheckboxes.hashCode() : 0);
        result = 31 * result + (esmLikertMax != null ? esmLikertMax.hashCode() : 0);
        result = 31 * result + (esmLikertMaxLabel != null ? esmLikertMaxLabel.hashCode() : 0);
        result = 31 * result + (esmLikertMinLabel != null ? esmLikertMinLabel.hashCode() : 0);
        result = 31 * result + (esmLikertStep != null ? esmLikertStep.hashCode() : 0);
        result = 31 * result + (esmQuickAnswers != null ? esmQuickAnswers.hashCode() : 0);
        result = 31 * result + (esmExpirationThreshold != null ? esmExpirationThreshold.hashCode() : 0);
        result = 31 * result + (esmStatus != null ? esmStatus.hashCode() : 0);
        result = 31 * result + (doubleEsmUserAnswerTimestamp != null ? doubleEsmUserAnswerTimestamp.hashCode() : 0);
        result = 31 * result + (esmUserAnswer != null ? esmUserAnswer.hashCode() : 0);
        result = 31 * result + (esmTrigger != null ? esmTrigger.hashCode() : 0);
        result = 31 * result + (esmScaleMin != null ? esmScaleMin.hashCode() : 0);
        result = 31 * result + (esmScaleMax != null ? esmScaleMax.hashCode() : 0);
        result = 31 * result + (esmScaleStart != null ? esmScaleStart.hashCode() : 0);
        result = 31 * result + (esmScaleMaxLabel != null ? esmScaleMaxLabel.hashCode() : 0);
        result = 31 * result + (esmScaleMinLabel != null ? esmScaleMinLabel.hashCode() : 0);
        result = 31 * result + (esmScaleStep != null ? esmScaleStep.hashCode() : 0);
        return result;
    }
}
