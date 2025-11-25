package com.example.tpadapter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EtudiantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val btnSearch = findViewById<Button>(R.id.btn_search)


        if (EtudiantService.findAll().isEmpty()) {
            EtudiantService.create(Etudiant(0, "Mahi", "abdo", "Développement Digital", "Homme", "Bac"))
            EtudiantService.create(Etudiant(0, "Fatima", "Zahra", "Réseaux & Sécurité", "Femme", "NewBac"))
            EtudiantService.create(Etudiant(0, "hmyene", " Salma ", "Développement Digital", "Femme", "Bac"))
            EtudiantService.create(Etudiant(0, "Joual", "hamza", "Réseaux & Sécurité", "Homme", "NewBac"))
            EtudiantService.create(Etudiant(0, "Smira ", "Ali", "Développement Digital", "Homme", "Bac"))
            EtudiantService.create(Etudiant(0, " laasri", "Rim", "Réseaux & Sécurité", "Femme", "NewBac"))
            EtudiantService.create(Etudiant(0, "guzaoui", " Soufiane", "Développement Digital", "Homme", "Bac"))
            EtudiantService.create(Etudiant(0, "adnan", "imane", "Réseaux & Sécurité", "Femme", "NewBac"))
            EtudiantService.create(Etudiant(0, "Moussa", "aya", "Développement Digital", "Homme", "Bac"))
            EtudiantService.create(Etudiant(0, "benhima", "yahya", "Réseaux & Sécurité", "Homme", "NewBac"))
            EtudiantService.create(Etudiant(0, "Moussa", "Ali", "Développement Digital", "Homme", "Bac"))
            EtudiantService.create(Etudiant(0, "Fatima", "Zahra", "Réseaux & Sécurité", "Femme", "NewBac"))
            EtudiantService.create(Etudiant(0, "Moussa", "Ali", "Développement Digital", "Homme", "Bac"))
            EtudiantService.create(Etudiant(0, "Fatima", "Zahra", "Réseaux & Sécurité", "Femme", "NewBac"))
            EtudiantService.create(Etudiant(0, "Moussa", "Ali", "Développement Digital", "Homme", "Bac"))
            EtudiantService.create(Etudiant(0, "Fatima", "Zahra", "Réseaux & Sécurité", "Femme", "NewBac"))
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = EtudiantAdapter(
            onDelete = { e ->
                EtudiantService.delete(e)
                adapter.setData(EtudiantService.findAll())
                Toast.makeText(this, "Supprimé", Toast.LENGTH_SHORT).show()
            },
            onUpdate = { e ->
                val intent = Intent(this, AddActivity::class.java)
                intent.putExtra("id", e.id)
                startActivity(intent)
            },
            onClick = { e ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("id", e.id)
                startActivity(intent)
            }
        )

        recyclerView.adapter = adapter
        adapter.setData(EtudiantService.findAll())

        btnAdd.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }

        btnSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.setData(EtudiantService.findAll())
    }
}
