package com.soumik.zsrecruitmenttest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.soumik.zsrecruitmenttest.Base
import com.soumik.zsrecruitmenttest.R
import com.soumik.zsrecruitmenttest.data.models.Resources
import kotlinx.android.synthetic.main.item_dashboard.view.*


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class DetailsAdapter:RecyclerView.Adapter<DetailsAdapter.Holder>() {
    class Holder(itemView:View):RecyclerView.ViewHolder(itemView) {

        fun bindView(data:Resources){
            itemView.tv_owner_name.text = data.owner.fullname
            itemView.tv_owner_team.text = data.owner.primaryTeam
            itemView.tv_title.text = data.event.title
            itemView.tv_caption.text = data.caption

            Glide.with(Base.context)
                .load(data.owner.avatar)
                .into(itemView.iv_avatar)

            Glide.with(Base.context)
                .load(data.photo)
                .into(itemView.iv_photo)
        }
    }

    val differ = AsyncListDiffer(this, DiffUtil())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = differ.currentList[position]
        holder.bindView(data)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}