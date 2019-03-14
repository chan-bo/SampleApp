package com.chanbo.sampleapp.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

abstract class BaseActivity<VB: ViewDataBinding, VM: BaseViewModel> : AppCompatActivity() {

    protected lateinit var mBinding: VB

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val bindingVariable: Int

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.setVariable(bindingVariable, viewModel)
        mBinding.executePendingBindings()
        onInitView(savedInstanceState)
        subscriptLiveData()
    }

    abstract fun onInitView(savedInstanceState: Bundle?)

    abstract fun subscriptLiveData()

}