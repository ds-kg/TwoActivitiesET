package kg.geektech.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.twoactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            if(it.data !=null){
                val textActivity2 = it.data!!.getStringExtra(key2)
                binding.etEdit1.setText(textActivity2)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnButton1.setOnClickListener {
        
             if (binding.etEdit1.text.toString().isBlank()) {
                Toast.makeText(this, getString(R.string.toastText), Toast.LENGTH_SHORT).show()

            } else{
                Intent( this, MainActivity2::class.java).apply {
                    putExtra(key, binding.etEdit1.text.toString())
                    resultContract.launch(this)
                }
             }
        }
    }

    companion object{
        const val key = "key"
        const val key2 = "key2"
    }
}
