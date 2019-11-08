package com.anil_shatharashi.clean.mvvm.domain.mappers

class ListMapper<MODEL, DATA>(private val mapper: Mapper<MODEL, DATA>) : Mapper<List<MODEL>, List<DATA>> {

    override fun map(model: List<MODEL>): List<DATA> {
        val data = ArrayList<DATA>()
        if (model.isNotEmpty()) {
            for (item in model) {
                data.add(mapper.map(item))
            }
        }
        return data
    }
}
