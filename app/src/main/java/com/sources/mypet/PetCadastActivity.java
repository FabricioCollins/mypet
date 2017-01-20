package com.sources.mypet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PetCadastActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    private static final int SELECT_PICTURE = 1;
    private static final int MAKE_PICTURE = 2;
    String imageName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_cadast);

        /*
        * Define a Toolbar da Activity
        * */
        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*
        * Fim Define a Toolbar da Activity
        * */


        /*
        * Adiciona evento para adicionar foto do perfil
        * */

        // Adiciona evento ao botao
        ImageView petProfilePicButton = (ImageView) findViewById(R.id.my_pet_profile_pic);
        // Cria janela de opcoes
        View.OnClickListener petCadastButtonListener = new View.OnClickListener(){
            public void onClick(View v) {
                final CharSequence[] items = {
                        getString(R.string.prfile_dialog_opt1),
                        getString(R.string.prfile_dialog_opt2)
                };

                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(PetCadastActivity.this);

                builder.setTitle(R.string.dialog_title);
                builder.setItems(items, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();

                        // ACOES AO CLICAR NAS OPCOES DA LISTA
                        switch (item) {
                            case 0: // ABRE A GALERIA
                                Intent intent = new Intent();
                                intent.setType("image/*");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent, "Galeria de fotos"), SELECT_PICTURE);
                                break;
                            case 1: // ABRE A CAMERA
                                // Define o nome da imagem utilizando a data
                                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
                                imageName = "PROFILEPIC-" + sdf.format(new Date()) + ".jpg";

                                // Diretorio onde sera salvo a imagem
                                File appProfilePics = getDir("AppProfilePics", Context.MODE_PRIVATE);
                                // Criar caso nao exista
                                try {
                                    if (!appProfilePics.exists())
                                        appProfilePics.mkdir();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                File imageFile = new File(appProfilePics, imageName);
                                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));

                                startActivity(i);

                                break;
                        }
                    }

                });

                AlertDialog alert = builder.create();

                alert.show();
            }
        };
        petProfilePicButton.setOnClickListener(petCadastButtonListener);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == SELECT_PICTURE && resultCode == RESULT_OK){
            //imagem veio da galeria
            getPictureFromGallery(resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pet_cadast, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent it = new Intent(this, MainActivity.class);
                startActivity(it);
                return true;

            case R.id.cadast_cancel:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.action_settings:
                // Your code here
                return true;
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getPictureFromGallery(int resultStatus, Intent data) {
        if (resultStatus == RESULT_OK && data != null && data.getData() != null) {
            try {
                // DO HERE
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
