package com.grtapplications.android.nasaapod.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.grtapplications.android.nasaapod.R
import com.grtapplications.android.nasaapod.data.DailyImage
import com.grtapplications.android.nasaapod.databinding.DailyImageItemBinding

class DailyImageAdapter(val items: List<DailyImage>, private val onItemClick: (DailyImage) -> Unit)
    : RecyclerView.Adapter<DailyImageAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: DailyImageItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    // Inflate the View of DailyImageItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DailyImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Bind the items with each item of the list to be shown in the recycler view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dailyImage = items[position]

        with(holder.binding) {
            // Load image
            // If the media_type is not an image (i.e. video), load placeholder image
            // TODO: Figure out how to load first frame of video using Coil
            if (dailyImage.media_type != "image") {
                image.load(R.drawable.nasa) {
                    crossfade(100)
                }
            }
            else {
                image.load(dailyImage.url) {
                    crossfade(100)
                }
            }
            // Load Text for the image title
            title.text = dailyImage.title
            title.contentDescription = dailyImage.title

            // Handle RecyclerView click
            holder.itemView.setOnClickListener {
                onItemClick(dailyImage)
            }
        }
    }

    // Return size of the DailyImage list
    override fun getItemCount(): Int {
        return items.size
    }
}