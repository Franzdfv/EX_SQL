package mainactivity.franzfonseca.com.ex_sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ventas extends AppCompatActivity implements View.OnClickListener {

    EditText eIroman, eViuda, eCapitan, eHulk, eBruja, eSpiderman, eValorapagar;
    Button bComprar, blimpiar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);

        eIroman = (EditText) findViewById(R.id.eIroman);
        eViuda = (EditText) findViewById(R.id.eViuda);
        eCapitan = (EditText) findViewById(R.id.eCapitan);
        eHulk = (EditText) findViewById(R.id.eHulk);
        eBruja = (EditText) findViewById(R.id.eBruja);
        eSpiderman = (EditText) findViewById(R.id.eSpiderman);
        eValorapagar = (EditText) findViewById(R.id.eValorapagar);
        bComprar = (Button)findViewById(R.id.bComprar);
        blimpiar = (Button)findViewById(R.id.bLimp);


        bComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valorapagar;

                valorapagar = Double.parseDouble(eIroman.getText().toString())*15000 + Double.parseDouble(eViuda.getText().toString())*12000 +
                        Double.parseDouble(eCapitan.getText().toString())*15000 +
                        Double.parseDouble(eHulk.getText().toString())*12000+
                        Double.parseDouble(eBruja.getText().toString())*15000+
                        Double.parseDouble(eSpiderman.getText().toString())*10000;
                eValorapagar.setText(String.valueOf(valorapagar));



            }
        });
        blimpiar.setOnClickListener(this);


    }
    @Override

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override

    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.mConfig){
            //Toast.makeText(MainActivity.this, "Presionó menu Configuración", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Settings.class);
            intent.putExtra("pIroman",15000);
            intent.putExtra("pViuda",12000);
            intent.putExtra("pCapitan", 15000);
            intent.putExtra("pHulk", 12000);
            intent.putExtra("pBruja", 15000);
            intent.putExtra("pSpiderman", 10000);
            //startActivity(intent);
            startActivityForResult(intent, 1234);        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String iro, viu, cap, hu, bru, spi;
        if (requestCode==1234 && resultCode==RESULT_OK){
            iro = data.getExtras().getString("npIron");
            viu = data.getExtras().getString("npViu");
            cap = data.getExtras().getString("npCap");
            hu = data.getExtras().getString("npHu");
            bru = data.getExtras().getString("npBru");
            spi = data.getExtras().getString("npSpi");

            Toast.makeText(Ventas.this, "Nuevos datos: Iroman: "+iro+" Viuda Negra"+viu+" Capitan America"+cap+" Hulk"+hu+" Bruja Escarlata"+bru+""+ "Spiderman"+spi, Toast.LENGTH_SHORT).show();


        }
    }


    @Override
    public void onClick(View v) {
        eIroman.setText("");
        eViuda.setText("");
        eCapitan.setText("");
        eHulk.setText("");
        eBruja.setText("");
        eSpiderman.setText("");
        eValorapagar.setText("");


    }


}

