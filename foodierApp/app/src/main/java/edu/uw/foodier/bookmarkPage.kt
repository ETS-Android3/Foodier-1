package edu.uw.foodier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.uw.foodier.databinding.BookmarkPageBinding

class bookmarkPage : Fragment() {
    private var _binding: BookmarkPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = BookmarkPageBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bookmarkButton.setOnClickListener {
            findNavController().navigate(R.id.action_bookmark_to_main)
        }
    }
}