package br.com.guilhermedellatin.hotel.di

import br.com.guilhermedellatin.hotel.details.HotelDetailsPresenter
import br.com.guilhermedellatin.hotel.details.HotelDetailsView
import br.com.guilhermedellatin.hotel.form.HotelFormPresenter
import br.com.guilhermedellatin.hotel.form.HotelFormView
import br.com.guilhermedellatin.hotel.list.HotelListPresenter
import br.com.guilhermedellatin.hotel.list.HotelListView
import br.com.guilhermedellatin.hotel.repository.HotelRepository
import br.com.guilhermedellatin.hotel.repository.sqlite.ProviderRepository
import br.com.guilhermedellatin.hotel.repository.sqlite.SQLiteRepository
import org.koin.dsl.module.module

val androidModule = module {
    single{ this }

    single {
        ProviderRepository(ctx = get()) as HotelRepository
    }

    factory { (view: HotelListView) ->
        HotelListPresenter(view, repository = get())
    }

    factory { (view: HotelDetailsView) ->
        HotelDetailsPresenter(view, repository = get())
    }

    factory { (view: HotelFormView) ->
        HotelFormPresenter(view, repository = get())
    }
}