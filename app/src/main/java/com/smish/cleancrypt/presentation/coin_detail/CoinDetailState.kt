package com.smish.cleancrypt.presentation.coin_detail

import com.smish.cleancrypt.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
