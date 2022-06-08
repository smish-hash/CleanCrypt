package com.smish.cleancrypt.domain.use_case.get_coins

import com.smish.cleancrypt.common.Resource
import com.smish.cleancrypt.data.remote.dto.toCoin
import com.smish.cleancrypt.domain.model.Coin
import com.smish.cleancrypt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpRetryException
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
             emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
         } catch (e: IOException) {
//             internet
             emit(Resource.Error(e.localizedMessage ?: "Internet problem"))
         }

     }
}