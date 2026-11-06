package net.time4j.tz;

/* JADX INFO: loaded from: classes5.dex */
public enum GapResolver {
    PUSH_FORWARD,
    NEXT_VALID_TIME,
    ABORT;

    public TransitionStrategy and(OverlapResolver overlapResolver) {
        return TransitionResolver.of(this, overlapResolver);
    }
}
