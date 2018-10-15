package hr.from.ivanrezic.comicsapp.ui.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import hr.from.ivanrezic.comicsapp.R;
import hr.from.ivanrezic.comicsapp.di.fragment.DaggerFragment;
import hr.from.ivanrezic.comicsapp.di.fragment.FragmentComponent;
import hr.from.ivanrezic.comicsapp.utils.ImageLoader;

public final class EpisodeDetailsFragment extends DaggerFragment implements EpisodeDetailsContract.View {

    private static final String KEY_EPISODE_ID = "key.episode.details.url";

    @BindView(R.id.episode_details_episode_name)
    TextView episodeName;

    @BindView(R.id.episode_details_image)
    ImageView episodeImage;

    @BindView(R.id.episode_details_air_date)
    TextView episodeAirDate;

    @BindView(R.id.episode_details_series_name)
    TextView episodeSeriesName;

    @BindView(R.id.episode_details_episode_number)
    TextView episodeNumber;

    @BindView(R.id.episode_details_description)
    TextView episodeDescription;

    @BindView(R.id.episode_details_image_favorite)
    ImageView episodeImageFavorite;

    @Inject
    EpisodeDetailsContract.Presenter episodeDetailsPresenter;

    @Inject
    ImageLoader imageLoader;

    private Unbinder unbinder;

    public static Fragment newInstance(final String episodeId) {
        final Bundle arguments = new Bundle();
        arguments.putString(KEY_EPISODE_ID, episodeId);
        final Fragment fragment = new EpisodeDetailsFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        episodeDetailsPresenter.start(getArguments().getString(KEY_EPISODE_ID));
    }

    @Override
    public void render(final EpisodeViewModel episodeViewModel) {
        imageLoader.loadImage(episodeViewModel.imageUrl, episodeImage);
        episodeName.setText(episodeViewModel.name);
        episodeAirDate.setText(episodeViewModel.airDate);
        episodeSeriesName.setText(episodeViewModel.seriesName);
        episodeNumber.setText(episodeViewModel.episodeNumber);
        episodeDescription.setText(episodeViewModel.description);
        imageLoader.setImageFavorite(episodeImageFavorite, episodeViewModel.favorite);
    }

    @Override
    public void onStop() {
        episodeDetailsPresenter.clear();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }
}
