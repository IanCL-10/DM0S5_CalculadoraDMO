package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.R;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.model.Calculadora;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener{

    private Calculadora calculadora;

    private String resultado;
    private int ultimaOp;
    private boolean foiOp;
    private float memoria;

    private TextView resultadoView;

    private Button cButton;
    private Button ceButton;
    private Button potenciaButton;

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

        resultado = "0";
        foiOp = false;
        memoria = 0;

        resultadoView = findViewById(R.id.textview_lcd);
        cButton = findViewById(R.id.button_c);
        ceButton = findViewById(R.id.button_ce);
        potenciaButton = findViewById(R.id.button_potencia);
        cButton.setOnClickListener(this);
        ceButton.setOnClickListener(this);
        potenciaButton.setOnClickListener(this);

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

        if(v == ceButton){
            foiOp = false;
            resultado = "0";
            resultadoView.setText("0");
        }

        if (v == nro0Button){
            adicionarNro("0");
        }
        if (v == nro1Button){
            adicionarNro("1");
        }
        if (v == nro2Button){
            adicionarNro("2");
        }
        if (v == nro3Button){
            adicionarNro("3");
        }
        if (v == nro4Button){
            adicionarNro("4");
        }
        if (v == nro5Button){
            adicionarNro("5");
        }
        if (v == nro6Button){
            adicionarNro("6");
        }
        if (v == nro7Button){
            adicionarNro("7");
        }
        if (v == nro8Button){
            adicionarNro("8");
        }
        if (v == nro9Button){
            adicionarNro("9");
        }
        if (v == pontoButton){
            adicionarNro(".");
        }

        if (v == adicaoButton){
            fazerOperacao(Constantes.ADICAO);
        }
        if (v == subtracaoButton){
            fazerOperacao(Constantes.SUBTRACAO);
        }
        if (v == multiplicacaoButton){
            if(!resultado.equals("0")) {
                fazerOperacao(Constantes.MULTIPLICACAO);
            }
        }
        if (v == divisaoButton){
            if(!resultado.equals("0")) {
                fazerOperacao(Constantes.DIVISAO);
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

        if (v == potenciaButton){
            fazerOperacao(Constantes.POTENCIA);
        }
    }

    private void fazerOperacao(int constante) {
        foiOp = true;
        ultimaOp = constante;
        memoria = calculadora.calcular(ultimaOp, Float.parseFloat(resultado));
        resultadoView.setText(String.valueOf(memoria));
        resultado = "0";
    }

    private void adicionarNro(String s) {
        if (foiOp) {
            resultado = "";
        }
        foiOp = false;
        resultado += s;
        resultadoView.setText(resultado);
    }

}
