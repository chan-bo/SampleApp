package com.chanbo.sampleapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.chanbo.sampleapp.BR
import com.chanbo.sampleapp.R
import com.chanbo.sampleapp.databinding.ActivityMainBinding
import com.chanbo.sampleapp.ui.base.BaseActivity
import com.chanbo.sampleapp.ui.toprated.TopRatedFragment
import com.chanbo.sampleapp.utils.clipToStatusBar
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
//
//    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun getLayoutId(): Int = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MainViewModel by viewModel()

    override fun onInitView(savedInstanceState: Bundle?) {

        toolbar.clipToStatusBar()

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Movie"

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, TopRatedFragment())
            .commit()
    }

    override fun subscriptLiveData() {

    }

}
