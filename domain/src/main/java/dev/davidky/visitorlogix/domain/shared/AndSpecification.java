package dev.davidky.visitorlogix.domain.shared;

public class AndSpecification<T> extends AbstractSpecification<T> {

    private Specification<T> spec1;
    private Specification<T> spec2;

    public AndSpecification(Specification<T> spec1, Specification<T> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    @Override
    public boolean isSatisfiedBY(T t) {
        return spec1.isSatisfiedBY(t) &&  spec2.isSatisfiedBY(t);
    }

    @Override
    public void check(T t) {}
}
