package io.didomi.ssl.view.ctv;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/view/ctv/CenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "position", "", "smoothScrollToPosition", "Landroid/content/Context;", "context", "orientation", "", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "a", "android_release"}, k = 1, mv = {1, 8, 0})
public final class CenterLayoutManager extends LinearLayoutManager {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lio/didomi/sdk/view/ctv/CenterLayoutManager$a;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateDtToFit", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    private static final class a extends LinearSmoothScroller {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            return (boxStart + ((boxEnd - boxStart) / 2)) - (viewStart + ((viewEnd - viewStart) / 2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CenterLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(state, "state");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
        a aVar = new a(context);
        aVar.setTargetPosition(position);
        startSmoothScroll(aVar);
    }
}
