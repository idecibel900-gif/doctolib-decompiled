package coil.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSizeKt;
import coil.request.ImageRequest;
import coil.request.NullRequestDataException;
import coil.size.Scale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UtilsKt {
    private static final long ZeroConstraints = Constraints.Companion.m2539fixedJhjzzOo(0, 0);

    public static final ImageRequest requestOf(Object obj, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1151830858, i, -1, "coil.compose.requestOf (Utils.kt:21)");
        }
        if (obj instanceof ImageRequest) {
            return (ImageRequest) obj;
        }
        return new ImageRequest.Builder((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).data(obj).build();
    }

    public static final Function1 transformOf(final Painter painter, final Painter painter2, final Painter painter3) {
        if (painter != null || painter2 != null || painter3 != null) {
            return new Function1() { // from class: coil.compose.UtilsKt.transformOf.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AsyncImagePainter.State invoke(AsyncImagePainter.State state) {
                    if (state instanceof AsyncImagePainter.State.Loading) {
                        Painter painter4 = painter;
                        AsyncImagePainter.State.Loading loading = (AsyncImagePainter.State.Loading) state;
                        return painter4 != null ? loading.copy(painter4) : loading;
                    }
                    if (!(state instanceof AsyncImagePainter.State.Error)) {
                        return state;
                    }
                    AsyncImagePainter.State.Error error = (AsyncImagePainter.State.Error) state;
                    if (error.getResult().getThrowable() instanceof NullRequestDataException) {
                        Painter painter5 = painter3;
                        return painter5 != null ? AsyncImagePainter.State.Error.copy$default(error, painter5, null, 2, null) : error;
                    }
                    Painter painter6 = painter2;
                    return painter6 != null ? AsyncImagePainter.State.Error.copy$default(error, painter6, null, 2, null) : error;
                }
            };
        }
        return AsyncImagePainter.INSTANCE.getDefaultTransform();
    }

    public static final Function1 onStateOf(final Function1 function1, final Function1 function2, final Function1 function3) {
        if (function1 == null && function2 == null && function3 == null) {
            return null;
        }
        return new Function1() { // from class: coil.compose.UtilsKt.onStateOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AsyncImagePainter.State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(AsyncImagePainter.State state) {
                Function1 function4;
                if (state instanceof AsyncImagePainter.State.Loading) {
                    Function1 function5 = function1;
                    if (function5 != null) {
                        function5.invoke(state);
                        return;
                    }
                    return;
                }
                if (state instanceof AsyncImagePainter.State.Success) {
                    Function1 function6 = function2;
                    if (function6 != null) {
                        function6.invoke(state);
                        return;
                    }
                    return;
                }
                if (!(state instanceof AsyncImagePainter.State.Error) || (function4 = function3) == null) {
                    return;
                }
                function4.invoke(state);
            }
        };
    }

    public static final Scale toScale(ContentScale contentScale) {
        ContentScale.Companion companion = ContentScale.Companion;
        return Intrinsics.areEqual(contentScale, companion.getFit()) ? true : Intrinsics.areEqual(contentScale, companion.getInside()) ? Scale.FIT : Scale.FILL;
    }

    /* JADX INFO: renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final float m3021constrainWidthK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.m2532getMinWidthimpl(j), Constraints.m2530getMaxWidthimpl(j));
    }

    /* JADX INFO: renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final float m3020constrainHeightK40F9xA(long j, float f) {
        return RangesKt.coerceIn(f, Constraints.m2531getMinHeightimpl(j), Constraints.m2529getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: toIntSize-uvyYCjk, reason: not valid java name */
    public static final long m3022toIntSizeuvyYCjk(long j) {
        return IntSizeKt.IntSize(MathKt.roundToInt(Size.m1261getWidthimpl(j)), MathKt.roundToInt(Size.m1259getHeightimpl(j)));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }
}
