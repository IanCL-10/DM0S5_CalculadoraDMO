package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.CompletionService;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.R;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.model.Calculadora;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener{

    private Calculadora calculadora;

    private TextView resultadoView;
    private String resultado;
    private int ultimaOp;
    private boolean foiOp;
    private float memoria;

    private Button cButton;

    private Button nro0Button;
    private Button nro1Button;
    private Button nro2Button;
    private Button nro3Button;
    private Button nro4Button;
    private Button nro5Button;
    private Button nro6Button;
    private Button nro7Button;
    private Button nro8Button;
    private Button nro9Button;
    private Button pontoButton;

    private Button adicaoButton;
    private Button subtracaoButton;
    private Button multiplicacaoButton;
    private Button divisaoButton;
    private Button igualButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        calculadora = Calculadora.getInstance();

        resultadoView = findViewById(R.id.textview_lcd);
        resultado = "0";
        foiOp = false;
        memoria = 0;

        cButton = findViewById(R.id.button_c);
        cButton.setOnClickListener(this);

        //Botões dos numeros e do ponto
        nro0Button = findViewById(R.id.button_zero);
        nro1Button = findViewById(R.id.button_um);
        nro2Button = findViewById(R.id.button_dois);
        nro3Button = findViewById(R.id.button_tres);
        nro4Button = findViewById(R.id.button_quatro);
        nro5Button = findViewById(R.id.button_cinco);
        nro6Button = findViewById(R.id.button_seis);
        nro7Button = findViewById(R.id.button_sete);
        nro8Button = findViewById(R.id.button_oito);
        nro9Button = findViewById(R.id.button_nove);
        pontoButton = findViewById(R.id.button_ponto);
        nro0Button.setOnClickListener(this);
        nro1Button.setOnClickListener(this);
        nro2Button.setOnClickListener(this);
        nro3Button.setOnClickListener(this);
        nro4Button.setOnClickListener(this);
        nro5Button.setOnClickListener(this);
        nro6Button.setOnClickListener(this);
        nro7Button.setOnClickListener(this);
        nro8Button.setOnClickListener(this);
        nro9Button.setOnClickListener(this);
        pontoButton.setOnClickListener(this);

        //Botões das operações
        adicaoButton = findViewById(R.id.button_adicao);
        subtracaoButton = findViewById(R.id.button_subtracao);
        multiplicacaoButton = findViewById(R.id.button_multiplicacao);
        divisaoButton = findViewById(R.id.button_divisao);
        igualButton = findViewById(R.id.button_igual);
        adicaoButton.setOnClickListener(this);
        subtracaoButton.setOnClickListener(this);
        multiplicacaoButton.setOnClickListener(this);
        divisaoButton.setOnClickListener(this);
        igualButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == cButton){
            foiOp = false;
            resultado = "0";
            resultadoView.setText("0");
            calculadora.c();
            ultimaOp = Constantes.NULO;
            memoria = 0;
        }

        if (v == nro0Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "0";
            resultadoView.setText(resultado);
        }
        if (v == nro1Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "1";
            resultadoView.setText(resultado);
        }
        if (v == nro2Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "2";
            resultadoView.setText(resultado);
        }
        if (v == nro3Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "3";
            resultadoView.setText(resultado);
        }
        if (v == nro4Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "4";
            resultadoView.setText(resultado);
        }
        if (v == nro5Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "5";
            resultadoView.setText(resultado);
        }
        if (v == nro6Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "6";
            resultadoView.setText(resultado);
        }
        if (v == nro7Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "7";
            resultadoView.setText(resultado);
        }
        if (v == nro8Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "8";
            resultadoView.setText(resultado);
        }
        if (v == nro9Button){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += "9";
            resultadoView.setText(resultado);
        }
        if (v == pontoButton){
            if(foiOp){
                resultado = "";
            }
            foiOp = false;
            resultado += ".";
            resultadoView.setText(resultado);
        }

        if (v == adicaoButton){
            foiOp = true;
            ultimaOp = Constantes.ADICAO;
            memoria = calculadora.calcular(ultimaOp, Float.parseFloat(resultado));
            resultadoView.setText(String.valueOf(memoria));
            resultado = "0";
        }
        if (v == subtracaoButton){
            foiOp = true;
            ultimaOp = Constantes.SUBTRACAO;
            memoria = calculadora.calcular(ultimaOp, Float.parseFloat(resultado));
            resultado = "0";
            resultadoView.setText(String.valueOf(memoria));
        }
        if (v == multiplicacaoButton){
            if(resultado != "0") {
                foiOp = true;
                ultimaOp = Constantes.MULTIPLICACAO;
                memoria = calculadora.calcular(ultimaOp, Float.parseFloat(resultado));
                resultado = "0";
                resultadoView.setText(String.valueOf(memoria));
            }
        }
        if (v == divisaoButton){
            if(resultado != "0") {
                foiOp = true;
                ultimaOp = Constantes.DIVISAO;
                memoria = calculadora.calcular(ultimaOp, Float.parseFloat(resultado));
                resultado = "0";
                resultadoView.setText(String.valueOf(memoria));
            }
        }
        if (v == igualButton){
            foiOp = true;
            memoria = calculadora.calcular(ultimaOp, Float.parseFloat(resultado));
            resultado = String.valueOf(memoria);
            calculadora.c();
            resultadoView.setText(String.valueOf(memoria));
            ultimaOp = Constantes.RESULTADO;
        }
    }


}
