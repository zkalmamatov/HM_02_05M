package kg.less.hm_02_05m

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {

    val api: LoveApiService = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(LoveApiService::class.java)
}