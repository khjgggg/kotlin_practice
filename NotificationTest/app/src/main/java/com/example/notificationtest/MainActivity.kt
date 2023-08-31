package com.example.notificationtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.notificationtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        checkPermission()

        binding.notificationButton.setOnClickListener {
            notification()
        }

        binding.radioGroup.setOnCheckedChangeListener { _, i ->
            onRadioButtonClicked(i)
        }

        //고화질 저화질
        //진동/소리 소리 진동 무음
        //30초 1분 2분 3분
    }

    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 26 버전 이상
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                //안드로이드 기본사운드
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        } else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }

        val bitmap = BitmapFactory.decodeResource(resources,R.drawable.board)
        val intent = Intent(this, SecondActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("새로운 알림입니다.")
            setContentText("알림이 잘 보이시나요.")
            setContentIntent(pendingIntent)
            priority = NotificationCompat.PRIORITY_HIGH
//            setStyle(
//                NotificationCompat.BigTextStyle()
//                    .bigText("이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.")
//            )
            setLargeIcon(bitmap)
            setStyle(NotificationCompat.BigPictureStyle()
                    .bigPicture(bitmap)
                    .bigLargeIcon(null))  // hide largeIcon while expanding
            addAction(R.mipmap.ic_launcher, "두번째 액티비티 가기", pendingIntent)
        }


        manager.notify(11, builder.build())
    }

    private val ACTIVITY_REQUEST_PERMISSION = 1

    private fun checkPermission() {
        val permissions = getPermissions()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissions(permissions, ACTIVITY_REQUEST_PERMISSION)
                return
            }
        }
    }

    private fun getPermissions(): Array<String> {
        val permissions = ArrayList<String>()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissions.add(android.Manifest.permission.POST_NOTIFICATIONS)
        }

        val arrPermission = arrayOfNulls<String>(permissions.size)
        return permissions.toArray(arrPermission)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.isEmpty()) {
            Toast.makeText(this, "권한 결과 데이타가 없음", Toast.LENGTH_SHORT).show()
            return
        }

        if (requestCode == ACTIVITY_REQUEST_PERMISSION) {
            var isGrantedNoti = false
            for (index in grantResults.indices) {
                if (permissions[index] == android.Manifest.permission.POST_NOTIFICATIONS
                    && grantResults[index] == PackageManager.PERMISSION_GRANTED
                ) {
                    isGrantedNoti = true
                }
            }

            if (!isGrantedNoti) {
                Toast.makeText(this, "알림 권한이 필요합니다. 설정에서 알림 권한을 켜주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun onRadioButtonClicked(checkId: Int) = when (checkId) {
        R.id.radioButton -> {
            binding.radioButton2.setBackgroundResource(R.drawable.selector_radio_button_last)
            binding.radioButton3.setBackgroundResource(R.drawable.selector_radio_button_last)
        }

        R.id.radioButton2 -> {
            binding.radioButton.setBackgroundResource(R.drawable.selector_radio_button_first)
            binding.radioButton3.setBackgroundResource(R.drawable.selector_radio_button_last)
        }

        R.id.radioButton3 -> {
            binding.radioButton.setBackgroundResource(R.drawable.selector_radio_button_first)
            binding.radioButton2.setBackgroundResource(R.drawable.selector_radio_button_first)
        }
        else -> {}
    }

}