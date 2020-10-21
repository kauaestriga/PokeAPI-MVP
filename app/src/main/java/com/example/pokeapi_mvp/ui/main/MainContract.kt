package com.example.pokeapi_mvp.ui.main

import com.example.pokeapi_mvp.model.Pokemon

interface MainContract {

    interface MainView {

        fun mostrarPokemon(pokemon: Pokemon?)
        fun mostrarErro(mensagem: String)
        fun showLoading()
        fun hideLoading()
    }

    interface MainPresenter {

        fun pesquisar(pokemon: String)

    }

}