package com.example.andy

import com.google.firebase.database.IgnoreExtraProperties


//@IgnoreExtraProperties
data class User(val userId: String? = null, val bloodGroup: String? = null, val email: String? = null, val address: String? = null, val phoneNumber: String? = null, val name: String? = null, val password: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}