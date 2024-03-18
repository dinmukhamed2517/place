package kz.sd.place.fragments

import androidx.navigation.fragment.findNavController
import kz.sd.place.R
import kz.sd.place.base.BaseFragment
import kz.sd.place.databinding.FragmentSignUpBinding

class SignUpFragment:BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        with(binding){
            findNavController().navigate(
                R.id.action_signUpFragment_to_loginFragment
            )
        }
    }

}