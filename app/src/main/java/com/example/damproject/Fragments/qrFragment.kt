package com.example.damproject.Fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.camera2.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.damproject.R
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import kotlinx.android.synthetic.main.fragment_qr.*

class QrFragment : Fragment() {

    var isFlash = false
    var isOn = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {// Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_qr, container, false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var result: IntentResult=IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result!=null){
            if(result.contents==null){
                Toast.makeText(activity,"Lectura cancelada",Toast.LENGTH_LONG)
            }else{
                Toast.makeText(activity,result.contents,Toast.LENGTH_LONG)
                text.setText(result.contents)
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(activity,"Entré",Toast.LENGTH_SHORT)
/*        leer_qr.setOnClickListener {
            var integrador:IntentIntegrator=IntentIntegrator(activity)
            integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
            integrador.setPrompt("Lector-CDP")
            integrador.setCameraId(0)
            integrador.setBeepEnabled(true)
            integrador.setBarcodeImageEnabled(true)
            integrador.initiateScan()
        }
        initFlash()
        flash.setOnClickListener {
            Toast.makeText(activity,"Entré",Toast.LENGTH_SHORT)
        }
        leer_qr.setOnClickListener {
            Toast.makeText(activity,"Entré a leer",Toast.LENGTH_SHORT)
        }*/
    }

    private fun initFlash(){
        var hasCameraFlash=activity?.packageManager?.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
        flash.setOnClickListener {
            if(isFlash){
                Toast.makeText(activity,"Entré al primer if",Toast.LENGTH_SHORT)
                if (isOn){
                    Toast.makeText(activity,"Entré al segundo if",Toast.LENGTH_SHORT)
                    isOn=false
                    flash.setBackgroundResource(R.drawable.flash_off)
                    flashLightOff()
                }else{
                    isOn=true
                    flash.setBackgroundResource(R.drawable.flash_on)
                    flashLightOn()
                }
            }else{
                Toast.makeText(activity,"No flash available in your device",Toast.LENGTH_SHORT)
            }
        }
    }

    private fun flashLightOn(){
        //https://developer.android.com/reference/kotlin/android/hardware/camera2/CameraManager#getcameraidlist
        val cameraManager= activity?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId=cameraManager.cameraIdList
        cameraManager.setTorchMode(cameraId.toString(),true)
        Toast.makeText(activity,"Flash On",Toast.LENGTH_SHORT)
    }

    private fun flashLightOff(){
        val cameraManager= activity?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId=cameraManager.cameraIdList
        cameraManager.setTorchMode(cameraId.toString(),false)
        Toast.makeText(activity,"Flash Off",Toast.LENGTH_SHORT)
    }


 }




