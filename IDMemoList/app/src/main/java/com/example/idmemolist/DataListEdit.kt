package com.example.idmemolist

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.idmemolist.databinding.ActivityDataListEditBinding

class DataListEdit : AppCompatActivity() {

    val STORAGE_PERMISSION = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    val FLAG_PERM_STORAGE = 99
    val FLAG_REQ_GALLERY = 102

    private lateinit var binding: ActivityDataListEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataListEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.Modifypen.setOnClickListener{
            if (isPermitted(STORAGE_PERMISSION)) {
                openGallery()
                //권한이 있으면 갤러리 열기
            } else {
                ActivityCompat.requestPermissions(this, STORAGE_PERMISSION, FLAG_PERM_STORAGE)
                //권한이 없으면 요청
                //승인 거절 시 onRequestPermissionsResult함수 호출됨
            }
        }
    }
    fun isPermitted(permissions:Array<String>):Boolean{
        for(permission in permissions) {
            val result = ContextCompat.checkSelfPermission(this, permission)
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true

    }

    fun openGallery(){
        val intent= Intent(Intent.ACTION_PICK)
        intent.type= MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, FLAG_REQ_GALLERY)
        //onActivityResult 함수 호출됨
    }
    fun saveImageFile(){

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            //resultCode가 정상일 때만
            when(requestCode) {
                FLAG_REQ_GALLERY -> {
                    val uri=data?.data
                    binding.image.setImageURI(uri)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            FLAG_PERM_STORAGE->{
                var checked= true
                for(grant in grantResults){
                    if(grant!= PackageManager.PERMISSION_GRANTED){
                        checked= false
                        break
                        //하나라도 승인이 되어있지 않으면 갤러리를 열지 않는다

                    }
                }
                if(checked){
                    openGallery()
                }

            }
        }
    }
}