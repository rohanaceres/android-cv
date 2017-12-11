package rohanaceres.github.io.mycv

import android.content.ContentValues
import android.content.Context

/**
 * Created by rohanaceres on 10/12/17.
 */

class PersonalDataDao {
    val TableUsers = "users"
    var gw : DbGateway

    constructor(context : Context) {
        gw = DbGateway.getInstance(context)
    }


    fun save() : Boolean {
        val data = PersonalData.getInstance()
        var cv : ContentValues = ContentValues()
        cv.put("name", data.name)
        cv.put("email", data.email)
        cv.put("district", data.district)
        cv.put("city", data.city)
        cv.put("phoneNumber", data.phoneNumber)
        cv.put("graduation", data.graduation)
        cv.put("mba", data.mba)
        cv.put("phd", data.phd)
        cv.put("companyTime", data.companyTime)
        cv.put("companyName", data.companyName)
        cv.put("jobTitle", data.jobTitle)
        cv.put("courseTitle", data.courseTitle)
        cv.put("institution", data.institution)
        cv.put("courseTime", data.courseTime)
        cv.put("publicationDate", data.publicationDate)
        cv.put("publicationTitle", data.publicationTitle)


        return gw.database.insert(TableUsers, null, cv) > 0
    }
}