package com.example.mc_ca

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mc_ca.data.RatingEntity
import com.example.mc_ca.databinding.EditorFragmentBinding

class EditorFragment : Fragment() {

    private val args: EditorFragmentArgs by navArgs()
    private lateinit var binding: EditorFragmentBinding
    private lateinit var viewModel: EditorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ActionBar is menu on top
        (activity as AppCompatActivity).supportActionBar?.let {
            // 'it' is similar to 'this' in Java (there are small differences)
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_check)
        }
        setHasOptionsMenu(true)

        // bind with the editor fragment layout
        binding = EditorFragmentBinding.inflate(inflater, container, false)
        // define the setup and punchline of the joke passed from the main fragment
        binding.setup.setText(args.joke.setup)
        binding.punchline.setText(args.joke.punchline)

        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        //if the rsting is changed update in the layout
        viewModel.currentRating.observe(viewLifecycleOwner, Observer {
            binding.myRatings.setText(it.myRatings)
        })

        // viewModel gets any ratings for the joke in the database
        viewModel.getRating(args.joke.id)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed(){
                    saveAndReturn()
                }
            }
        )
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // When the home button is clicked, save changes then return to the MainFragment, which is the List
            android.R.id.home -> saveAndReturn()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveAndReturn() : Boolean{
        viewModel.saveRating(RatingEntity(args.joke.id.toString(), binding.myRatings.text.toString()))

        findNavController().navigateUp()
        return true
    }

}