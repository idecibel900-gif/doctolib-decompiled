package io.didomi.ssl;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0017J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/eh;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "a", "Lkotlinx/coroutines/flow/StateFlow;", "", "e", "b", "d", "Lio/didomi/sdk/ic;", "subScreenType", "c", "h", "Lkotlinx/coroutines/flow/MutableStateFlow;", "g", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isNoticeDisplayed", "f", "isPreferencesDisplayed", "android_release"}, k = 1, mv = {1, 8, 0})
public interface eh {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static void a(eh ehVar, FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ehVar.getIsNoticeDisplayed().setValue(Boolean.TRUE);
        }

        public static StateFlow b(eh ehVar) {
            return ehVar.getIsPreferencesDisplayed();
        }

        public static boolean c(eh ehVar) {
            return ((Boolean) ehVar.getIsNoticeDisplayed().getValue()).booleanValue();
        }

        public static boolean d(eh ehVar) {
            return ((Boolean) ehVar.getIsPreferencesDisplayed().getValue()).booleanValue();
        }

        public static void e(eh ehVar) {
            ehVar.getIsNoticeDisplayed().setValue(Boolean.FALSE);
        }

        public static void f(eh ehVar) {
            ehVar.getIsPreferencesDisplayed().setValue(Boolean.FALSE);
        }

        public static StateFlow a(eh ehVar) {
            return ehVar.getIsNoticeDisplayed();
        }

        public static void a(eh ehVar, FragmentActivity activity, ic subScreenType) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(subScreenType, "subScreenType");
            ehVar.getIsPreferencesDisplayed().setValue(Boolean.TRUE);
        }
    }

    StateFlow a();

    void a(FragmentActivity activity);

    void a(FragmentActivity activity, ic subScreenType);

    boolean b();

    boolean c();

    void d();

    StateFlow e();

    /* JADX INFO: renamed from: f */
    MutableStateFlow getIsPreferencesDisplayed();

    /* JADX INFO: renamed from: g */
    MutableStateFlow getIsNoticeDisplayed();

    void h();
}
