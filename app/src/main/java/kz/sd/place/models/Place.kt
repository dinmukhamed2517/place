package kz.sd.place.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val id:Int,
    val name:String,
    val type:String,
    val rating:Double,
    val deposit:Int,
    val address:String,
    val description:String,
    @DrawableRes
    val img:Int,
):Parcelable
