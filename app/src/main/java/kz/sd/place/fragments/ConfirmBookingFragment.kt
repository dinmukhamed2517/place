package kz.sd.place.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.sd.place.base.BaseFragment
import kz.sd.place.databinding.FragmentConfirmBookingBinding

class ConfirmBookingFragment:BaseFragment<FragmentConfirmBookingBinding>(FragmentConfirmBookingBinding::inflate) {
    private val args: ConfirmBookingFragmentArgs by navArgs()
    override fun onBindView() {
        super.onBindView()
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        with(binding){
            address.text = args.confirmInfo.place.address
            deposit.text = args.confirmInfo.place.deposit.toString()+" KZT"
            time.text = args.confirmInfo.selectedTime
            date.text = args.confirmInfo.selectedDate
            guest.text = args.confirmInfo.numberOfGuests.toString()+ " guest"
            goToPayment.setOnClickListener {
                findNavController().navigate(ConfirmBookingFragmentDirections.actionConfirmBookingFragmentToPaymentFragment())
            }
        }
    }
}