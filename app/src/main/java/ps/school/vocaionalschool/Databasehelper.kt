package ps.school.vocaionalschool

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Databasehelper(context: Context) :
    SQLiteOpenHelper(context, DATABASNAME, null, DATABASE_VERSION) {

    var db: SQLiteDatabase = this.writableDatabase
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE $DATABASE_TABLE_NAME($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT , $NAME TEXT ,$ADDRESS TEXT , $PHONE TEXT , $NUMBER TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $DATABASE_TABLE_NAME")
    }

    fun insert_data(name: String, address: String, phone: String, number: String): Boolean {
        val Values = ContentValues()
        Values.put(NAME, name)
        Values.put(ADDRESS, address)
        Values.put(PHONE, phone)
        Values.put(NUMBER, number)
        return db.insert(DATABASE_TABLE_NAME, null, Values) > 0
    }

    fun show_data(): ArrayList<SchoolModel> {
        val data = ArrayList<SchoolModel>()
        val cursor = db.rawQuery("SELECT * FROM $DATABASE_TABLE_NAME ORDER BY $KEY_ID DESC", null)
        cursor.moveToFirst()

        while (!cursor.isAfterLast) {
            data.add(
                SchoolModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
                )
            )
            cursor.moveToNext()
        }
        cursor.close()
        return data

    }

    fun delete_data(id: Int): Boolean {
        db.delete(DATABASE_TABLE_NAME, "$KEY_ID=?", arrayOf(id.toString())).toLong()
        return true
    }

    companion object {
        val KEY_ID = "ID"
        val NAME = "NAMES"
        val ADDRESS = "ADDRESS"
        val PHONE = "PHONE"
        val NUMBER = "NUMBER"

        /*----------------------------------------------*/
        val DATABASNAME = "school.db"
        val DATABASE_TABLE_NAME = "school"
        val DATABASE_VERSION = 2

    }


}