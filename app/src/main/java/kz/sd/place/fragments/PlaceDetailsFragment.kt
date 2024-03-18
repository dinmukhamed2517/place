package kz.sd.place.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.sd.place.R
import kz.sd.place.base.BaseFragment
import kz.sd.place.databinding.FragmentPlaceDetailsBinding

class PlaceDetailsFragment:BaseFragment<FragmentPlaceDetailsBinding>(FragmentPlaceDetailsBinding::inflate) {

    private val args: PlaceDetailsFragmentArgs by navArgs()
    override fun onBindView() {
        super.onBindView()
        val place = args.place
        with(binding){
            name.text = place.name
            type.text = place.type
            rating.text = place.rating.toString()
            address.text = place.address
            deposit.text = place.deposit.toString()+" KZT"
            imageView2.setImageResource(place.img)
            backBtn.setOnClickListener{
                findNavController().popBackStack()
            }
            bookTableBtn.setOnClickListener {
                findNavController().navigate(PlaceDetailsFragmentDirections.actionPlaceDetailsFragmentToBookTableFragment(place))
            }
        }
    }

}