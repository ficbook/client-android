package org.unravel22.fbchat.models

import java.util.*

/**
 * Created by admin on 08.09.17.
 */
data class Room(
        val id: Int,
        val name: String,
        val members: Int,
        val description: String,
        val created_at: Date
)