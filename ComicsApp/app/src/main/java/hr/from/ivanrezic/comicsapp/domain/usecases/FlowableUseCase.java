package hr.from.ivanrezic.comicsapp.domain.usecases;

import io.reactivex.Flowable;

public interface FlowableUseCase<R> {

    Flowable<R> execute();
}
