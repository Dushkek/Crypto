package by.adush.cryptocurrency.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.adush.cryptocurrency.R
import by.adush.cryptocurrency.data.entity.Cryptocurrencies
import by.adush.cryptocurrency.ui.detail.Click
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*
import java.text.DecimalFormat


class CryptoAdapter(private val cryptocurrencies : Cryptocurrencies, private val click: Click) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>()  {

    class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return CryptoViewHolder(itemView)
    }

    override fun getItemCount(): Int = cryptocurrencies.data.size


    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val myView = holder.itemView

        Picasso.get()
            .load("https://s2.coinmarketcap.com/static/img/coins/200x200/${cryptocurrencies.data[position].id}.png")
            .into(myView.imageOfCrypto)
        myView.nameOfCrypto.text = cryptocurrencies.data[position].name
        val price = cryptocurrencies.data[position].quote.USD.price
        myView.priceOfCrypto.text = DecimalFormat("#0.000").format(price) + " USD"


        myView.setOnClickListener {
                click.sendData(
                    cryptocurrencies.data[position].quote.USD.percentChange1h,
                    cryptocurrencies.data[position].quote.USD.percentChange24h,
                    cryptocurrencies.data[position].dateAdded,
                    "https://s2.coinmarketcap.com/static/img/coins/200x200/${cryptocurrencies.data[position].id}.png"
                )

        }

//        var connected = false
//        try {
//            val cm = (myView.context).getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val nInfo = cm.activeNetworkInfo
//            connected = nInfo != null && nInfo!!.isAvailable && nInfo!!.isConnected
//
//        } catch (e: Exception) {
//            Log.e("Connectivity Exception", e.message)
//        }
//
//        fun saveDate(){
//            val sharedPreferences = (myView.context).getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//            editor.apply{
//                putString("NAME", cryptocurrencies.data[position].name)
//                putString("PRICE", cryptocurrencies.data[position].quote.USD.price.toString())
//            }.apply()
//        }
//
//        fun loadDate(){
//        if (!connected) {
//            val savedName = sharedPreferences.getString("NAME", null)
//            val savedPrice = sharedPreferences.getString("Price", null)
//
//            myView.nameOfCrypto.text = savedName
//            myView.priceOfCrypto.text = "$savedPrice USD"
//        }
//        }



    }




}

