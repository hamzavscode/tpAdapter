package com.example.tpadapter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var txtNom: TextView
    private lateinit var txtPrenom: TextView
    private lateinit var txtFiliere: TextView
    private lateinit var txtGenre: TextView
    private lateinit var txtNiveau: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        txtNom = findViewById(R.id.detail_nom)
        txtPrenom = findViewById(R.id.detail_prenom)
        txtFiliere = findViewById(R.id.detail_filiere)
        txtGenre = findViewById(R.id.detail_genre)
        txtNiveau = findViewById(R.id.detail_niveau)

        val id = intent.getIntExtra("id", -1)

        if (id != -1) {
            val etudiant = EtudiantService.findById(id)

            if (etudiant != null) {
                txtNom.text = "Nom : ${etudiant.nom}"
                txtPrenom.text = "Prénom : ${etudiant.prenom}"
                txtFiliere.text = "Filière : ${etudiant.filiere}"
                txtGenre.text = "Genre : ${etudiant.genre}"
                txtNiveau.text = "Niveau : ${etudiant.niveau}"
            }
        }
    }
}
