package com.example.pokeapi_mvp.ui.main

import com.example.pokeapi_mvp.data.network.APIService
import com.example.pokeapi_mvp.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter (var view: MainContract.MainView): MainContract.MainPresenter {

    override fun pesquisar(pokemon: String) {
        if (pokemon.isEmpty()) {
            view.mostrarErro("Insira um pokemon para continuar")
        } else {

            view.showLoading()

            APIService.instance
                ?.pesquisar(pokemon)
                ?.enqueue(object : Callback<Pokemon> {
                    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                        if (response.isSuccessful) {
                            view.mostrarPokemon(response.body())
                        } else {
                            view.mostrarErro("Pokemon não encontrado")
                        }
                        view.hideLoading()
                    }

                    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                        view.hideLoading()
                        view.mostrarErro(t.message.toString())
                    }
                })
        }
    }

}