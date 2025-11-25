# 📱 Gestion des Étudiants - Android App

Une application Android native développée en **Kotlin** pour gérer une liste d'étudiants. Ce projet met en œuvre l'utilisation avancée du `RecyclerView`, des `Adapters` personnalisés et la gestion des événements (CRUD).

## 🚀 Fonctionnalités

L'application permet de réaliser les opérations suivantes :

* **Lister les étudiants :** Affichage dynamique via un `RecyclerView`.
* **Ajouter un étudiant :** Formulaire complet incluant :
    * Saisie de texte (Nom, Prénom).
    * Sélection de filière (`Spinner`).
    * Choix du genre (`RadioGroup`).
    * Sélection du niveau (`CheckBox`).
* **Détails :** Afficher les informations complètes d'un étudiant au clic.
* **Modifier & Supprimer :** Boutons d'action directement intégrés dans chaque élément de la liste (`Item`).
* **Recherche :** Filtrer la liste des étudiants.

## 🛠️ Stack Technique

* **Langage :** Kotlin
* **UI Components :**
    * `RecyclerView` & `Custom Adapter`
    * `ConstraintLayout`, `LinearLayout`, `ScrollView`
  
* **Architecture :** Modèle - Vue - Service (Simulation de données).

## 📂 Structure du Projet

Le projet est structuré de manière claire :
* `Adapter` : Contient `EtudiantAdapter` pour gérer l'affichage de la liste et les clics (Delete, Update, View).
* `Model` : La classe de données `Etudiant`.
* `Service` : Gestion logique des données (`EtudiantService`).
* `Activities` :
    * `MainActivity` : Liste principale.
    * `AddActivity` : Formulaire d'ajout.
    * `DetailActivity` : Affichage des infos.

## 📸 Aperçu (Screenshots)

| Liste Principale | Formulaire d'Ajout | Formulaire de Modification | Test de Recherche/Filtrage |
|:---:|:---:|:---:|:---:|
| *screenshot de recyclerview((https://github.com/hamzavscode/tpAdapter/issues/1))* | *(Ajouter un etudiant(https://github.com/hamzavscode/tpAdapter/issues/2))* |*(Modifier un etudiant(https://github.com/hamzavscode/tpAdapter/issues/3))* |



