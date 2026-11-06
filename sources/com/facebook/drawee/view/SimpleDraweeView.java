package com.facebook.drawee.view;

import com.facebook.common.internal.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleDraweeView extends GenericDraweeView {
    private static Supplier sDraweecontrollerbuildersupplier;

    public static void initialize(Supplier supplier) {
        sDraweecontrollerbuildersupplier = supplier;
    }
}
