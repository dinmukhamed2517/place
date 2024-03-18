package kz.sd.place.base


import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.sd.place.models.Place

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

abstract class BasePlaceViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, Place>(binding)

