package com.soumik.zsrecruitmenttest.ui.adapters

import android.content.res.Resources
import androidx.recyclerview.widget.DiffUtil


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class DiffUtil: DiffUtil.ItemCallback<com.soumik.zsrecruitmenttest.data.models.Resources>() {
    override fun areItemsTheSame(oldItem: com.soumik.zsrecruitmenttest.data.models.Resources, newItem: com.soumik.zsrecruitmenttest.data.models.Resources): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: com.soumik.zsrecruitmenttest.data.models.Resources, newItem: com.soumik.zsrecruitmenttest.data.models.Resources): Boolean {
        return oldItem==newItem
    }
}