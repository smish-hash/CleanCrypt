package com.smish.cleancrypt.domain.repository

import com.smish.cleancrypt.data.remote.dto.CoinDetailDto
import com.smish.cleancrypt.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}