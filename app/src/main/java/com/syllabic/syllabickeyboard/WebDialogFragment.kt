package com.syllabic.syllabickeyboard
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebResourceRequest
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.webkit.WebViewClientCompat

class WebDialogFragment(private val url: String) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())

        // Inflate the layout for the DialogFragment
        val inflater: LayoutInflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_webview, null)

        // Reference the WebView inside the Dialog layout
        val webView = view.findViewById<WebView>(R.id.webView)

        // Set a custom WebViewClient to handle URL loading
        webView.webViewClient = object : WebViewClientCompat() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                view.loadUrl(request.url.toString())
                return true
            }
        }

        // Load the website in the WebView
        webView.loadUrl(url)

        // Set the custom view for the DialogFragment
        builder.setView(view)

        // Create the Dialog
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return dialog
    }
}
