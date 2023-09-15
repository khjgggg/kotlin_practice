package com.example.a12_miseya.retrofit

import com.example.a12_miseya.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetWorkClient {
    private const val DUST_BASE_URL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/"
    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        // 디버그 모드에서는 HTTP 요청 및 응답 내용을 로그에 출력
        if (BuildConfig.DEBUG)
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        else
            interceptor.level = HttpLoggingInterceptor.Level.NONE

        // OkHttpClient를 생성하고 설정을 추가
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .build()
    }
    //Retrofit 인스턴스를 생성하여 서버와 통신하는 API 요청을 만든다.
    private val dustRetrofit = Retrofit.Builder()//Retrofit을 설정하기 위한 빌더 객체를 생성. 이 객체를 사용하여 API와의 통신을 설정
        .baseUrl(DUST_BASE_URL)// 서버의 기본 URL을 설정
        .addConverterFactory(GsonConverterFactory.create())//JSON데이터를 파싱하기 위한 컨버트 팩토리(Gson)설정
        .client(createOkHttpClient())// OkHttpClient를 설정
        .build()
    // Retrofit을 사용하여 서버와 통신하는 인터페이스를 생성
    val dustNetWork: NetWorkInterface = dustRetrofit.create(NetWorkInterface::class.java)
}