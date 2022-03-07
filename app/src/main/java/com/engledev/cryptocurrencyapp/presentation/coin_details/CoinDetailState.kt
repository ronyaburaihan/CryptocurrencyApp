package com.engledev.cryptocurrencyapp.presentation.coin_details

import com.engledev.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
