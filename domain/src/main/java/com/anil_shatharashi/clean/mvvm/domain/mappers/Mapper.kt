package com.anil_shatharashi.clean.mvvm.domain.mappers

interface Mapper<MODEL, DATA> {
    fun map(model: MODEL): DATA
}

