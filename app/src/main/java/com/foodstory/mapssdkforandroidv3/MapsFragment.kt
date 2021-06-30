package com.foodstory.mapssdkforandroidv3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.libraries.maps.*
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null

    companion object {
        fun newInstance(): MapsFragment {
            val fragment = MapsFragment()
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
        return inflater.inflate(R.layout.fragment_maps, container, false)
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

        // Multicolored Polyline
        /*
        val line = googleMap.addPolyline(
            PolylineOptions()
                .add(
                    LatLng(13.792277383265722, 100.575979745895),
                    LatLng(13.791861823423291, 100.57609860230417),
                    LatLng(13.79202405939618, 100.57618560544084),
                    LatLng(13.792315403615532, 100.5763544636901),
                    LatLng(13.79282518717298, 100.5763526892593),
                    LatLng(13.792612992324402, 100.5761504508075),
                    LatLng(13.792479650981887, 100.57606645825722),
                    LatLng(13.792277383265722, 100.575979745895)
                )
                .addSpan(StyleSpan(Color.GRAY))
                .addSpan(StyleSpan(Color.CYAN))
                .addSpan(StyleSpan(Color.BLUE))
                .addSpan(StyleSpan(Color.GREEN))
                .addSpan(StyleSpan(Color.YELLOW))
                .addSpan(StyleSpan(Color.BLACK))
                .addSpan(StyleSpan(Color.RED))
        )
         */

        // Gradient Polyline
        /*
        val line = googleMap.addPolyline(
            PolylineOptions()
                .add(
                    LatLng(13.792277383265722, 100.575979745895),
                    LatLng(13.791861823423291, 100.57609860230417),
                    LatLng(13.79202405939618, 100.57618560544084),
                    LatLng(13.792315403615532, 100.5763544636901),
                    LatLng(13.79282518717298, 100.5763526892593),
                    LatLng(13.792612992324402, 100.5761504508075),
                    LatLng(13.792479650981887, 100.57606645825722),
                    LatLng(13.792277383265722, 100.575979745895)
                    )
                .addSpan(
                    StyleSpan(
                        StrokeStyle.gradientBuilder(
                            Color.RED,
                            Color.YELLOW
                        ).build()
                    )
                )
        )
         */

        // Stamped Polyline
        /*
        val stampStyle =
            TextureStyle.newBuilder(BitmapDescriptorFactory.fromResource(R.drawable.maps_icon_gmm))
                .build()
        val span = StyleSpan(StrokeStyle.colorBuilder(Color.BLACK).stamp(stampStyle).build())
        googleMap.addPolyline(
            PolylineOptions()
                .add(
                    LatLng(13.792277383265722, 100.575979745895),
                    LatLng(13.791861823423291, 100.57609860230417),
                    LatLng(13.79202405939618, 100.57618560544084),
                    LatLng(13.792315403615532, 100.5763544636901),
                    LatLng(13.79282518717298, 100.5763526892593),
                    LatLng(13.792612992324402, 100.5761504508075),
                    LatLng(13.792479650981887, 100.57606645825722),
                    LatLng(13.792277383265722, 100.575979745895)
                )
                .addSpan(span)
        )
         */
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Restore Instance (Fragment level's variables) State here
    }

}