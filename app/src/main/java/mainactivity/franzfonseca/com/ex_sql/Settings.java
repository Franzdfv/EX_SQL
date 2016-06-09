package mainactivity.franzfonseca.com.ex_sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity implements View.OnClickListener {
    EditText epIroman, epViuda, epCapitan, epHulk, epBruja, epSpider;
    Button bGuardar, ebLimpiarcampos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        epIroman= (EditText) findViewById(R.id.epIroman);
        epViuda= (EditText) findViewById(R.id.epViuda);
        epCapitan= (EditText) findViewById(R.id.epCapitan);
        epHulk= (EditText) findViewById(R.id.epHulk);
        epBruja= (EditText) findViewById(R.id.epBruja);
        epSpider= (EditText) findViewById(R.id.epSpider);
        bGuardar= (Button) findViewById(R.id.bGuardar);
        ebLimpiarcampos= (Button) findViewById(R.id.ebLimp);



        Bundle extras =  getIntent().getExtras();

        epIroman.setText(String.valueOf(extras.getInt("pIroman")));
        epViuda.setText(String.valueOf(extras.getInt("pViuda")));
        epCapitan.setText(String.valueOf(extras.getInt("pCapitan")));
        epHulk.setText(String.valueOf(extras.getInt("pHulk")));
        epBruja.setText(String.valueOf(extras.getInt("pBruja")));
        epSpider.setText(String.valueOf(extras.getInt("pSpiderman")));


        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("npIron", epIroman.getText().toString());
                intent.putExtra("npViu", epViuda.getText().toString());
                intent.putExtra("npCap", epCapitan.getText().toString());
                intent.putExtra("npHu", epHulk.getText().toString());
                intent.putExtra("npBru", epBruja.getText().toString());
                intent.putExtra("npSpi", epSpider.getText().toString());
                setResult(RESULT_OK, intent);
                finish();


            }

        });
        ebLimpiarcampos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        epIroman.setText("");
        epViuda.setText("");
        epCapitan.setText("");
        epHulk.setText("");
        epBruja.setText("");
        epSpider.setText("");


    }
}
