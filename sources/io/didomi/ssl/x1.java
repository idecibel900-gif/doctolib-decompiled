package io.didomi.ssl;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/x1;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDrawOver", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/graphics/drawable/Drawable;", "divider", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "b", "android_release"}, k = 1, mv = {1, 8, 0})
public final class x1 extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Drawable divider;

    public x1(Drawable divider) {
        Intrinsics.checkNotNullParameter(divider, "divider");
        this.divider = divider;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int paddingLeft = parent.getPaddingLeft();
        int width = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "parent.getChildAt(i)");
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            int top = childAt.getTop() + 1 + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).topMargin;
            this.divider.setBounds(paddingLeft, top, width, top + 1);
            this.divider.draw(canvas);
        }
    }
}
