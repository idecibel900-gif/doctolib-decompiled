package androidx.constraintlayout.compose;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class Visibility {
    private final String name;
    public static final Companion Companion = new Companion(null);
    private static final Visibility Visible = new Visibility("visible");
    private static final Visibility Invisible = new Visibility("invisible");
    private static final Visibility Gone = new Visibility("gone");

    public Visibility(String str) {
        this.name = str;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Visibility getVisible() {
            return Visibility.Visible;
        }
    }

    public final String getName$constraintlayout_compose_release() {
        return this.name;
    }
}
