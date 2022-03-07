package com.engledev.cryptocurrencyapp.domain.use_case.get_coin

import com.engledev.cryptocurrencyapp.common.Resource
import com.engledev.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.engledev.cryptocurrencyapp.domain.repository.CoinRepository
import com.engledev.cryptocurrencyapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection"))
        }
    }
}