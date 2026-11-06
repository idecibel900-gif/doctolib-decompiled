package io.sentry.android.replay;

import androidx.compose.ui.semantics.SemanticsPropertyKey;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryReplayModifiers {
    public static final SentryReplayModifiers INSTANCE = new SentryReplayModifiers();
    private static final SemanticsPropertyKey SentryPrivacy = new SemanticsPropertyKey("SentryPrivacy", new Function2() { // from class: io.sentry.android.replay.SentryReplayModifiers$SentryPrivacy$1
        @Override // kotlin.jvm.functions.Function2
        public final String invoke(String str, String str2) {
            Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
            return str;
        }
    });
    public static final int $stable = SemanticsPropertyKey.$stable;

    private SentryReplayModifiers() {
    }

    public final SemanticsPropertyKey getSentryPrivacy() {
        return SentryPrivacy;
    }
}
