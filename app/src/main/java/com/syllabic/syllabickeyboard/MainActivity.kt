package com.syllabic.syllabickeyboard

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.provider.UserDictionary
import android.util.DisplayMetrics
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.syllabic.syllabickeyboard.config.BaseConfig
import com.syllabic.syllabickeyboard.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    var checkLanguage = "";

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClick()
        UserDictionary.Words.addWord(
            this, "MadeUpWord", 10,
            UserDictionary.Words.LOCALE_TYPE_CURRENT
        )
        val metrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(metrics)
        val yInches = metrics.heightPixels / metrics.ydpi
        val xInches = metrics.widthPixels / metrics.xdpi
        val diagonalInches = sqrt((xInches * xInches + yInches * yInches).toDouble())
        if (diagonalInches >= 7) {
            BaseConfig.saveNameDevice("tablet", this);
        } else {
            BaseConfig.saveNameDevice("mobile", this);
        }
        if (BaseConfig.readNameDevice(this).equals("tablet")) {
            layoutEnableSuggest.visibility = View.VISIBLE
            layoutEnableSuggestMobile.visibility = View.GONE
            layoutEnableSuggest.gravity = Gravity.CENTER
            tvHomeThree.gravity = Gravity.CENTER
            tvHomeFour.gravity = Gravity.CENTER
            tvHomeFive.gravity = Gravity.CENTER
            tvHomeSix.gravity = Gravity.CENTER
            tvHomeSeven.gravity = Gravity.CENTER
            tvHomeEight.gravity = Gravity.CENTER
            tvHomeNight.gravity = Gravity.CENTER
            tvHomeThree.gravity = Gravity.CENTER
            tvHomeThree.gravity = Gravity.CENTER
        }
    }


    private fun setOnClick() {
        layoutOne.setOnClickListener {
            setTextOne()
        }
        layoutTwo.setOnClickListener {
            setTextTwo()
        }
        layoutThree.setOnClickListener {
            setTextThree()
        }

        layoutClickOrange.setOnClickListener {
            val myIntent = Intent(this, DetailActivity::class.java)
            startActivity(myIntent)
        }

        imgSetting.setOnClickListener {
            val myIntent = Intent(this, DetailTwoActivity::class.java)
            myIntent.putExtra("keycheck", checkLanguage)
            startActivity(myIntent)
        }

        switchUserIpad.isChecked = BaseConfig.readLastButtonPressed(this)
        switchUserMobile.isChecked = BaseConfig.readLastButtonPressed(this)
        switchUserIpad.setOnClickListener {
            if (BaseConfig.readLastButtonPressed(this)){
                showAlterDialog()
            }
        }
        switchUserMobile.setOnClickListener {
            if (BaseConfig.readLastButtonPressed(this)){
                showAlterDialog()
            }
        }
        switchUserIpad.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                BaseConfig.saveLastButtonPressed(true, this)
                var arrayList = ArrayList<String>()
                if (BaseConfig.getListSuggestion(this) != null) {
                    arrayList = BaseConfig.getListSuggestion(this);
                } else {
                    arrayList.addAll(Utils.list)
                }
                BaseConfig.saveListSuggestion(arrayList, this)
            } else {
                val arrayList = ArrayList<String>()
                BaseConfig.saveLastButtonPressed(false, this)
                BaseConfig.saveListSuggestion(arrayList, this)
                BaseConfig.saveListInLocal(arrayList, this)
            }
        }
        switchUserMobile.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                BaseConfig.saveLastButtonPressed(true, this)
                var arrayList = ArrayList<String>()
                if (BaseConfig.getListSuggestion(this) != null) {
                    arrayList = BaseConfig.getListSuggestion(this);
                } else {
                    arrayList.addAll(Utils.list)
                }
                BaseConfig.saveListSuggestion(arrayList, this)
            } else {
                val arrayList = ArrayList<String>()
                BaseConfig.saveLastButtonPressed(false, this)
                BaseConfig.saveListSuggestion(arrayList, this)
                BaseConfig.saveListInLocal(arrayList, this)
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            BaseConfig.saveHorizontalOrVertical("LANDSCAPE", applicationContext)
            Log.e("On Config Change", "LANDSCAPE")
        } else {
            BaseConfig.saveHorizontalOrVertical("PORTRAIT", applicationContext)
            Log.e("On Config Change", "PORTRAIT")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setTextOne() {
        val face = ResourcesCompat.getFont(this, R.font.llisarniq_demi);
        tvHomeTitle.typeface = face
        tvHomeTitleTwo.typeface = face
        tvHomeThree.typeface = face
        tvHomeFour.typeface = face
        tvHomeFive.typeface = face
        tvHomeSix.typeface = face
        tvHomeSeven.typeface = face
        tvHomeEight.typeface = face
        tvHomeNight.typeface = face
        tvHomeTen.typeface = face
        tvHomeTenMobile.typeface = face
        tvHomeElevent.typeface = face
        tvHomeTitle.text = "ᐃᓄᐃᑦ ᓇᕿᑕᕋᖓ"
        tvHomeTitleTwo.text = "ᒪᓕᒐᖅ ᓄᐃᑦᓯᕈᑎᒃ"
        tvHomeThree.text = "• ᐃᓄᒃᑎᑐᑦ ᐊᓪᓚᕈᓐᓇᓯᒍᒪᕈᕕᑦ"
        tvHomeFour.text = "•  ᐅᑯᐊ ᓇᕐᓂᓗᒋᑦ"
        tvHomeFive.text = "> General"
        tvHomeSix.text = "> Keyboard"
        tvHomeSeven.text = "> Keyboards"
        tvHomeEight.text = "> On screen keyboard"
        tvHomeNight.text = "• ᐃᓄᒃᑎᑐᑦ ᐊᐅᓚᒍᓐᓇᓯᓕᕐᑎᓗᒍ"
        tvHomeTen.text = "ᐃᓕᓐᓂᑐᐊ ᐱᒍᑦᔨᔪᒃ ᐊᐅᓚᑎᓗᒍ"
        tvHomeTenMobile.text = "ᐃᓕᓐᓂᑐᐊ ᐱᒍᑦᔨᔪᒃ ᐊᐅᓚᑎᓗᒍ"
        tvHomeElevent.text = "ᖃᓂᐅᔮᕐᐯᑎᑑᕐᑐᑦ ᓄᐃᑎᓗᒋᑦ"
        layoutOne.setBackgroundResource(R.drawable.bg_click_main_orange)
        layoutTwo.setBackgroundResource(R.drawable.bg_click_main_black)
        layoutThree.setBackgroundResource(R.drawable.bg_click_main_black)
        checkLanguage = "one"
    }

    @SuppressLint("SetTextI18n")
    private fun setTextTwo() {
        val face = ResourcesCompat.getFont(this, R.font.roboto_regular);
        tvHomeTitle.typeface = face
        tvHomeTitleTwo.typeface = face
        tvHomeThree.typeface = face
        tvHomeFour.typeface = face
        tvHomeFive.typeface = face
        tvHomeSix.typeface = face
        tvHomeSeven.typeface = face
        tvHomeEight.typeface = face
        tvHomeNight.typeface = face
        tvHomeTen.typeface = face
        tvHomeTenMobile.typeface = face
        tvHomeElevent.typeface = face
        tvHomeTitle.text = "Inuktitut Keyboard"
        tvHomeTitleTwo.text = "Installation instruction"
        tvHomeThree.text = "• To enable the Inuktitut keyboard"
        tvHomeFour.text = "• Go to"
        tvHomeFive.text = "> Settings"
        tvHomeSix.text = "> System"
        tvHomeSeven.text = "> Languages & input"
        tvHomeEight.text = "> On screen keyboard"
        tvHomeNight.text = "• Enable Inuktitut"
        tvHomeTen.text = "Enable personalized suggestions"
        tvHomeTenMobile.text = "Enable personalized suggestions"
        tvHomeElevent.text = "View syllabic characters"
        layoutOne.setBackgroundResource(R.drawable.bg_click_main_black)
        layoutTwo.setBackgroundResource(R.drawable.bg_click_main_orange)
        layoutThree.setBackgroundResource(R.drawable.bg_click_main_black)
        checkLanguage = "two"
    }

    @SuppressLint("SetTextI18n")
    private fun setTextThree() {
        val face = ResourcesCompat.getFont(this, R.font.roboto_regular);
        tvHomeTitle.typeface = face
        tvHomeTitleTwo.typeface = face
        tvHomeThree.typeface = face
        tvHomeFour.typeface = face
        tvHomeFive.typeface = face
        tvHomeSix.typeface = face
        tvHomeSeven.typeface = face
        tvHomeEight.typeface = face
        tvHomeNight.typeface = face
        tvHomeTen.typeface = face
        tvHomeTenMobile.typeface = face
        tvHomeElevent.typeface = face
        tvHomeTitle.text = "Clavier en Inuktitut"
        tvHomeTitleTwo.text = "Instructions d'installation"
        tvHomeThree.text = "• Pour activer le clavier Inuktitut"
        tvHomeFour.text = "• Ouvrir"
        tvHomeFive.text = "> Paramètres"
        tvHomeSix.text = "> Système"
        tvHomeSeven.text = "> Langues et modes d'entrée"
        tvHomeEight.text = "> Clavier à l'écran"
        tvHomeNight.text = "• Activer Inuktitut"
        tvHomeTen.text = "Activer les suggestions personnalisées"
        tvHomeTenMobile.text = "Activer les suggestions personnalisées"
        tvHomeElevent.text = "Afficher les caractères syllabiques"
        layoutOne.setBackgroundResource(R.drawable.bg_click_main_black)
        layoutTwo.setBackgroundResource(R.drawable.bg_click_main_black)
        layoutThree.setBackgroundResource(R.drawable.bg_click_main_orange)
        checkLanguage = "three"
    }

    private fun showAlterDialog() {
        if (checkLanguage == "" || checkLanguage == "two") {
            AlertDialog.Builder(this)
                .setTitle("We need your consent")
                .setMessage("When \"Personalized suggestions\" enabled algorithms track what vocabulary you use and on what frequency. Algorithm provides suggestions based on how often the word was used by you. The algorithm is executed on the device and all the information is stored on locally on the device. You can disable suggestions or delete all collected data from this application") // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Enable"
                ) { dialog, which ->
                    switchUserIpad.isChecked = true
                    switchUserMobile.isChecked = true
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    switchUserIpad.isChecked = false
                    switchUserMobile.isChecked = false
                    dialog.dismiss()
                }
                .show()
        } else if (checkLanguage == "one") {
            AlertDialog.Builder(this)
                .setTitle("ᐊᖏᕐᓯᒪᐅᑎᓐᓂᐅᕕᑦ ᑭᖕᖒᒪᑦᓯᔪᒍ")
                .setMessage("\"ᐃᓕᓐᓂᑐᐊ ᐱᒍᑦᔨᔪᒃ\" ᐊᐅᓚᑎᑐᐊᒍᕕᐅᒃ, ᐊᓪᓚᒐᔪᓲᑎᑦ ᖃᕆᑕᐅᔮᕈᓐᓄᑦ ᓄᐊᑕᐅᔪᑦ ᐊᓪᓚᓕᕈᕕᑦ ᐅᖃᐅᓰᑦ " +
                        "ᐊᓪᓚᓲᑎᑦ ᓇᕐᓂᓗᒋᑦ ᓄᐃᑎᕇᕈᓐᓇᖃᑦᑕᕋᔭᕋᕕᒋᑦ. ᐅᖃᐅᓰᑦ ᓄᐊᑕᐅᒪᔪᑦ ᖃᕆᑕᐅᔮᕈᑉᐱᑦ ᐃᓗᐊᓃᑐᐃᓐᓇᓚᖓᔪᑦ " +
                        "ᓄᖑᑎᕈᓐᓇᓱᒋᓪᓗ. ᐃᓕᓐᓂᑐᐊ ᐱᒍᑦᔨᔪᒃ ᓄᕐᖃᑎᒍᓐᓇᑌᑦ")
                .setPositiveButton("ᐱᕈᓐᓇᓯᑎᓗᒍ",
                    DialogInterface.OnClickListener { dialog, which ->
                        switchUserIpad.isChecked = true
                        switchUserMobile.isChecked = true
                        dialog.dismiss()
                        // Continue with delete operation
                    }) // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("ᖁᔭᓇ") { dialog, which ->
                    switchUserIpad.isChecked = false
                    switchUserMobile.isChecked = false
                    dialog.dismiss()
                }
                .show()
        } else {
            AlertDialog.Builder(this)
                .setTitle("Nous avons besoin de votre consentement")
                .setMessage("Lorsque les \"Suggestions personnalisées\" sont activées, les algorithmes suivent le vocabulaire que vous utilisez et à quelle fréquence. L'algorithme fournit des suggestions en fonction de la fréquence à laquelle vous avez utilisé le mot. L'algorithme est exécuté sur l'appareil et toutes les informations sont stockées localement sur l'appareil. Vous pouvez désactiver les suggestions ou supprimer toutes les données collectées de cette application") // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Activer",
                    DialogInterface.OnClickListener { dialog, which ->
                        switchUserIpad.isChecked = true
                        switchUserMobile.isChecked = true
                        dialog.dismiss()
                    }) // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Annuler") { dialog, which ->
                    switchUserIpad.isChecked = false
                    switchUserMobile.isChecked = false
                    dialog.dismiss()
                }
                .show()
        }
    }

}