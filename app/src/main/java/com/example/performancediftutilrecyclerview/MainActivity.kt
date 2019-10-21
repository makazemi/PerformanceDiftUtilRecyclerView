package com.example.performancediftutilrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.performancediftutilrecyclerview.adapter.MitchAdapter
import com.example.performancediftutilrecyclerview.model.BlogPost
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MitchAdapter.Interaction {


    val TAG="MainActivity"

    private lateinit var blogAdapter:MitchAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRcy()
    }

    private fun initRcy(){
        blogAdapter=MitchAdapter(this)
        recyclerView.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=blogAdapter
        }
        blogAdapter.submitList(createList())
    }

    private fun createList():ArrayList<BlogPost>{
        val list=ArrayList<BlogPost>()
        val model1=BlogPost(1,"model1","body1","https://picsum.photos/200")
        val model2=BlogPost(2,"model2","body2","https://picsum.photos/200")
        val model3=BlogPost(3,"model3","body3","https://picsum.photos/200")
        val model4=BlogPost(4,"model4","body4","https://picsum.photos/200")
        list.add(model1)
        list.add(model2)
        list.add(model3)
        list.add(model4)
        return list
    }

    override fun onItemSelected(position: Int, item: BlogPost) {
        Log.e(TAG,"item:$position")
    }
}
