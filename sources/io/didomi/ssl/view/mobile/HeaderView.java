package io.didomi.ssl.view.mobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.R;
import io.didomi.ssl.ah;
import io.didomi.ssl.ib;
import io.didomi.ssl.n5;
import io.didomi.ssl.u7;
import io.didomi.ssl.zg;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J*\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rJ$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, d2 = {"Lio/didomi/sdk/view/mobile/HeaderView;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Bitmap;", "bitmap", "", "a", "", "resourceId", "b", "Lio/didomi/sdk/u7;", "logoProvider", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", com.amazon.a.a.o.b.S, "accessibilityTitle", "titleGravity", "Lio/didomi/sdk/n5;", "Lio/didomi/sdk/n5;", "binding", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "getThemeProvider", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/ib;", "c", "Lio/didomi/sdk/ib;", "getResourcesHelper", "()Lio/didomi/sdk/ib;", "setResourcesHelper", "(Lio/didomi/sdk/ib;)V", "resourcesHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class HeaderView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final n5 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ib resourcesHelper;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class a extends FunctionReferenceImpl implements Function1 {
        a(Object obj) {
            super(1, obj, HeaderView.class, "onBitmapLogo", "onBitmapLogo(Landroid/graphics/Bitmap;)V", 0);
        }

        public final void a(Bitmap bitmap) {
            ((HeaderView) this.receiver).a(bitmap);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Bitmap) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class b extends FunctionReferenceImpl implements Function1 {
        b(Object obj) {
            super(1, obj, HeaderView.class, "onResourceLogo", "onResourceLogo(I)V", 0);
        }

        public final void a(int i) {
            ((HeaderView) this.receiver).a(i);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class c extends FunctionReferenceImpl implements Function0 {
        c(Object obj) {
            super(0, obj, HeaderView.class, "onLogoAbsent", "onLogoAbsent()V", 0);
        }

        public final void a() {
            ((HeaderView) this.receiver).b();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        this.binding.c.setVisibility(0);
    }

    public final ib getResourcesHelper() {
        ib ibVar = this.resourcesHelper;
        if (ibVar != null) {
            return ibVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("resourcesHelper");
        return null;
    }

    public final ah getThemeProvider() {
        ah ahVar = this.themeProvider;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeProvider");
        return null;
    }

    public final void setResourcesHelper(ib ibVar) {
        Intrinsics.checkNotNullParameter(ibVar, "<set-?>");
        this.resourcesHelper = ibVar;
    }

    public final void setThemeProvider(ah ahVar) {
        Intrinsics.checkNotNullParameter(ahVar, "<set-?>");
        this.themeProvider = ahVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        n5 n5VarA = n5.a(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(n5VarA, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = n5VarA;
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
    }

    public static /* synthetic */ void a(HeaderView headerView, u7 u7Var, LifecycleOwner lifecycleOwner, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        headerView.a(u7Var, lifecycleOwner, str, str2);
    }

    public final void a(u7 logoProvider, LifecycleOwner lifecycleOwner, String title, String accessibilityTitle) {
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(title, "title");
        TextView setup$lambda$0 = this.binding.c;
        setup$lambda$0.setText(title);
        if (StringsKt.isBlank(title) || accessibilityTitle == null || StringsKt.isBlank(accessibilityTitle)) {
            accessibilityTitle = null;
        }
        setup$lambda$0.setHint(accessibilityTitle);
        Intrinsics.checkNotNullExpressionValue(setup$lambda$0, "setup$lambda$0");
        zg.a(setup$lambda$0, getThemeProvider().i().n());
        this.binding.b.setVisibility(8);
        logoProvider.a(lifecycleOwner, new a(this), new b(this), new c(this));
    }

    public static /* synthetic */ void a(HeaderView headerView, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            i = 17;
        }
        headerView.a(str, str2, i);
    }

    public final void a(String title, String accessibilityTitle, int titleGravity) {
        Intrinsics.checkNotNullParameter(title, "title");
        ImageView imageView = this.binding.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageHeaderLogo");
        imageView.setVisibility(8);
        TextView setup$lambda$2 = this.binding.c;
        setup$lambda$2.setText(title);
        if (StringsKt.isBlank(title) || accessibilityTitle == null || StringsKt.isBlank(accessibilityTitle)) {
            accessibilityTitle = null;
        }
        setup$lambda$2.setHint(accessibilityTitle);
        Intrinsics.checkNotNullExpressionValue(setup$lambda$2, "setup$lambda$2");
        zg.a(setup$lambda$2, getThemeProvider().i().n());
        setup$lambda$2.setGravity(titleGravity);
        setup$lambda$2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Bitmap bitmap) {
        this.binding.c.setVisibility(8);
        ImageView imageView = this.binding.b;
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int resourceId) {
        this.binding.c.setVisibility(8);
        ImageView imageView = this.binding.b;
        imageView.setImageResource(resourceId);
        imageView.setVisibility(0);
    }

    public final void a() {
        if (getResourcesHelper().b()) {
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.didomi_title_horizontal_padding_with_cross);
        if (this.binding.c.getGravity() == 17) {
            setPadding(dimensionPixelOffset, getPaddingTop(), dimensionPixelOffset, getPaddingBottom());
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), dimensionPixelOffset, getPaddingBottom());
        }
    }
}
