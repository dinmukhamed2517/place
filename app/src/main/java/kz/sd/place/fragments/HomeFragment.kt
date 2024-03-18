package kz.sd.place.fragments

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kz.sd.place.R
import kz.sd.place.adapters.PlaceAdapter
import kz.sd.place.base.BaseFragment
import kz.sd.place.databinding.FragmentHomeBinding
import kz.sd.place.models.Place

class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        val adapter1 = PlaceAdapter()
        val adapter2 = PlaceAdapter()
        with(binding){
            recycler1.adapter =adapter1
            recycler1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            recycler2.adapter = adapter2
            recycler2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter1.submitList(getPlaces())
            adapter2.submitList(getPlaces())
        }
        adapter1.itemClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeToPlaceDetailsFragment(it))
        }
//        adapter2.itemClick = {
//            findNavController().navigate(HomeFragmentDirections.actionHomeToPlaceDetailsFragment(it))
//        }
    }

    fun getPlaces():List<Place>{
        return listOf(
            Place(1, "Medovic", "Cafe", 4.8, 5000, "Manasa 34/1", "11 restaurants", R.drawable.medovic),
            Place(2, "Del Papa", "Restaurant", 4.7 , 10000, "Manasa 34/1", "11 restaurants", R.drawable.del_papa),
            Place(3, "Aurora", "Restaurant", 4.6 , 10000, "Manasa 34/1", "11 restaurants", R.drawable.item_placeholder),

        )
    }

}