package mainactivity.franzfonseca.com.ex_sql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Ganancias extends AppCompatActivity {

    TextView ganancias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganancias);

        ganancias = (TextView) findViewById(R.id.ganancias);


    }
}
