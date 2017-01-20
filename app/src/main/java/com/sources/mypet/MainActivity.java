package com.sources.mypet;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by d-codepages on 11/11/2014.
 */
public class MainActivity extends ActionBarActivity implements DrawerCallbacks {

    private Toolbar mToolbar;

    private Nav_DrawerFragment mNavigationNavDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mToolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                }
                return false;
            }
        });

        mNavigationNavDrawerFragment = (Nav_DrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationNavDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
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

            case R.id.menu_add_item:
                Intent itAdd = new Intent(this, PetCadastActivity.class);
                startActivity(itAdd);
                return true;
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        //Toast.makeText(this, "item no: " + position + "-Selected", Toast.LENGTH_SHORT).show();

        Fragment fragment;
        switch (position) {
            case 0: //Meus bichinhos
                fragment = getFragmentManager().findFragmentByTag(MyPetList.TAG);
                if (fragment == null) {
                    fragment = new MyPetList();
                }
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, MyPetList.TAG).commit();
                break;
            case 1: //Pesquisar
                break;
            case 2: //my account //todo
                break;
            case 3: //settings //todo
                break;
            case 4: //Sair //todo

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // Seta o Titulo do Dialog
                alertDialogBuilder.setTitle(getResources().getString(R.string.dialog_title_1));

                // seta a mensagem
                alertDialogBuilder.setMessage(getResources().getString(R.string.dialog_text_1)).setCancelable(false).setPositiveButton(
                        getResources().getString(R.string.dialog_ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // SIM
                                // Fecha o APP
                                System.exit(0);

                                // Fecha o dialog
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(getResources().getString(R.string.dialog_cancel),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // NAO
                                        // Fecha o dialog
                                        dialog.cancel();
                                    }
                                });

                // Cria o alertDialog com o conteudo do alertDialogBuilder
                AlertDialog alertDialog = alertDialogBuilder.create();
                // Exibe o Dialog
                alertDialog.show();

                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mNavigationNavDrawerFragment.isDrawerOpen())
            mNavigationNavDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }
}
