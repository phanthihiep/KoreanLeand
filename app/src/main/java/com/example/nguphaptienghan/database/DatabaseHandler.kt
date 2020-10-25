package com.example.nguphaptienghan.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.example.nguphaptienghan.modle.Vocabulary

class DatabaseHandler(context: Context): SQLiteOpenHelper(context,DATABASE_NAME , null,DATABASE_VERSION) {
    companion object {
        private val DATABASE_VERSION = 3
        private val DATABASE_NAME = "korean"
        private val TABLE_CONTACTS = "words"
        private val KEY_ID = "id"
        private val KEY_KOREAN = "korean"
        private val KEY_VIETNAM = "vietnamese"
        private val KEY_TYPE = "type"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
            + KEY_ID + " INTEGER PRIMARY KEY," + KEY_KOREAN + " TEXT,"
            + KEY_VIETNAM + " TEXT," + KEY_TYPE + " TEXT" +")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)
        onCreate(db)
    }

    //insert data to db
    fun addVocabulary(vocabulary: Vocabulary): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, vocabulary.id)
        contentValues.put(KEY_KOREAN, vocabulary.korean)
        contentValues.put(KEY_VIETNAM,vocabulary.vietnamese )
        contentValues.put(KEY_TYPE,vocabulary.type )
        // Inserting Row
        val success = db.insert(TABLE_CONTACTS, null, contentValues)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
        return success
    }

    // get all vocabulary book one
    fun viewVocabularyOne(type: String):ArrayList<Vocabulary>{
        return commonGetVocabulary(type)
    }

    // get all vocabulary book two
    fun viewVocabularyTwo(type: String):ArrayList<Vocabulary>{
        return commonGetVocabulary(type)
    }

    // get all vocabulary book three
    fun viewVocabularyThree(type: String):ArrayList<Vocabulary>{
        return commonGetVocabulary(type)
    }

    // get all vocabulary book four
    fun viewVocabularyFour(type: String):ArrayList<Vocabulary>{
        return commonGetVocabulary(type)
    }

    // get all vocabulary book five
    fun viewVocabularyFive(type: String):ArrayList<Vocabulary>{
        return commonGetVocabulary(type)
    }

    // get all vocabulary book six
    fun viewVocabularySix(type: String):ArrayList<Vocabulary>{
        return commonGetVocabulary(type)
    }

    //method to read data
    @SuppressLint("Recycle")
    fun commonGetVocabulary(type: String):ArrayList<Vocabulary>{
        val vocabularyList:ArrayList<Vocabulary> = ArrayList()
        val selectQuery = "SELECT  * FROM $TABLE_CONTACTS WHERE $KEY_TYPE = $type"
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: SQLiteException) {
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id: Int
        var korean: String
        var vietnamese: String
        var type: String
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                korean = cursor.getString(cursor.getColumnIndex("korean"))
                vietnamese = cursor.getString(cursor.getColumnIndex("vietnamese"))
                type = cursor.getString(cursor.getColumnIndex("type"))
                val voc= Vocabulary(id = id, korean = korean, vietnamese = vietnamese, type = type)
                vocabularyList.add(voc)
            } while (cursor.moveToNext())
        }
        return vocabularyList
    }
}