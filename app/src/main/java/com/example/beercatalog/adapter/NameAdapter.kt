package com.example.beercatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView
import com.example.beercatalog.R
import com.example.beercatalog.dto.BeerCatalog

class NameAdapter(var mList: List<BeerCatalog>) :
    RecyclerView.Adapter<NameAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo : ImageView = itemView.findViewById(R.id.logo)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
        val price : TextView = itemView.findViewById(R.id.price)
        val langDescTv : TextView = itemView.findViewById(R.id.langDesc)
        val constraint : ConstraintLayout = itemView.findViewById(R.id.constraintLayout)

        fun collapseExpandedView(){
            langDescTv.visibility = View.GONE
        }
    }

    fun setFilteredList(mList: List<BeerCatalog>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item , parent , false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {

        val beerData = mList[position]

        holder.logo.setImageResource(beerData.logo)
        holder.titleTv.text = beerData.title
        holder.price.text = beerData.price
        holder.langDescTv.text = beerData.desc

        val isExpandable : Boolean = beerData.isExpandable
        holder.langDescTv.visibility = if(isExpandable) View.VISIBLE else View.GONE

        holder.constraint.setOnClickListener{
            isAnyItemExpanded(position)
            beerData.isExpandable = !beerData.isExpandable
            notifyItemChanged(position, Unit)
        }
    }

    private fun isAnyItemExpanded(position: Int){
        val temp = mList.indexOfFirst {
            it.isExpandable
        }

        if (temp >= 0 && temp!= position){
            mList[temp].isExpandable = false
            notifyItemChanged(temp, 0)
        }

    }

    override fun onBindViewHolder(
        holder: LanguageViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty() && payloads[0] == 0){

        }else {
            holder.collapseExpandedView()
        }
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}