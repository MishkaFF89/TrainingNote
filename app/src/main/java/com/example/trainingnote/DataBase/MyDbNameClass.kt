package com.example.trainingnote.DataBase

import android.provider.BaseColumns

object MyDbNameClass {
    const val TABLE_NAME = "fitnotes"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_WEIGHT1 = "weight1"
    const val COLUMN_NAME_WEIGHT2 = "weight2"
    const val COLUMN_NAME_WEIGHT3 = "weight3"
    const val COLUMN_NAME_WEIGHT4 = "weight4"
    const val COLUMN_NAME_WEIGHT5 = "weight5"
    const val COLUMN_NAME_WEIGHT6 = "weight6"

    const val COLUMN_NAME_QUA1 = "quantity1"
    const val COLUMN_NAME_QUA2 = "quantity2"
    const val COLUMN_NAME_QUA3 = "quantity3"
    const val COLUMN_NAME_QUA4 = "quantity4"
    const val COLUMN_NAME_QUA5 = "quantity5"
    const val COLUMN_NAME_QUA6 = "quantity6"

    const val COLUMN_NAME_TYPE = "type"
    const val COLUMN_NAME_DATA1 = "data1"
    const val COLUMN_NAME_DATA2 = "data2"
    const val COLUMN_NAME_TIME = "time"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "FitDB.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME " +
            "(${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_TITLE TEXT," +
            "$COLUMN_NAME_TYPE TEXT, $COLUMN_NAME_TIME TEXT, $COLUMN_NAME_DATA1 TEXT," +
            "$COLUMN_NAME_DATA2 TEXT, $COLUMN_NAME_WEIGHT1 TEXT, $COLUMN_NAME_QUA1 TEXT," +
            "$COLUMN_NAME_WEIGHT2 TEXT, $COLUMN_NAME_QUA2 TEXT,$COLUMN_NAME_WEIGHT3 TEXT," +
            "$COLUMN_NAME_QUA3 TEXT, $COLUMN_NAME_WEIGHT4 TEXT,$COLUMN_NAME_QUA4 TEXT," +
            "$COLUMN_NAME_WEIGHT5 TEXT, $COLUMN_NAME_QUA5 TEXT,$COLUMN_NAME_WEIGHT6 TEXT," +
            "$COLUMN_NAME_QUA6 TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}