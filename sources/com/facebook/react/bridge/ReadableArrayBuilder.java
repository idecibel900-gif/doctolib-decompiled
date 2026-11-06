package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\fJ\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\r¢\u0006\u0004\b\t\u0010\u000eJ\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0010J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0011¢\u0006\u0004\b\t\u0010\u0012J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0013¢\u0006\u0004\b\t\u0010\u0014J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0015¢\u0006\u0004\b\t\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001c\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001f¨\u0006 "}, d2 = {"Lcom/facebook/react/bridge/ReadableArrayBuilder;", "", "Lcom/facebook/react/bridge/WritableArray;", "array", "<init>", "(Lcom/facebook/react/bridge/WritableArray;)V", "", "value", "", "add", "(Ljava/lang/String;)V", "", "(I)V", "", "(Z)V", "", "(D)V", "", "(J)V", "Lcom/facebook/react/bridge/ReadableMap;", "(Lcom/facebook/react/bridge/ReadableMap;)V", "Lcom/facebook/react/bridge/ReadableArray;", "(Lcom/facebook/react/bridge/ReadableArray;)V", "addNull", "()V", "Lkotlin/Function1;", "Lcom/facebook/react/bridge/ReadableMapBuilder;", "builder", "addMap", "(Lkotlin/jvm/functions/Function1;)V", "addArray", "Lcom/facebook/react/bridge/WritableArray;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableArrayBuilder {
    private final WritableArray array;

    public ReadableArrayBuilder(WritableArray array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    public final void add(String value) {
        this.array.pushString(value);
    }

    public final void add(int value) {
        this.array.pushInt(value);
    }

    public final void add(boolean value) {
        this.array.pushBoolean(value);
    }

    public final void add(double value) {
        this.array.pushDouble(value);
    }

    public final void add(long value) {
        this.array.pushDouble(value);
    }

    public final void add(ReadableMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.array.pushMap(value);
    }

    public final void add(ReadableArray value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.array.pushArray(value);
    }

    public final void addNull() {
        this.array.pushNull();
    }

    public final void addMap(Function1 builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        WritableArray writableArray = this.array;
        WritableMap writableMapCreateMap = Arguments.createMap();
        builder.invoke(new ReadableMapBuilder(writableMapCreateMap));
        writableArray.pushMap(writableMapCreateMap);
    }

    public final void addArray(Function1 builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        WritableArray writableArray = this.array;
        WritableArray writableArrayCreateArray = Arguments.createArray();
        builder.invoke(new ReadableArrayBuilder(writableArrayCreateArray));
        writableArray.pushArray(writableArrayCreateArray);
    }
}
