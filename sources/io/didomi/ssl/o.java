package io.didomi.ssl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.modules.appstate.AppStateModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0004J\b\u0010\u0004\u001a\u00020\u0002H\u0004R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0006\u0010\u0015¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/o;", "Landroidx/appcompat/app/AppCompatActivity;", "", "g", "h", "", "a", "Lkotlin/Lazy;", "j", "()F", "backgroundAlpha", "", "b", "k", "()J", "fadeDuration", "Landroid/view/View;", "c", "Landroid/view/View;", "i", "()Landroid/view/View;", "(Landroid/view/View;)V", AppStateModule.APP_STATE_BACKGROUND, "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public abstract class o extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Lazy backgroundAlpha = LazyKt.lazy(new a());

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final Lazy fadeDuration = LazyKt.lazy(new b());

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    protected View background;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function0 {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            TypedValue typedValue = new TypedValue();
            o.this.getResources().getValue(R.dimen.didomi_tv_colored_background_alpha, typedValue, true);
            return Float.valueOf(typedValue.getFloat());
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function0 {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(o.this.getResources().getInteger(R.integer.didomi_fragment_slide_animation_time));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"io/didomi/sdk/o$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.a.setVisibility(8);
        }
    }

    private final float j() {
        return ((Number) this.backgroundAlpha.getValue()).floatValue();
    }

    private final long k() {
        return ((Number) this.fadeDuration.getValue()).longValue();
    }

    protected final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.background = view;
    }

    protected final void g() {
        View viewI = i();
        viewI.clearAnimation();
        viewI.setAlpha(0.0f);
        viewI.setVisibility(0);
        viewI.animate().alpha(j()).setDuration(k()).setListener(null);
    }

    protected final void h() {
        View viewI = i();
        viewI.clearAnimation();
        viewI.setAlpha(j());
        viewI.animate().alpha(0.0f).setDuration(k()).setListener(new c(viewI));
    }

    protected final View i() {
        View view = this.background;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(AppStateModule.APP_STATE_BACKGROUND);
        return null;
    }
}
