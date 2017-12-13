package rohanaceres.github.io.mycv

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.content.Intent
import android.view.View
import android.widget.Toast
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences



class MainActivity2 : AppCompatActivity() {

    val personalData : PersonalData = PersonalData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val data = CrudBoladao.getLastRow(getApplicationContext())

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

            personalData.graduation = graducao.text.toString()
            personalData.mba = pos.text.toString()
            personalData.phd = mestrado.text.toString()
            personalData.companyTime = tempoDeEmpresa.text.toString()
            personalData.companyName = empresa.text.toString()
            personalData.jobTitle = cargo.text.toString()
            personalData.courseTitle = curso.text.toString()
            personalData.institution = instituicao.text.toString()
            personalData.courseTime = tempoCurso.text.toString()
            personalData.publicationDate = publicacaoData.text.toString()
            personalData.publicationTitle = publicacaoDescricao.text.toString()

            val sharedPref = getSharedPreferences("personalData", Context.MODE_PRIVATE)

            personalData.name = sharedPref.getString("name", "")
            personalData.email = sharedPref.getString("email", "")
            personalData.district = sharedPref.getString("district", "")
            personalData.city = sharedPref.getString("city", "")
            personalData.phoneNumber = sharedPref.getString("phoneNumber", "")

            val personalDataDao = PersonalDataDao(baseContext)
            var success = personalDataDao.save(personalData)

            if (success) {
                Toast.makeText(getApplicationContext(), "Salvou!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(getApplicationContext(), "Falhou!", Toast.LENGTH_LONG).show()
            }

            startActivity(intent)
        }
    }
}