package dev.davidky.visitorlogix.domain.shared;

public abstract class AbstractSpecification<T> implements Specification<T>{

    public abstract boolean isSatisfiedBY(T t);

    @Override
    public Specification<T> and(Specification<T> t) {
        return new AndSpecification<>(this, t);
    }

    public abstract void check(T t);
}
