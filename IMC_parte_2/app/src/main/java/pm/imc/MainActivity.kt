package pm.imc

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pm.imc.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnCalcular.setOnClickListener {
            var peso = binding.editPeso.text.toString().toDouble()
            var altura = binding.editAltura.text.toString().toDouble()
            var total = peso / altura.pow(2.0)
            binding.txtResultado.text = "%.1f".format(total)

            when {
                total < 18.5 -> binding.txtMensagem.setText(R.string.tabela1)
                total < 25   -> binding.txtMensagem.setText(R.string.tabela2)
                total < 30   -> binding.txtMensagem.setText(R.string.tabela3)
                total < 35   -> binding.txtMensagem.setText(R.string.tabela4)
                total < 40   -> binding.txtMensagem.setText(R.string.tabela5)
                total >= 40  -> binding.txtMensagem.setText(R.string.tabela6)
                else -> null
            }
        }
    }

    fun btnAjuda(view: View) {
        val intent = Intent(this, ImgActivity::class.java)
        intent.putExtra("resultado",binding.txtResultado.text)
        intent.putExtra("mensagem",binding.txtMensagem.text)
        startActivity(intent)
    }
}