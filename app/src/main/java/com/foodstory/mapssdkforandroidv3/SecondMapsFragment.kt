package com.foodstory.mapssdkforandroidv3

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.OnMapReadyCallback
import com.google.android.libraries.maps.SupportMapFragment
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.Marker
import com.google.android.libraries.maps.model.MarkerOptions

class SecondMapsFragment : Fragment(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null

    companion object {
        fun newInstance(): SecondMapsFragment {
            val fragment = SecondMapsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance(view, savedInstanceState)
    }

    private fun initInstance(view: View, savedInstanceState: Bundle?) {
        initGoogleMap()
    }

    private fun initGoogleMap() {

        val getMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        getMapFragment?.let { mapFragment: SupportMapFragment ->
            mapFragment.getMapAsync { googleMap: GoogleMap ->
                // Google Maps is ready
                onMapReady(googleMap)
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        // Setup the Google Map

        // add zoom control
        googleMap.uiSettings.isZoomControlsEnabled = true

        // set my location
        googleMap.isMyLocationEnabled = true

        // Add Marker
        val livingMobile = LatLng(13.792294815247505, 100.57611607958073)
        googleMap.addMarker(
            MarkerOptions()
                .position(livingMobile)
                .title("This marker is LivingMobile")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(livingMobile))

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Restore Instance (Fragment level's variables) State here
    }

}