package ps.school.vocaionalschool

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.custom_view_layout.view.*

class SchoolAdapter(var activity: Activity, var data:ArrayList<SchoolModel>) : BaseAdapter(){
    override fun getView(postion: Int, convertView: View?, parent: ViewGroup?): View {
        var inflate=LayoutInflater.from(activity).inflate(R.layout.custom_view_layout,parent,false)
        inflate.name_school_.text=data[postion].name
        inflate.button_delete.setOnClickListener {
            val database=Databasehelper(activity)
            if (database.delete_data(data[postion].id)){
                data.removeAt(postion)
                Toast.makeText(activity,"تم الحذف بنجاح",Toast.LENGTH_SHORT).show()
            }
        }
        inflate.button_inforamtion.setOnClickListener {
            val intent= Intent(activity,DetailesActivity::class.java)
             intent.putExtra("putname",data[postion].name)
             intent.putExtra("putaddress",data[postion].address)
             intent.putExtra("putphone",data[postion].phone)
             intent.putExtra("putnumber",data[postion].number)
            activity.startActivity(intent)

        }
        return inflate

    }
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(postion: Int): Any {
        return data[postion]

    }

    override fun getItemId(postion: Int): Long {
        return postion.toLong()

    }


}