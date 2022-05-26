package com.example.statuseinworkapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.statuseinworkapp.R
import com.example.statuseinworkapp.databinding.FragmentRegisterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment() {

    val vModel: UserViewModel by viewModel()
    lateinit var binding :FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_register, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            if (checked()){
//                vModel.register("ala","1231")
                register()
                binding.txvIdUser.text = vModel.user.value?.id
            }
        }


    }

    private fun checked(): Boolean {
        var result = false
        // todo check
        return true
    }

    fun register(){
        vModel.register(
            binding.edtName.toString(),
            binding.edtPassword.toString()
        )
    }

}