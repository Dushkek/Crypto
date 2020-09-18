package by.adush.cryptocurrency.data.entity


import com.google.gson.annotations.SerializedName

data class Cryptocurrencies(
    @SerializedName("data")
    val `data`: List<Data>
)