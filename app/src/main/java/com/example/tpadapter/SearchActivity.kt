package com.example.tpadapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ListView

class SearchActivity : AppCompatActivity() {

    private lateinit var editSearch: EditText
    private lateinit var listView: ListView
    private lateinit var adapter: EtudiantListSimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        editSearch = findViewById(R.id.input_search)
        listView = findViewById(R.id.list_search)

        adapter = EtudiantListSimpleAdapter(this, EtudiantService.findAll())
        listView.adapter = adapter

        editSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }
        })
    }
}
