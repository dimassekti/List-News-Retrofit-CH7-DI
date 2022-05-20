package com.coufie.tugasempatchaptertujuhbinardependencyinjection.dengan_viewmodel.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FilmDao {

    @Insert
    fun insertNote(film: Film)  : Long

    @Query("SELECT * FROM Film")
    fun getAllFilm() : List<Film>

    @Delete
    fun deleteFilm(film: Film) : Int

}