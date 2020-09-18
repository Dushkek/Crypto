package by.adush.cryptocurrency.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import by.adush.cryptocurrency.R
import by.adush.cryptocurrency.ui.list.DATE_ADDED
import by.adush.cryptocurrency.ui.list.PERC1H
import by.adush.cryptocurrency.ui.list.PERC24H
import by.adush.cryptocurrency.ui.list.URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_detail_fragment.*

class CryptoDetailFragment : Fragment() {

    private lateinit var viewModel: CryptoDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.crypto_detail_fragment, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CryptoDetailViewModel::class.java)

        val bundle = arguments
        if (bundle != null) {

            percentChange1h.text =  bundle.getDouble(PERC1H).toString()
            percentChange24h.text = "24h change: ${bundle.getDouble(PERC24H)} USD"
            dateAdded.text = "Date added: ${bundle.getString(DATE_ADDED)}"
            Picasso.get().load(bundle.getString(URL)).into(imageOfCrypto)
        }


        when {
            bundle!!.getDouble(PERC1H) > 0.0 -> {
                percentChange1h.text = "1h change: +${ bundle.getDouble(PERC1H)} USD"
                percentChange1h.setTextColor(
                    ContextCompat.getColor(
                        context!!.applicationContext,
                        R.color.colorGreen
                    )
                )

            }
            bundle.getDouble(PERC1H)< 0.0 -> {
                percentChange1h.text= "1h change: -${bundle.getDouble(PERC1H)} USD"
                percentChange1h.setTextColor(
                    ContextCompat.getColor(
                        context!!.applicationContext,
                        R.color.colorRed
                    )
                )
            }
            bundle.getDouble(PERC1H) == 0.0 -> {
                percentChange1h.text = "1h change: ${bundle.getDouble(PERC1H)} USD"
                percentChange1h.setTextColor(
                    ContextCompat.getColor(
                        context!!.applicationContext,
                        R.color.colorDefault
                    )
                )
            }
        }

    }



}
