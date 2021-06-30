package com.foodstory.mapssdkforandroidv3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.libraries.maps.GoogleMapOptions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.maps, SecondMapsFragment.newInstance()
                )
                .commit()
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            btnStyle1 -> {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.maps, MapsFragment.newInstance()
                    )
                    .commit()
            }

            btnStyle2 -> {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.maps, SecondMapsFragment.newInstance()
                    )
                    .commit()
            }

            btnStyle3 -> {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.maps, ThirdMapsFragment.newInstance()
                    )
                    .commit()
            }
        }
    }
}