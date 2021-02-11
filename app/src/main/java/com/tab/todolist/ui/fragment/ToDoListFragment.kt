package com.tab.todolist.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tab.core.entity.Card
import com.tab.todolist.databinding.FragmentToDoListBinding
import com.tab.todolist.viewmodel.ToDoListFragmentViewModel

class ToDoListFragment : Fragment() {

    //Binding
    private var _binding: FragmentToDoListBinding? = null
    private val binding get() = _binding!!

    //ViewModel
    private lateinit var  viewModel: ToDoListFragmentViewModel

    private lateinit var fab: FloatingActionButton
    private lateinit var recycerView: RecyclerView
    private lateinit var recyclerViewAdapter: CardListAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentToDoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        observeCardList()

        fab.setOnClickListener {
            createCard()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Initiate UI components
     */
    private fun init() {
        viewModel = ToDoListFragmentViewModel()
        fab = binding.fab
        layoutManager = LinearLayoutManager(context)
        recycerView = binding.cardsRecyclerview
        recyclerViewAdapter =
            CardListAdapter(
                viewModel::removeCard
            )
        recycerView.adapter = recyclerViewAdapter
        recycerView.layoutManager = layoutManager
    }

    /**
     * Observer for CardList
     */
    private fun observeCardList() {
        viewModel.cardsLiveData.observe(this, {
            recyclerViewAdapter.setCardList(it)
        })
    }

    /**
     * Call a Dialog to create a new Card to be
     * added to the To Do list
     */
    private fun createCard() {
        val inputTitle = EditText(context!!)
        val inputDescription = EditText(context!!)

        AlertDialog.Builder(context!!)
            .setTitle("Create a Task")
            .setView(inputTitle)
            .setPositiveButton("Save") { _, _ ->
                val title = inputTitle.text.toString()
                AlertDialog.Builder(context!!)
                    .setTitle("Create a Task")
                    .setView(inputDescription)
                    .setPositiveButton("Save") { _, _ ->
                        val description = inputDescription.text.toString()
                        viewModel.createCard(title, description)
                    }
                    .setNegativeButton("Cancel") { _, _ -> }
                    .show()
            }
            .setNegativeButton("Cancel") { _, _ -> }
            .show()
    }

}