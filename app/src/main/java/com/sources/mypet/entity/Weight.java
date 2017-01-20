package com.sources.mypet.entity;

/**
 * Created by Fabricio on 24/06/2015.
 */
public class Weight {
	private long id;
	private long pet_id;
	private String date;	
	private String weight;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPet_id() {
		return pet_id;
	}

	public void setPet_id(long pet_id) {
		this.pet_id = pet_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
}
