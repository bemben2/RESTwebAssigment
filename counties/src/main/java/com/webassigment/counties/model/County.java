package com.webassigment.counties.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the county database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "County.findAll", query = "SELECT c FROM County c") })
public class County implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name = "area_land")
	private int areaLand;

	@Column(name = "area_rank")
	private int areaRank;

	@Column(name = "area_total")
	private int areaTotal;

	@Column(name = "area_water")
	private int areaWater;

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

	public int getAreaLand() {
		return this.areaLand;
	}

	public void setAreaLand(int areaLand) {
		this.areaLand = areaLand;
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

	public int getAreaWater() {
		return this.areaWater;
	}

	public void setAreaWater(int areaWater) {
		this.areaWater = areaWater;
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