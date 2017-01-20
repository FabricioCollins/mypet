package com.sources.mypet.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
	private static final String NOME_BD = "MyPetBD";
	private static final int VERSAO_BD = 1;
	
	
	public BDCore(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL("create table pet(id integer primary key autoincrement, name text not null, specie text not null, breed text not null, gender text not null, date_born real, profile_pic text, date_cadast TIMESTAMP DEFAULT CURRENT_TIMESTAMP );");
		bd.execSQL("create table vaccine_card(id integer primary key autoincrement, pet_id integer not null, vaccine_name text not null, volume real not null, volume_und text not null, application_date date not null, notified integer, pending integer, date_cadast date not null);");
		bd.execSQL("create table weight (id integer primary key autoincrement, pet_id integer not null,  date not null, weight text not null);");
		bd.execSQL("create table specie(id integer primary key, name text not null);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		bd.execSQL("drop table pets;");
		bd.execSQL("drop table vaccine_card;");
		bd.execSQL("drop table weight;");
		bd.execSQL("drop table specie;");
		onCreate(bd);
	}

}
