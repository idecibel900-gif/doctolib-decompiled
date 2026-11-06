package coil.request;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import coil.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class Parameters implements Iterable, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    public static final Parameters EMPTY = new Parameters();
    private final Map entries;

    public /* synthetic */ Parameters(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private Parameters(Map map) {
        this.entries = map;
    }

    public Parameters() {
        this(MapsKt.emptyMap());
    }

    public final boolean isEmpty() {
        return this.entries.isEmpty();
    }

    public final Map memoryCacheKeys() {
        if (isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map map = this.entries;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return linkedHashMap;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(((Map.Entry) it.next()).getValue());
        throw null;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map map = this.entries;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(entry.getValue());
            arrayList.add(TuplesKt.to(str, null));
        }
        return arrayList.iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Parameters) && Intrinsics.areEqual(this.entries, ((Parameters) obj).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        private final Map entries;

        public Builder(Parameters parameters) {
            this.entries = MapsKt.toMutableMap(parameters.entries);
        }

        public final Parameters build() {
            return new Parameters(Collections.toImmutableMap(this.entries), null);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
