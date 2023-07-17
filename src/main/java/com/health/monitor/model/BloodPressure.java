package com.health.monitor.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="t_bloodps")
public class BloodPressure {
	@Id
	private UUID id;
	private double systolic;
	private double diastolic;
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profile_id", updatable = false)
	private Profile pprofile;
    @Transient
    private String profileId;
    private LocalDate date;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public double getSystolic() {
		return systolic;
	}
	public void setSystolic(double systolic) {
		this.systolic = systolic;
	}
	public double getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(double diastolic) {
		this.diastolic = diastolic;
	}

	
	
	public Profile getPprofile() {
		return pprofile;
	}
	public void setPprofile(Profile pprofile) {
		this.pprofile = pprofile;
	}

	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
