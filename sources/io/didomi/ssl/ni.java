package io.didomi.ssl;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u001a$\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u001a.\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t\u001a\u001c\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a2\u0010\u0006\u001a\u00020\u0004*\u00020\u00002\b\b\u0003\u0010\r\u001a\u00020\u00072\b\b\u0003\u0010\u000e\u001a\u00020\u00072\b\b\u0003\u0010\u000f\u001a\u00020\u00072\b\b\u0003\u0010\u0010\u001a\u00020\u0007\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0000\u001a\n\u0010\u0011\u001a\u00020\u0004*\u00020\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00002\b\b\u0003\u0010\u0012\u001a\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Landroid/view/View;", "", "duration", "Lkotlin/Function0;", "", "complete", "a", "", "visibility", "Lio/didomi/sdk/ah;", "themeProvider", "", "visible", "start", "top", "end", "bottom", "b", "value", "android_release"}, k = 2, mv = {1, 8, 0})
public final class ni {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/ni$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements Animation.AnimationListener {
        final /* synthetic */ View a;
        final /* synthetic */ Function0 b;

        a(View view, Function0 function0) {
            this.a = view;
            this.b = function0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Function0 function0 = this.b;
            if (function0 != null) {
                function0.invoke();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.a.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/ni$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ View a;
        final /* synthetic */ int b;
        final /* synthetic */ Function0 c;

        b(View view, int i, Function0 function0) {
            this.a = view;
            this.b = i;
            this.c = function0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.setVisibility(this.b);
            Function0 function0 = this.c;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static /* synthetic */ void a(View view, long j, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        a(view, j, function0);
    }

    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setAlpha(1.0f);
        view.setEnabled(true);
    }

    public static final void a(View view, long j, Function0 function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.clearAnimation();
        if (view.getVisibility() == 0) {
            return;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.didomi_fade_in);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        animationLoadAnimation.setDuration((long) (j * w0.b(context)));
        animationLoadAnimation.setAnimationListener(new a(view, function0));
        view.startAnimation(animationLoadAnimation);
    }

    public static /* synthetic */ void a(View view, long j, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        if ((i2 & 4) != 0) {
            function0 = null;
        }
        a(view, j, i, function0);
    }

    public static final void a(View view, long j, int i, Function0 function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.clearAnimation();
        if (view.getVisibility() != 0) {
            return;
        }
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.didomi_fade_out);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        animationLoadAnimation.setDuration((long) (j * w0.b(context)));
        animationLoadAnimation.setAnimationListener(new b(view, i, function0));
        view.startAnimation(animationLoadAnimation);
    }

    public static final void a(View view, ah themeProvider) {
        int i;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        Context context = view.getContext();
        if (themeProvider.t()) {
            i = R.color.didomi_dark_bottom_divider;
        } else {
            i = R.color.didomi_light_bottom_divider;
        }
        view.setBackgroundColor(ContextCompat.getColor(context, i));
    }

    public static /* synthetic */ void a(View view, ah ahVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        a(view, ahVar, z);
    }

    public static final void a(View view, ah themeProvider, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(themeProvider, "themeProvider");
        if (z) {
            Context context = view.getContext();
            if (themeProvider.t()) {
                i = R.color.didomi_dark_divider;
            } else {
                i = R.color.didomi_light_divider;
            }
            view.setBackgroundColor(ContextCompat.getColor(context, i));
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static /* synthetic */ void a(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        a(view, i, i2, i3, i4);
    }

    public static final void a(View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(a(view, i), a(view, i2), a(view, i3), a(view, i4));
    }

    public static final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setAlpha(0.5f);
        view.setEnabled(false);
    }

    private static final int a(View view, int i) {
        if (i != 0) {
            return view.getResources().getDimensionPixelSize(i);
        }
        return 0;
    }
}
