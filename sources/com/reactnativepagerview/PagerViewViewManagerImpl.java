package com.reactnativepagerview;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PagerViewViewManagerImpl {
    public static final PagerViewViewManagerImpl INSTANCE = new PagerViewViewManagerImpl();
    private static Choreographer.FrameCallback refreshFrameCallback;

    public final boolean needsCustomLayoutForChildren() {
        return true;
    }

    private PagerViewViewManagerImpl() {
    }

    public final ViewPager2 getViewPager(NestedScrollableHost view) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getChildAt(0) instanceof ViewPager2) {
            View childAt = view.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
            return (ViewPager2) childAt;
        }
        throw new ClassNotFoundException("Could not retrieve ViewPager2 instance");
    }

    public final void setCurrentItem(ViewPager2 view, int i, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        refreshViewChildrenLayout(view);
        view.setCurrentItem(i, z);
    }

    public final void addView(NestedScrollableHost host, View view, int i) throws ClassNotFoundException {
        Integer initialIndex;
        Intrinsics.checkNotNullParameter(host, "host");
        if (view == null) {
            return;
        }
        ViewPager2 viewPager = getViewPager(host);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.addChild(view, i);
        }
        if (viewPager.getCurrentItem() == i) {
            refreshViewChildrenLayout(viewPager);
        }
        if (host.getDidSetInitialIndex() || (initialIndex = host.getInitialIndex()) == null || initialIndex.intValue() != i) {
            return;
        }
        host.setDidSetInitialIndex(true);
        setCurrentItem(viewPager, i, false);
    }

    public final int getChildCount(NestedScrollableHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView.Adapter adapter = getViewPager(parent).getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public final View getChildAt(NestedScrollableHost parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) getViewPager(parent).getAdapter();
        Intrinsics.checkNotNull(viewPagerAdapter);
        return viewPagerAdapter.getChildAt(i);
    }

    public final void removeView(NestedScrollableHost parent, View view) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        ViewPager2 viewPager = getViewPager(parent);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeChild(view);
        }
        refreshViewChildrenLayout(viewPager);
    }

    public final void removeAllViews(NestedScrollableHost parent) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPager2 viewPager = getViewPager(parent);
        viewPager.setUserInputEnabled(false);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeAll();
        }
    }

    public final void removeViewAt(NestedScrollableHost parent, int i) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPager2 viewPager = getViewPager(parent);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        View childAt = viewPagerAdapter != null ? viewPagerAdapter.getChildAt(i) : null;
        if (childAt != null && childAt.getParent() != null) {
            ViewParent parent2 = childAt.getParent();
            ViewGroup viewGroup = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup != null) {
                viewGroup.removeView(childAt);
            }
        }
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeChildAt(i);
        }
        debouncedRefreshViewChildrenLayout(viewPager);
    }

    public final void setScrollEnabled(NestedScrollableHost host, boolean z) {
        Intrinsics.checkNotNullParameter(host, "host");
        getViewPager(host).setUserInputEnabled(z);
    }

    public final void setLayoutDirection(NestedScrollableHost host, String value) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        ViewPager2 viewPager = getViewPager(host);
        if (Intrinsics.areEqual(value, "rtl")) {
            viewPager.setLayoutDirection(1);
        } else {
            viewPager.setLayoutDirection(0);
        }
    }

    public final void setInitialPage(final NestedScrollableHost host, int i) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        ViewPager2 viewPager = getViewPager(host);
        if (host.getInitialIndex() == null) {
            host.setInitialIndex(Integer.valueOf(i));
            viewPager.post(new Runnable() { // from class: com.reactnativepagerview.PagerViewViewManagerImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    host.setDidSetInitialIndex(true);
                }
            });
        }
    }

    public final void setOrientation(NestedScrollableHost host, String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        getViewPager(host).setOrientation(Intrinsics.areEqual(value, "vertical") ? 1 : 0);
    }

    public final void setOffscreenPageLimit(NestedScrollableHost host, int i) {
        Intrinsics.checkNotNullParameter(host, "host");
        getViewPager(host).setOffscreenPageLimit(i);
    }

    public final void setOverScrollMode(NestedScrollableHost host, String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        View childAt = getViewPager(host).getChildAt(0);
        if (Intrinsics.areEqual(value, "never")) {
            childAt.setOverScrollMode(2);
        } else if (Intrinsics.areEqual(value, "always")) {
            childAt.setOverScrollMode(0);
        } else {
            childAt.setOverScrollMode(1);
        }
    }

    public final void setPageMargin(NestedScrollableHost host, int i) throws ClassNotFoundException {
        Intrinsics.checkNotNullParameter(host, "host");
        final ViewPager2 viewPager = getViewPager(host);
        final int pixelFromDIP = (int) PixelUtil.toPixelFromDIP(i);
        viewPager.setPageTransformer(new ViewPager2.PageTransformer() { // from class: com.reactnativepagerview.PagerViewViewManagerImpl$$ExternalSyntheticLambda0
            @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
            public final void transformPage(View view, float f) {
                PagerViewViewManagerImpl.setPageMargin$lambda$1(pixelFromDIP, viewPager, view, f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPageMargin$lambda$1(int i, ViewPager2 viewPager2, View page, float f) {
        Intrinsics.checkNotNullParameter(page, "page");
        float f2 = i * f;
        if (viewPager2.getOrientation() == 0) {
            if (viewPager2.getLayoutDirection() == 1) {
                f2 = -f2;
            }
            page.setTranslationX(f2);
            return;
        }
        page.setTranslationY(f2);
    }

    private final void refreshViewChildrenLayout(final View view) {
        view.post(new Runnable() { // from class: com.reactnativepagerview.PagerViewViewManagerImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PagerViewViewManagerImpl.refreshViewChildrenLayout$lambda$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshViewChildrenLayout$lambda$2(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private final void debouncedRefreshViewChildrenLayout(final View view) {
        Choreographer.FrameCallback frameCallback = refreshFrameCallback;
        if (frameCallback != null) {
            Choreographer.getInstance().removeFrameCallback(frameCallback);
        }
        ViewPager2 viewPager2 = view instanceof ViewPager2 ? (ViewPager2) view : null;
        RecyclerView.Adapter adapter = viewPager2 != null ? viewPager2.getAdapter() : null;
        ViewPagerAdapter viewPagerAdapter = adapter instanceof ViewPagerAdapter ? (ViewPagerAdapter) adapter : null;
        if (viewPagerAdapter == null || viewPagerAdapter.getItemCount() == 0) {
            return;
        }
        refreshFrameCallback = new Choreographer.FrameCallback() { // from class: com.reactnativepagerview.PagerViewViewManagerImpl$$ExternalSyntheticLambda2
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                PagerViewViewManagerImpl.debouncedRefreshViewChildrenLayout$lambda$4(view, j);
            }
        };
        Choreographer.getInstance().postFrameCallback(refreshFrameCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void debouncedRefreshViewChildrenLayout$lambda$4(View view, long j) {
        INSTANCE.refreshViewChildrenLayout(view);
        refreshFrameCallback = null;
    }
}
