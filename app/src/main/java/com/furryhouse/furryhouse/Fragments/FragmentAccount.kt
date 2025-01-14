package com.furryhouse.furryhouse.Fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.furryhouse.furryhouse.OptionsLogin
import com.furryhouse.furryhouse.databinding.FragmentAccountBinding
import com.google.firebase.auth.FirebaseAuth

class FragmentAccount : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var  mContext: Context

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnLogOut.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(mContext, OptionsLogin::class.java))
            activity?.finishAffinity()
        }
    }
}