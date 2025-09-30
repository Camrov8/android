package pm.calculoimc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import pm.calculoimc.databinding.ActivityMainBinding
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        val txtResultado: TextView = findViewById(R.id.txt_Resultado)
        val txtAjuda: TextView = findViewById(R.id.txt_Ajuda)
        val editPeso: EditText = findViewById(R.id.edit_Peso)
        val editAltura: EditText = findViewById(R.id.edit_Altura)
        val btnCalcular: Button = findViewById(R.id.button)

        btnCalcular.setOnClickListener {
            val peso: Double = editPeso.text.toString().toDouble()
            val altura: Double = editAltura.text.toString().toDouble()
            val total = peso / altura.pow(2.0)
            txtResultado.text = "%.1f".format(total)
            //txtResultado.text = String.format("%.1f", total )
        }
    binding.btnAjuda.setOnClickListener {  }
        fun btnAjuda(view: View){
            val intent = Intent(this, imgActivity::class.java)
            intent.putExtra("resultado",binding.txtResultado.text)

           startActivity(intent)

        }
    }
private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)
}

}