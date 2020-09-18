package by.adush.cryptocurrency.data.entity


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("date_added")
    val dateAdded: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("quote")
    val quote: Quote,
    @SerializedName("symbol")
    val symbol: String
)