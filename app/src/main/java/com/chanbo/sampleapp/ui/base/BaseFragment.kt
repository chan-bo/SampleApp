package com.chanbo.sampleapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private lateinit var mBinding: VB

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val bindingVariable: Int

    abstract val viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mBinding.setVariable(bindingVariable, viewModel)
        mBinding.executePendingBindings()
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitView(view, savedInstanceState)

        subscriptLiveData()
    }

    abstract fun onInitView(view: View, savedInstanceState: Bundle?)

    abstract fun subscriptLiveData()
}