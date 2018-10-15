package hr.from.ivanrezic.comicsapp.ui.trending;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hr.from.ivanrezic.comicsapp.R;
import hr.from.ivanrezic.comicsapp.di.fragment.DaggerFragment;
import hr.from.ivanrezic.comicsapp.di.fragment.FragmentComponent;
import hr.from.ivanrezic.comicsapp.ui.details.EpisodeDetailsFragment;
import hr.from.ivanrezic.comicsapp.utils.ImageLoader;

public final class TrendingFragment extends DaggerFragment implements TrendingContract.View, TrendingViewAdapter.OnTrendingEpisodesClickListener,
                                                                      SwipeRefreshLayout.OnRefreshListener,
                                                                      TrendingViewAdapter.OnTrendingEpisodesClickFavoriteListener{

    @BindView(R.id.trending_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;

    @Inject
    TrendingContract.Presenter trendingPresenter;

    @Inject
    ImageLoader imageLoader;

    private TrendingViewAdapter adapter;
    private Unbinder unbinder;

    public static TrendingFragment newInstance() {
        return new TrendingFragment();
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trending, container, false);
        unbinder = ButterKnife.bind(this, view);
        swipeRefreshLayout.setOnRefreshListener(this);

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trendingPresenter.start();
        initRecyclerView();
    }

    @Override
    public void render(final TrendingViewModel trendingViewModel) {
        adapter.setViewModels(trendingViewModel);
    }

    @Override
    public void onTrendingEpisodeClickListener(final String episodeId) {
        requireActivity().getSupportFragmentManager()
                         .beginTransaction()
                         .add(R.id.main_container, EpisodeDetailsFragment.newInstance(episodeId))
                         .addToBackStack(null)
                         .commit();
    }

    @Override
    public void onRefresh() {
        trendingPresenter.refresh();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onTrendingEpisodesClickFavoriteListener(final String episodeId, final boolean favorite) {
        trendingPresenter.clickFavorite(episodeId, favorite);
    }

    @Override
    public void onStop() {
        trendingPresenter.clear();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new TrendingViewAdapter(imageLoader, getLayoutInflater());
        adapter.setOnTrendingEpisodesClickListener(this);
        adapter.setOnTrendingEpisodesClickFavoriteListener(this);
        recyclerView.setAdapter(adapter);
    }
}
