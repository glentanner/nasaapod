package com.grtapplications.android.nasaapod.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.grtapplications.android.nasaapod.LOG_TAG
import com.grtapplications.android.nasaapod.data.DailyImage
import com.grtapplications.android.nasaapod.databinding.FragmentMainBinding
import android.R
import androidx.fragment.app.FragmentTransaction


class MainFragment: Fragment() {

    private var viewModel: MainViewModel?= null
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val onItemClick: (DailyImage) -> Unit = { dailyImage ->
        Log.i(LOG_TAG, "the selected daily image: $dailyImage")
//        NavHostFragment.findNavController(this).navigate(R.id.action_mainFragment_to_detailFragment)
//        //findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
//        val navHostFragment = childFragmentManager.findFragmentById(R.id.container) as NavHostFragment
//        val navController = navHostFragment.navController
//        navController.navigate(R.id.action_mainFragment_to_detailFragment)
        val detail: Fragment = DetailFragment()

        val arguments = Bundle()
        arguments.putString("media", dailyImage.media_type)
        arguments.putString("url", dailyImage.url)
        arguments.putString("explanation", dailyImage.explanation)
        detail.arguments = arguments

        val transaction: Int? =
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(com.grtapplications.android.nasaapod.R.id.container, detail)
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN )
                ?.addToBackStack(null )
                ?.commit( )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(requireActivity())[MainViewModel::class.java]
        }

        viewModel?.dailyImages?.observe(viewLifecycleOwner, { dailyImages ->
            // Attach the Adapter to the RecyclerView
            binding.dailyImageList.adapter = DailyImageAdapter(dailyImages, onItemClick)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
