package com.meicansoftware.calculadoraimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btn_calcular;
    private EditText edt_altura, edt_peso;
    private TextView imc_resultado, imc_classificacao, imc_consequencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_calcular = findViewById(R.id.btn_calcular);
        edt_altura = findViewById(R.id.edt_altura);
        edt_peso = findViewById(R.id.edt_peso);
        imc_classificacao = findViewById(R.id.txt_classificacao);
        imc_resultado = findViewById(R.id.num_resultado);
        imc_consequencia = findViewById(R.id.txt_consequencias);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                double peso = Double.parseDouble(edt_peso.getText().toString());
                double altura = Double.parseDouble(edt_altura.getText().toString());
                double imc = peso/(altura*altura);

                imc_resultado.setText(String.format("%.2f", imc));

                if(imc > 16 && imc < 16.9){
                    imc_classificacao.setText("Muito abaixo do peso");
                    imc_consequencia.setText("Queda de cabelo, infertilidade, ausência menstrual");
                    imc_classificacao.setTextColor(Color.rgb(200, 0, 0));
                    imc_classificacao.setBackgroundColor(Color.rgb(200, 200,200));
                }

                }catch(Exception e){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setMessage("Insira as informações corretamente. \n " + e);
                    dialog.setNeutralButton("OK", null);
                    dialog.show();
                }
            }
        });
    }
}