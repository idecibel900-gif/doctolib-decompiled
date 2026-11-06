package com.facebook.react.animated;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AnimatedNode {
    public static final Companion Companion = new Companion(null);
    public int BFSColor;
    public int activeIncomingNodes;
    public List children;
    public int tag = -1;

    public void onAttachedToNode$ReactAndroid_release(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public void onDetachedFromNode$ReactAndroid_release(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public abstract String prettyPrint$ReactAndroid_release();

    public void update$ReactAndroid_release() {
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void addChild$ReactAndroid_release(AnimatedNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        List arrayList = this.children;
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            this.children = arrayList;
        }
        arrayList.add(child);
        child.onAttachedToNode$ReactAndroid_release(this);
    }

    public final void removeChild$ReactAndroid_release(AnimatedNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        List list = this.children;
        if (list == null) {
            return;
        }
        child.onDetachedFromNode$ReactAndroid_release(this);
        list.remove(child);
    }

    public final String prettyPrintWithChildren$ReactAndroid_release() {
        String str;
        List list = this.children;
        String strJoinToString$default = list != null ? CollectionsKt.joinToString$default(list, " ", null, null, 0, null, null, 62, null) : null;
        String strPrettyPrint$ReactAndroid_release = prettyPrint$ReactAndroid_release();
        if (strJoinToString$default == null || StringsKt.isBlank(strJoinToString$default)) {
            str = "";
        } else {
            str = " children: " + strJoinToString$default;
        }
        return strPrettyPrint$ReactAndroid_release + str;
    }
}
