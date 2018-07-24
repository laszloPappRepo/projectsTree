package com.android.laci.superhero2

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.android.laci.superhero2.model.Hero
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

@GlideModule
class MainActivity : AppCompatActivity() {


    private var tvGetResponse: TextView? = null
    private var progress: ProgressDialog? = null
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewsAndWidgets()
        FuelManager.instance.basePath = "http://httpbin.org"
    }

    private fun initViewsAndWidgets() {
        tvGetResponse = findViewById(R.id.tvGetResponse)
        progress = ProgressDialog(this)
        progress!!.setTitle("Kotlin Fuel Http Sample")
        progress!!.setMessage("Loading...")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val imageView = ImageView(this)

        when (item.itemId) {
            R.id.action_find_hero -> {
                var heroIdEditText = EditText(this)
                val dialog = android.support.v7.app.AlertDialog.Builder(this)
                        .setTitle("Get a hero")
                        .setMessage("Type an id number!")
                        .setView(heroIdEditText!!)
                        .setPositiveButton("Get") { dialog, which ->

                            try {
                                progress!!.show()
                                Fuel.get("http://superheroapi.com/api/1798381083516711/${heroIdEditText.text.toString().toInt()}")
                                        .responseJson { request, response, result ->

                                            /**
                                             * Getting the name value
                                             */
                                            val heroName = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroName!!.text = heroName.name

                                            /**
                                             * Getting the image url
                                             */
                                            val heroImage = gson.fromJson(result.get().content, Hero::class.java)
                                            val getHeroImage = findViewById<LinearLayout>(R.id.getHeroImage)
                                            val imageView = ImageView(this)
                                            Glide.with(this).load(heroImage.image!!.url).into(imageView)
                                            getHeroImage.addView(imageView)

                                            /**
                                             * Getting hero stats
                                             */
                                            val heroPowerIntelligence = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeropowerstatsIntelligence!!.text = heroPowerIntelligence.powerstats!!.intelligence.toString()
                                            val heroPowerStrength = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeropowerstatsStrength!!.text = heroPowerStrength.powerstats!!.strength.toString()
                                            val heroPowerSpeed = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeropowerstatsSpeed!!.text = heroPowerSpeed.powerstats!!.speed.toString()
                                            val heroPowerDurability = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeropowerstatsDurability!!.text = heroPowerDurability.powerstats!!.durability.toString()
                                            val heroPowerPower = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeropowerstatsPower!!.text = heroPowerPower.powerstats!!.power.toString()
                                            val heroPowerCombat = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeropowerstatsCombat!!.text = heroPowerCombat.powerstats!!.combat.toString()

                                            /**
                                             * Getting hero biography
                                             */
                                            val heroBioPublisher = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroBioPublisher!!.text = heroBioPublisher.biography!!.publisher.toString()
                                            val heroBioAlignment = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroBioAlignment!!.text = heroBioAlignment.biography!!.alignment.toString()

                                            /**
                                             * Getting hero appearance
                                             */
                                            val heroAppearanceGender = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroAppearanceGender!!.text = heroAppearanceGender.appearance!!.gender.toString()
                                            val heroAppearanceRace = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroAppearanceRace!!.text = heroAppearanceRace.appearance!!.race.toString()
                                            val heroAppearanceHeight = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroAppearanceHeight!!.text = heroAppearanceHeight.appearance!!.height.toString()
                                            val heroAppearanceWeight = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroAppearanceWeight!!.text = heroAppearanceWeight.appearance!!.weight.toString()

                                            /**
                                             * Getting hero work
                                             */
                                            val heroWorkOccupation = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroWorkOccupation!!.text = heroWorkOccupation.work!!.occupation.toString()
                                            val heroWorkBase = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroWorkBase!!.text = heroWorkBase.work!!.base.toString()

                                            /**
                                             * Getting hero connections
                                             */
                                            val heroConnectionsRelatives = gson.fromJson(result.get().content, Hero::class.java)
                                            getHeroConnectionsRelatives!!.text = heroConnectionsRelatives.connections!!.relatives.toString()

                                }
                            } catch (e: Exception) {
                                tvGetResponse!!.text = e.message
                            } finally {
                                progress!!.dismiss()
                            }
                        }
                        .setNegativeButton("Cancel", null)
                        .create()
                dialog.show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}




