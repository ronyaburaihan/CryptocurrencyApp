package com.engledev.cryptocurrencyapp.domain.repository

import com.engledev.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.engledev.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}