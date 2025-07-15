package com.ext.searchablespinnerview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputLayout

class SearchableSpinnerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = inflate(context, R.layout.searchable_spinner_view, this)
    private val editText: EditText = binding.findViewById(R.id.searchEditText)
    private val suggestionsListView: ListView = binding.findViewById(R.id.suggestionsListView)
    private var items: List<String> = emptyList()
    private var onItemSelectedListener: ((String) -> Unit)? = null

    init {
        orientation = VERTICAL
        setupEditText()
        setupSuggestionsListView()
        // Initially hide the suggestions list
        suggestionsListView.visibility = View.GONE
    }

    private fun setupEditText() {
        // Show suggestions list when EditText is clicked
        editText.setOnClickListener {
            val query = editText.text.toString().trim()
            if (query.isNotEmpty()) {
                val filteredItems = items.filter { it.contains(query, ignoreCase = true) }
                if (filteredItems.isNotEmpty()) {
                    updateSuggestions(filteredItems)
                } else {
                    suggestionsListView.visibility = View.GONE
                }
            } else {
                suggestionsListView.visibility = View.GONE
            }
        }


        editText.addTextChangedListener { text ->
            val query = text.toString().trim()
            if (query.isNotEmpty()) {
                val filteredItems = items.filter { it.contains(query, ignoreCase = true) }
                if (filteredItems.isNotEmpty()) {
                    updateSuggestions(filteredItems)
                } else {
                    suggestionsListView.visibility = View.GONE
                }
            } else {
                suggestionsListView.visibility = View.GONE
            }
        }

    }

    private fun setupSuggestionsListView() {
        suggestionsListView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = items[position]
            editText.setText(selectedItem)
            onItemSelectedListener?.invoke(selectedItem)
            suggestionsListView.visibility = View.GONE
        }
    }

    private fun updateSuggestions(items: List<String>) {
        if (items.isEmpty()) {
            suggestionsListView.visibility = View.GONE
            return
        }

        suggestionsListView.adapter = ArrayAdapter(
            context,
            android.R.layout.simple_list_item_1,
            items
        )
        suggestionsListView.visibility = View.VISIBLE
    }

    fun setItems(items: List<String>) {
        this.items = items
        suggestionsListView.visibility = View.GONE // just ensure it's hidden
    }


    fun setOnItemSelectedListener(listener: (String) -> Unit) {
        this.onItemSelectedListener = listener
    }

    fun getSelectedItem(): String = editText.text.toString()
}
