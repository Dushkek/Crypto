package by.adush.cryptocurrency.data.entity


import com.google.gson.annotations.SerializedName

data class USD(
    @SerializedName("percent_change_1h")
    val percentChange1h: Double,
    @SerializedName("percent_change_24h")
    val percentChange24h: Double,
    @SerializedName("price")
    val price: Double
)