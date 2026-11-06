package com.datadog.opentracing.scopemanager;

import io.opentracing.Scope;
import io.opentracing.Span;

/* JADX INFO: loaded from: classes3.dex */
interface DDScope extends Scope {
    int depth();

    Span span();
}
