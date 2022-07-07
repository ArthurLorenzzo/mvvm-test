package arlorenzzo.dev.br.mvvm_test.viewmodel

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arlorenzzo.dev.br.mvvm_test.model.City
import arlorenzzo.dev.br.mvvm_test.model.CityDataProvider
import java.util.logging.Handler

class CityViewModel: ViewModel() {

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 3000L

    init {
        updateCity()
    }

    fun getCityData(): LiveData<City> = cityData

    private fun loop(){
       android.os.Handler(Looper.getMainLooper()).postDelayed({updateCity()}, delay)
    }

    private fun updateCity(){
        currentIndex++
        currentIndex %= cities.size

        cityData.value = cities[currentIndex]

       loop()
    }
}