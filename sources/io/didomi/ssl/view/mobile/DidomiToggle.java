package io.didomi.ssl.view.mobile;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.R;
import io.didomi.ssl.ah;
import io.didomi.ssl.q;
import io.didomi.ssl.s5;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\r\u0003B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR*\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00066"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle;", "Landroid/widget/FrameLayout;", "", "b", "", "getAccessibilityClassName", "onFinishInflate", "", "enabled", "setEnabled", "Lio/didomi/sdk/view/mobile/DidomiToggle$a;", "callback", "setCallback", "a", "Lio/didomi/sdk/s5;", "Lio/didomi/sdk/s5;", "binding", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "value", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "getState", "()Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "setState", "(Lio/didomi/sdk/view/mobile/DidomiToggle$b;)V", "state", "c", "Z", "getAnimate", "()Z", "setAnimate", "(Z)V", "animate", "d", "getHasMiddleState", "setHasMiddleState", "hasMiddleState", "e", "Lio/didomi/sdk/view/mobile/DidomiToggle$a;", "Lio/didomi/sdk/ah;", "f", "Lio/didomi/sdk/ah;", "getThemeProvider", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class DidomiToggle extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final s5 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private b state;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean animate;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private boolean hasMiddleState;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private a callback;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public ah themeProvider;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle$a;", "", "Lio/didomi/sdk/view/mobile/DidomiToggle;", "toggle", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public interface a {
        void a(DidomiToggle toggle, b state);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\n\u0010\bj\u0002\b\nj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "", "", "hasMiddleState", "a", "", "I", "b", "()I", "colorRes", "c", "iconRes", "<init>", "(Ljava/lang/String;III)V", "d", "e", "android_release"}, k = 1, mv = {1, 8, 0})
    public enum b {
        DISABLED(R.color.didomi_toggle_disabled, R.drawable.didomi_ic_toggle_cross),
        ENABLED(R.color.didomi_toggle_enabled, R.drawable.didomi_ic_toggle_check),
        UNKNOWN(R.color.didomi_toggle_unknown, 0, 2, null);


        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int colorRes;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final int iconRes;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.ENABLED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.DISABLED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[b.UNKNOWN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        b(int i, int i2) {
            this.colorRes = i;
            this.iconRes = i2;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getColorRes() {
            return this.colorRes;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* synthetic */ b(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2);
        }

        public final b a(boolean hasMiddleState) {
            int i = a.a[ordinal()];
            if (i == 1) {
                return DISABLED;
            }
            if (i == 2) {
                return hasMiddleState ? UNKNOWN : ENABLED;
            }
            if (i == 3) {
                return ENABLED;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiToggle(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiToggle this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    private final void b() {
        int i;
        ImageView imageView = this.binding.d;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(imageView.getLayoutParams());
        int i2 = c.a[this.state.ordinal()];
        if (i2 == 1) {
            i = 8388629;
        } else if (i2 == 2) {
            i = 8388627;
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = 17;
        }
        layoutParams.gravity = i;
        imageView.setLayoutParams(layoutParams);
        ViewCompat.setBackgroundTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(imageView.getContext(), this.state.getColorRes())));
        imageView.setImageResource(this.state.getIconRes());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        String name = Switch.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "Switch::class.java.name");
        return name;
    }

    public final boolean getAnimate() {
        return this.animate;
    }

    public final boolean getHasMiddleState() {
        return this.hasMiddleState;
    }

    public final b getState() {
        return this.state;
    }

    public final ah getThemeProvider() {
        ah ahVar = this.themeProvider;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeProvider");
        return null;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View view = this.binding.c;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDisplayMetrics().density * 180.0f);
        gradientDrawable.setColor(ContextCompat.getColor(getContext(), getThemeProvider().t() ? R.color.didomi_dark_divider : R.color.didomi_light_divider));
        view.setBackground(gradientDrawable);
        if (this.hasMiddleState || this.state != b.UNKNOWN) {
            b();
        } else {
            setState(b.DISABLED);
        }
        setAnimate(true);
        setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.view.mobile.DidomiToggle$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DidomiToggle.a(this.f$0, view2);
            }
        });
    }

    public final void setAnimate(boolean z) {
        LayoutTransition layoutTransition;
        this.animate = z;
        FrameLayout frameLayout = this.binding.b;
        if (!z || q.a.get()) {
            layoutTransition = null;
        } else {
            layoutTransition = new LayoutTransition();
            layoutTransition.setDuration(150L);
            layoutTransition.enableTransitionType(4);
            layoutTransition.setInterpolator(4, new FastOutLinearInInterpolator());
        }
        frameLayout.setLayoutTransition(layoutTransition);
    }

    public final void setCallback(a callback) {
        this.callback = callback;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(enabled ? 1.0f : 0.6f);
    }

    public final void setHasMiddleState(boolean z) {
        this.hasMiddleState = z;
    }

    public final void setState(b value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state = value;
        b();
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(this, this.state);
        }
    }

    public final void setThemeProvider(ah ahVar) {
        Intrinsics.checkNotNullParameter(ahVar, "<set-?>");
        this.themeProvider = ahVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidomiToggle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        setState(this.state.a(this.hasMiddleState));
        b();
    }

    public /* synthetic */ DidomiToggle(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidomiToggle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        s5 s5VarA = s5.a(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(s5VarA, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = s5VarA;
        this.state = b.UNKNOWN;
        this.animate = !q.a.get();
        this.hasMiddleState = true;
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DidomiToggle);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…R.styleable.DidomiToggle)");
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DidomiToggle_didomi_enabled)) {
                setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DidomiToggle_didomi_enabled, true));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DidomiToggle_didomi_has_middle_state)) {
                this.hasMiddleState = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DidomiToggle_didomi_has_middle_state, true);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.DidomiToggle_didomi_state)) {
                setState(b.values()[typedArrayObtainStyledAttributes.getInt(R.styleable.DidomiToggle_didomi_state, 0)]);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
