package com.jovan.mlbbheroesdata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MlbbHeroes(
    val name: String = "",
    val photo: Int,
    val heroesRole: String,
    val title: String = "",
    val speciality: String = "",
    val heroesBackground: String = "",
    val heroesSkill: String = "",
    val species: String = "",
    val heroesOrigin: String = "",
    val laneReccomendation: String = "",
) : Parcelable
