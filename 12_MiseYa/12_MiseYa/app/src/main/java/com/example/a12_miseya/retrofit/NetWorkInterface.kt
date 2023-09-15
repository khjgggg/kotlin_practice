package com.example.a12_miseya.retrofit

import com.example.a12_miseya.data.Dust
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface NetWorkInterface {
    @GET("getCtprvnRltmMesureDnsty")// 시도별 실시간 측정정보 조회 주소
    // 위의 URL 주소로 GET 요청을 보내는 메서드입니다.
    // 시도별 실시간 미세먼지 측정 정보를 조회하기 위한 API 요청입니다.
    suspend fun getDust(@QueryMap param: HashMap<String, String>): Dust
    // getDust 메서드는 코루틴 내에서 호출되며, 미세먼지 데이터를 가져오기 위해 API 요청을 수행합니다.
    // 요청을 보내고 서버로부터 응답을 받으면, 그 응답을 Dust 객체로 파싱하여 반환합니다.
    @POST
    suspend fun postDust(@Body param: HashMap<String, String>): Dust
    // POST 요청은 서버로 데이터를 전송하기 위해 사용됩니다. @Body 어노테이션을 사용하여 요청 본문에 데이터를 담을 수 있다.
    // POST 요청을 보내고 서버로부터 응답을 받으면, 그 응답을 Dust 객체로 파싱하여 반환합니다.
}