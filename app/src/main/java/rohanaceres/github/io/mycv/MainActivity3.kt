package rohanaceres.github.io.mycv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val data = PersonalData.getInstance()

        val nome = findViewById<TextView>(R.id.textViewNome)
        val email = findViewById<TextView>(R.id.textViewEmail)
        val estado = findViewById<TextView>(R.id.textViewEstado)
        val cidade = findViewById<TextView>(R.id.textViewCidade)
        val telefone = findViewById<TextView>(R.id.textViewTelefone)

        nome.text = data.name
        email.text = data.email
        estado.text = data.district
        cidade.text = data.city
        telefone.text = data.phoneNumber
    }
}