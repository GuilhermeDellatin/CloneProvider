package br.com.guilhermedellatin.hotel.form

import br.com.guilhermedellatin.hotel.model.Hotel

interface HotelFormView {
    fun showHotel(hotel: Hotel)
    fun errorInvalidHotel()
    fun errorSaveHotel()
}