package com.example.performancediftutilrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.performancediftutilrecyclerview.R
import com.example.performancediftutilrecyclerview.model.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class GoogleAdapter:ListAdapter<BlogPost,GoogleAdapter.ViewHolder>(BlogPostDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(item:BlogPost){

            itemView.blog_title.text = item.title

            Glide.with(itemView.context)
                .load(item.image)
                .into(itemView.blog_image)
        }

        companion object{
            fun from(parent:ViewGroup):ViewHolder{
                val layoutInflater=LayoutInflater.from(parent.context)
                val view=layoutInflater.inflate(R.layout.layout_blog_list_item,parent,false)

                return ViewHolder(view)
            }
        }

    }

    class BlogPostDiffCallback:DiffUtil.ItemCallback<BlogPost>(){
        override fun areItemsTheSame(oldItem: BlogPost, newItem: BlogPost): Boolean {
           return oldItem.pk==newItem.pk
        }

        override fun areContentsTheSame(oldItem: BlogPost, newItem: BlogPost): Boolean {
            return oldItem==newItem
        }

    }

}