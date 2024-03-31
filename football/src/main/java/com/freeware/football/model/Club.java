package com.freeware.football.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity(name = "Club")
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Club implements Serializable {

	private static final long serialVersionUID = 5854528878597719329L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "CLUBID_PK")
	private int id;

	@Column(name = "NAME")
	private String clubName;
	
	@JsonIgnore
	@CreatedDate
	@Column(name = "CREATION_TIME")
	private Date creationTime;
	
	@JsonIgnore
	@LastModifiedDate
	@Column(name = "MODIFICATION_TIME")
	private Date modificationTime;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ClubLeagueMapping", joinColumns = @JoinColumn(name = "CLUBID_FK"), inverseJoinColumns = @JoinColumn(name = "LEAGUEID_FK"))
	private Set<League> leagues ;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="COUNTRYID_FK",nullable= false)
	private Country country;

}
