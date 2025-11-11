package com.example.tp2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private Button calculBtn;
    private CheckBox piscineCheck;

    private EditText nomEdit,adresseEdit,nbPiecesEdit,surfaceEdit;

    private TextView resultTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calculBtn = findViewById(R.id.calculBtn);
        piscineCheck = findViewById(R.id.piscineCheck);
        nomEdit = findViewById(R.id.nomEdit);
        adresseEdit = findViewById(R.id.adresseEdit);
        nbPiecesEdit = findViewById(R.id.nbPiecesEdit);
        surfaceEdit = findViewById(R.id.surfaceEdit);
        resultTxt = findViewById(R.id.resultTxt);


        calculBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });

    }


    private void calculer() {
        // Lecture des valeurs saisies
        double surface = Double.parseDouble(surfaceEdit.getText().toString());
        int pieces = Integer.parseInt(nbPiecesEdit.getText().toString());
        boolean piscine = piscineCheck.isChecked();

        // Calcul des impôts
        double impotBase = surface * 2;
        double supplement = pieces * 50 + (piscine ? 100 : 0);
        double total = impotBase + supplement;

        // Affichage du résultat
        resultTxt.setText("Impôt total : " + total + " DH");
    }
}
