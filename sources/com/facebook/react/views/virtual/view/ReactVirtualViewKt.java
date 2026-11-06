package com.facebook.react.views.virtual.view;

import com.facebook.react.common.build.ReactBuildConfig;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactVirtualViewKt {
    private static final boolean IS_DEBUG_BUILD;

    static {
        IS_DEBUG_BUILD = ReactBuildConfig.DEBUG || ReactBuildConfig.IS_INTERNAL_BUILD || ReactBuildConfig.ENABLE_PERFETTO;
    }
}
