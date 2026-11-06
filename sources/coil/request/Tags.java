package coil.request;

import coil.util.Collections;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Tags {
    public static final Companion Companion = new Companion(null);
    public static final Tags EMPTY = new Tags(MapsKt.emptyMap());
    private final Map tags;

    public /* synthetic */ Tags(Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(map);
    }

    private Tags(Map map) {
        this.tags = map;
    }

    public final Map asMap() {
        return this.tags;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Tags) && Intrinsics.areEqual(this.tags, ((Tags) obj).tags);
    }

    public int hashCode() {
        return this.tags.hashCode();
    }

    public String toString() {
        return "Tags(tags=" + this.tags + ')';
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Tags from(Map map) {
            return new Tags(Collections.toImmutableMap(map), null);
        }
    }
}
