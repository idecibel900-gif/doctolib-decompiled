package io.didomi.ssl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\r\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0014J/\u0010\r\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0018J!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u001aJ\u001f\u0010\r\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u001dJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u001eJ'\u0010!\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010(¨\u0006)"}, d2 = {"Lio/didomi/sdk/g6;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "", "shouldFadeOutHeader", "Lkotlin/Function1;", "", "isHeader", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;ZLkotlin/jvm/functions/Function1;)V", "itemPosition", "Landroid/view/View;", "a", "(ILandroidx/recyclerview/widget/RecyclerView;)Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "header", "paddingTop", "", "(Landroid/graphics/Canvas;Landroid/view/View;I)V", "c", "currentHeader", "nextHeader", "(Landroid/graphics/Canvas;Landroid/view/View;Landroid/view/View;I)V", "contactPoint", "(Landroidx/recyclerview/widget/RecyclerView;I)Landroid/view/View;", "Landroid/view/ViewGroup;", "view", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "(I)I", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Z", "b", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Pair;", "android_release"}, k = 1, mv = {1, 8, 0})
public final class g6 extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final boolean shouldFadeOutHeader;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Function1 isHeader;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private Pair<Integer, ? extends RecyclerView.ViewHolder> currentHeader;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"io/didomi/sdk/g6$a", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "onChanged", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            g6.this.currentHeader = null;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/g6$b", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/MotionEvent;", "motionEvent", "", "onInterceptTouchEvent", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends RecyclerView.SimpleOnItemTouchListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerView.ViewHolder viewHolder;
            View view;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            if (motionEvent.getAction() == 0) {
                float y = motionEvent.getY();
                Pair pair = g6.this.currentHeader;
                if (y <= ((pair == null || (viewHolder = (RecyclerView.ViewHolder) pair.getSecond()) == null || (view = viewHolder.itemView) == null) ? 0 : view.getBottom())) {
                    return true;
                }
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000f\u001a\u00020\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            g6.this.currentHeader = null;
        }
    }

    public /* synthetic */ g6(RecyclerView recyclerView, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? false : z, function1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas c2, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        View viewA;
        View viewA2;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(c2, parent, state);
        View childAt = parent.getChildAt(0);
        if (childAt == null || (childAdapterPosition = parent.getChildAdapterPosition(childAt)) == -1 || (viewA = a(childAdapterPosition, parent)) == null || (viewA2 = a(parent, viewA.getBottom() + parent.getPaddingTop())) == null) {
            return;
        }
        if (((Boolean) this.isHeader.invoke(Integer.valueOf(parent.getChildAdapterPosition(viewA2)))).booleanValue()) {
            a(c2, viewA, viewA2, parent.getPaddingTop());
        } else {
            a(c2, viewA, parent.getPaddingTop());
        }
    }

    public g6(RecyclerView parent, boolean z, Function1 isHeader) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(isHeader, "isHeader");
        this.shouldFadeOutHeader = z;
        this.isHeader = isHeader;
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new a());
        }
        parent.addOnLayoutChangeListener(new c());
        parent.addOnItemTouchListener(new b());
    }

    private final View a(int itemPosition, RecyclerView parent) {
        int iA;
        RecyclerView.Adapter adapter;
        Pair<Integer, ? extends RecyclerView.ViewHolder> pair;
        RecyclerView.ViewHolder viewHolder;
        RecyclerView.ViewHolder viewHolder2;
        if (parent.getAdapter() != null && (iA = a(itemPosition)) != -1 && (adapter = parent.getAdapter()) != null) {
            int itemViewType = adapter.getItemViewType(iA);
            Pair<Integer, ? extends RecyclerView.ViewHolder> pair2 = this.currentHeader;
            if (pair2 != null && ((Number) pair2.getFirst()).intValue() == iA && (pair = this.currentHeader) != null && (viewHolder = (RecyclerView.ViewHolder) pair.getSecond()) != null && viewHolder.getItemViewType() == itemViewType) {
                Pair<Integer, ? extends RecyclerView.ViewHolder> pair3 = this.currentHeader;
                if (pair3 == null || (viewHolder2 = (RecyclerView.ViewHolder) pair3.getSecond()) == null) {
                    return null;
                }
                return viewHolder2.itemView;
            }
            RecyclerView.Adapter adapter2 = parent.getAdapter();
            RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter2 != null ? adapter2.createViewHolder(parent, itemViewType) : null;
            if (viewHolderCreateViewHolder != null) {
                RecyclerView.Adapter adapter3 = parent.getAdapter();
                if (adapter3 != null) {
                    adapter3.onBindViewHolder(viewHolderCreateViewHolder, iA);
                }
                View view = viewHolderCreateViewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "headerHolder.itemView");
                a(parent, view);
                this.currentHeader = TuplesKt.to(Integer.valueOf(iA), viewHolderCreateViewHolder);
            }
            if (viewHolderCreateViewHolder != null) {
                return viewHolderCreateViewHolder.itemView;
            }
        }
        return null;
    }

    private final void a(Canvas canvas, View header, int paddingTop) {
        canvas.save();
        canvas.translate(0.0f, paddingTop);
        header.draw(canvas);
        canvas.restore();
    }

    private final void a(Canvas c2, View currentHeader, View nextHeader, int paddingTop) {
        c2.save();
        if (!this.shouldFadeOutHeader) {
            c2.clipRect(0, paddingTop, c2.getWidth(), currentHeader.getHeight() + paddingTop);
        } else {
            c2.saveLayerAlpha(new RectF(0.0f, 0.0f, c2.getWidth(), c2.getHeight()), (int) (((nextHeader.getTop() - paddingTop) / nextHeader.getHeight()) * 255));
        }
        c2.translate(0.0f, nextHeader.getTop() - currentHeader.getHeight());
        currentHeader.draw(c2);
        if (this.shouldFadeOutHeader) {
            c2.restore();
        }
        c2.restore();
    }

    private final View a(RecyclerView parent, int contactPoint) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            Rect rect = new Rect();
            parent.getDecoratedBoundsWithMargins(childAt, rect);
            if (rect.bottom > contactPoint && rect.top <= contactPoint) {
                return childAt;
            }
        }
        return null;
    }

    private final void a(ViewGroup parent, View view) {
        view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(parent.getWidth(), 1073741824), parent.getPaddingLeft() + parent.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(parent.getHeight(), 0), parent.getPaddingTop() + parent.getPaddingBottom(), view.getLayoutParams().height));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private final int a(int itemPosition) {
        while (!((Boolean) this.isHeader.invoke(Integer.valueOf(itemPosition))).booleanValue()) {
            itemPosition--;
            if (itemPosition < 0) {
                return -1;
            }
        }
        return itemPosition;
    }
}
