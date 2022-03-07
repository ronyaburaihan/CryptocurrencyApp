package com.engledev.cryptocurrencyapp.domain.use_case.get_coins

import com.engledev.cryptocurrencyapp.common.Resource
import com.engledev.cryptocurrencyapp.data.remote.dto.toCoin
import com.engledev.cryptocurrencyapp.domain.repository.CoinRepository
import com.engledev.cryptocurrencyapp.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}