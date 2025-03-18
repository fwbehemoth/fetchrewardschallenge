package com.nickmcgough.fetchrewardschallenge.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.nickmcgough.fetchrewardschallenge.datamodels.ListItem
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun readJSONFromAssetsFolder(context: Context, path: String): String{
    val fileTag = "ReadJSON"

    try {
        val file = context.assets.open(path)

        val bufferedReader = BufferedReader(InputStreamReader(file))
        val stringBuilder = StringBuilder()
        bufferedReader.useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
            }
        }

        val jsonString = stringBuilder.toString()
        return jsonString
    } catch (except: Exception){
        Log.e(fileTag, "Error Reading JSON File: $except")
        except.printStackTrace()
        return ""
    }
}

fun convertStringToJSONObject(jsonString: String): List<ListItem> {
    return Gson().fromJson(jsonString, Array<ListItem>::class.java).toList()
}

fun getJSONObjectFromAssetsFolder(context: Context, path: String): List<ListItem>{
    return convertStringToJSONObject(readJSONFromAssetsFolder(context, path))
}

