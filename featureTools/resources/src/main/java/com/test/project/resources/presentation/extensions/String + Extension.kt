package com.test.project.resources.presentation.extensions

import android.os.Build
import java.util.*

/** Return the String encoded in Base64 */
fun String.toBase64(): String =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        Base64.getEncoder().withoutPadding().encodeToString(this.toByteArray())
    else
        this


/** Return the String decoded from Base64 */
fun String.toBase64Decoded(): String {

    val decodedBytes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Base64.getDecoder().decode(this)
    } else  return this

    return  String(decodedBytes)

}
