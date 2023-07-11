package com.example.scribebird

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.scribebird.presentation.fragment.NoteViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigateMenuInit()
        viewModel = NoteViewModel(application)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        return super.onCreateView(name, context, attrs)
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            val int: Int = viewModel.readAllData.first().size
            println("!!!!!!!!!!!!!${int}")
        }
    }

    private fun bottomNavigateMenuInit() {

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        val navController = findNavController(R.id.fragmentContainerView)

        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.bottomNavigationView)
        return navController.navigateUp()
    }
}