package com.example.damproject


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.damproject.Fragments.*
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private val qrFragment= QrFragment()
    private val productsFragment= ProductsFragment()
    //private val exampleFragment= ExampleFragment()
    private val clientsFragment= ClientsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Initialize()
    }

    //Remplazar el fragmento al cual se quiere ir
    private fun replaceFragment(frag: Fragment){
        if(frag!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,frag)
            transaction.commit()
        }
    }

    private fun Initialize(){
        //Inicializar el la navegación en el dashboard Fragment
        replaceFragment(clientsFragment)
        //Reemplazar el fragmento con uno nuevo
        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                //R.id.dashboar -> replaceFragment(dashboardFragment)
                R.id.products -> replaceFragment(productsFragment)
                R.id.qr_generate -> replaceFragment(qrFragment)
                R.id.client -> replaceFragment(clientsFragment)

            }
            true
        }
    }
}