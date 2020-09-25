package com.soumik.zsrecruitmenttest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.soumik.zsrecruitmenttest.R
import com.soumik.zsrecruitmenttest.data.repositories.UserRepository
import com.soumik.zsrecruitmenttest.ui.adapters.DetailsAdapter
import com.soumik.zsrecruitmenttest.utils.Status
import com.soumik.zsrecruitmenttest.utils.showToast
import com.soumik.zsrecruitmenttest.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_next.*
import kotlinx.coroutines.launch

class NextActivity : AppCompatActivity() {

    private lateinit var mViewModel: UserViewModel
    private lateinit var mAdapter: DetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        mViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mAdapter = DetailsAdapter()

        setUpRecyclerView()
        setUpObservers()




    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            mViewModel.dashDetails(UserRepository()).observe(this@NextActivity,{
                it.let { resource ->
                    when(resource.status){
                        Status.SUCCESS->{
                            rv_list.visibility= View.VISIBLE
                            progress_bar.visibility=View.GONE
                            mAdapter.differ.submitList(it.data?.results!!.resources)
                        }
                        Status.ERROR->{
                            rv_list.visibility=View.GONE
                            progress_bar.visibility=View.GONE
                            showToast(this@NextActivity,it.error!!)
                        }
                        Status.LOADING->{
                            rv_list.visibility=View.GONE
                            progress_bar.visibility=View.VISIBLE
                        }
                    }
                }
            })
        }
    }

    private fun setUpRecyclerView() {
        rv_list.apply {
            layoutManager = LinearLayoutManager(this@NextActivity)
            setHasFixedSize(true)
            adapter=mAdapter
        }
    }
}