package com.example.android2

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.Image
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.android2.databinding.ActivityMainBinding
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    val CAMERA_PERMISSION = arrayOf(android.Manifest.permission.CAMERA)
    val STORAGE_PERMISSION = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    val FLAG_PERM_CAMERA=98
    val FLAG_PERM_STORAGE=99

    val FLAG_REQ_CAMERA=101
    val FLAG_REQ_GALLERY=102

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonCamera.setOnClickListener {
            if (isPermitted(CAMERA_PERMISSION)) {
                //카메라 호출 전 권한 체크
                openCamera()
                    //있다면 카메라 열기
            }
            else{
                ActivityCompat.requestPermissions(this, CAMERA_PERMISSION, FLAG_PERM_CAMERA)
                //없다면 권한 요청
            }

        }
        binding.buttonGallery.setOnClickListener {
            if(isPermitted((STORAGE_PERMISSION))){
                openGallery()
            }else{
                ActivityCompat.requestPermissions(this, STORAGE_PERMISSION, FLAG_PERM_STORAGE)
            }
        }

    }

    fun isPermitted(permissions: Array<String>): Boolean {
        //권한 체크 함수
        for (permission in permissions) {
            val result = ContextCompat.checkSelfPermission(this, permission)
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    fun openCamera(){
        val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,FLAG_REQ_CAMERA )
    }
    fun openGallery(){
        val intent=Intent(Intent.ACTION_PICK)//파일 선택창을 열어줌
        intent.type=MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, FLAG_REQ_GALLERY )
    }

    fun saveImageFile(filename:String, mimeType:String, bitmap:Bitmap): Uri?{
        var values=ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME,filename)
        values.put(MediaStore.Images.Media.MIME_TYPE,mimeType)

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
            values.put(MediaStore.Images.Media.IS_PENDING,1)
        }
        val uri=contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
        //내가 저장할 사진의 주소값을 지정

        try {
            if (uri != null) {
                var descriptor = contentResolver.openFileDescriptor(uri, "w")
                //null이 아닐 때 파일을 열겠다
                if (descriptor != null) {
                    val fos = FileOutputStream(descriptor.fileDescriptor)
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                    //bitmap을 JPEG로 압축
                    fos.close()
                    return uri
                }
            }
        } catch(e:Exception){
            Log.e("Camera","${e.localizedMessage}")
        }
        return null
    }
    //파일 저장

    fun newFileName(): String{
        val sdf=SimpleDateFormat("yyyyMMdd_HHmmss")
        val filename=sdf.format(System.currentTimeMillis())
        return filename
    }
    //파일 이름 설정

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK)
        when(requestCode){
            FLAG_REQ_CAMERA->{
                //
                if(data?.extras?.get("data")!=null) {
                    //data에 값이 있다면
                    val bitmap = data?.extras?.get("data") as Bitmap
                    //
                    val filename = newFileName()
                    val uri = saveImageFile(filename, "image/jpg", bitmap)
                    binding.imagePreview.setImageURI(uri)
                }
            }
            FLAG_REQ_GALLERY->{
                val uri=data?.data
                binding.imagePreview.setImageURI(uri)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode){
            FLAG_PERM_CAMERA->{
                var checked= true
                for(grant in grantResults){
                    if(grant !=PackageManager.PERMISSION_GRANTED){
                        checked =false
                        break
                        //하나라도 승인이 되지 않았으면 카메라를 열지 않는다
                    }
                }
                if(checked){
                    openCamera()
                }
            }
        }
    }
}