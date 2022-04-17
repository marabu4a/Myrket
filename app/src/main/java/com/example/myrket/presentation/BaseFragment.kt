package com.example.myrket.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.viewbinding.ViewBinding
import com.example.myrket.R

abstract class BaseFragment <VB: ViewBinding>: Fragment() {

    private val navHostFragment by lazy {
        activity?.supportFragmentManager?.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
    }

    protected val navController by lazy {
        navHostFragment.navController
    }

    protected var binding: VB? = null

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    protected val navOptions = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(layoutInflater, container, false)
        return requireNotNull(binding).root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}