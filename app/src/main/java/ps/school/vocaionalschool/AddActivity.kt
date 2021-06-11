package ps.school.vocaionalschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        add_button.setOnClickListener {
            var myData = Databasehelper(this)
            myData.insert_data(
                name_school.text.toString(),
                address_school.text.toString(),
                num_phone_school.text.toString(),
                num_studrnt_school.text.toString()
            )
            name_school.text.clear()
            address_school.text.clear()
            num_phone_school.text.clear()
            num_studrnt_school.text.clear()

        }
        back_button.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}