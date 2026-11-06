package com.facebook.react.uimanager.util;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R$id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactFindViewUtil {
    public static final ReactFindViewUtil INSTANCE = new ReactFindViewUtil();
    private static final List onViewFoundListeners = new ArrayList();
    private static final Map onMultipleViewsFoundListener = new HashMap();

    private ReactFindViewUtil() {
    }

    public static final View findView(View root, String nativeId) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(nativeId, "nativeId");
        if (Intrinsics.areEqual(INSTANCE.getNativeId(root), nativeId)) {
            return root;
        }
        if (!(root instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) root;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
            View viewFindView = findView(childAt, nativeId);
            if (viewFindView != null) {
                return viewFindView;
            }
        }
        return null;
    }

    public static final void notifyViewRendered(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String nativeId = INSTANCE.getNativeId(view);
        if (nativeId == null) {
            return;
        }
        Iterator it = onViewFoundListeners.iterator();
        if (it.hasNext()) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
            throw null;
        }
        for (Map.Entry entry : onMultipleViewsFoundListener.entrySet()) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(entry.getKey());
            if (((Set) entry.getValue()).contains(nativeId)) {
                throw null;
            }
        }
    }

    private final String getNativeId(View view) {
        Object tag = view.getTag(R$id.view_tag_native_id);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }
}
