package com.datadog.android.rum.internal.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class ComponentPredicateExtKt$runIfValid$1 extends Lambda implements Function0 {
    public static final ComponentPredicateExtKt$runIfValid$1 INSTANCE = new ComponentPredicateExtKt$runIfValid$1();

    public ComponentPredicateExtKt$runIfValid$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return "Internal operation failed on ComponentPredicate";
    }
}
