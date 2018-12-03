package br.com.gilmar.calculafex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.gilmar.calculafex.extensions.getDouble
import br.com.gilmar.calculafex.extensions.getDouble
import br.com.gilmar.calculafex.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        etGasPrice.addTextChangedListener(DecimalTextWatcher(etGasPrice))
        etEtanolPrice.addTextChangedListener(DecimalTextWatcher(etEtanolPrice))

        etGasAverage.addTextChangedListener(DecimalTextWatcher(etGasAverage , totalDecimalNumber = 1))
        etEtanolAverage.addTextChangedListener(DecimalTextWatcher(etEtanolAverage,totalDecimalNumber = 1))

        btCalculate.setOnClickListener{
            val proximaTela = Intent(this,ResultActivity::class.java)
            proximaTela.putExtra("GAS_PRICE" , etGasPrice.getDouble())
            proximaTela.putExtra("ETHANOL_PRICE",etEtanolPrice.getDouble())
            proximaTela.putExtra("GAS_AVERAGE" ,etGasAverage.getDouble())
            proximaTela.putExtra("ETHANOL_AVERAGE" ,etEtanolAverage.getDouble())
            startActivity(proximaTela)

        }
    }

}
