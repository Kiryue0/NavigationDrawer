package com.melih.navigationdraver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.melih.navigationdraver.databinding.ActivityMainBinding
import com.melih.navigationdraver.databinding.FragmentSecondBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navhostFragment = supportFragmentManager.findFragmentById(R.id.navhostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navigationView,navhostFragment.navController)
        binding.toolbar.title= "Başlık"
        val toogle = ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,0,0)
        binding.drawer.addDrawerListener(toogle)
        val baslik = binding.navigationView.inflateHeaderView(R.layout.nabigatin_baslik)

        toogle.syncState()
    }

    override fun onBackPressed() {
        if(binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }
}