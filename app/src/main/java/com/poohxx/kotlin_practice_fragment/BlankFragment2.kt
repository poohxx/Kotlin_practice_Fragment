package com.poohxx.kotlin_practice_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.poohxx.kotlin_practice_fragment.databinding.Fragment2Binding

class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag2.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })
        binding.btnSendToFrag.setOnClickListener {
            dataModel.messageForFrag1.value = "Message to  fragment 1 from Fragment 2"
        }
        binding.btnSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Message to  Activity from Fragment 2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =  BlankFragment2()}




}



