package com.linkpulsion.courstrackbars; //package dans lequel se situe notre application

/**
 * Toutes les classes externes non natives de Java dont nous
 * nous servons doivent être importées
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Déclaration de la classe Main en tant que AppCompatActivity
 * pour qu'elle soit définie comme activité
 * @author Cyprien A.
 * @version 1.0
 */
public class Main extends AppCompatActivity{

    private int initVal = 0;
    private SeekBar trackBar;
    private TextView output,status;
    private int tempValue;

    /**
     * Méthode onCreate exectué au lacement de l'activité
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //passage de la sauvegarde dans le super-constructeur
        setContentView(R.layout.activty_main); //selection du layout comme contenu

        /**
         * Création des objects
         */
        output = (TextView)findViewById(R.id.out);
        status = (TextView)findViewById(R.id.status);
        trackBar = (SeekBar)findViewById(R.id.trackBar);

        /**
         * Initialisation des valeurs affichées
         */
        status.setText(getString(R.string.status) + " RELACHÉ");
        output.setText(getString(R.string.main) + " " + Integer.toString(0));

        /**
         * Création du Listener qui va detecter un pression sur la SeekBar et
         * un changement de valeur
         */
        trackBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /**
             * Méthode qui va s'executer dès qu'un chagement de valeur sera détecté
             * @param seekBar
             * @param progress
             * @param fromUser
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tempValue = progress;
                update(progress);
            }

            /**
             * Méthode qui va s'executer dès qu'une pression sera détectée
             * @param seekBar
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                status.setText(getString(R.string.status) + " APPUYÉ");
            }

            /**
             * Méthode qui va s'exuter dès qu'un presion sera relachée
             * @param seekBar
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                status.setText(getString(R.string.status) + " RELACHÉ");
            }
        });
    }

    /**
     * Méthode qui met à jour l'affichage
     * @param value
     */
    private void update(int value){
        output.setText(getString(R.string.main) + " " + Integer.toString(value));
    }
}
