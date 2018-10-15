package hr.from.ivanrezic.comicsapp.domain.usecases;

import io.reactivex.Completable;

public interface CompletableUseCaseWithParameter<P> {

    Completable execute(P parameter);
}
