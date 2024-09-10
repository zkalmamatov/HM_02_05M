package kg.less.hm_02_05m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.less.hm_02_05m.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val firstName = it.getString("result") ?: "Unknown"
            val secondName = it.getString("percentage") ?: "0%"

            binding.fname.text = "You: $firstName"
            binding.sname.text = "Me: $secondName"
            binding.result.text = secondName
        }

        binding.btnAgain.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}