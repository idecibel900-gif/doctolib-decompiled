package com.iabtcf.utils;

import com.iabtcf.utils.function.Consumer;
import com.iabtcf.utils.function.Function;
import com.iabtcf.utils.function.Predicate;
import com.iabtcf.utils.function.Supplier;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    private Optional() {
        this.value = null;
    }

    public static <T> Optional<T> empty() {
        return (Optional<T>) EMPTY;
    }

    public static <T> Optional<T> of(T t) {
        return new Optional<>(t);
    }

    public static <T> Optional<T> ofNullable(T t) {
        return t == null ? empty() : of(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Optional) {
            return Objects.equals(this.value, ((Optional) obj).value);
        }
        return false;
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return (isPresent() && !predicate.test(this.value)) ? empty() : this;
    }

    public <U> Optional<U> flatMap(Function<? super T, Optional<U>> function) {
        Objects.requireNonNull(function);
        return !isPresent() ? empty() : (Optional) Objects.requireNonNull(function.apply(this.value));
    }

    public T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    public void ifPresent(Consumer<? super T> consumer) {
        T t = this.value;
        if (t != null) {
            consumer.accept(t);
        }
    }

    public boolean isPresent() {
        return this.value != null;
    }

    public <U> Optional<U> map(Function<? super T, ? extends U> function) {
        Objects.requireNonNull(function);
        return !isPresent() ? empty() : ofNullable(function.apply(this.value));
    }

    public T orElse(T t) {
        T t2 = this.value;
        return t2 != null ? t2 : t;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        T t = this.value;
        return t != null ? t : supplier.get();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) throws Throwable {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw supplier.get();
    }

    public String toString() {
        T t = this.value;
        return t != null ? String.format("Optional[%s]", t) : "Optional.empty";
    }

    private Optional(T t) {
        this.value = (T) Objects.requireNonNull(t);
    }
}
