package br.com.guilhermedellatin.hotel.model

data class Hotel(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var rating: Float = 0.0F,
    var path: String = ""
) {
    override fun toString(): String = name
}



