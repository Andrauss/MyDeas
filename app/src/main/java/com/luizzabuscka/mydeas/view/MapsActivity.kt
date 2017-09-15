package com.luizzabuscka.mydeas.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.luizzabuscka.mydeas.R

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

  private lateinit var mMap: GoogleMap

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_maps)

    supportActionBar?.title = intent.extras.getString("title")

    val mapFragment = supportFragmentManager
        .findFragmentById(R.id.map) as SupportMapFragment
    mapFragment.getMapAsync(this)
  }

  override fun onMapReady(googleMap: GoogleMap) {
    mMap = googleMap

    // Add a marker in Sydney and move the camera
    val accelerator = LatLng(intent.extras.getDouble("lat"), intent.extras.getDouble("lon"))
    mMap.addMarker(MarkerOptions().position(accelerator).title(intent.extras.getString("title")))
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(accelerator, 17f))
  }
}
