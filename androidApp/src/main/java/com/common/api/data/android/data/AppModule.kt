package com.common.api.data.android.data

import com.common.api.data.android.ui.screens.cat.CatViewModel
import com.common.api.data.android.ui.screens.post.PostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        PostViewModel(get())
    }
    viewModel {
        CatViewModel(get())
    }
}