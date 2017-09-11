package org.unravel22.fbchat.models

import java.util.*

/**
 * Created by admin on 08.09.17.
 */
data class Message (
        val id: Int,
        val user: User,
        val body: String,
        val attachment: Attachment?,
        val created_at: Date
)