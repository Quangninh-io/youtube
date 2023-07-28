package com.fftools.youtube.repositories

interface TestRepository {
    suspend fun test(a: Int, b: Int): Int?
}