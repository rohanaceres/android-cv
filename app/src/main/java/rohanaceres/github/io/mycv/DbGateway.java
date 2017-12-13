package rohanaceres.github.io.mycv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rohanaceres on 11/12/17.
 */

public class DbGateway {
    private static DbGateway gw;
    private SQLiteDatabase db;

    private DbGateway(Context ctx) {
        CrudBoladaoHelper helper = new CrudBoladaoHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context ctx) {
        if (gw == null && ctx != null) {
            gw = new DbGateway(ctx);
        }

        return gw;
    }
    public SQLiteDatabase getDatabase() {
        return db;
    }


}
