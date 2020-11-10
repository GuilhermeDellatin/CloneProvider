package br.com.guilhermedellatin.hotel.details

import br.com.guilhermedellatin.hotel.model.Hotel

//Exibe os detalhes do hotel no primeiro método
//Exibe mensagem de erro caso o hotel não seja carregado ou não exista
interface HotelDetailsView {
    fun showHotelDetails(hotel: Hotel)
    fun errorHotelNotFound()
}