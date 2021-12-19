package com.poohxx.kotlin_practice_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.poohxx.kotlin_practice_fragment.databinding.Fragment1Binding

class BlankFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag1.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })
        binding.btnSendToFrag2.setOnClickListener{
            dataModel.messageForFrag2.value = "Message to  fragment 2 from Fragment 1"
        }
        binding.btnSendToActivity.setOnClickListener{
            dataModel.messageForActivity.value = "Message to Activity from Fragment 1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance()= BlankFragment()}
}