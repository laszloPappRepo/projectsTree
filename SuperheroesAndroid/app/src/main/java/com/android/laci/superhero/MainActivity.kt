package com.android.laci.superhero
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.bumptech.glide.annotation.GlideModule

@GlideModule
class MainActivity : AppCompatActivity() {

    private var mBtLaunchActivity: Button? = null
    private var tvGetResponse: TextView? = null
    private var progress: ProgressDialog? = null
    private var heroId: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewsAndWidgets()
        initView()
        sendHeroIdToNextActivity()
    }

    private fun initViewsAndWidgets() {
        tvGetResponse = findViewById(R.id.tvGetResponse)
        progress = ProgressDialog(this)
        progress!!.setTitle("Kotlin Fuel Http Sample")
        progress!!.setMessage("Loading...")
    }

    private fun initView() {
        mBtLaunchActivity = findViewById<Button>(R.id.bt_launch_activity)
        heroId = findViewById<EditText>(R.id.tvGetResponse)
    }

    private fun sendHeroIdToNextActivity(){
        mBtLaunchActivity!!.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra ("id", heroId!!.text.toString())
            startActivity(intent)
        }
    }
}
