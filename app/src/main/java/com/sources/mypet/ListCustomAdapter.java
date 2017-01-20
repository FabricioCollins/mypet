package com.sources.mypet;

/**
 * Created by Fabricio on 18/06/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sources.mypet.entity.Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListCustomAdapter extends BaseAdapter {
        private Context context;
        private List<Pet> pets;

        public ListCustomAdapter(Activity context, List<Pet> pets){
                // Itens do listview
                this.pets = pets;
                // Pega contento.
                this.context = context;
        }

        @Override
        public int getCount() {
                if(pets == null) {
                        return 0;
                }
                return pets.size();
        }

        @Override
        public Object getItem(int i) {
                return pets.get(i);
        }

        @Override
        public long getItemId(int i) {
                return pets.get(i).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

                Pet pet = (Pet)getItem(position);

                /**
                 * Utiliza o conceito de Adaptador Eficiente.
                 * usando o convertView da forma que e feita e mais eficiente do que
                 * usar View v = LayoutInflater.from ... porque dessa forma toda fez que 
                 * o usuario der scroll novas linhas vao ser criadas. E com o convertView
                 * isso nao acontece.
                 **/
                if(convertView == null) {
                        LayoutInflater inflater = (LayoutInflater)  context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        convertView = inflater.inflate(R.layout.mypetlist_item, parent, false);
                }

                TextView textView = (TextView) convertView.findViewById(R.id.petListTextView);
                TextView textView2 = (TextView) convertView.findViewById(R.id.petListTextView2);
                ImageView imageView = (ImageView) convertView.findViewById(R.id.petListImageView);

                //pega os dados da lista
                //e define os valores nos itens.

                //int age = getAge(pet.getDate_born());


                textView.setText(pet.getName());
                textView2.setText(pet.getSpecie() + " - " + pet.getBreed() + ", " + 3 + " anos");
                imageView.setImageResource(R.drawable.pet_avatar1);

                //retorna a view com as informacoes
                return convertView;
        }

        public static int getAge(Date dateOfBirth) {

                if (dateOfBirth==null) return 0;

                Calendar today = Calendar.getInstance();
                Calendar birthDate = Calendar.getInstance();

                int age = 0;

                birthDate.setTime(dateOfBirth);
                if (birthDate.after(today)) {
                        throw new IllegalArgumentException("Can't be born in the future");
                }

                age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

                // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
                if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
                        (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
                        age--;

                        // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
                }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
                        (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
                        age--;
                }

                return age;
        }

}