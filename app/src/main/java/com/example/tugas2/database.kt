package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class database : AppCompatActivity() {

    private lateinit var databaseRecyclerView: RecyclerView
    private lateinit var databaseList: ArrayList<Image>
    private lateinit var databaseAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_database)

        databaseList = ArrayList()

        databaseList.add(
            Image(R.drawable.id1,"Alan Walker","Alan Walker adalah seorang DJ, produser musik, dan penulis lagu asal Inggris-Norwegia. Ia terkenal secara global setelah merilis lagu \"Faded\" pada tahun 2015, yang langsung meledak dan jadi hit internasional.")
        )
        databaseList.add(
            Image(R.drawable.id2,"Watch Dog 2","Watch Dogs 2 adalah sebuah video game aksi-petualangan (action-adventure) dunia terbuka yang dikembangkan oleh Ubisoft dan dirilis pada tahun 2016.")
        )
        databaseList.add(
            Image(R.drawable.id3,"The Matrix","The Matrix adalah sebuah film fiksi ilmiah ikonik yang dirilis pada tahun 1999, disutradarai oleh The Wachowskis. Film ini jadi tonggak penting dalam dunia perfilman karena ceritanya yang mind-blowing dan efek visualnya yang revolusioner (terutama bullet time).")
        )
        databaseList.add(
            Image(R.drawable.id4,"Assasin","Assassin's Creed adalah sebuah seri video game aksi-petualangan yang sangat terkenal, dikembangkan oleh Ubisoft. Game ini menggabungkan unsur sejarah, petualangan, dan stealth (penyusupan) dengan cerita yang kompleks tentang konflik abadi antara dua kelompok: Assassin dan Templar.")
        )
        databaseList.add(
            Image(R.drawable.id5,"L","L adalah seorang detektif jenius dan misterius yang ditugaskan menyelidiki kasus pembunuhan massal oleh Kira. Dikenal dengan gaya duduk unik, kecintaan pada makanan manis, dan kemampuan analisis luar biasa, L menjadi lawan utama Light Yagami dalam pertarungan intelektual yang menegangkan.")
        )
        databaseList.add(
            Image(R.drawable.id6,"Abraham Lincon","Abraham Lincoln adalah Presiden ke-16 Amerika Serikat yang terkenal karena memimpin negara selama Perang Saudara dan menghapus perbudakan melalui Proklamasi Emansipasi. Ia dikenal sebagai simbol keadilan, persatuan, dan demokrasi.")
        )
        databaseList.add(
            Image(R.drawable.id7,"Socrates","Socrates adalah seorang filsuf Yunani kuno yang dianggap sebagai bapak filsafat Barat. Ia dikenal karena metode tanya-jawabnya (Metode Socrates) dan pemikirannya tentang etika, kebenaran, dan kebijaksanaan.")
        )
        databaseList.add(
            Image(R.drawable.id8,"Plato","Plato adalah filsuf Yunani kuno, murid Socrates dan guru Aristoteles. Ia dikenal karena pemikirannya tentang dunia ide, keadilan, dan politik, serta pendiri Akademi—sekolah filsafat pertama di dunia Barat.")
        )
        databaseList.add(
            Image(R.drawable.id9,"Black Beard","Blackbeard, atau nama aslinya Edward Teach (atau Thatch), adalah seorang bajak laut terkenal asal Inggris yang aktif pada awal abad ke-18. Ia dikenal karena penampilannya yang menakutkan, dengan janggut hitam panjang yang dibakar dengan rumbai untuk menciptakan kesan menakutkan. Blackbeard mengendalikan kapal Queen Anne’s Revenge dan terkenal dengan tindakan kekerasan serta perampokan di perairan Karibia dan sepanjang pantai timur Amerika Utara. Ia tewas dalam pertempuran dengan pasukan Inggris pada 1718.")
        )
        databaseList.add(
            Image(R.drawable.id10,"captain jack spaparow","Jack Sparrow adalah karakter fiksi dari seri film Pirates of the Caribbean, yang diperankan oleh Johnny Depp. Ia adalah seorang bajak laut yang cerdik, penuh akal, dan agak gila, dengan gaya berpakaian yang unik dan perilaku yang tak terduga. Jack terkenal karena kecintaannya pada kebebasan dan petualangan, serta kemampuannya dalam bernegosiasi dan menghindari bahaya. Meskipun sering terlibat dalam berbagai konflik dan masalah, Jack selalu berhasil keluar dari situasi sulit dengan cara yang tak terduga. Karakter ini menjadi ikonik karena kepribadiannya yang karismatik dan humoris.")
        )
        databaseList.add(
            Image(R.drawable.id11,"2pac Shakur",
                    "Tupac Shakur, atau 2Pac, adalah rapper dan aktor asal Amerika yang terkenal dengan lirik-liriknya yang membahas ketidakadilan sosial, kekerasan, dan kehidupan di jalanan. Album-albumnya seperti All Eyez on Me dianggap sebagai karya klasik hip-hop. 2Pac juga dikenal karena keterlibatannya dalam isu sosial dan budaya. Ia tewas tragis pada 1996 dalam penembakan yang belum terpecahkan.")
        )
        databaseList.add(
            Image(R.drawable.id12,"snoop doog","Snoop Dogg, lahir sebagai Calvin Broadus Jr., adalah rapper, produser, dan ikon budaya asal Amerika. Ia terkenal dengan gaya rap santai dan vokalnya yang khas. Debutnya lewat album Doggystyle pada 1993 membuatnya menjadi salah satu rapper terkemuka. Selain musik, Snoop juga aktif di dunia film, televisi, dan bisnis.")
        )
        databaseList.add(
            Image(R.drawable.id13,"biggie","The Notorious B.I.G., atau Biggie Smalls, adalah rapper asal Amerika yang dikenal karena gaya rapnya yang halus dan lirik yang kuat. Nama asli beliau adalah Christopher Wallace, dan ia menjadi ikon hip-hop di 1990-an. Album debutnya, Ready to Die, dianggap sebagai salah satu album terbaik dalam sejarah hip-hop. Biggie tewas tragis dalam penembakan pada 1997, yang masih menjadi misteri hingga sekarang.")
        )
        databaseList.add(
            Image(R.drawable.huae,"Karl Max","Karl Marx adalah seorang filsuf, ekonom, dan pemikir sosial asal Jerman yang dikenal sebagai pendiri teori Marxisme. Ia terkenal karena karyanya Das Kapital dan The Communist Manifesto, yang mengkritik kapitalisme dan menganjurkan revolusi untuk menggulingkan sistem kelas sosial. Marx berpendapat bahwa sejarah umat manusia adalah sejarah perjuangan kelas, dan ia mengusulkan masyarakat tanpa kelas di mana sumber daya dan produksi dikelola bersama. Pemikiran Marx memiliki dampak besar terhadap teori politik dan gerakan sosial di seluruh dunia.")
        )

        databaseRecyclerView = findViewById(R.id.myRecyclerView)
        databaseRecyclerView.setHasFixedSize(true)
        databaseRecyclerView.layoutManager = LinearLayoutManager(this)

        databaseAdapter = ImageAdapter(databaseList)
        databaseRecyclerView.adapter = databaseAdapter
        databaseAdapter.onItemClick = {
            val intent = Intent (this,DetailActivity::class.java)
            intent.putExtra("databse", it)
            startActivity(intent)




//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
        }
    }
}