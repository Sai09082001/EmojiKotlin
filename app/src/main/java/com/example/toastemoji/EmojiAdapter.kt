package com.example.toastemoji

import android.content.Context
import android.content.LocusId
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EmojiAdapter(val mContext :Context , val listEmoji :Array<Int>) :
    RecyclerView.Adapter<EmojiAdapter.Companion.EmojiHolder>() {

    companion object{
         class EmojiHolder(val context: Context,view :View) :RecyclerView.ViewHolder(view){
            val ivEmoji = view.findViewById<ImageView>(R.id.iv_emoji)
            init {
                view.setOnClickListener{
                    it.startAnimation(AnimationUtils.loadAnimation(context,androidx.appcompat.R.anim.abc_popup_enter))
                    toastEmoji(ivEmoji.tag as Int)
                }
            }

             private fun toastEmoji(imageEmoijId: Int) {
                 val toast = Toast(context)
                 val ivEmoij = ImageView(context)
                 ivEmoij.setImageResource(imageEmoijId)
                 toast.view = ivEmoij
                 toast.show()
             }
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_emoji,parent,false)
        return EmojiHolder(mContext,view)
    }

    override fun getItemCount(): Int {
        return listEmoji.size
    }

    override fun onBindViewHolder(holder: EmojiHolder, position: Int) {
       holder.ivEmoji.setImageResource(listEmoji[position])
        holder.ivEmoji.tag = listEmoji[position]
    }
}