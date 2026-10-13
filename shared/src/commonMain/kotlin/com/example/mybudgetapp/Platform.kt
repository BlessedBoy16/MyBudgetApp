package com.example.mybudgetapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform