package hr.from.ivanrezic.comicsapp.ui.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import butterknife.Unbinder;
import hr.from.ivanrezic.comicsapp.R;
import hr.from.ivanrezic.comicsapp.di.fragment.DaggerFragment;
import hr.from.ivanrezic.comicsapp.di.fragment.FragmentComponent;
import hr.from.ivanrezic.comicsapp.utils.ImageLoader;

public class SearchFragment extends DaggerFragment implements SearchContract.View {

    @BindView(R.id.search_recycler_view)
    RecyclerView recyclerView;

    @Inject
    SearchContract.Presenter searchPresenter;

    @Inject
    ImageLoader imageLoader;

    private SearchViewAdapter searchViewAdapter;
    private Unbinder unbinder;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    @Override
    public void render(final List<SearchViewModel> searchViewModels) {
        searchViewAdapter.setViewModels(searchViewModels);
    }

    @Override
    public void onStop() {
        searchPresenter.clear();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @OnTextChanged(R.id.search_edit_text)
    public void searchTextChanged(CharSequence text) {
        searchPresenter.search(text.toString());
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        searchViewAdapter = new SearchViewAdapter(imageLoader, getLayoutInflater());
        recyclerView.setAdapter(searchViewAdapter);
    }
}
