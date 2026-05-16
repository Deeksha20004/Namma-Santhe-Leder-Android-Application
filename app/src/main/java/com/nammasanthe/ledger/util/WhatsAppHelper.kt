package com.nammasanthe.ledger.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.net.URLEncoder

object WhatsAppHelper {
    fun openReminder(
        context: Context,
        phone: String,
        customerName: String,
        amount: Int,
        vendorName: String,
        shopName: String
    ) {
        val shopPart = if (shopName.isNotBlank()) " ($shopName)" else ""
        val message = "नमस्ते $customerName, आपका $vendorName$shopPart से ₹$amount बकाया है। कृपया जल्द चुकता करें। - Namma Santhe"
        val encoded = URLEncoder.encode(message, "UTF-8")
        val digits = phone.filter { it.isDigit() }
        val uri = Uri.parse("https://wa.me/$digits?text=$encoded")
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage("com.whatsapp")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            context.startActivity(intent)
        } catch (_: Exception) {
            context.startActivity(
                Intent(Intent.ACTION_VIEW, uri).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }
}
