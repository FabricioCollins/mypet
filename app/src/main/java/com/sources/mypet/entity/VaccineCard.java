package com.sources.mypet.entity;

/**
 * Created by Fabricio on 24/06/2015.
 */
public class VaccineCard {
	private long id;
	private long pet_id;
	private String vaccine_name;
	private double volume;
	private String volume_und;	
	private String application_date;
	private int notified;
	private boolean pending;
	private String date_cadast;

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

	public String getVaccine_name() {
		return vaccine_name;
	}

	public void setVaccine_name(String vaccine_name) {
		this.vaccine_name = vaccine_name;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getVolume_und() {
		return volume_und;
	}

	public void setVolume_und(String volume_und) {
		this.volume_und = volume_und;
	}

	public String getApplication_date() {
		return application_date;
	}

	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public int getNotified() {
		return notified;
	}

	public void setNotified(int notified) {
		this.notified = notified;
	}

	public String getDate_cadast() {
		return date_cadast;
	}

	public void setDate_cadast(String date_cadast) {
		this.date_cadast = date_cadast;
	}
}
