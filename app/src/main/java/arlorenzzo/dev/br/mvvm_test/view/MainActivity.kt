package arlorenzzo.dev.br.mvvm_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import arlorenzzo.dev.br.mvvm_test.R
import arlorenzzo.dev.br.mvvm_test.databinding.ActivityMainBinding
import arlorenzzo.dev.br.mvvm_test.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this, {city ->
            binding.cityImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )
            binding.nameTv.text = city.name
            binding.populationTv.text = city.population.toString()
        })
    }
}