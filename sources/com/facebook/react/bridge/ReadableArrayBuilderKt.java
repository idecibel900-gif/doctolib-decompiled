package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"Lkotlin/Function1;", "Lcom/facebook/react/bridge/ReadableArrayBuilder;", "", "builder", "Lcom/facebook/react/bridge/ReadableArray;", "buildReadableArray", "(Lkotlin/jvm/functions/Function1;)Lcom/facebook/react/bridge/ReadableArray;", "ReactAndroid_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ReadableArrayBuilderKt {
    public static final ReadableArray buildReadableArray(Function1 builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        builder.invoke(new ReadableArrayBuilder(writableArrayCreateArray));
        return writableArrayCreateArray;
    }
}
