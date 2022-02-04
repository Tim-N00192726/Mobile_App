package com.example.mc_ca.data

import android.os.Parcel
import android.os.Parcelable

//the data class is a constructor class for the data used in the app
//it contains the primary constructor, in this case JokeEntity which contains the Joke parameters id,setup and punchline

data class JokeEntity(
    var id: String?,
    var setup: String?,
    var punchline: String?
) : Parcelable
{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(setup)
        parcel.writeString(punchline)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<JokeEntity> {
        override fun createFromParcel(parcel: Parcel): JokeEntity {
            return JokeEntity(parcel)
        }

        override fun newArray(size: Int): Array<JokeEntity?> {
            return arrayOfNulls(size)
        }
    }



}