package com.facebook.drawee.view;

import android.content.Context;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GenericDraweeView extends DraweeView {
    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        setHierarchy(genericDraweeHierarchy);
    }
}
