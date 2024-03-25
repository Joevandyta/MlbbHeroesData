package com.jovan.mlbbheroesdata

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<MlbbHeroes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

        supportActionBar!!.setTitle("MLBB Heroes Data")
    }

//    Create ActionMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveToAboutActivity = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveToAboutActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): Collection<MlbbHeroes> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataHeroesRole = resources.getStringArray(R.array.data_heroes_role)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listHeroes = ArrayList<MlbbHeroes>()

        for (i in dataName.indices) {
            val mlbbHeroes = MlbbHeroes(name = dataName[i], heroesRole = dataHeroesRole[i], photo = dataPhoto.getResourceId(i, -1))
            listHeroes.add(mlbbHeroes)
        }
        return listHeroes
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val heroesListAdapter = HeroesListAdapter(list)
        rvHeroes.adapter = heroesListAdapter

        heroesListAdapter.setOnItemClickCallback(
            object : HeroesListAdapter.OnItemClickCallback {
                override fun onItemClicked(
                    data: MlbbHeroes,
                    position: Int,
                ) {
                    val moveToDetail = Intent(this@MainActivity, DetailHeroes::class.java)
                    moveToDetail.putExtra(DetailHeroes.EXTRA_HEROES_ID, position)
                    startActivity(moveToDetail)
                }
            },
        )
    }
}
