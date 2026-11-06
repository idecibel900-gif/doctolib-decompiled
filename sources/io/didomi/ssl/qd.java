package io.didomi.ssl;

import android.view.View;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/qd;", "Lio/didomi/sdk/sd;", "Lio/didomi/sdk/h4;", "binding", "<init>", "(Lio/didomi/sdk/h4;)V", "Lio/didomi/sdk/pd$g;", "purpose", "Lkotlin/Function1;", "", "", "callback", "a", "(Lio/didomi/sdk/pd$g;Lkotlin/jvm/functions/Function1;)V", "Lio/didomi/sdk/h4;", "android_release"}, k = 1, mv = {1, 8, 0})
public final class qd extends sd {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final h4 binding;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/qd$a", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch;", "switch", "", "isChecked", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
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
    public qd(h4 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(pd.Purpose purpose, Function1 callback) {
        Intrinsics.checkNotNullParameter(purpose, "purpose");
        Intrinsics.checkNotNullParameter(callback, "callback");
        h4 h4Var = this.binding;
        h4Var.e.setText(purpose.getTitle());
        h4Var.d.setText(purpose.getSubtitle());
        final DidomiTVSwitch bind$lambda$3 = this.binding.c;
        bind$lambda$3.setCallback(null);
        bind$lambda$3.setAnimate(false);
        bind$lambda$3.setChecked(purpose.getIsChecked());
        if (purpose.getPurpose().isEssential()) {
            bind$lambda$3.setEnabled(false);
            Intrinsics.checkNotNullExpressionValue(bind$lambda$3, "bind$lambda$3");
            bind$lambda$3.setVisibility(4);
        } else {
            bind$lambda$3.setEnabled(true);
            Intrinsics.checkNotNullExpressionValue(bind$lambda$3, "bind$lambda$3");
            bind$lambda$3.setVisibility(0);
            bind$lambda$3.setCallback(new a(callback));
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.qd$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    qd.a(bind$lambda$3, view);
                }
            });
            bind$lambda$3.post(new Runnable() { // from class: io.didomi.sdk.qd$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    qd.a(bind$lambda$3);
                }
            });
        }
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
