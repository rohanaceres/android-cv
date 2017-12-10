package rohanaceres.github.io.mycv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(onNavigationItemSelected)

        val data = PersonalData.getInstance()
        val nome = findViewById<EditText>(R.id.editTextNome)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val estado = findViewById<EditText>(R.id.editTextEstado)
        val cidade = findViewById<EditText>(R.id.editTextCidade)
        val telefone = findViewById<EditText>(R.id.editTextTelefone)

        nome.setText(data.name)
        email.setText(data.email)
        estado.setText(data.district)
        cidade.setText(data.city)
        telefone.setText(data.phoneNumber)
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        val nomeMenu = findViewById<TextView>(R.id.textViewNomeMenu)
        nomeMenu.text = PersonalData.getInstance().name
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return super.onOptionsItemSelected(item)
    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.personalInfo) {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        } else if (id == R.id.other) {
            // TODO
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun nextForm(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        val nome = findViewById<EditText>(R.id.editTextNome)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val estado = findViewById<EditText>(R.id.editTextEstado)
        val cidade = findViewById<EditText>(R.id.editTextCidade)
        val telefone = findViewById<EditText>(R.id.editTextTelefone)

        if (nome.text.toString() == "" || email.text.toString() == "" || estado.text.toString() == "" || cidade.text.toString() == "" || telefone.text.toString() == "") {

        } else {
            val data = PersonalData.getInstance()
            data.name = nome.text.toString()
            data.email = email.text.toString()
            data.district = estado.text.toString()
            data.city = cidade.text.toString()
            data.phoneNumber = telefone.text.toString()

            startActivity(intent)
        }

        // String	message	= mMessageEditText.getText().toString();
        // intent.putExtra(EXTRA_MESSAGE,	message);
    }
}
