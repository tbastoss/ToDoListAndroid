package com.tab.core.entity

data class Card (
    val title: String,
    val description: String,
    val status: Boolean, //default true - DONE turn false
)