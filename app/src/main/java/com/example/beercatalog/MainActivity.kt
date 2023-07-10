package com.example.beercatalog

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beercatalog.adapter.NameAdapter
import com.example.beercatalog.dto.BeerCatalog
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<BeerCatalog>()
    private lateinit var adapter: NameAdapter
    private lateinit var checkBox: CheckBox

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = NameAdapter(mList)
        recyclerView.adapter = adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<BeerCatalog>()
            for (i in mList) {
                if (i.title.contains(query.capitalize())) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Beer found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun save(){
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val isChecked = checkBox.isChecked
        editor.putBoolean("checkBoxStatus", isChecked)
        val savedStatus = sharedPref.getBoolean("checkBoxStatus", false)
        checkBox.isChecked = savedStatus
    }


    private fun addDataToList() {
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л" , "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj asbdvasdbjv"))
        mList.add(BeerCatalog("Лидское", R.drawable.beer, "2.9p / 0,5 л","asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Алмида", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Крыница", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Раковский пив.", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Реформатор", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Жигулевское", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Corona", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Coronet", R.drawable.beer, "2.9p / 0,5 л" , "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj asbdvasdbjv"))
        mList.add(BeerCatalog("Двинское", R.drawable.beer, "2.9p / 0,5 л","asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Tuborg", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Miller", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Blank", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Балтика", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л" , "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj asbdvasdbjv"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л","asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
        mList.add(BeerCatalog("Аливария", R.drawable.beer, "2.9p / 0,5 л", "asdlgjasjdlbfjadsbjvbasdvjsbdvjlasbjdvj"))
    }
}