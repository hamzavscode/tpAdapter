package com.example.tpadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EtudiantAdapter(
    private val onDelete: (Etudiant) -> Unit,
    private val onUpdate: (Etudiant) -> Unit,
    private val onClick: (Etudiant) -> Unit
) : RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder>() {

    private var listeEtudiants: List<Etudiant> = emptyList()


    class EtudiantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNom: TextView = itemView.findViewById(R.id.textItem)
        val txtFiliere: TextView = itemView.findViewById(R.id.textFiliere)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
        val btnUpdate: Button = itemView.findViewById(R.id.btnUpdate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EtudiantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return EtudiantViewHolder(view)
    }

    override fun onBindViewHolder(holder: EtudiantViewHolder, position: Int) {
        val etudiant = listeEtudiants[position]

        holder.txtNom.text = "${etudiant.nom} ${etudiant.prenom}"
        holder.txtFiliere.text = etudiant.filiere


        holder.btnDelete.setOnClickListener {
            onDelete(etudiant)
        }


        holder.btnUpdate.setOnClickListener {
            onUpdate(etudiant)
        }
        holder.itemView.setOnClickListener {
            onClick(etudiant)
        }

    }

    override fun getItemCount(): Int = listeEtudiants.size

    fun setData(nouvelleListe: List<Etudiant>) {
        listeEtudiants = nouvelleListe
        notifyDataSetChanged()
    }
}
