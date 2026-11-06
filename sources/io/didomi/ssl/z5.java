package io.didomi.ssl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0017R\u0014\u0010\u0005\u001a\u00020\u00028\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lio/didomi/sdk/z5;", "", "Lio/didomi/sdk/b6;", "a", "Lio/didomi/sdk/b6;", "eventsRepository", "<init>", "(Lio/didomi/sdk/b6;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class z5 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final b6 eventsRepository;

    public z5(b6 eventsRepository) {
        Intrinsics.checkNotNullParameter(eventsRepository, "eventsRepository");
        this.eventsRepository = eventsRepository;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public b6 getEventsRepository() {
        return this.eventsRepository;
    }
}
