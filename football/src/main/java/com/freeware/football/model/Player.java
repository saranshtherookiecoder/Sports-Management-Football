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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@NamedQueries({ @NamedQuery(name = "getPlayersByClubId", query = "select p from Player p where p.club.id=:clubId"),
		@NamedQuery(name = "getPlayersByCountryId", query = "select p from Player p where p.country.id=:countryId") })

@Entity(name = "Player")
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Player implements Serializable {

	private static final long serialVersionUID = 8187072003579178327L;

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "PLAYERID_PK")
	private Integer id;

	@Column(name = "NAME")
	private String playerName;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "COUNTRYID_FK", nullable = false)
	private Country country;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "CLUBID_FK", nullable = false)
	private Club club;	

	@Column(name = "POSITION")
	private String position;
	
	@JsonIgnore
	@CreatedDate
	@Column(name = "CREATION_TIME")
	private Date creationTime;	
	
	@JsonIgnore
	@LastModifiedDate
	@Column(name = "MODIFICATION_TIME")
	private Date modificationTime;

	@Column(name = "SALARY")
	private Integer salary;

	@Column(name = "JERSEY_NO")
	private Integer jerseyNo;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name = "CAPTAIN", nullable = false, columnDefinition = "boolean")
	private Boolean isCaptain;

	@Column(name = "NATIONALITY")
	private String nationality;

	@Column(name = "RETIRED", nullable = false, columnDefinition = "boolean default false")
	private Boolean isRetired;

}
