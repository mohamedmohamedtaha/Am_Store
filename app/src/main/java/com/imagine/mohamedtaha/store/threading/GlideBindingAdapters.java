package com.imagine.mohamedtaha.store.threading;


import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.imagine.mohamedtaha.store.R;

public class GlideBindingAdapters {
@BindingAdapter("imageUrl")
    public static void setImage(ImageView image,int imageUrl){
    Context context =image.getContext();
    RequestOptions options = new RequestOptions()
            .placeholder(R.drawable.ic_launcher1)
            .error(R.drawable.ic_launcher1);

    Glide.with(context).setDefaultRequestOptions(options).load(imageUrl).load(imageUrl);
}
}

