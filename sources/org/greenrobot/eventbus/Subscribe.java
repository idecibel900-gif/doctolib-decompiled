package org.greenrobot.eventbus;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface Subscribe {
    int priority() default 0;

    boolean sticky() default false;

    ThreadMode threadMode() default ThreadMode.POSTING;
}
