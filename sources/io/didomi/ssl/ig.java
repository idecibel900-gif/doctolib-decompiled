package io.didomi.ssl;

import android.view.View;
import android.widget.TextView;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/ig;", "Lio/didomi/sdk/ng;", "Lio/didomi/sdk/a5;", "binding", "<init>", "(Lio/didomi/sdk/a5;)V", "Lio/didomi/sdk/hg$g;", "vendor", "Lkotlin/Function1;", "", "", "callback", "a", "(Lio/didomi/sdk/hg$g;Lkotlin/jvm/functions/Function1;)V", "Lio/didomi/sdk/a5;", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ig extends ng {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final a5 binding;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/ig$a", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch;", "switch", "", "isChecked", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements DidomiTVSwitch.a {
        final /* synthetic */ Function1 a;

        a(Function1 function1) {
            this.a = function1;
        }

        @Override // io.didomi.sdk.view.ctv.DidomiTVSwitch.a
        public void a(DidomiTVSwitch didomiTVSwitch, boolean isChecked) {
            Intrinsics.checkNotNullParameter(didomiTVSwitch, "switch");
            this.a.invoke(Boolean.valueOf(isChecked));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig(a5 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(hg.Vendor vendor, Function1 callback) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.binding.g.setText(vendor.getTitle());
        TextView textView = this.binding.e;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textCtvVendorItemIabtcfTag");
        textView.setVisibility(vendor.getIsIAB() ? 0 : 8);
        if (!vendor.getHasState()) {
            TextView textView2 = this.binding.f;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textCtvVendorItemStatus");
            textView2.setVisibility(8);
            DidomiTVSwitch bind$lambda$4 = this.binding.d;
            bind$lambda$4.setEnabled(false);
            Intrinsics.checkNotNullExpressionValue(bind$lambda$4, "bind$lambda$4");
            bind$lambda$4.setVisibility(4);
            bind$lambda$4.setCallback(null);
            return;
        }
        a5 a5Var = this.binding;
        a5Var.f.setText(vendor.getStatus());
        TextView textCtvVendorItemStatus = a5Var.f;
        Intrinsics.checkNotNullExpressionValue(textCtvVendorItemStatus, "textCtvVendorItemStatus");
        textCtvVendorItemStatus.setVisibility(0);
        final DidomiTVSwitch bind$lambda$3 = this.binding.d;
        bind$lambda$3.setAnimate(false);
        bind$lambda$3.setEnabled(true);
        Intrinsics.checkNotNullExpressionValue(bind$lambda$3, "bind$lambda$3");
        bind$lambda$3.setVisibility(0);
        bind$lambda$3.setCallback(null);
        bind$lambda$3.setChecked(vendor.getIsChecked());
        bind$lambda$3.setCallback(new a(callback));
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.ig$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ig.a(bind$lambda$3, view);
            }
        });
        bind$lambda$3.post(new Runnable() { // from class: io.didomi.sdk.ig$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ig.a(bind$lambda$3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiTVSwitch this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiTVSwitch this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setAnimate(true);
    }
}
