package com.jovan.mlbbheroesdata

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailHeroes : AppCompatActivity() {
    private val list = ArrayList<MlbbHeroes>()

    companion object {
        const val EXTRA_HEROES_ID = "extra_heroes_id"
    }

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_heroes)
        val selectedHero = intent.getIntExtra(EXTRA_HEROES_ID, 0)

        val tvName: TextView = findViewById(R.id.tv_heroes_name)
        val tvRole: TextView = findViewById(R.id.tv_heroes_role)
        val imgPhoto: ImageView = findViewById(R.id.img_heroes_photo)
        val tvTitle: TextView = findViewById(R.id.tv_heroes_title)
        val tvSpeciality: TextView = findViewById(R.id.tv_heroes_speciality)
        val tvHeroesBackground: TextView = findViewById(R.id.tv_heroes_background)
        val tvHeroesSkill: TextView = findViewById(R.id.tv_heroes_skill)
        val tvSpecies: TextView = findViewById(R.id.tv_heroes_species)
        val tvHeroesOrigin: TextView = findViewById(R.id.tv_heroes_origin)
        val tvHeroesLane: TextView = findViewById(R.id.tv_heroes_lane)

        list.addAll(getListHeroes())
        val (
            name,
            photo,
            heroesRole,
            title,
            speciality,
            heroBackground,
            heroesSkill,
            species,
            heroesOrigin,
            laneReccomendation,
        ) = list[selectedHero]
        // Memasukkan data yang diterima ke dalam TextView dan ImageView pada layout
        tvName.text = name
        tvRole.text = heroesRole
        tvTitle.text = title
        tvSpeciality.text = speciality
        tvHeroesBackground.text = heroBackground
        tvHeroesSkill.text = heroesSkill
        tvSpecies.text = species
        tvHeroesOrigin.text = heroesOrigin
        tvHeroesLane.text = laneReccomendation
        imgPhoto.setImageResource(photo)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Heroes Detail"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.action_share) {
            val shareIntent =
                Intent().apply {
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_TEXT, "Data Success to share")
                    this.type = "text/plain"
                }

            startActivity((shareIntent))
        } else {
            return super.onOptionsItemSelected(item)
        }
        return true
    }

    @Suppress("DEPRECATION")
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    @SuppressLint("Recycle")
    private fun getListHeroes(): Collection<MlbbHeroes> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataHeroesRole = resources.getStringArray(R.array.data_heroes_role)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataHeroesBackground = resources.getStringArray(R.array.data_background)
        val dataSpeciality = resources.getStringArray(R.array.data_speciality)
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataSkill = resources.getStringArray(R.array.data_heroes_skill)
        val dataSpecies = resources.getStringArray(R.array.data_heroes_species)
        val dataOrigin = resources.getStringArray(R.array.data_heroes_origin)
        val dataLane = resources.getStringArray(R.array.data_heroes_lane)

        val listHeroes = ArrayList<MlbbHeroes>()

        for (i in dataName.indices) {
            val mlbbHeroes =
                MlbbHeroes(
                    name = dataName[i],
                    heroesRole = dataHeroesRole[i],
                    photo = dataPhoto.getResourceId(i, -1),
                    heroesBackground = dataHeroesBackground[i],
                    speciality = dataSpeciality[i],
                    title = dataTitle[i],
                    heroesSkill = dataSkill[i],
                    species = dataSpecies[i],
                    heroesOrigin = dataOrigin[i],
                    laneReccomendation = dataLane[i],
                )
            listHeroes.add(mlbbHeroes)
        }
        return listHeroes
    }
}
