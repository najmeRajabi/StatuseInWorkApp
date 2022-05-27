package com.example.statuseinworkapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.statuseinworkapp.R
import com.example.statuseinworkapp.databinding.FragmentLoginBinding
import com.example.statuseinworkapp.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    val vModel: LoginViewModel by viewModel()
    lateinit var binding: FragmentLoginBinding
    lateinit var result: ApiStatus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login , container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnLogin.setOnClickListener {
            if (checkFiled()){
                vModel.getUser(
                    binding.edtId.text.toString(),
                    binding.edtPasswordLogin.text.toString().toInt()
                )
            }
        }
        vModel.loginStatus.observe(viewLifecycleOwner){

            if (it.isNotBlank()) Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            if (it == "Login successful") findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
        binding.txvGoToRegister.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun checkFiled(): Boolean {
        var result = false
        if (binding.edtId.text.isNullOrBlank()){
            binding.edtId.error = "please enter your id"
        }else if (binding.edtPasswordLogin.text.isNullOrBlank()){
            binding.edtPasswordLogin.error = "please enter your password"
        }else
            result = true
        return result
    }


}