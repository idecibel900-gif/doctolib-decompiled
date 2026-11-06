package io.didomi.ssl.view.ctv;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import io.didomi.ssl.R;
import io.didomi.ssl.q;
import io.didomi.ssl.r5;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0003\u0004\u0014\u0019B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006+"}, d2 = {"Lio/didomi/sdk/view/ctv/DidomiTVSwitch;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "", "a", "", "enabled", "setEnabled", "checked", "setChecked", "isChecked", "toggle", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "callback", "setCallback", "Lio/didomi/sdk/r5;", "Lio/didomi/sdk/r5;", "binding", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$c;", "value", "b", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$c;", "setState", "(Lio/didomi/sdk/view/ctv/DidomiTVSwitch$c;)V", "state", "c", "Z", "getAnimate", "()Z", "setAnimate", "(Z)V", "animate", "d", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "android_release"}, k = 1, mv = {1, 8, 0})
public final class DidomiTVSwitch extends FrameLayout implements Checkable {
    private static final int f = R.color.didomi_tv_neutrals_25;
    private static final int g = R.color.didomi_tv_neutrals_50;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final r5 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private c state;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean animate;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private a callback;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch;", "switch", "", "isChecked", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(DidomiTVSwitch didomiTVSwitch, boolean isChecked);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u0005j\u0002\b\f¨\u0006\r"}, d2 = {"Lio/didomi/sdk/view/ctv/DidomiTVSwitch$c;", "", "", "a", "I", "c", "()I", "colorRes", "b", "backgroundColorRes", "<init>", "(Ljava/lang/String;III)V", "d", "android_release"}, k = 1, mv = {1, 8, 0})
    private enum c {
        DISABLED(R.color.didomi_tv_neutrals, R.color.didomi_tv_background_c),
        ENABLED(R.color.didomi_tv_neutrals, R.color.didomi_tv_primary_brand);


        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int colorRes;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final int backgroundColorRes;

        c(int i, int i2) {
            this.colorRes = i;
            this.backgroundColorRes = i2;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getBackgroundColorRes() {
            return this.backgroundColorRes;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getColorRes() {
            return this.colorRes;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiTVSwitch(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiTVSwitch this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toggle();
    }

    private final void setState(c cVar) {
        this.state = cVar;
        a();
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(this, cVar == c.ENABLED);
        }
    }

    public final boolean getAnimate() {
        return this.animate;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.state == c.ENABLED;
    }

    public final void setAnimate(boolean z) {
        LayoutTransition layoutTransition;
        this.animate = z;
        FrameLayout root = this.binding.getRoot();
        if (!this.animate || q.a.get()) {
            layoutTransition = null;
        } else {
            layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(150L);
            layoutTransition.enableTransitionType(4);
            layoutTransition.setInterpolator(4, new FastOutLinearInInterpolator());
        }
        root.setLayoutTransition(layoutTransition);
    }

    public final void setCallback(a callback) {
        this.callback = callback;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        setState(checked ? c.ENABLED : c.DISABLED);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(enabled ? 1.0f : 0.6f);
        a();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        c cVar = this.state;
        c cVar2 = c.ENABLED;
        if (cVar == cVar2) {
            cVar2 = c.DISABLED;
        }
        setState(cVar2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiTVSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        int i;
        ImageView imageView = this.binding.c;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(imageView.getLayoutParams());
        int i2 = d.a[this.state.ordinal()];
        if (i2 == 1) {
            i = 8388629;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 8388627;
        }
        layoutParams.gravity = i;
        imageView.setLayoutParams(layoutParams);
        imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), imageView.isEnabled() ? this.state.getColorRes() : f));
        this.binding.b.setColorFilter(ContextCompat.getColor(getContext(), isEnabled() ? this.state.getBackgroundColorRes() : g), PorterDuff.Mode.SRC);
    }

    public /* synthetic */ DidomiTVSwitch(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidomiTVSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        r5 r5VarA = r5.a(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(r5VarA, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = r5VarA;
        c cVar = c.DISABLED;
        this.state = cVar;
        this.animate = !q.a.get();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DidomiTVSwitch);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…styleable.DidomiTVSwitch)");
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DidomiTVSwitch_didomi_enabled)) {
                setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DidomiTVSwitch_didomi_enabled, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DidomiTVSwitch_didomi_state)) {
                int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.DidomiTVSwitch_didomi_state, 0);
                setState(i2 < c.values().length ? c.values()[i2] : cVar);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        a();
        setAnimate(true);
        setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.view.ctv.DidomiTVSwitch$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DidomiTVSwitch.a(this.f$0, view);
            }
        });
    }
}
