package com.freeware.football.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity(name = "Country")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Country implements Serializable {

	private static final long serialVersionUID = 1041651028918313789L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "COUNTRYID_PK")
	private int id;

	@Column(name = "NAME")
	private String countryName;

	@JsonIgnore
	@CreatedDate
	@Column(name = "CREATION_TIME", nullable = false, updatable = false)
	private Date creationTime;

	@JsonIgnore
	@LastModifiedDate
	@Column(name = "MODIFICATION_TIME")
	private Date modificationTime;
	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "country",fetch =  FetchType.LAZY)
//	private Set<Club> club;
//	
//	@JsonManagedReference
//	@OneToMany(mappedBy = "country",fetch =  FetchType.LAZY)
//	private Set<League> league;

}
