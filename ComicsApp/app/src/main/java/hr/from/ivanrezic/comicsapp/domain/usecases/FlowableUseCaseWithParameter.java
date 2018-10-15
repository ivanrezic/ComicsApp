package hr.from.ivanrezic.comicsapp.domain.usecases;

import io.reactivex.Flowable;

public interface FlowableUseCaseWithParameter<R, P> {

    Flowable<R> execute(P parameter);
}
