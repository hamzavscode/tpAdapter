package com.example.tpadapter



import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class EtudiantListSimpleAdapter(
    private val context: Context,
    private var list: List<Etudiant>
) : BaseAdapter() {

    private val originalList = list.toMutableList()

    override fun getCount() = list.size
    override fun getItem(position: Int) = list[position]
    override fun getItemId(position: Int) = list[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val txt = TextView(context)
        txt.textSize = 20f
        txt.setPadding(20, 20, 20, 20)
        txt.text = "${list[position].nom} ${list[position].prenom}"

        txt.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", list[position].id)
            context.startActivity(intent)
        }

        return txt
    }

    fun filter(text: String) {
        list = if (text.isEmpty()) {
            originalList
        } else {
            originalList.filter {
                it.nom.contains(text, true) ||
                        it.prenom.contains(text, true) ||
                        it.filiere.contains(text, true)
            }
        }
        notifyDataSetChanged()
    }
}
