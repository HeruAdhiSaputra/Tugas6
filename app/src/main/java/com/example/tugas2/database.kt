package com.example.tugas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.view.ItemData
import com.example.view.MyAdapter

class database : AppCompatActivity() {
    private lateinit var dataRecyclerView: RecyclerView
    private lateinit var dataAdapter: MyAdapter
    private lateinit var datalist :ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_database)

        dataRecyclerView = findViewById(R.id.database)
        datalist = ArrayList()

        datalist.add(ItemData(R.drawable.id2,"Watchdog2","Hacker In Game"))
        datalist.add(ItemData(R.drawable.id3,"The Matrix","Hacker In Movie"))
        datalist.add(ItemData(R.drawable.id4,"Assasin","Hassasin"))
        datalist.add(ItemData(R.drawable.id5,"L","Hacker In Anime"))
        datalist.add(ItemData(R.drawable.id6,"Abraham Lincon","President Kemerdekaan Kulit hitam"))
        datalist.add(ItemData(R.drawable.id7,"Socroates","Filsuf Yunani Stoik"))
        datalist.add(ItemData(R.drawable.id8,"Plato","Filsuf Idealisme"))
        datalist.add(ItemData(R.drawable.id9,"Black Beard","Bajak laut"))
        datalist.add(ItemData(R.drawable.id10,"Jhonny deep","Actor Terbaik"))
        datalist.add(ItemData(R.drawable.id11,"2Pac shakur","Legenda Rapper West coast"))
        datalist.add(ItemData(R.drawable.id12,"snoop Dog","Rapper Unik"))
        datalist.add(ItemData(R.drawable.id13,"biggie","Legenda Rapper East Coast"))
        datalist.add(ItemData(R.drawable.huae,"karl Max","Bapak Komunis"))

        dataRecyclerView.layoutManager = LinearLayoutManager(this)
        dataRecyclerView.setHasFixedSize(true)
        dataAdapter = MyAdapter(datalist)
        dataRecyclerView.adapter =dataAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}