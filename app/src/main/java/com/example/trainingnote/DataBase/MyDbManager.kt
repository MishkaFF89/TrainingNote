package com.example.trainingnote.DataBase

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class MyDbManager (context: Context){

    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDbHelper.writableDatabase
    }

    fun insertToDb(title: String, weight1: String, quantity1: String,
                   weight2: String, quantity2: String, weight3: String, quantity3: String,
                   weight4: String, quantity4: String, weight5: String, quantity5: String,
                   weight6: String, quantity6: String, type: String, time: String, data1: String, data2: String) {

        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT1, weight1)
            put(MyDbNameClass.COLUMN_NAME_QUA1, quantity1)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT2, weight2)
            put(MyDbNameClass.COLUMN_NAME_QUA2, quantity2)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT3, weight3)
            put(MyDbNameClass.COLUMN_NAME_QUA3, quantity3)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT4, weight4)
            put(MyDbNameClass.COLUMN_NAME_QUA4, quantity4)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT5, weight5)
            put(MyDbNameClass.COLUMN_NAME_QUA5, quantity5)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT6, weight6)
            put(MyDbNameClass.COLUMN_NAME_QUA6, quantity6)

            put(MyDbNameClass.COLUMN_NAME_TYPE, type)
            put(MyDbNameClass.COLUMN_NAME_TIME, time)

            put(MyDbNameClass.COLUMN_NAME_DATA1, data1)
            put(MyDbNameClass.COLUMN_NAME_DATA2, data2)


        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)

    }

    /*fun updateToDb( title: String, weight1: String, quantity1: String,
                   weight2: String, quantity2: String,weight3: String, quantity3: String,
                   weight4: String, quantity4: String,weight5: String, quantity5: String,
                   weight6: String, quantity6: String, id: Int, type: String) {
        val selection = BaseColumns._ID + "=$id"
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUMN_NAME_TITLE, title)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT1, weight1)
            put(MyDbNameClass.COLUMN_NAME_QUA1, quantity1)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT2, weight2)
            put(MyDbNameClass.COLUMN_NAME_QUA2, quantity2)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT3, weight3)
            put(MyDbNameClass.COLUMN_NAME_QUA3, quantity3)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT4, weight4)
            put(MyDbNameClass.COLUMN_NAME_QUA4, quantity4)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT5, weight5)
            put(MyDbNameClass.COLUMN_NAME_QUA5, quantity5)

            put(MyDbNameClass.COLUMN_NAME_WEIGHT6, weight6)
            put(MyDbNameClass.COLUMN_NAME_QUA6, quantity6)


        }
        db?.update(MyDbNameClass.TABLE_NAME, values, selection, null)
    }*/

    fun removeItemFromDb(id: String) {
        val selection = BaseColumns._ID + "=$id"
        db?.delete(MyDbNameClass.TABLE_NAME, selection, null)
    }



    @SuppressLint("Range")
    fun readDbData(columnName: String): ArrayList<ListItem>{

        val dataList = ArrayList<ListItem>()


        val cursor = db?.query(MyDbNameClass.TABLE_NAME,
            null, null, null, null, null, null)
        while (cursor?.moveToNext()!!) {

            val dataTitle = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TITLE))
            val time = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TIME))
            val typeId = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_TYPE))
            val dataT1 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_DATA1))
            val dataT2 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_DATA2))
            val dataId = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))

            val dataWeight1 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_WEIGHT1))
            val dataQuantity1 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_QUA1))

            val dataWeight2 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_WEIGHT2))
            val dataQuantity2 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_QUA2))

            val dataWeight3 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_WEIGHT3))
            val dataQuantity3 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_QUA3))

            val dataWeight4 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_WEIGHT4))
            val dataQuantity4 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_QUA4))

            val dataWeight5 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_WEIGHT5))
            val dataQuantity5 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_QUA5))

            val dataWeight6 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_WEIGHT6))
            val dataQuantity6 = cursor.getString(cursor.getColumnIndex(MyDbNameClass.COLUMN_NAME_QUA6))



            val item =ListItem()
            item.title = dataTitle

            item.time = time
            item.type = typeId

            item.data1 = dataT1
            item.data2 = dataT2

            item.id = dataId

            item.weight1 = dataWeight1
            item.quantity1 = dataQuantity1

            item.weight2 = dataWeight2
            item.quantity2 = dataQuantity2

            item.weight3 = dataWeight3
            item.quantity3 = dataQuantity3

            item.weight4 = dataWeight4
            item.quantity4 = dataQuantity4

            item.weight5 = dataWeight5
            item.quantity5 = dataQuantity5

            item.weight6 = dataWeight6
            item.quantity6 = dataQuantity6


            dataList.add(item)
        }

        cursor.close()

        return dataList

    }


    fun closeDb(){
        myDbHelper.close()
    }
}