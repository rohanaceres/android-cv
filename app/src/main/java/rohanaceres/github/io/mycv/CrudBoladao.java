package rohanaceres.github.io.mycv;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rohanaceres on 12/12/17.
 */

public class CrudBoladao {
    public static PersonalData getLastRow(Context context) {
        DbGateway dw = DbGateway.getInstance(context);

        if (dw == null) { return new PersonalData(); }

        SQLiteDatabase db = dw.getDatabase();

        if (db == null) { return new PersonalData(); }

        Cursor cursor = db.rawQuery("select * from users ORDER BY Id DESC LIMIT 1", null);

        PersonalData personalData = new PersonalData();

        if (cursor.moveToNext()) {
            personalData.setName(cursor.getString(cursor.getColumnIndex("name")));
            personalData.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            personalData.setDistrict(cursor.getString(cursor.getColumnIndex("district")));
            personalData.setCity(cursor.getString(cursor.getColumnIndex("city")));
            personalData.setPhoneNumber(cursor.getString(cursor.getColumnIndex("phoneNumber")));
            personalData.setGraduation(cursor.getString(cursor.getColumnIndex("graduation")));
            personalData.setMba(cursor.getString(cursor.getColumnIndex("mba")));
            personalData.setPhd(cursor.getString(cursor.getColumnIndex("phd")));
            personalData.setCompanyTime(cursor.getString(cursor.getColumnIndex("companyTime")));
            personalData.setCompanyName(cursor.getString(cursor.getColumnIndex("companyName")));
            personalData.setJobTitle(cursor.getString(cursor.getColumnIndex("jobTitle")));
            personalData.setCourseTitle(cursor.getString(cursor.getColumnIndex("courseTitle")));
            personalData.setInstitution(cursor.getString(cursor.getColumnIndex("institution")));
            personalData.setCourseTime(cursor.getString(cursor.getColumnIndex("courseTime")));
            personalData.setPublicationDate(cursor.getString(cursor.getColumnIndex("publicationDate")));
            personalData.setPublicationTitle(cursor.getString(cursor.getColumnIndex("publicationTitle")));
        }

        cursor.close();

        return personalData;
    }
}
