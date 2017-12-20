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
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE
import android.location.Address
import android.location.Geocoder
import android.widget.Toast
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.content_main.view.*
import java.io.IOException


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

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
        navigationView.setNavigationItemSelectedListener(this)

        val data = CrudBoladao.getLastRow(getApplicationContext())
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

        MobileAds.initialize(this, "ca-app-pub-9324256093642544~0987645453");
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
        nomeMenu.text = CrudBoladao.getLastRow(getApplicationContext()).name
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
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

        val name = findViewById<EditText>(R.id.editTextNome)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val district = findViewById<EditText>(R.id.editTextEstado)
        val city = findViewById<EditText>(R.id.editTextCidade)
        val phoneNumber = findViewById<EditText>(R.id.editTextTelefone)

        if (!(name.text.toString() == "" || email.text.toString() == "" || district.text.toString() == "" || city.text.toString() == "" ||
                phoneNumber.text.toString() == "")) {
            val data = PersonalData()

            data.name = name.text.toString()
            data.email = email.text.toString()
            data.district = district.text.toString()
            data.city = city.text.toString()
            data.phoneNumber = phoneNumber.text.toString()

            val sharedPref = getSharedPreferences("personalData", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.putString("name", data.name)
            editor.putString("email", data.email)
            editor.putString("district", data.district)
            editor.putString("city", data.city)
            editor.putString("phoneNumber", data.phoneNumber)
            editor.commit()

            startActivity(intent)
        }

        // String	message	= mMessageEditText.getText().toString();
        // intent.putExtra(EXTRA_MESSAGE,	message);
    }

    fun showMaps(view: View)
    {
        val intent = Intent(this, MapsActivity::class.java)

        val district = findViewById<EditText>(R.id.editTextEstado)

        try {
            val latLng = getLocationFromAddress(applicationContext, district.text.toString())

            val sharedPref = getSharedPreferences("latLng", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.putString("lat", latLng?.latitude.toString())
            editor.putString("lng", latLng?.longitude.toString())
            editor.commit()

            startActivity(intent)
        }
        catch (ex: Exception) {
            Toast.makeText(getApplicationContext(), "ENDEREÇO INVALIDO", Toast.LENGTH_LONG).show()
        }
    }

    fun getLocationFromAddress(context: Context, strAddress: String): LatLng? {

        val coder = Geocoder(context)
        val address: List<Address>?
        var p1: LatLng? = null

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5)
            if (address == null) {
                return null
            }
            val location = address[0]
            location.latitude
            location.longitude

            p1 = LatLng(location.latitude, location.longitude)

        } catch (ex: IOException) {

            ex.printStackTrace()
        }

        return p1
    }
}
