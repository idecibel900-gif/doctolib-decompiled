package androidx.compose.foundation.pager;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
final class DefaultPagerState extends PagerState {
    public static final Companion Companion = new Companion(null);
    private static final Saver Saver = ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.foundation.pager.DefaultPagerState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List invoke(SaverScope saverScope, DefaultPagerState defaultPagerState) {
            return CollectionsKt.listOf(Integer.valueOf(defaultPagerState.getCurrentPage()), Float.valueOf(RangesKt.coerceIn(defaultPagerState.getCurrentPageOffsetFraction(), -0.5f, 0.5f)), Integer.valueOf(defaultPagerState.getPageCount()));
        }
    }, new Function1() { // from class: androidx.compose.foundation.pager.DefaultPagerState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final DefaultPagerState invoke(final List list) {
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new DefaultPagerState(iIntValue, ((Float) obj2).floatValue(), new Function0() { // from class: androidx.compose.foundation.pager.DefaultPagerState$Companion$Saver$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    Object obj3 = list.get(2);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                    return (Integer) obj3;
                }
            });
        }
    });
    private MutableState pageCountState;

    public DefaultPagerState(int i, float f, Function0 function0) {
        super(i, f);
        this.pageCountState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function0, null, 2, null);
    }

    public final MutableState getPageCountState() {
        return this.pageCountState;
    }

    @Override // androidx.compose.foundation.pager.PagerState
    public int getPageCount() {
        return ((Number) ((Function0) this.pageCountState.getValue()).invoke()).intValue();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver getSaver() {
            return DefaultPagerState.Saver;
        }
    }
}
