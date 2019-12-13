package com.apps.airyrecipe.ui.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.apps.airyrecipe.R
import com.apps.airyrecipe.abstraction.base.BaseActivity
import com.apps.airyrecipe.abstraction.utils.ext.hide
import com.apps.airyrecipe.abstraction.utils.ext.toast
import com.apps.airyrecipe.abstraction.utils.state.LoaderState
import com.apps.airyrecipe.data.entity.Recipe
import com.apps.airyrecipe.ui.MainAdapter
import com.apps.airyrecipe.ui.MainModule
import com.apps.airyrecipe.ui.MainViewModel
import com.apps.neuronthings.di.dashboard.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity: BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    private var repoData = arrayListOf<Recipe>()
    private val adapter: MainAdapter by lazy {
        MainAdapter(repoData)
    }
    override fun contentView(): Int = R.layout.activity_main

    override fun initView() {
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(MainViewModel::class.java)

        uiList.setLayoutManager(GridLayoutManager(this, 2));
        uiList.adapter = adapter

        uiRefresh.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            uiRefresh.setRefreshing(false)
            viewModel.getRecipe()
        })
        viewModel.getRecipe()
        initObserver()
    }
    private fun initObserver() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is LoaderState.ShowLoading -> uiRefresh.setRefreshing(true)
                is LoaderState.HideLoading -> uiRefresh.setRefreshing(false)
            }
        })

        viewModel.repoData.observe(this, Observer { repo ->
            repoData.clear()
            repoData.addAll(repo)
            adapter.notifyDataSetChanged()
        })

        viewModel.error.observe(this, Observer { error ->
            toast(error)
            uiRefresh.hide()
        })
    }

    override fun initInjector() {
        DaggerHomeComponent.builder()
                .mainModule(MainModule(getApplicationContext()))
                .build()
                .inject(this)
    }
}