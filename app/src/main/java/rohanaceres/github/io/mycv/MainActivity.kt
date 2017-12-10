package rohanaceres.github.io.mycv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun nextForm(view: View) {
        val intent = Intent(this, Main2Activity::class.java)
        val nome = findViewById<EditText>(R.id.editTextNome)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val estado = findViewById<EditText>(R.id.editTextEstado)
        val cidade = findViewById<EditText>(R.id.editTextCidade)
        val telefone = findViewById<EditText>(R.id.editTextTelefone)

        if (!(nome.text.toString() == "" || email.text.toString() == "" || estado.text.toString() == "" || cidade.text.toString() == "" || telefone.text.toString() == "")) {
            val data = PersonalData.getInstance()
            data.name = nome.getText().toString()
            data.email = email.getText().toString()
            data.district  = estado.getText().toString()
            data.city  = cidade.getText().toString()
            data.phoneNumber = telefone.getText().toString()

            startActivity(intent)
        }
    }
}
