package com.example.tpadapter




object EtudiantService : IDao<Etudiant> {

    private val etudiants = mutableListOf<Etudiant>()


    private var idCounter = 1

    override fun create(o: Etudiant): Boolean {
        o.id = idCounter++
        return etudiants.add(o)
    }

    override fun delete(o: Etudiant): Boolean {
        return etudiants.remove(o)
    }

    override fun update(o: Etudiant): Boolean {
        val index = etudiants.indexOfFirst { it.id == o.id }
        if (index != -1) {
            etudiants[index] = o
            return true
        }
        return false
    }

    override fun findById(id: Int): Etudiant? {
        return etudiants.find { it.id == id }
    }
    override fun findAll(): List<Etudiant> {
        return etudiants
    }
}