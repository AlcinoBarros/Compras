package com.alcinojose.compras

import java.io.Serializable

data class Item (
    val id: Int? = null,
    val titulo: String,
    val descricao: String
) : Serializable {
}