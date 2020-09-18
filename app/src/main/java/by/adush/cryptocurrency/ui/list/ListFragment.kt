package by.adush.cryptocurrency.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.adush.cryptocurrency.R
import by.adush.cryptocurrency.data.retrofit.CryptoAPIFactory
import by.adush.cryptocurrency.ui.detail.Click
import by.adush.cryptocurrency.ui.adapter.CryptoAdapter
import by.adush.cryptocurrency.ui.MainActivity
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val PERC1H = "percentChange1h"
const val PERC24H = "percentChange24h"
const val DATE_ADDED = "DATE_ADDED"
const val URL = "URL"

class ListFragment : Fragment(), Click {

    override fun sendData(percentChange1h: Double, percentChange24h: Double, dateAdded: String, url: String) {
        val bundle = Bundle()
        bundle.putDouble(PERC1H, percentChange1h)
        bundle.putDouble(PERC24H, percentChange24h)
        bundle.putString(DATE_ADDED, dateAdded)
        bundle.putString(URL, url)
        val navController =
            Navigation.findNavController(context as MainActivity, R.id.navigation_host_fragment)
        navController.navigate(R.id.cryptoDetailFragment,bundle)
    }

    private lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListFragmentViewModel::class.java)


        CoroutineScope(Dispatchers.IO).launch {
            val result = CryptoAPIFactory.getRetrofit().getTopCrypto(10, "USD").await().body()

            if (result != null) {

                withContext(Dispatchers.Main) {
                    recyclerView.adapter =
                        CryptoAdapter(result, this@ListFragment)
                    recyclerView.layoutManager = LinearLayoutManager(parentFragment?.context)
                    recyclerView.setHasFixedSize(true)
                }
            }
        }


    }

}
