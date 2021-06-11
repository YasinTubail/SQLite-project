package ps.school.vocaionalschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detailes.*

class DetailesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailes)


        text_name_school.setText(intent.getStringExtra("putname"))
        text_address_school.setText(intent.getStringExtra("putaddress"))
        text_number_phone.setText(intent.getStringExtra("putphone"))
        text_number_student.setText(intent.getStringExtra("putnumber"))

        button_back.setOnClickListener {
            var back = Intent(this, ShowActivity::class.java)
            startActivity(back)
        }
    }
}