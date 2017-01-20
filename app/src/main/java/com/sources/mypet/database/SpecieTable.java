package com.sources.mypet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sources.mypet.entity.Specie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabricio on 24/06/2015.
 */
public class SpecieTable {
    private SQLiteDatabase tblSpecie;

    public SpecieTable(Context context){
        BDCore auxBd = new BDCore(context);
        tblSpecie = auxBd.getWritableDatabase();
    }


    public void insert(Specie specie){
        ContentValues valores = new ContentValues();
        valores.put("id", specie.getName());
        valores.put("name", specie.getName());

        tblSpecie.insert("specie", null, valores);
    }

    public void delete(Specie specie){
        tblSpecie.delete("specie", "id = "+specie.getId(), null);
    }


    public List<Specie> get(){
        List<Specie> list = new ArrayList<Specie>();
        String[] columns = new String[]{"id", "name"};

        Cursor cursor = tblSpecie.query("specie", columns, null, null, null, null, "id ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{
                Specie p = new Specie();
                p.setId(cursor.getLong(0));
                p.setName(cursor.getString(1));
                list.add(p);

            }while(cursor.moveToNext());
        }

        return(list);
    }
}
