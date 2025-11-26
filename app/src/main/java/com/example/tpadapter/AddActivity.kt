package com.example.tpadapter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {

    private lateinit var inputNom: EditText
    private lateinit var inputPrenom: EditText
    private lateinit var spinnerFiliere: Spinner
    private lateinit var radioGroupGenre: RadioGroup
    private lateinit var checkBac: CheckBox
    private lateinit var checkNewBac: CheckBox
    private lateinit var btnValider: Button

    private var etudiantId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        inputNom = findViewById(R.id.input_nom)
        inputPrenom = findViewById(R.id.input_prenom)
        spinnerFiliere = findViewById(R.id.spinner_filiere)
        radioGroupGenre = findViewById(R.id.radio_genre)
        checkBac = findViewById(R.id.checkbox_bac)
        checkNewBac = findViewById(R.id.checkbox_newbac)
        btnValider = findViewById(R.id.btn_valider)

        val filieres = arrayOf(
            "Développement Digital",
            "Infrastructure Digitale",
            "Réseaux & Sécurité",
            "Gestion des Entreprises"
        )
        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, filieres)
        spinnerFiliere.adapter = adapterSpinner

        etudiantId = intent.getIntExtra("id", -1)

        if (etudiantId != -1) {
            loadEtudiant()
        }

        btnValider.setOnClickListener {
            saveEtudiant()
        }
    }

    private fun loadEtudiant() {
        val e = EtudiantService.findById(etudiantId)

        if (e != null) {
            inputNom.setText(e.nom)
            inputPrenom.setText(e.prenom)

            val pos = (spinnerFiliere.adapter as ArrayAdapter<String>).getPosition(e.filiere)
            spinnerFiliere.setSelection(pos)

            if (e.genre == "Homme") radioGroupGenre.check(R.id.radio_homme)
            if (e.genre == "Femme") radioGroupGenre.check(R.id.radio_femme)

           
            checkBac.isChecked = e.niveau.contains("Bac")
            checkNewBac.isChecked = e.niveau.contains("NewBac")

            btnValider.text = "Modifier"
        }
    }

    private fun saveEtudiant() {

        val nom = inputNom.text.toString()
        val prenom = inputPrenom.text.toString()

        if (nom.isEmpty() || prenom.isEmpty()) {
            Toast.makeText(this, "Nom et Prénom obligatoires", Toast.LENGTH_SHORT).show()
            return
        }

        val filiere = spinnerFiliere.selectedItem.toString()

        
        val selectedRadioId = radioGroupGenre.checkedRadioButtonId
        val genre = if (selectedRadioId != -1) findViewById<RadioButton>(selectedRadioId).text.toString()
        else "Non spécifié"

        var niveau = ""
        if (checkBac.isChecked) niveau += "Bac "
        if (checkNewBac.isChecked) niveau += "NewBac"

        val etudiant = Etudiant(
            id = if (etudiantId != -1) etudiantId else 0,
            nom = nom,
            prenom = prenom,
            filiere = filiere,
            genre = genre,
            niveau = niveau.trim()
        )

        val ok = if (etudiantId != -1) {
            EtudiantService.update(etudiant)
        } else {
            EtudiantService.create(etudiant)
        }

        if (ok)
            Toast.makeText(this, "Opération réussie", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show()

        finish()
    }
}
