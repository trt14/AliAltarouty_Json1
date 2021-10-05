package com.example.json1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parseJson()
    }

    fun parseJson() {
        var TAG = "sometag"

        val stringJson = "" +
                "{\"details\":[" +
                "{\"Name\":\"Abdul\", \"Age\":\"21\",\"Location\":\"Saudi Arabia\", \"Blood group\":    \"B+\", \"Mobile\":{\"Phone\":{\"Personal\":\"+00 9876543210\",\"Home\":\"044 482248682\"}}}," +
                "{\"Name\":\"Rahman\",\"Age\":\"22\",\"Location\":\"SouthAfrica \", \"Blood group\":    \"A+\", \"Mobile\":{\"Phone\":{\"Personal\":\"+00 9876234210\",\"Home\":\"044-872248682\"}}}," +
                "{\"Name\":\"King\",  \"Age\":\"32\",\"Location\":\"England\",      \"Blood group\":    \"B+\", \"Mobile\":{\"Phone\":{\"Personal\":\"+00 9876542210\",\"Home\":\" 044-212248682\"}}}," +
                "{\"Name\":\"Prince\",\"Age\":\"19\",\"Location\":\"USA\",          \"Blood group\":    \"AB+\",\"Mobile\":{\"Phone\":{\"Personal\":\"+00 3876543210\",\"Home\":\"044-182248682\"}}}]}"

        Log.i(TAG, "Json as string : $stringJson");

        try {
            val jsonObject = JSONObject(stringJson)
            Log.i(TAG, "Json as whole object : $jsonObject");

            val detailsJsonarray = jsonObject.getJSONArray("details")
            Log.i("detailsArray", "Json as whole array : $detailsJsonarray\n\n\n");

            val firstsingleobject = detailsJsonarray.getJSONObject(0)
            Log.i("firstObject", "Json as single first object : $firstsingleobject\n\n\n");
            val firstarray :String = firstsingleobject.getString("Name");
            Log.i("firstObjectfirstarray", "Json as single first object first array : $firstarray\n\n\n");

            val tv : TextView = findViewById(R.id.tv)

            tv.text = "Json as whole object : $jsonObject \n\n\n"+
                    "Json as whole array : $detailsJsonarray\n\n\n"+
                    "Json as single first object : $firstsingleobject\n\n\n"+
                    "Json as single first array of first object :$firstarray\n\n\n"

        } catch (e: Exception) {
        }
    }
}
