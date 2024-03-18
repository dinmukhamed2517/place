package kz.sd.place.fragments

import androidx.navigation.fragment.findNavController
import kz.sd.place.R
import kz.sd.place.base.BaseFragment
import kz.sd.place.databinding.FragmentLoginBinding

class LoginFragment:BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        with(binding){
            noAccountBtn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_loginFragment_to_signUpFragment
                )
            }
        }
    }

}