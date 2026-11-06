package com.facebook.react.uimanager.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Method from annotation default annotation not found: defaultLong */
/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface ReactPropGroup {
    String customType() default "__default_type__";

    double defaultDouble() default 0.0d;

    float defaultFloat() default 0.0f;

    int defaultInt() default 0;

    String[] names();
}
