package com.smish.cleancrypt.domain.use_case.get_coin

import com.smish.cleancrypt.common.Resource
import com.smish.cleancrypt.data.remote.dto.toCoin
import com.smish.cleancrypt.data.remote.dto.toCoinDetail
import com.smish.cleancrypt.domain.model.Coin
import com.smish.cleancrypt.domain.model.CoinDetail
import com.smish.cleancrypt.domain.repository.CoinRepository
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
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
//             internet
            emit(Resource.Error(e.localizedMessage ?: "Internet problem"))
        }

    }
}