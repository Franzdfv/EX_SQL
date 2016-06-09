package mainactivity.franzfonseca.com.ex_sql;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button bingresar, bactualizar, bconsultar, bborrar;
    EditText ecantidad, enombre, eidpeluche, evalor;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bingresar = (Button) findViewById(R.id.binsertar);
        bactualizar = (Button) findViewById(R.id.bactualizar);
        bconsultar = (Button) findViewById(R.id.bbuscar);
        bborrar = (Button) findViewById(R.id.beliminar);

        ecantidad = (EditText) findViewById(R.id.ecantidad);
        enombre = (EditText) findViewById(R.id.enombre);
        eidpeluche = (EditText) findViewById(R.id.eidpeluche);
        evalor = (EditText) findViewById(R.id.evalor);
        resultado = (TextView) findViewById(R.id.resultado);

        UsuariosSQLiteHelper usuario = new UsuariosSQLiteHelper(this);
        db = usuario.getWritableDatabase();
        ver_Tabla();

        bingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = enombre.getText().toString();
                String cantidad = ecantidad.getText().toString();
                String valor = evalor.getText().toString();

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nombre);
                nuevoRegistro.put("cantidad", cantidad);
                nuevoRegistro.put("valor", valor);
                db.insert("Usuarios", null, nuevoRegistro);
                ver_Tabla();

            }
        });

        bactualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = enombre.getText().toString();
                String cantidad = ecantidad.getText().toString();
                String valor = evalor.getText().toString();
                String idpeluche = eidpeluche.getText().toString();

                ContentValues nuevoRegistro = new ContentValues();
                nuevoRegistro.put("nombre", nombre);
                nuevoRegistro.put("cantidad", cantidad);
                nuevoRegistro.put("valor", valor);
                nuevoRegistro.put("idepeluche", idpeluche);

                db.update("Usuarios", nuevoRegistro, "idpeluche=" + idpeluche, null);
                ver_Tabla();

            }
        });

        bborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idpeluche = eidpeluche.getText().toString();
                db.delete("Usuarios", "idpeluche=" + idpeluche, null);
                ver_Tabla();

            }
        });

        bconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = enombre.getText().toString();
                String cantidad = ecantidad.getText().toString();
                String valor = evalor.getText().toString();
                String idpeluche = eidpeluche.getText().toString();

                String[] campos = new String[]{"idpeluche", "nombre", "cantidad", "valor"};
                String[] args = new String[]{nombre};

                Cursor c = db.query("Usuarios", campos, "nombre=?", args, null, null, null);
                if (c.moveToFirst()) {
                    resultado.setText("");

                    do {
                        String code = c.getString(0);
                        String name = c.getString(1);
                        int cant = c.getInt(2);
                        int val = c.getInt(3);

                        resultado.append(" " + code + " - " + name + " - " + cant + " - " + val + "\n");

                    } while (c.moveToNext());


                }
                //ver_Tabla();
            }
        });
        findViewById(R.id.bventa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ventas.class));
            }
        });
        findViewById(R.id.binventario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Inventario.class));
            }
        });
        findViewById(R.id.bganancias).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Ganancias.class));
            }
        });



    }

    protected void ver_Tabla(){
        Cursor c =db.rawQuery("SELECT idpeluche, nombre, cantidad, valor FROM Usuarios", null);
        resultado.setText("");
        if (c.moveToFirst()){
            do{
                String idpeluche = c.getString(0);
                String nombre = c.getString(1);
                int cantidad = c.getInt(2);
                int valor = c.getInt(3);
                resultado.append(" "+idpeluche+" - "+nombre+" - "+cantidad+" - "+valor+"\n");

            }while (c.moveToNext());
        }
    }
}
