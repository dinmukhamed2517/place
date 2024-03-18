package kz.sd.place.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.sd.place.base.BasePlaceViewHolder
import kz.sd.place.databinding.ItemPlaceBinding
import kz.sd.place.models.Place

class PlaceAdapter: ListAdapter<Place, BasePlaceViewHolder<*>>(PlaceDiffUtils()) {

    var itemClick: ((Place) -> Unit)? = null

    class PlaceDiffUtils:DiffUtil.ItemCallback<Place>(){
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePlaceViewHolder<*> {
        return PlaceViewHolder(
            ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BasePlaceViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
    inner class PlaceViewHolder(binding:ItemPlaceBinding):BasePlaceViewHolder<ItemPlaceBinding>(binding){
        override fun bindView(item: Place) {
            with(binding){
                name.text = item.name
                description.text = item.description
                rating.text = item.rating.toString()
                img.setImageResource(item.img)
            }
            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }
        }
    }
}