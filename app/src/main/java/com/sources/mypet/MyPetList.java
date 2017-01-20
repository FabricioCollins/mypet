package com.sources.mypet;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.sources.mypet.database.PetTable;
import com.sources.mypet.entity.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabricio on 18/06/2015.
 */
public class MyPetList extends Fragment  {
    public static final String TAG = "petlist";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mypetlist_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        PetTable petTable = new PetTable(getActivity());

        // Remover depois
        /*Pet pet1 = new Pet();
        pet1.setName("Fred");
        pet1.setProfile_pic("profile");
        pet1.setGender("Macho");
        pet1.setSpecie("Cachorro");
        pet1.setBreed("SRD");
        pet1.setDate_born("14/10/2012");

        Pet pet2 = new Pet();
        pet2.setName("Jannie");
        pet2.setProfile_pic("profile");
        pet2.setGender("Femea");
        pet2.setSpecie("Cachorro");
        pet2.setBreed("Poodle");
        pet2.setDate_born("02/10/2010");

        Pet pet3 = new Pet();
        pet3.setName("Pitty");
        pet3.setProfile_pic("profile");
        pet3.setGender("Macho");
        pet3.setSpecie("Cachorro");
        pet3.setBreed("Vira lata");
        pet3.setDate_born("03/04/2000");
        // Remover depois

        petTable.insert(pet1);
        petTable.insert(pet2);
        petTable.insert(pet3);*/

        List<Pet> pets = petTable.get();

        // Este esta dando erro
        ListCustomAdapter adapter = new ListCustomAdapter(getActivity(), pets);

        ListView lv = (ListView) getActivity().findViewById(R.id.petsListView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast.makeText(getActivity(), "Item clicked : " + position, Toast.LENGTH_SHORT).show();
            }

        });

        /*
        * Adiciona evento ao botao que abre a tela de cadastro
        * */
        ImageView petCadastButton = (ImageView) getActivity().findViewById(R.id.petCadastButton);
        View.OnClickListener petCadastButtonListener = new View.OnClickListener(){
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Abrir cadastro...",Toast.LENGTH_SHORT).show();

                Intent it = new Intent(getActivity(), PetCadastActivity.class);
                startActivity(it);
            }
        };
        petCadastButton.setOnClickListener(petCadastButtonListener);
    }

}
