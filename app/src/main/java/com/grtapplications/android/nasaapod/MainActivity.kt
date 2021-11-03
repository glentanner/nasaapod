package com.grtapplications.android.nasaapod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.grtapplications.android.nasaapod.databinding.ActivityMainBinding
import com.grtapplications.android.nasaapod.ui.main.DetailFragment
import com.grtapplications.android.nasaapod.ui.main.MainFragment
import com.grtapplications.android.nasaapod.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.container)
            }
        }

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}