package rohanaceres.github.io.mycv

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context

/**
 * Created by rohanaceres on 10/12/17.
 */

class CrudBoladaoHelper : SQLiteOpenHelper {

    val CreateTable: String = "CREATE TABLE users (id int primary key autoincrement, name text, email text, district text, city text, phoneNumber text, graduation text, mba text, phd text, companyTime text, companyName text, jobTitle text, courseTitle text, institution text, courseTime, publicationDate, publicationTitle);"

    constructor(context : Context) : super(context, "dbbolado.db", null, 1) { }

    override fun onCreate(p0: SQLiteDatabase?) {
        this.writableDatabase.execSQL(CreateTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // Does nothing.
    }

}