package com.test.project.connection.home.domain.entity.get_beer_list

data class Ingredients(
    val hops: List<Hop>?,
    val malt: List<Malt>?,
    val yeast: String?
){
    /** */
    fun toHopStringList():List<String> {
        val listStringHop = mutableListOf<String>()

        hops?.forEach {
            listStringHop.add(
                "${it.name} ${it.amount?.value} ${it.amount?.unit}"
            )
        }
        return listStringHop
    }

    /** */
    fun toMaltStringList():List<String> {
        val listStringHop = mutableListOf<String>()

        malt?.forEach {
            listStringHop.add(
                "${it.name} ${it.amount?.value} ${it.amount?.unit}"
            )
        }
        return listStringHop
    }

}