package com.globant.openbankmarvel.common

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class HashClass {
    companion object{
        fun md5(ts: String, sk :String, pk:String): ByteArray {
            return MessageDigest.getInstance("MD5").digest("$ts$sk$pk".toByteArray(UTF_8))
        }
        fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }
    }

}