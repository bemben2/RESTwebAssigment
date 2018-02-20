package com.webassigment.counties.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the county_has_neighbour database table.
 * 
 */
@Entity
@Table(name="county_has_neighbour")
@NamedQueries({
	
@NamedQuery(name="CountyHasNeighbour.findNeighbourById", query="SELECT c FROM CountyHasNeighbour c WHERE  c.countyId = :countyId "),
@NamedQuery(name="CountyHasNeighbour.findAll", query="SELECT c FROM CountyHasNeighbour c")
})
public class CountyHasNeighbour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="border_length")
	private int borderLength;

	@Column(name="county_id")
	private int countyId;

	@Column(name="neighbour_id")
	private int neighbourId;

	public CountyHasNeighbour() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBorderLength() {
		return this.borderLength;
	}

	public void setBorderLength(int borderLength) {
		this.borderLength = borderLength;
	}

	public int getCountyId() {
		return this.countyId;
	}

	public void setCountyId(int countyId) {
		this.countyId = countyId;
	}

	public int getNeighbourId() {
		return this.neighbourId;
	}

	public void setNeighbourId(int neighbourId) {
		this.neighbourId = neighbourId;
	}

}