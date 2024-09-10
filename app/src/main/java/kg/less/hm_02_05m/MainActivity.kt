package kg.less.hm_02_05m

import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kg.less.hm_02_05m.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), LoveContract {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter = LovePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCal.setOnClickListener {
            val firstName = binding.etFname.text.toString()
            val secondName = binding.etSname.text.toString()

            if (firstName.isNotBlank() && secondName.isNotBlank()) {
                presenter.getPercentage(firstName, secondName)
            } else {
                Toast.makeText(this, "Введите пожалуйста имя", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun showResult(result: LoveModel) {
        val resultFragment = ResultFragment().apply {
            arguments = Bundle().apply {
                putString("result", result.result)
                putString("percentage", result.percentage)
            }
        }
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_Container, resultFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun getPercentage(firstName: String, secondName: String) {
    }
}