package mainactivity.franzfonseca.com.ex_sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FRANZ on 3/05/2016.
 */
public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME= "Usuarios";
    private static final int DATA_VERSION=20;

    String sqlCreate = "CREATE TABLE Usuarios (idpeluche  INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, cantidad INTEGER, valor INTEGER)";

    public UsuariosSQLiteHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXCIST Usuarios");
        db.execSQL(sqlCreate);

    }
}
