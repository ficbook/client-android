package org.unravel22.fbchat.models

/**
 * Created by admin on 01.09.17.
 */
data class Account(
        val id: Int,
        val token: String,
        val username: String,
        val level: Byte
)