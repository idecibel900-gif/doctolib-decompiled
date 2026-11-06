package io.didomi.ssl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0000H\u0002¨\u0006\b"}, d2 = {"Landroid/widget/ImageView;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lio/didomi/sdk/u7;", "logoProvider", "", "a", "b", "android_release"}, k = 2, mv = {1, 8, 0})
public final class z6 {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/Bitmap;", "it", "", "a", "(Landroid/graphics/Bitmap;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function1 {
        final /* synthetic */ ImageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ImageView imageView) {
            super(1);
            this.a = imageView;
        }

        public final void a(Bitmap it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.a.setImageBitmap(it);
            z6.b(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Bitmap) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(I)V"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function1 {
        final /* synthetic */ ImageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImageView imageView) {
            super(1);
            this.a = imageView;
        }

        public final void a(int i) {
            this.a.setImageResource(i);
            z6.b(this.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        final /* synthetic */ ImageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(ImageView imageView) {
            super(0);
            this.a = imageView;
        }

        public final void a() {
            this.a.setVisibility(8);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ImageView imageView) {
        int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(R.dimen.didomi_notice_logo_max_height);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            if (drawable.getIntrinsicHeight() < dimensionPixelSize) {
                drawable = null;
            }
            if (drawable != null) {
                imageView.setAdjustViewBounds(true);
                imageView.setMaxHeight(dimensionPixelSize);
            }
        }
    }

    public static final void a(ImageView imageView, LifecycleOwner lifecycleOwner, u7 logoProvider) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(logoProvider, "logoProvider");
        logoProvider.a(lifecycleOwner, new a(imageView), new b(imageView), new c(imageView));
    }
}
