package com.anil_shatharashi.clean.mvvm.domain.model

data class Task(
        val id: Int,
        val taskName: String,
        val description: String,
        val notification: String
)