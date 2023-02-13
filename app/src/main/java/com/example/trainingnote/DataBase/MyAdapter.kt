package com.example.trainingnote.DataBase

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingnote.R
import com.example.trainingnote.TextExercise

class MyAdapter(listMain: ArrayList<ListItem>, contextM: Context) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var listArray = listMain

    var context = contextM


    class MyHolder(itemView: View, contextV: Context) : RecyclerView.ViewHolder(itemView) {
        val tvBackground: ConstraintLayout = itemView.findViewById(R.id.tvBackground)

        val tvTitle: TextView = itemView.findViewById(R.id.tvNameTraining)

        val tvNameData1: TextView = itemView.findViewById(R.id.tvNameData1)
        val tvNameData2: TextView = itemView.findViewById(R.id.tvNameData2)

        val tvExWeight1: TextView = itemView.findViewById(R.id.tvExWeight1)
        val tvExWeight2: TextView = itemView.findViewById(R.id.tvExWeight2)
        val tvExWeight3: TextView = itemView.findViewById(R.id.tvExWeight3)
        val tvExWeight4: TextView = itemView.findViewById(R.id.tvExWeight4)
        val tvExWeight5: TextView = itemView.findViewById(R.id.tvExWeight5)
        val tvExWeight6: TextView = itemView.findViewById(R.id.tvExWeight6)

        val tvExQua1: TextView = itemView.findViewById(R.id.tvExQua1)
        val tvExQua2: TextView = itemView.findViewById(R.id.tvExQua2)
        val tvExQua3: TextView = itemView.findViewById(R.id.tvExQua3)
        val tvExQua4: TextView = itemView.findViewById(R.id.tvExQua4)
        val tvExQua5: TextView = itemView.findViewById(R.id.tvExQua5)
        val tvExQua6: TextView = itemView.findViewById(R.id.tvExQua6)

        val imTrain: ImageView = itemView.findViewById(R.id.imTraining)
        val timeTr: TextView = itemView.findViewById(R.id.tvTimeTr)
        val context = contextV


        fun setData(item: ListItem) {

            tvTitle.text = item.title
            timeTr.text = item.time
            tvNameData1.text = item.data1
            tvNameData2.text = item.data2

            tvExWeight1.text = item.weight1
            tvExWeight2.text = item.weight2
            tvExWeight3.text = item.weight3
            tvExWeight4.text = item.weight4
            tvExWeight5.text = item.weight5
            tvExWeight6.text = item.weight6

            tvExQua1.text = item.quantity1
            tvExQua2.text = item.quantity2
            tvExQua3.text = item.quantity3
            tvExQua4.text = item.quantity4
            tvExQua5.text = item.quantity5
            tvExQua6.text = item.quantity6





            if (item.type == "0") {
                tvBackground.setBackgroundResource(R.color.cardio)
                imTrain.setImageResource(R.drawable.iconcardio)
                tvExWeight2.visibility = View.GONE
                tvExQua2.visibility = View.GONE
                tvExWeight3.visibility = View.GONE
                tvExQua3.visibility = View.GONE
                tvExWeight4.visibility = View.GONE
                tvExQua4.visibility = View.GONE
                tvExWeight5.visibility = View.GONE
                tvExQua5.visibility = View.GONE
                tvExWeight6.visibility = View.GONE
                tvExQua6.visibility = View.GONE
            } else {
                tvBackground.setBackgroundResource(R.color.fitnes)
                imTrain.setImageResource(R.drawable.icongym)
                if (tvExWeight6.text == ""){
                    tvExWeight6.visibility = View.GONE
                    tvExQua6.visibility = View.GONE
                    if (tvExWeight5.text == ""){
                        tvExWeight5.visibility = View.GONE
                        tvExQua5.visibility = View.GONE
                        if (tvExWeight4.text == ""){
                            tvExWeight4.visibility = View.GONE
                            tvExQua4.visibility = View.GONE
                            if (tvExWeight3.text == ""){
                                tvExWeight3.visibility = View.GONE
                                tvExQua3.visibility = View.GONE
                                if (tvExWeight2.text == ""){
                                    tvExWeight2.visibility = View.GONE
                                    tvExQua2.visibility = View.GONE

                                }
                            }
                        }
                    }
                }
            }




            itemView.setOnClickListener {

                val intent = Intent(context, TextExercise::class.java).apply {
                    putExtra(MyIntentConstants.I_TITLE_KEY, item.title)
                    putExtra(MyIntentConstants.I_DATA1_KEY, item.data1)
                    putExtra(MyIntentConstants.I_DATA2_KEY, item.data2)

                    putExtra(MyIntentConstants.I_ID_KEY, item.id)
                    putExtra(MyIntentConstants.I_WEIGHT1_KEY, item.weight1)
                    putExtra(MyIntentConstants.I_QUANTITY1_KEY, item.quantity1)

                    putExtra(MyIntentConstants.I_WEIGHT2_KEY, item.weight2)
                    putExtra(MyIntentConstants.I_QUANTITY2_KEY, item.quantity2)

                    putExtra(MyIntentConstants.I_WEIGHT3_KEY, item.weight3)
                    putExtra(MyIntentConstants.I_QUANTITY3_KEY, item.quantity3)

                    putExtra(MyIntentConstants.I_WEIGHT4_KEY, item.weight4)
                    putExtra(MyIntentConstants.I_QUANTITY4_KEY, item.quantity4)

                    putExtra(MyIntentConstants.I_WEIGHT5_KEY, item.weight5)
                    putExtra(MyIntentConstants.I_QUANTITY5_KEY, item.quantity5)

                    putExtra(MyIntentConstants.I_WEIGHT6_KEY, item.weight6)
                    putExtra(MyIntentConstants.I_QUANTITY6_KEY, item.quantity6)
                }
                //context.startActivities(arrayOf(intent))
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)

        return MyHolder(inflater.inflate(R.layout.rc_full_training, parent, false), context)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        listArray.asReversed()
        holder.setData(listArray.get(position))

    }

    override fun getItemCount(): Int {
        return listArray.size
    }

    fun updateAdapter(listItems: List<ListItem>) {
        listArray.clear()
        listArray.addAll(listItems)

        notifyDataSetChanged()
    }



    fun removeItem(pos: Int, dbManager: MyDbManager) {
        dbManager.removeItemFromDb(listArray[pos].id.toString())
        listArray.removeAt(pos)
        notifyItemRangeChanged(0, listArray.size)
        notifyItemRemoved(pos)

    }
}