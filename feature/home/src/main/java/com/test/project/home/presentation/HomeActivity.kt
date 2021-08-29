package com.test.project.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import com.test.project.home.R
import com.test.project.home.databinding.HomeActivityBinding

class HomeActivity : AppCompatActivity() {

    /* */
    private val binding : HomeActivityBinding by lazy {
        HomeActivityBinding.inflate(layoutInflater)
    }

    /* */
    private lateinit var navController: NavController

    /* */
    private lateinit var navGraph: NavGraph

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpViews()
    }

    /** */
    private fun setUpViews() {
        navController = Navigation.findNavController(this, R.id.home_nav_host)
        navGraph = navController.navInflater.inflate(R.navigation.navigation_graph_home)
        navController.setGraph(navGraph, intent.extras)
    }

}