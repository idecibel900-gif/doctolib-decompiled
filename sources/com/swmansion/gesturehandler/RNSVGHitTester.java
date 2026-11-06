package com.swmansion.gesturehandler;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import com.horcrux.svg.SvgView;
import com.horcrux.svg.VirtualView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RNSVGHitTester {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final SvgView getRootSvgView(View view) {
            SvgView svgView;
            if (view instanceof VirtualView) {
                svgView = ((VirtualView) view).getSvgView();
                Intrinsics.checkNotNull(svgView);
            } else {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.horcrux.svg.SvgView");
                svgView = (SvgView) view;
            }
            while (true) {
                ViewParent parent = svgView.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                if (!isSvgElement(parent)) {
                    return svgView;
                }
                if (svgView.getParent() instanceof VirtualView) {
                    ViewParent parent2 = svgView.getParent();
                    Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type com.horcrux.svg.VirtualView");
                    svgView = ((VirtualView) parent2).getSvgView();
                    Intrinsics.checkNotNull(svgView);
                } else {
                    ViewParent parent3 = svgView.getParent();
                    Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type com.horcrux.svg.SvgView");
                    svgView = (SvgView) parent3;
                }
            }
        }

        public final boolean isSvgElement(Object view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return (view instanceof VirtualView) || (view instanceof SvgView);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0056  */
        public final boolean hitTest(View view, float f, float f2) {
            boolean z;
            Intrinsics.checkNotNullParameter(view, "view");
            SvgView rootSvgView = getRootSvgView(view);
            int[] iArr = {0, 0};
            int[] iArr2 = {0, 0};
            view.getLocationOnScreen(iArr);
            rootSvgView.getLocationOnScreen(iArr2);
            int iReactTagForTouch = rootSvgView.reactTagForTouch((iArr[0] + f) - iArr2[0], (iArr[1] + f2) - iArr2[1]);
            boolean z2 = view.getId() == iReactTagForTouch;
            double width = view.getWidth();
            double d = f;
            if (0.0d > d || d > width) {
                z = false;
            } else {
                double height = view.getHeight();
                double d2 = f2;
                if (0.0d > d2 || d2 > height) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (view instanceof SvgView) {
                return (z2 || SequencesKt.contains(SequencesKt.map(ViewGroupKt.getChildren((ViewGroup) view), new Function1() { // from class: com.swmansion.gesturehandler.RNSVGHitTester$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(RNSVGHitTester.Companion.hitTest$lambda$0((View) obj));
                    }
                }), Integer.valueOf(iReactTagForTouch))) && z;
            }
            return z2 && z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int hitTest$lambda$0(View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getId();
        }
    }
}
