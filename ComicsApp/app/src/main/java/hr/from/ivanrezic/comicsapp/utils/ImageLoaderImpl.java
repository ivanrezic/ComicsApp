package hr.from.ivanrezic.comicsapp.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import hr.from.ivanrezic.comicsapp.R;

public class ImageLoaderImpl implements ImageLoader {

    private RequestOptions requestOptions;

    public ImageLoaderImpl() {
        requestOptions = new RequestOptions();
    }

    @Override
    public void loadImage(final String imageUrl, final ImageView destination) {
        Glide.with(destination)
             .load(imageUrl)
             .apply(requestOptions.error(R.drawable.ic_broken_image_24dp))
             .apply(requestOptions.centerCrop())
             .into(destination);
    }

    @Override
    public void setImageFavorite(ImageView imageView, boolean favorite) {
        imageView.setImageResource(favorite ? R.drawable.ic_favorite_24dp : R.drawable.ic_favorite_border_24dp);
    }
}
