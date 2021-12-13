package com.example.damproject

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Linea para quitar la barra superior ActionBar//ToolBar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        setup()
    }
    private fun setup(){
        login_btn.setOnClickListener{
            //Si los campos usuario y contraseña no son vacíos entonces el usuario puede acceder el usuario y envíalo a la pantalla de inicio
            //Sino envía una alerta de que no se pudo autenticar
            if(user_field.text.isNotEmpty() && password_field.text.isNotEmpty()){
                //Linea para poder ingresar un usuario en Firebase
                FirebaseAuth.getInstance().signInWithEmailAndPassword(user_field.text.toString(),password_field.text.toString())
                    .addOnCompleteListener{
                        //Si es correcto envíalo a la pantalla de inicio
                        if(it.isSuccessful){
                            val homeIntent = Intent(this, HomeActivity::class.java)
                            startActivity(homeIntent)
                            finish()
                        }else{
                            //Función que muestra una alerta si no es correcto
                            showAlert()
                        }
                    }
            }else{
                //Función que muestra una alerta si no es correcto
                showAlert()
            }
        }
        sigin_btn.setOnClickListener {
            //Si los campos usuario y contraseña no son vacíos entonces registra el usuario y envíalo a la pantalla de inicio
            //Sino envía una alerta de que no se pudo autenticar
            if(user_field.text.isNotEmpty() && password_field.text.isNotEmpty()){
                //Linea para poder registrar un usuario en Firebase
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(user_field.text.toString(),password_field.text.toString())
                    .addOnCompleteListener{
                        //Si es correcto envíalo a la pantalla de inicio
                        if(it.isSuccessful){
                            val homeIntent = Intent(this, HomeActivity::class.java)
                            startActivity(homeIntent)
                            finish()
                        }else{
                            //Función que muestra una alerta si no es correcto
                            showAlert()
                        }
                    }
            }else{
                //Función que muestra una alerta si no es correcto
                showAlert()
            }
        }
    }

    private fun showAlert(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("¡¡ERROR!!")
        builder.setMessage("Se ha producido un error de autenticación")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }
}