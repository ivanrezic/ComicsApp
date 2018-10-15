package hr.from.ivanrezic.comicsapp.ui.search;

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
import hr.from.ivanrezic.comicsapp.ui.trending.TrendingViewAdapter;
import hr.from.ivanrezic.comicsapp.ui.trending.TrendingViewModel;
import hr.from.ivanrezic.comicsapp.utils.ImageLoader;

public final class SearchViewAdapter extends RecyclerView.Adapter<SearchViewAdapter.ViewHolder> {

    private final ImageLoader imageLoader;
    private final LayoutInflater layoutInflater;
    private List<SearchViewModel> searchViewModels;

    public SearchViewAdapter(final ImageLoader imageLoader, final LayoutInflater layoutInflater) {
        this.imageLoader = imageLoader;
        this.layoutInflater = layoutInflater;
        this.searchViewModels = new ArrayList<>();
    }

    public void setViewModels(final List<SearchViewModel> searchViewModels) {
        this.searchViewModels.clear();
        this.searchViewModels.addAll(searchViewModels);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = layoutInflater.inflate(R.layout.search_recyclerview_row, parent, false);
        return new ViewHolder(view, imageLoader);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bind(searchViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return searchViewModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.search_result_image)
        ImageView searchResultImage;

        @BindView(R.id.search_result_name)
        TextView searchResultName;

        @BindView(R.id.search_result_start_year)
        TextView searchResultStartYear;

        private final View itemView;
        private final ImageLoader imageLoader;

        public ViewHolder(final View itemView, final ImageLoader imageLoader) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
            this.imageLoader = imageLoader;
        }

        public void bind(final SearchViewModel searchViewModel) {
            searchResultName.setText(searchViewModel.name);
            searchResultStartYear.setText(searchViewModel.startYear);
            imageLoader.loadImage(searchViewModel.imageUrl, searchResultImage);
        }
    }
}
