package io.didomi.ssl;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "", "count", "", "a", "Landroid/view/View;", "headerView", "android_release"}, k = 2, mv = {1, 8, 0})
public final class ya {

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"io/didomi/sdk/ya$a", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/ViewGroup;", DiagnosticsTracker.HOST_KEY, "Landroid/view/View;", "child", "Landroid/view/accessibility/AccessibilityEvent;", "event", "", "onRequestSendAccessibilityEvent", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends AccessibilityDelegateCompat {
        final /* synthetic */ RecyclerView a;

        a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getEventType() == 32768) {
                RecyclerView.LayoutManager layoutManager = this.a.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    linearLayoutManager.scrollToPosition(0);
                }
            }
            return super.onRequestSendAccessibilityEvent(host, child, event);
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"io/didomi/sdk/ya$b", "Landroidx/core/view/AccessibilityDelegateCompat;", "Landroid/view/ViewGroup;", DiagnosticsTracker.HOST_KEY, "Landroid/view/View;", "child", "Landroid/view/accessibility/AccessibilityEvent;", "event", "", "onRequestSendAccessibilityEvent", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "", "onInitializeAccessibilityNodeInfo", "a", "Z", "getRemoveListCountAccessibility", "()Z", "setRemoveListCountAccessibility", "(Z)V", "removeListCountAccessibility", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private boolean removeListCountAccessibility;
        final /* synthetic */ RecyclerView b;
        final /* synthetic */ int c;

        b(RecyclerView recyclerView, int i) {
            this.b = recyclerView;
            this.c = i;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (this.removeListCountAccessibility) {
                info.setCollectionInfo(null);
            } else {
                info.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.c, 1, true));
            }
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0057  */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            boolean zBooleanValue;
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getEventType() == 32768) {
                boolean z = this.removeListCountAccessibility;
                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = this.b.findContainingViewHolder(child);
                if (viewHolderFindContainingViewHolder == null) {
                    zBooleanValue = false;
                } else {
                    if (viewHolderFindContainingViewHolder instanceof la) {
                        boolValueOf = Boolean.valueOf(((la) viewHolderFindContainingViewHolder).getPreventListAccessibilityAnnouncement());
                    } else if (viewHolderFindContainingViewHolder instanceof zb) {
                        boolValueOf = Boolean.valueOf(((zb) viewHolderFindContainingViewHolder).getPreventListAccessibilityAnnouncement());
                    } else {
                        boolValueOf = viewHolderFindContainingViewHolder instanceof ji ? Boolean.valueOf(((ji) viewHolderFindContainingViewHolder).getPreventListAccessibilityAnnouncement()) : null;
                    }
                    if (boolValueOf != null) {
                        zBooleanValue = boolValueOf.booleanValue();
                    } else {
                        zBooleanValue = false;
                    }
                }
                this.removeListCountAccessibility = zBooleanValue;
                if (zBooleanValue != z) {
                    host.sendAccessibilityEvent(32768);
                }
                RecyclerView.LayoutManager layoutManager = this.b.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                ((LinearLayoutManager) layoutManager).scrollToPosition(this.b.getChildAdapterPosition(child));
            }
            return super.onRequestSendAccessibilityEvent(host, child, event);
        }
    }

    public static final void a(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        ViewCompat.setAccessibilityDelegate(recyclerView, new b(recyclerView, i));
    }

    public static final void a(RecyclerView recyclerView, View headerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(headerView, "headerView");
        ViewCompat.setAccessibilityDelegate(headerView, new a(recyclerView));
    }
}
