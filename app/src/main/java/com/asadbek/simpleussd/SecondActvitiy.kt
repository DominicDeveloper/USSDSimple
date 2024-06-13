package com.asadbek.simpleussd

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asadbek.simpleussd.adapter.MyAdapter
import com.asadbek.simpleussd.databinding.ActivitySecondActvitiyBinding
import com.asadbek.simpleussd.models.MyObject

class SecondActvitiy : AppCompatActivity() {
    lateinit var listTarif: ArrayList<MyObject>
    lateinit var listDaqiqa:ArrayList<MyObject>
    lateinit var listSms:ArrayList<MyObject>
    lateinit var listYangiliklar:ArrayList<MyObject>
    lateinit var listInternet:ArrayList<MyObject>
    lateinit var listXizmatlar:ArrayList<MyObject>
    lateinit var binding: ActivitySecondActvitiyBinding
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondActvitiyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listTarif = ArrayList()
        listDaqiqa = ArrayList()
        listSms = ArrayList()
        listYangiliklar = ArrayList()
        listInternet = ArrayList()
        listXizmatlar = ArrayList()
        loadData()
        var key = intent.getStringExtra("key")
        when(key){
            "daqiqa" -> showDaqiqa()
            "sms" -> showSms()
            "internet" -> showInternet()
            "tariflar" -> showTarif()
            "xizmatlar" -> showXizmatlar()
            "yangiliklar" -> showNews()
            else -> showNews()
        }



    }
    private fun loadData(){
        listTarif.add(MyObject("Oson 10","*110*1#","O`zbekiston bo`ylab 100 daq. 500 sms. 10 gb trafik. Oylik to`lov: 10 000 so`m"))
        listTarif.add(MyObject("Oson 25","*110*15#","O`zbekiston bo`ylab 200 daq. 700 sms. 25 gb trafik. Oylik to`lov: 25 000 so`m"))
        listTarif.add(MyObject("Oson 30","*110*35#","O`zbekiston bo`ylab 1000 daq. 1000 sms. 30 gb trafik. Oylik to`lov: 30 000 so`m"))
        listDaqiqa.add(MyObject("10","*111*10#","O`zbekiston ichiga 10 daqiqa, Amal qilish muddati 7 kun. To`lov: 10 000 so`m"))
        listDaqiqa.add(MyObject("100","*111*100#","O`zbekiston ichiga 100 daqiqa, Amal qilish muddati 7 kun. To`lov: 40 000 so`m"))
        listDaqiqa.add(MyObject("500","*111*150#","O`zbekiston ichiga 500 daqiqa, Amal qilish muddati 30 kun. To`lov: 45 000 so`m"))
        listSms.add(MyObject("TOP 100","*112*1#","O`zbekiston ichidagi barcha yo`nalishlar uchun 100 ta sms. Ulanish narxi: 4 000 so`m"))
        listSms.add(MyObject("TOP 250","*112*25#","O`zbekiston ichidagi barcha yo`nalishlar uchun 250 ta sms. Ulanish narxi: 10 000 so`m"))
        listSms.add(MyObject("TOP 500","*112*10#","O`zbekiston ichidagi barcha yo`nalishlar uchun 500 ta sms. Ulanish narxi: 15 500 so`m"))
        listYangiliklar.add(MyObject("AKSIYA","*1#","O`zbekiston bo`ylab barcha abonentlar uchun bepul 10 gb trafik"))
        listInternet.add(MyObject("1 GB","*120*1#","1 GB internet trafik 30 kunga. Ulanish narxi: 10 000 so`m"))
        listInternet.add(MyObject("5 GB","*120*5#","5 GB internet trafik 30 kunga. Ulanish narxi: 20 000 so`m"))
        listInternet.add(MyObject("10 GB","*120*10#","10 GB internet trafik 30 kunga. Ulanish narxi: 50 000 so`m"))
        listXizmatlar.add(MyObject("Aloqada","*108*8#","Tarmoqda bo`lmaganingizdaxam doyimo aloqada bo`ling. Ulanish narxi: 0 so`m"))
        listXizmatlar.add(MyObject("Esim","*107*9#","Sim kartasiz doyimo aloqada bo`lish imkoniyati(Bu faqat eSim ni qo`llab quvvatlaydigan telefonlarda ishlaydi). Ulanish narxi: 13 000 so`m"))

    }
    private fun showTarif(){
        myAdapter = MyAdapter(this,listTarif,object : MyAdapter.RvClick{
            override fun onClick(myObject: MyObject) {
                finalActivity(myObject)
            }
        })
        myAdapter.notifyDataSetChanged()
        binding.mainRv.adapter = myAdapter

    }
    private fun showDaqiqa(){
        myAdapter = MyAdapter(this,listDaqiqa,object : MyAdapter.RvClick{
            override fun onClick(myObject: MyObject) {
                finalActivity(myObject)
            }
        })
        myAdapter.notifyDataSetChanged()
        binding.mainRv.adapter = myAdapter
    }
    private fun showSms(){
        myAdapter = MyAdapter(this,listSms,object : MyAdapter.RvClick{
            override fun onClick(myObject: MyObject) {
                finalActivity(myObject)
            }
        })
        myAdapter.notifyDataSetChanged()
        binding.mainRv.adapter = myAdapter
    }
    private fun showXizmatlar(){
        myAdapter = MyAdapter(this,listXizmatlar,object : MyAdapter.RvClick{
            override fun onClick(myObject: MyObject) {
                finalActivity(myObject)
            }
        })
        myAdapter.notifyDataSetChanged()
        binding.mainRv.adapter = myAdapter
    }
    private fun showInternet(){
        myAdapter = MyAdapter(this,listInternet,object : MyAdapter.RvClick{
            override fun onClick(myObject: MyObject) {
                finalActivity(myObject)
            }
        })
        myAdapter.notifyDataSetChanged()
        binding.mainRv.adapter = myAdapter
    }
    private fun showNews(){
        myAdapter = MyAdapter(this,listYangiliklar,object : MyAdapter.RvClick{
            override fun onClick(myObject: MyObject) {
                finalActivity(myObject)
            }
        })
        myAdapter.notifyDataSetChanged()
        binding.mainRv.adapter = myAdapter
    }
    private fun finalActivity(myObject: MyObject){
        val intent = Intent(this,FinalActivity::class.java)
        intent.putExtra("key",myObject)
        startActivity(intent)
    }

}