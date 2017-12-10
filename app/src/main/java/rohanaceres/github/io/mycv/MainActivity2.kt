package rohanaceres.github.io.mycv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.content.Intent
import android.view.View
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val data = PersonalData.getInstance()

        val graducao = findViewById<EditText>(R.id.editTextGraduation)
        graducao.setText(data.graduation)

        val pos = findViewById<EditText>(R.id.editTextMba)
        pos.setText(data.mba)

        val mestrado = findViewById<EditText>(R.id.editTextPhd)
        mestrado.setText(data.phd)

        val empresa = findViewById<EditText>(R.id.editTextCompanyName)
        empresa.setText(data.companyName)

        val tempoEmpresa = findViewById<EditText>(R.id.editTextCompanyTime)
        tempoEmpresa.setText(data.companyTime)

        val cargo = findViewById<EditText>(R.id.editTextJobTitle)
        cargo.setText(data.jobTitle)

        val curso = findViewById<EditText>(R.id.editTextCoursesTitle)
        curso.setText(data.courseTitle)

        val instituicao = findViewById<EditText>(R.id.editTextInstitution)
        instituicao.setText(data.institution)

        val tempoCurso = findViewById<EditText>(R.id.editTextCourseTime)
        tempoCurso.setText(data.courseTime)

        val publicacaoData = findViewById<EditText>(R.id.editTextPublicationDate)
        publicacaoData.setText(data.publicationDate)

        val publicacaoDescricao = findViewById<EditText>(R.id.editTextPublicationDescription)
        publicacaoDescricao.setText(data.publicationTitle)
    }

    fun save(view: View) {
        Toast.makeText(getApplicationContext(), "TESTANDO1", Toast.LENGTH_SHORT)

        val intent = Intent(this, MainActivity::class.java)

        val graducao = findViewById<EditText>(R.id.editTextGraduation)
        val pos = findViewById<EditText>(R.id.editTextMba)
        val mestrado = findViewById<EditText>(R.id.editTextPhd)

        val tempoDeEmpresa = findViewById<EditText>(R.id.editTextCompanyTime)
        val empresa = findViewById<EditText>(R.id.editTextCompanyName)
        val cargo = findViewById<EditText>(R.id.editTextJobTitle)

        val curso = findViewById<EditText>(R.id.editTextCoursesTitle)
        val instituicao = findViewById<EditText>(R.id.editTextInstitution)
        val tempoCurso = findViewById<EditText>(R.id.editTextCourseTime)

        val publicacaoData = findViewById<EditText>(R.id.editTextPublicationDate)
        val publicacaoDescricao = findViewById<EditText>(R.id.editTextPublicationDescription)

        Toast.makeText(getApplicationContext(), "TESTANDO2", Toast.LENGTH_SHORT)

        if (!(graducao.text.toString() == "" ||
                pos.text.toString() == "" ||
                mestrado.text.toString() == "" ||
                tempoDeEmpresa.text.toString() == "" ||
                empresa.text.toString() == "" ||

                cargo.text.toString() == "" ||
                curso.text.toString() == "" ||
                instituicao.text.toString() == "" ||
                tempoCurso.text.toString() == "" ||
                publicacaoData.text.toString() == "" ||
                publicacaoDescricao.text.toString() == "")) {

            val data = PersonalData.getInstance()

            data.graduation = graducao.text.toString()
            data.mba = pos.text.toString()
            data.phd = mestrado.text.toString()
            data.companyTime = tempoDeEmpresa.text.toString()
            data.companyName = empresa.text.toString()
            data.jobTitle = cargo.text.toString()
            data.courseTitle = curso.text.toString()
            data.institution = instituicao.text.toString()
            data.courseTime = tempoCurso.text.toString()
            data.publicationDate = publicacaoData.text.toString()
            data.publicationTitle = publicacaoDescricao.text.toString()

            startActivity(intent)
        }
    }
}