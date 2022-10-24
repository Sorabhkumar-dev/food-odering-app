package com.sorabh.grabfood.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.QNACardViewBinding
import com.sorabh.grabfood.util.QNAData

class QNAAdapter : RecyclerView.Adapter<QNAViewHolder>() {
    private var qnaList = ArrayList<QNAData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QNAViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val qnaCardViewBinding = DataBindingUtil.inflate<QNACardViewBinding>(
            layoutInflater,
            R.layout.q_n_a_card_view,
            parent,
            false
        )
        return QNAViewHolder(qnaCardViewBinding)
    }

    override fun onBindViewHolder(holder: QNAViewHolder, position: Int) {
        holder.qnaCardViewBinding.qnaSerialNumber.text = qnaList[position].sno.toString()
        holder.qnaCardViewBinding.qnaAnswer.text = qnaList[position].answer
        holder.qnaCardViewBinding.qnaQuestion.text = qnaList[position].question
        holder.qnaCardViewBinding.executePendingBindings()
    }

    override fun getItemCount(): Int = qnaList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<QNAData>?){
        qnaList.clear()
        qnaList = list as ArrayList<QNAData>
        notifyDataSetChanged()
    }
}

class QNAViewHolder(val qnaCardViewBinding: QNACardViewBinding) :
    RecyclerView.ViewHolder(qnaCardViewBinding.root) {

}