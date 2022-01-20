package kg.geektech.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.twoactivities.MainActivity.Companion.key
import kg.geektech.twoactivities.MainActivity.Companion.key2
import kg.geektech.twoactivities.databinding.ActivityMain2Binding
import kg.geektech.twoactivities.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent = intent

        var text = intent.getStringExtra(key)
        binding.etEdit2.setText(text)

        binding.btnButton2.setOnClickListener {
            if (binding.etEdit2.text.toString().isBlank()) {
                Toast.makeText(this, "Поле Пустое", Toast.LENGTH_LONG).show()
            } else {

                intent.putExtra(key2, binding.etEdit2.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    val companion = Unit
    val value = object {
        val key = "key"
        val key2 = "key2"
    }
}