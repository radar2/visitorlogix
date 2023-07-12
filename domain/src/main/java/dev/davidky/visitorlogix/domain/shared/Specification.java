package dev.davidky.visitorlogix.domain.shared;

public interface Specification<T> {

    boolean isSatisfiedBY(T t);

    Specification<T> and(Specification<T> t);

    void check(T t);


}
