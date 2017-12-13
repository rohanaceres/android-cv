package rohanaceres.github.io.mycv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText

/**
 * Created by rohanaceres on 10/12/17.
 */

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val data = CrudBoladao.getLastRow(getApplicationContext())

        val graducao = findViewById<EditText>(R.id.editTextGraduation)
        graducao.setText(data.graduation)

        val pos = findViewById<EditText>(R.id.editTextMba)
        pos.setText(data.mba)

        val mestrado = findViewById<EditText>(R.id.editTextPhd)
        mestrado.setText(data.phd)

        val tempo = findViewById<EditText>(R.id.editTextCompanyTime)
        tempo.setText(data.companyTime)

        val cargo = findViewById<EditText>(R.id.editTextJobTitle)
        cargo.setText(data.jobTitle)

        val empresa = findViewById<EditText>(R.id.editTextCompanyName)
        empresa.setText(data.companyName)

        val nomeCurso = findViewById<EditText>(R.id.editTextCoursesTitle)
        nomeCurso.setText(data.courseTitle)

        val instituicao = findViewById<EditText>(R.id.editTextInstitution)
        instituicao.setText(data.institution)

        val cursoTempo = findViewById<EditText>(R.id.editTextCourseTime)
        cursoTempo.setText(data.courseTime)

        val dataT = findViewById<EditText>(R.id.editTextPublicationDate)
        dataT.setText(data.publicationDate)

        val descricao = findViewById<EditText>(R.id.editTextPublicationDescription)
        descricao.setText(data.publicationTitle)

    }
}