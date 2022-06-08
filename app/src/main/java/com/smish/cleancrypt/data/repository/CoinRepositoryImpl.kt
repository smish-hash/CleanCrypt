package com.smish.cleancrypt.data.repository

import com.smish.cleancrypt.data.remote.CoinPaprikaApi
import com.smish.cleancrypt.data.remote.dto.CoinDetailDto
import com.smish.cleancrypt.data.remote.dto.CoinDto
import com.smish.cleancrypt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}