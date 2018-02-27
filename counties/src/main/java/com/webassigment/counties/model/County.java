package com.webassigment.counties.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the county database table.
 * 
 */
@Entity
@NamedQueries({ 
@NamedQuery(name = "County.findAll", query = "SELECT c FROM County c"),
@NamedQuery(name = "County.findByName", query = "SELECT c FROM County c WHERE c.name LIKE :name") })
public class County implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "population")
	private int population;

	@Column(name = "area_rank")
	private int areaRank;

	@Column(name = "area_total")
	private int areaTotal;

	@Column(name = "neighbours_no")
	private int neighboursNo;

	private String capital;

	private String flag;

	private String motto;

	private String name;

	private String province;

	public County() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPopulation() {
		return this.population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getAreaRank() {
		return this.areaRank;
	}

	public void setAreaRank(int areaRank) {
		this.areaRank = areaRank;
	}

	public int getAreaTotal() {
		return this.areaTotal;
	}

	public void setAreaTotal(int areaTotal) {
		this.areaTotal = areaTotal;
	}

	public int getNeighbourNo() {
		return this.neighboursNo;
	}

	public void setNeighbourNo(int neighbourNo) {
		this.neighboursNo = neighbourNo;
	}

	public String getCapital() {
		return this.capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMotto() {
		return this.motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}