package com.anil_shatharashi.clean.mvvm.domain.mappers

interface TwoWaysMapper<MODEL, DATA> : Mapper<MODEL, DATA> {
    fun inverseMap(model: DATA): MODEL
}