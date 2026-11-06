package io.didomi.ssl;

import android.view.View;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/ef;", "Lio/didomi/sdk/ng;", "Lio/didomi/sdk/r4;", "binding", "<init>", "(Lio/didomi/sdk/r4;)V", "Lio/didomi/sdk/hg$a;", "bulk", "Lkotlin/Function1;", "", "", "callback", "a", "(Lio/didomi/sdk/hg$a;Lkotlin/jvm/functions/Function1;)V", "Lio/didomi/sdk/r4;", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ef extends ng {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final r4 binding;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/ef$a", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch;", "switch", "", "isChecked", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
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
    public ef(r4 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(hg.Bulk bulk, Function1 callback) {
        Intrinsics.checkNotNullParameter(bulk, "bulk");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final r4 r4Var = this.binding;
        r4Var.d.setText(bulk.getTitle());
        r4Var.c.setText(bulk.getStatus());
        final DidomiTVSwitch didomiTVSwitch = r4Var.b;
        didomiTVSwitch.setCallback(null);
        didomiTVSwitch.setAnimate(false);
        didomiTVSwitch.setChecked(bulk.getIsChecked());
        didomiTVSwitch.setCallback(new a(callback));
        didomiTVSwitch.post(new Runnable() { // from class: io.didomi.sdk.ef$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ef.a(didomiTVSwitch);
            }
        });
        r4Var.getRoot().setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.ef$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ef.a(r4Var, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiTVSwitch this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setAnimate(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(r4 this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.b.callOnClick();
    }
}
