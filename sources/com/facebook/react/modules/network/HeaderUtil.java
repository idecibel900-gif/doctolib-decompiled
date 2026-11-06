package com.facebook.react.modules.network;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HeaderUtil {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String stripHeaderName(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            StringBuilder sb = new StringBuilder(name.length());
            int length = name.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if (Intrinsics.compare((int) cCharAt, 32) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0) {
                    z = true;
                } else {
                    sb.append(cCharAt);
                }
            }
            if (!z) {
                return name;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
}
