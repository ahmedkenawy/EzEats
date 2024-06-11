package com.ahmedkenawy.ezeats.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * User is a data class representing user data retrieved from the API.
 *
 * This data class:
 * - Implements the Parcelable interface for efficient serialization and deserialization.
 * - Contains properties representing various user attributes such as avatar URL, email, first name, last name, and ID.
 *
 * Properties:
 * - avatar: String? - URL of the user's avatar image.
 * - email: String? - Email address of the user.
 * - firstName: String? - First name of the user.
 * - id: Int? - Unique identifier of the user.
 * - lastName: String? - Last name of the user.
 */

@Parcelize
data class User(
    val avatar: String?,
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    val id: Int?,
    @SerializedName("last_name")
    val lastName: String?
):Parcelable