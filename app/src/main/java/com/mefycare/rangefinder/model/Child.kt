package com.mefycare.rangefinder.model

data class Child(
    val children: List<Children>,
    val key: String,
    val name: String,
    val range: List<AgeGenderRange>,
    val unit: String
)
