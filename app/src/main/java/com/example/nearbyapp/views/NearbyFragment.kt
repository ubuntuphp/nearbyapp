package com.example.nearbyapp.views

import android.Manifest
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nearbyapp.R
import com.example.nearbyapp.viewmodel.NearbyViewModel


class NearbyFragment : Fragment()  {

    private lateinit var nearbyViewModel : NearbyViewModel
    private lateinit var nearbyRv : RecyclerView
    private lateinit var searchBar: EditText
    private lateinit var nearbyViewAdaptor: NearbyViewAdaptor


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nearby, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupVenuesRv()
        nearbyViewModel = ViewModelProvider(this)[NearbyViewModel::class.java]
        nearbyViewModel.venueLiveData.observe(viewLifecycleOwner){
            nearbyViewAdaptor.showData(it)
        }
        val location = getLocation()
        nearbyViewModel.fetchNearbyVenues("12.971599","77.594566","12mi")
        setupSearch()
    }

    private fun initViews(view: View){
        nearbyRv = view.findViewById(R.id.nearbyRv)
        searchBar = view.findViewById(R.id.searchEt)
    }

    private fun setupVenuesRv(){
        nearbyViewAdaptor = NearbyViewAdaptor()
        nearbyRv.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = nearbyViewAdaptor
        }
    }

    private fun getLocation() : Pair<String,String>{
        val locationManager = requireContext().getSystemService(LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return Pair("","")
        }
        val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        if (location != null) {
            return Pair(location.latitude.toString(),location.longitude.toString())
        }
        return Pair("","")
    }

    private fun setupSearch(){
       /* searchBar.addTextChangedListener {
            if(it?.isNotEmpty() == true) {
                if(::nearbyViewAdaptor.isInitialized)nearbyViewAdaptor.showData(nearbyViewModel.getFilteredDta(it.toString()))
            }else{
                if(::nearbyViewAdaptor.isInitialized)nearbyViewAdaptor.clearFilter()
            }
        }*/
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            NearbyFragment()
    }
}