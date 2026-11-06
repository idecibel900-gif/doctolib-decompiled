package com.vonage.webrtc;

/* JADX INFO: loaded from: classes4.dex */
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> or(final Predicate<? super T> predicate) {
        return new Predicate<T>() { // from class: com.vonage.webrtc.Predicate.1
            @Override // com.vonage.webrtc.Predicate
            public boolean test(T t) {
                return Predicate.this.test(t) || predicate.test(t);
            }
        };
    }

    default Predicate<T> and(final Predicate<? super T> predicate) {
        return new Predicate<T>() { // from class: com.vonage.webrtc.Predicate.2
            @Override // com.vonage.webrtc.Predicate
            public boolean test(T t) {
                return Predicate.this.test(t) && predicate.test(t);
            }
        };
    }

    default Predicate<T> negate() {
        return new Predicate<T>() { // from class: com.vonage.webrtc.Predicate.3
            @Override // com.vonage.webrtc.Predicate
            public boolean test(T t) {
                return !Predicate.this.test(t);
            }
        };
    }
}
