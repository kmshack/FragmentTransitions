package com.kmshack.example.fragmenttransitions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.children


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_grid.*

class MainActivity : AppCompatActivity() {

    var count = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(false)
                .replace(R.id.container, GridFragment.newInstance(count))
                .addToBackStack("detail")
                .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_more -> {
                if (count > 1) {
                    count--
                    supportFragmentManager.beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.container, GridFragment.newInstance(count))
                            .addToBackStack("detail")
                            .apply {
                                val topFragment: Int = supportFragmentManager.fragments.size
                                val fragment: GridFragment = supportFragmentManager.fragments[topFragment - 1] as GridFragment

                                val recyclerView: androidx.recyclerview.widget.RecyclerView = fragment.recyclerview

                                var viewCount = 0
                                for (itemView in recyclerView.children) {
                                    addSharedElement(itemView, viewCount.toString())
                                    viewCount++
                                }

                            }
                            .commit()
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
