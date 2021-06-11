package ps.school.vocaionalschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent= Intent(this,AddActivity::class.java)
        val intent2= Intent(this,ShowActivity::class.java)
        button_add.setOnClickListener {
            startActivity(intent)
        }
        button_show.setOnClickListener {
            startActivity(intent2)
        }

    }
}