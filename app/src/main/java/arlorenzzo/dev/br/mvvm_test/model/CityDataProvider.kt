package arlorenzzo.dev.br.mvvm_test.model

import arlorenzzo.dev.br.mvvm_test.R

class CityDataProvider {

    private val cities = arrayListOf<City>()

    init {
        cities.add(City("Bangkok", R.drawable.bangkok, 1_000))
        cities.add(City("Beijing", R.drawable.beijing, 5_000))
        cities.add(City("newyork", R.drawable.newyork, 10_000))
        cities.add(City("Paris", R.drawable.paris, 15_000))
        cities.add(City("Rome", R.drawable.rome, 20_000))
        cities.add(City("Tokyo", R.drawable.tokyo, 30_000))
    }

    fun getCities() = cities
}