package com.example.pokeapi_mvp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pokeapi_mvp.R
import com.example.pokeapi_mvp.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter = MainPresenter(this)

        limparTela()
        btOK.setOnClickListener {
            limparTela()
            mainPresenter.pesquisar(etPesquisar.text.toString())
        }
    }

    override fun mostrarPokemon(pokemon: Pokemon?) {
        tvName.text = pokemon?.name
        Picasso.get()
            .load(pokemon?.sprites?.other?.artwork?.front_default)
            .into(ivPokemon)
    }

    override fun mostrarErro(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        containerLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        containerLoading.visibility = View.GONE
    }

    fun limparTela() {
        tvName.text = ""
        ivPokemon.setImageResource(0)
    }
}