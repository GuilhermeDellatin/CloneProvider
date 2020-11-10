package br.com.guilhermedellatin.hotel

import android.app.Application
import br.com.guilhermedellatin.hotel.di.androidModule
import org.koin.android.ext.android.startKoin
import org.koin.standalone.StandAloneContext.stopKoin

/*Classe criada para inicializar o grafo de dependencias do Koin*/
class HotelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(androidModule))
    }

    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }
}