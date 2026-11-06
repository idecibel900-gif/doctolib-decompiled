package com.facebook.imagepipeline.common;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BytesRange {
    public static final Companion Companion = new Companion(null);
    private static final Lazy headerParsingRegEx$delegate = LazyKt.lazy(new Function0() { // from class: com.facebook.imagepipeline.common.BytesRange$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BytesRange.headerParsingRegEx_delegate$lambda$0();
        }
    });
    public final int from;
    public final int to;

    public static final BytesRange from(int i) {
        return Companion.from(i);
    }

    public static final BytesRange toMax(int i) {
        return Companion.toMax(i);
    }

    public BytesRange(int i, int i2) {
        this.from = i;
        this.to = i2;
    }

    public final String toHttpRangeHeaderValue() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Companion companion = Companion;
        String str = String.format(null, "bytes=%s-%s", Arrays.copyOf(new Object[]{companion.valueOrEmpty(this.from), companion.valueOrEmpty(this.to)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final boolean contains(BytesRange bytesRange) {
        return bytesRange != null && this.from <= bytesRange.from && bytesRange.to <= this.to;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Companion companion = Companion;
        String str = String.format(null, "%s-%s", Arrays.copyOf(new Object[]{companion.valueOrEmpty(this.from), companion.valueOrEmpty(this.to)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(BytesRange.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.imagepipeline.common.BytesRange");
        BytesRange bytesRange = (BytesRange) obj;
        return this.from == bytesRange.from && this.to == bytesRange.to;
    }

    public int hashCode() {
        return (this.from * 31) + this.to;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Pattern getHeaderParsingRegEx() {
            Object value = BytesRange.headerParsingRegEx$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (Pattern) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String valueOrEmpty(int i) {
            return i == Integer.MAX_VALUE ? "" : String.valueOf(i);
        }

        public final BytesRange from(int i) {
            Preconditions.checkArgument(Boolean.valueOf(i >= 0));
            return new BytesRange(i, Integer.MAX_VALUE);
        }

        public final BytesRange toMax(int i) {
            Preconditions.checkArgument(Boolean.valueOf(i > 0));
            return new BytesRange(0, i);
        }

        public final BytesRange fromContentRangeHeader(String str) {
            if (str == null) {
                return null;
            }
            try {
                String[] strArrSplit = getHeaderParsingRegEx().split(str);
                Preconditions.checkArgument(Boolean.valueOf(strArrSplit.length == 4));
                Preconditions.checkArgument(Boolean.valueOf(Intrinsics.areEqual(strArrSplit[0], "bytes")));
                String str2 = strArrSplit[1];
                Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
                int i = Integer.parseInt(str2);
                String str3 = strArrSplit[2];
                Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
                int i2 = Integer.parseInt(str3);
                String str4 = strArrSplit[3];
                Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
                int i3 = Integer.parseInt(str4);
                Preconditions.checkArgument(Boolean.valueOf(i2 > i));
                Preconditions.checkArgument(Boolean.valueOf(i3 > i2));
                if (i2 < i3 - 1) {
                    return new BytesRange(i, i2);
                }
                return new BytesRange(i, Integer.MAX_VALUE);
            } catch (IllegalArgumentException e) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str5 = String.format(null, "Invalid Content-Range header value: \"%s\"", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                throw new IllegalArgumentException(str5, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pattern headerParsingRegEx_delegate$lambda$0() {
        return Pattern.compile("[-/ ]");
    }
}
