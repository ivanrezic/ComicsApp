package hr.from.ivanrezic.comicsapp.ui.trending;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.from.ivanrezic.comicsapp.R;
import hr.from.ivanrezic.comicsapp.ui.details.EpisodeViewModel;
import hr.from.ivanrezic.comicsapp.utils.ImageLoader;

public final class TrendingViewAdapter extends RecyclerView.Adapter<TrendingViewAdapter.ViewHolder> {

    public interface OnTrendingEpisodesClickListener {

        void onTrendingEpisodeClickListener(String episodeId);
    }

    public interface OnTrendingEpisodesClickFavoriteListener {

        void onTrendingEpisodesClickFavoriteListener(String episodeId, final boolean favorite);
    }

    private final ImageLoader imageLoader;
    private final LayoutInflater layoutInflater;
    private List<EpisodeViewModel> viewModels;
    private OnTrendingEpisodesClickListener onTrendingEpisodesClickListener;
    private OnTrendingEpisodesClickFavoriteListener onTrendingEpisodesClickFavoriteListener;

    public TrendingViewAdapter(final ImageLoader imageLoader, final LayoutInflater layoutInflater) {
        this.imageLoader = imageLoader;
        this.layoutInflater = layoutInflater;
        viewModels = new ArrayList<>();
    }

    public void setViewModels(final TrendingViewModel trendingViewModel) {
        viewModels.clear();
        viewModels.addAll(trendingViewModel.viewModelList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = layoutInflater.inflate(R.layout.trending_recyclerview_row, parent, false);
        return new ViewHolder(view, onTrendingEpisodesClickListener, imageLoader, onTrendingEpisodesClickFavoriteListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bind(viewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }

    public void setOnTrendingEpisodesClickListener(final OnTrendingEpisodesClickListener onTrendingEpisodesClickListener) {
        this.onTrendingEpisodesClickListener = onTrendingEpisodesClickListener;
    }

    public void setOnTrendingEpisodesClickFavoriteListener(final OnTrendingEpisodesClickFavoriteListener onTrendingEpisodesClickFavoriteListener) {
        this.onTrendingEpisodesClickFavoriteListener = onTrendingEpisodesClickFavoriteListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.episode_image)
        ImageView episodeImage;

        @BindView(R.id.episode_name)
        TextView episodeName;

        @BindView(R.id.episode_series)
        TextView episodeSeries;

        @BindView(R.id.episode_image_favorite)
        ImageView imageFavorite;

        private String episodeId;
        private boolean favorite;
        private final View itemView;
        private final ImageLoader imageLoader;
        private final OnTrendingEpisodesClickListener onItemClickListener;
        private final OnTrendingEpisodesClickFavoriteListener onTrendingEpisodesClickFavoriteListener;

        public ViewHolder(final View itemView,
                          final OnTrendingEpisodesClickListener onTrendingEpisodesClickListener,
                          final ImageLoader imageLoader,
                          final OnTrendingEpisodesClickFavoriteListener onTrendingEpisodesClickFavoriteListener) {
            super(itemView);
            this.itemView = itemView;
            this.onTrendingEpisodesClickFavoriteListener = onTrendingEpisodesClickFavoriteListener;
            ButterKnife.bind(this, itemView);
            this.onItemClickListener = onTrendingEpisodesClickListener;
            this.imageLoader = imageLoader;
        }

        public void bind(final EpisodeViewModel episodeViewModel) {
            episodeId = episodeViewModel.episodeId;
            favorite = episodeViewModel.favorite;

            episodeName.setText(episodeViewModel.name);
            episodeSeries.setText(episodeViewModel.seriesName);
            imageLoader.loadImage(episodeViewModel.imageUrl, episodeImage);
            imageLoader.setImageFavorite(imageFavorite, favorite);
        }

        @OnClick(R.id.trending_episode)
        void onClick() {
            onItemClickListener.onTrendingEpisodeClickListener(episodeId);
        }

        @OnClick(R.id.episode_image_favorite)
        void clickFavorite() {
            favorite = !favorite;
            imageLoader.setImageFavorite(imageFavorite, favorite);
            onTrendingEpisodesClickFavoriteListener.onTrendingEpisodesClickFavoriteListener(episodeId, favorite);
        }
    }
}
