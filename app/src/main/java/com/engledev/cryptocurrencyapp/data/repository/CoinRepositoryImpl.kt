package com.engledev.cryptocurrencyapp.data.repository

import com.engledev.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.engledev.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.engledev.cryptocurrencyapp.data.remote.dto.CoinDto
import com.engledev.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}