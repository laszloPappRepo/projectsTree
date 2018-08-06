package com.android.laci.superhero

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import com.android.laci.superhero.model.Hero
import com.bumptech.glide.Glide
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var mBtGoBack: Button? = null
    private val gson = Gson()
    private var heroDetails: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        receivingValue()
        heroDetails = findViewById(R.id.hero_details)
        mBtGoBack = findViewById(R.id.bt_go_back)
        mBtGoBack!!.setOnClickListener { finish() }
        FuelManager.instance.basePath = "http://httpbin.org"
    }

    private fun receivingValue() {
        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString("id")
            getHeroFromApi(id.toInt())
        }
    }

    private fun getHeroFromApi(receivedId: Int) {
        var imageView: ImageView? = ImageView(this)
            Fuel.get("http://superheroapi.com/api/1798381083516711/$receivedId")
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
                        Glide.with(this).load(heroImage.image!!.url).into(imageView!!)
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
    }
}