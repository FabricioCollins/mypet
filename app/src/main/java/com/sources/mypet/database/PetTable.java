package com.sources.mypet.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sources.mypet.entity.Pet;

public class PetTable {
	private SQLiteDatabase tblPet;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public PetTable(Context context){
		BDCore auxBd = new BDCore(context);
		tblPet = auxBd.getWritableDatabase();
		sdf.applyPattern("yyyy-MM-dd");
	}
	
	
	public void insert(Pet pet){
		ContentValues valores = new ContentValues();
		valores.put("name", pet.getName());
		valores.put("specie", pet.getSpecie());
		valores.put("breed", pet.getBreed());
		valores.put("gender", pet.getGender());
		valores.put("date_born", sdf.format(pet.getDate_born()));
		valores.put("profile_pic", pet.getProfile_pic());

		tblPet.insert("pet", null, valores);
	}
	
	
	public void update(Pet pet){
		ContentValues valores = new ContentValues();
		valores.put("name", pet.getName());
		valores.put("specie", pet.getSpecie());
		valores.put("breed", pet.getBreed());
		valores.put("gender", pet.getGender());
		valores.put("date_born", sdf.format(pet.getDate_born()));
		valores.put("profile_pic", pet.getProfile_pic());
		
		tblPet.update("pet", valores, "id = ?", new String[]{""+pet.getId()});
	}
	
	
	public void delete(Pet pet){
		tblPet.delete("pet", "id = "+pet.getId(), null);
	}
	
	
	public List<Pet> get(){
		List<Pet> list = new ArrayList<Pet>();
		String[] columns = new String[]{"id", "name", "specie", "breed", "gender", "date_born", "profile_pic"};
		
		Cursor cursor = tblPet.query("pet", columns, null, null, null, null, "name ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				Pet p = new Pet();
				p.setId(cursor.getLong(0));
				p.setName(cursor.getString(1));
				p.setSpecie(cursor.getString(2));
				p.setBreed(cursor.getString(3));
				p.setGender(cursor.getString(4));
				p.setDate_born(cursor.getString(5));
				p.setProfile_pic(cursor.getString(6));
				list.add(p);
				
			}while(cursor.moveToNext());
		}
		
		return(list);
	}
}
