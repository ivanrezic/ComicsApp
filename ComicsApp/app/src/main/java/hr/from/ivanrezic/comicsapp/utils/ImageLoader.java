package hr.from.ivanrezic.comicsapp.utils;

import android.view.View;
import android.widget.ImageView;

public interface ImageLoader {

    void loadImage(String imageUrl, ImageView destination);

    void setImageFavorite(ImageView imageView, boolean favorite);
}
