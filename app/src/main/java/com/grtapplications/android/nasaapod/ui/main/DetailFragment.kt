package com.grtapplications.android.nasaapod.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.grtapplications.android.nasaapod.R
import com.grtapplications.android.nasaapod.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var viewModel: MainViewModel? = null
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        var mediaType = ""
        var url = ""
        var explanation = ""
        if (bundle != null) {
            mediaType = bundle.getString("media", "")
            url = bundle.getString("url", "")
            explanation = bundle.getString("explanation", "")
        }

        viewModel = activity?.run {
            ViewModelProvider(requireActivity())[MainViewModel::class.java]
        }
        viewModel?.dailyImages?.observe(viewLifecycleOwner, { dailyImages ->
            if (mediaType == "image") {
                binding.imageDetail.load(url) {
                    crossfade(100)
                }
            }
            else if (mediaType == "video") {
                val youtubeIntent = Intent(Intent.ACTION_VIEW)
                youtubeIntent.data = Uri.parse(url)
                startActivity(youtubeIntent)
            }
            else {
                binding.imageDetail.load(R.drawable.nasa) {
                    crossfade(100)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
