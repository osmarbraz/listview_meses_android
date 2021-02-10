package com.exemplo.listview_meses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Associa os componentes da interface aos componentes da classe
        listView = findViewById(R.id.listView);
        //Vetor de string com os valores para o Listview
        String[] valores = new String[]{"Janeiro", "Fevereiro", "Março",
                "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
                "Outubro", "Novembro", "Dezembro"};

        //Cria um ArrayList do vetor de String
        ArrayList<String> listaValores = new ArrayList<>(Arrays.asList(valores));
        //Especialista em lidar com Adapter e listas de valores
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaValores);
        //Associa o adaptar a lista de visualização
        listView.setAdapter(adapter);
        //Associa evento aos itens da lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Cria uma caixa de diálogo para exibir informações do item
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                //Título da janela
                dialogo.setTitle("Alerta!");
                //Mensagem com o índice do item selecionado
                dialogo.setMessage("Você selecionou " + parent.getItemAtPosition(position)+ " na posição "+ position);
                //Botão de ok do diálogo
                dialogo.setNeutralButton("Ok", null);
                //Mostra a janela de diálogo
                dialogo.show();
            }
        });
    }

    /**
     * Evento do botão fechar
     * @param v
     */
    public void onClickBotaoFechar(View v) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Fechar aplicativo"); //Título da janela de diálogo
        dialogo.setMessage("Você tem certeza que deseja sair?"); //Mensagem da janela de diálogo
        dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() { //Evento para o botão sim
            public void onClick(DialogInterface dialog, int which) {
                //Ação para a resposta sim
                Toast.makeText(MainActivity.this, "Fechando o aplicativo", Toast.LENGTH_SHORT).show();
                System.exit(0);
            }
        });
        dialogo.setNegativeButton("Não", new DialogInterface.OnClickListener() { //Evento para o botão não
            public void onClick(DialogInterface dialog, int which) {
                //Ação para a resposta não
                //Apenas fecha a mensagem
                dialog.dismiss();
            }
        });
        dialogo.show(); //Exibe o diálogo
    }
}