package com.sources.mypet.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Fabricio on 24/06/2015.
 */
public class Pet {
	private long id;
	private String name;
	private String specie;	
	private String breed;	
	private String gender;
	private String date_born;
	private String profile_pic;
	private String date_cadast;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecie() {
		return specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate_born() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date born = null;
		try {
			born = sdf.parse(date_born);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return born;
	}

	public void setDate_born(String date_born) {
		this.date_born = date_born;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public String getDate_cadast() {
		return date_cadast;
	}

	public void setDate_cadast(String date_cadast) {
		this.date_cadast = date_cadast;
	}
}
