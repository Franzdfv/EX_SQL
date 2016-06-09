package mainactivity.franzfonseca.com.ex_sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Inventario extends AppCompatActivity {
    TextView Inventario;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        Inventario = (TextView) findViewById(R.id.Inventario);

        UsuariosSQLiteHelper usuario = new UsuariosSQLiteHelper(this);
        db = usuario.getWritableDatabase();
        ver_Tabla();

    }

    private void ver_Tabla() {
        Cursor c =db.rawQuery("SELECT idpeluche, nombre, cantidad, valor FROM Usuarios", null);
        Inventario.setText("");
        if (c.moveToFirst()){
            do{
                String idpeluche = c.getString(0);
                String nombre = c.getString(1);
                int cantidad = c.getInt(2);
                int valor = c.getInt(3);
                Inventario.append(" "+idpeluche+" - "+nombre+" - "+cantidad+" - "+valor+"\n");

            }while (c.moveToNext());
        }
    }


}
