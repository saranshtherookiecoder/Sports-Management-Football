package com.freeware.football.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity(name="League")
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class League implements Serializable{


	private static final long serialVersionUID = 1100195960780100087L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "LEAGUEID_PK")
	private int id;
	
	@Column(name="NAME")
	private String leagueName;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="COUNTRYID_FK",nullable= false)
	private Country country;
	
	@JsonIgnore
	@CreatedDate
	@Column(name = "CREATION_TIME")
	private Date creationTime;
	
	@JsonIgnore
	@LastModifiedDate
	@Column(name = "MODIFICATION_TIME")
	private Date modificationTime;
	

}
