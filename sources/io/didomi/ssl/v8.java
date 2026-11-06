package io.didomi.ssl;

import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lio/didomi/sdk/v8;", "", "Landroidx/fragment/app/DialogFragment;", AuthorizationRequest.ResponseMode.FRAGMENT, "Lio/didomi/sdk/eh;", "uiProvider", "", "a", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "job", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class v8 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private Job job;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isVisible", "", "a", "(Z)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends Lambda implements Function1 {
        final /* synthetic */ DialogFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(DialogFragment dialogFragment) {
            super(1);
            this.a = dialogFragment;
        }

        public final void a(boolean z) {
            if (z) {
                return;
            }
            this.a.dismiss();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    public final void a(DialogFragment fragment, eh uiProvider) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(uiProvider, "uiProvider");
        this.job = c6.a(fragment, uiProvider.a(), new a(fragment));
    }

    public final void a() {
        Job job = this.job;
        if (job != null) {
            job.cancel(null);
        }
    }
}
