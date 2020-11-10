package br.com.guilhermedellatin.hotel.repository.memory

import br.com.guilhermedellatin.hotel.repository.HotelRepository
import br.com.guilhermedellatin.hotel.model.Hotel

object MemoryRepository : HotelRepository {
    private var nextId = 1L
    private var hotelsList = mutableListOf<Hotel>()
    init {
        save(Hotel(0, "New Beach hotel", "Av. Boa Viagem", 4.5f))
        save(Hotel(0, "Recife hotel", "Av. Boa Viagem", 4.0f))
        save(Hotel(0, "Canario hotel", "Rua dos Navegantes", 3.0f))
        save(Hotel(0, "Byanca Beach hotel", "Rua Mamanguape", 4.0f))
        save(Hotel(0, "Grand hotel Dor", "Av. Bernardo", 3.5f))
        save(Hotel(0, "hotel Cool", "Av. Conselheiro Aguiar", 4.0f))
        save(Hotel(0, "hotel Infinito", "Rua Ribeiro de Brito", 5.0f))
        save(Hotel(0, "hotel Tulipa", "Av. Boa Viagem", 5.0f))
    }

    override fun save(hotel: Hotel) {
        if (hotel.id == 0L) {
            hotel.id = nextId++
            hotelsList.add(hotel)
        } else {
            val index = hotelsList.indexOfFirst { it.id == hotel.id }
            if (index > -1) {
                hotelsList[index] = hotel
            } else {
                hotelsList.add(hotel)
            }
        }
    }

    override fun remove(vararg hotels: Hotel) {
        hotelsList.removeAll(hotels)
    }

    override fun hotelById(id: Long, callback: (Hotel?) -> Unit) {
        callback(hotelsList.find { it.id == id })
    }

    override fun search(term: String, callback: (List<Hotel>) -> Unit) {
        val resultList =
            if (term.isEmpty()) hotelsList
            else hotelsList.filter {
                it.name.toUpperCase().contains(term.toUpperCase())
            }
        callback(resultList.sortedBy { it.name })
    }
}