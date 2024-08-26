package com.example.petcare.data

import com.example.petcare.R

data class CategoryListData(val image: Int, val category: String)

fun getCategoryList(): List<CategoryListData> {
    return listOf(
        CategoryListData(R.drawable.veterinary, "Veterinary"),
        CategoryListData(R.drawable.grooming, "Grooming"),
        CategoryListData(R.drawable.pet_boarding, "Pet boarding"),
        CategoryListData(R.drawable.adoption, "Adoption"),
        CategoryListData(R.drawable.dog_walking, "Dog walking"),
        CategoryListData(R.drawable.training, "Training"),
        CategoryListData(R.drawable.pet_taxi, "Pet taxi"),
        CategoryListData(R.drawable.pet_date, "Pet date"),
        CategoryListData(R.drawable.other, "Other"),
    )
}

fun getPopularSpecialists() = arrayOf("Cat Specialist", "Dog Specialist", "Ornithologist", "Dentist", "Surgeon")

fun getAllSpecialists() = arrayOf("Veterinarian", "Therapist", "Anesthetist", "Gastroenterologist", "Infectious disease", "Cardiologist", "Neurologist", "Oncologist", "Ornithologist", "Orthopedist", "Ophthalmologist", "Radiologist", "Dentist", "Therapist", "Traumatologist", "Surgeon", "Endocrinologist")

fun getAllTherapistName() = arrayOf("Sarah Taylor", "Beth Mooney", "Mag Lanning", "Ellyse Perry", "Sophie Ecclestone", "Mithali Raj", "Kate Kross", "Sophie Devine", "Marizanne Kapp", "Masabata Klass", "Smriti Mandhana", "Jamimah Rodrigues", "Maddy Green", "Ashlei Gardener", "Annabel Sutherland", "Jess Jonnasen", "Amellia ker")

fun getProfileOptions(): List<CategoryListData> {
    return listOf(
        CategoryListData(R.drawable.pet_foot, "My Pets"),
        CategoryListData(R.drawable.heart, "My Favourites"),
        CategoryListData(R.drawable.pet_service_icon, "Add pet service"),
        CategoryListData(R.drawable.announcement, "Invite Friends"),
        CategoryListData(R.drawable.help, "Help"),
        CategoryListData(R.drawable.settings, "Settings")
    )
}