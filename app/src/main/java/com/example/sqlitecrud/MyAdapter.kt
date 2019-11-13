package com.example.sqlitecrud


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var dataList:List<UserModel>,private val context: Context):RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    private var databaseHelper: DatabaseHelper? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view,parent,false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        databaseHelper = DatabaseHelper(context)

        holder.txtview1.setText("Name:  "+dataList.get(position).name)
        holder.txtview2.setText("Designation:  "+dataList.get(position).designation)

        holder.btnedit.setOnClickListener {
            val intent:Intent=Intent(context,UpdateDeleteActivity::class.java)
            intent.putExtra("user",dataList[position])
            Toast.makeText(context,"hello ${dataList[position].id}",Toast.LENGTH_LONG).show()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
           context.startActivity(intent)
        }



        // holder.itemView.setOnClickListener {
        // val intent = Intent(context,UpdateActivity:: class.java)
        // intent.putExtra("user",userModelArrayList[position])
        // context.startActivity(intent)
        // }



      holder.btndelete.setOnClickListener {

           databaseHelper!!.deleteUSer(dataList[position].id)
          Toast.makeText(context, "Deleted Successfully!", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, MainActivity::class.java)
         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
          context.startActivity(intent)




       }

    }


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){


        var txtview1:TextView=view.findViewById(R.id.txt1)
        var txtview2:TextView=view.findViewById(R.id.txt2)
        var btnedit:Button=view.findViewById(R.id.edit)
        var btndelete:Button=view.findViewById(R.id.delete)

    }

}

