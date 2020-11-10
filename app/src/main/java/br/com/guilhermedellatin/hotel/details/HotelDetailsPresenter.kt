package br.com.guilhermedellatin.hotel.details

import br.com.guilhermedellatin.hotel.repository.HotelRepository

//Realizar a busca do hotel no repositório, e por meio
//Da HotelDetailsView exibir os detalhes do hotel
class HotelDetailsPresenter (
    private val view: HotelDetailsView,
    private val repository: HotelRepository
) {
    fun loadHotelDetails(id: Long){
        repository.hotelById(id){ hotel ->
            if (hotel != null){
                view.showHotelDetails(hotel)
            } else {
                view.errorHotelNotFound()
            }
        }
    }
}