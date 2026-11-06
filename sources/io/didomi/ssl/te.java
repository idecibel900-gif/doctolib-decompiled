package io.didomi.ssl;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import io.didomi.ssl.notice.ctv.TVNoticeDialogActivity;
import io.didomi.ssl.preferences.ctv.TVPreferencesDialogActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/te;", "Lio/didomi/sdk/eh;", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "a", "Lio/didomi/sdk/ic;", "subScreenType", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "g", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isNoticeDisplayed", "b", "f", "isPreferencesDisplayed", "<init>", "()V", "c", "android_release"}, k = 1, mv = {1, 8, 0})
public final class te implements eh {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final MutableStateFlow isNoticeDisplayed;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final MutableStateFlow isPreferencesDisplayed;

    public te() {
        Boolean bool = Boolean.FALSE;
        this.isNoticeDisplayed = StateFlowKt.MutableStateFlow(bool);
        this.isPreferencesDisplayed = StateFlowKt.MutableStateFlow(bool);
    }

    @Override // io.didomi.ssl.eh
    public StateFlow a() {
        return eh.a.b(this);
    }

    @Override // io.didomi.ssl.eh
    public boolean b() {
        return eh.a.c(this);
    }

    @Override // io.didomi.ssl.eh
    public boolean c() {
        return eh.a.d(this);
    }

    @Override // io.didomi.ssl.eh
    public void d() {
        eh.a.e(this);
    }

    @Override // io.didomi.ssl.eh
    public StateFlow e() {
        return eh.a.a(this);
    }

    @Override // io.didomi.ssl.eh
    /* JADX INFO: renamed from: f, reason: from getter */
    public MutableStateFlow getIsPreferencesDisplayed() {
        return this.isPreferencesDisplayed;
    }

    @Override // io.didomi.ssl.eh
    /* JADX INFO: renamed from: g, reason: from getter */
    public MutableStateFlow getIsNoticeDisplayed() {
        return this.isNoticeDisplayed;
    }

    @Override // io.didomi.ssl.eh
    public void h() {
        eh.a.f(this);
    }

    @Override // io.didomi.ssl.eh
    public void a(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivity(new Intent(activity.getApplicationContext(), (Class<?>) TVNoticeDialogActivity.class).addFlags(0));
        eh.a.a(this, activity);
    }

    @Override // io.didomi.ssl.eh
    public void a(FragmentActivity activity, ic subScreenType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(subScreenType, "subScreenType");
        activity.startActivity(new Intent(activity.getApplicationContext(), (Class<?>) TVPreferencesDialogActivity.class).addFlags(0).putExtra("OPEN_SUBSCREEN", subScreenType));
        eh.a.a(this, activity, subScreenType);
    }
}
