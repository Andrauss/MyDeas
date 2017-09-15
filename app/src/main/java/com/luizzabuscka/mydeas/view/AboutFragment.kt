package com.luizzabuscka.mydeas.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.extensions.putDropShadow
import kotlinx.android.synthetic.main.fragment_about.*


/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivThinking.putDropShadow()
        tvVersion.text = getString(R.string.app_version)+" "+activity.packageManager.getPackageInfo(activity.packageName, 0).versionName
    }

}// Required empty public constructor
