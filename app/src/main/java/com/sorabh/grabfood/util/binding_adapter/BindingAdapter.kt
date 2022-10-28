package com.sorabh.grabfood.util.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.sorabh.grabfood.R
import com.squareup.picasso.Picasso

@BindingAdapter("imgSrcUrl")
fun ImageView.imgSrcUrl(url: String?) {
    if (url != null) {
        Picasso.with(this.context)
            .load(url)
            .resize(110,110)
            .centerCrop()
            .error(R.drawable.ic_grab_food)
            .into(this)
    }
}

@BindingAdapter("txt")
fun TextView.txt(txt:String?){
    val price = "$$txt"
    this.text = price

}

@BindingAdapter("price")
fun TextView.price(price:String?){
    val totalPrice = "Total Price $$price"
    this.text = totalPrice

}

