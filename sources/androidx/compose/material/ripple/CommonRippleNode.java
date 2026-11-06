package androidx.compose.material.ripple;

import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: loaded from: classes.dex */
public final class CommonRippleNode extends RippleNode {
    private final MutableScatterMap ripples;

    public /* synthetic */ CommonRippleNode(InteractionSource interactionSource, boolean z, float f, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z, f, colorProducer, function0);
    }

    private CommonRippleNode(InteractionSource interactionSource, boolean z, float f, ColorProducer colorProducer, Function0 function0) {
        super(interactionSource, z, f, colorProducer, function0, null);
        this.ripples = new MutableScatterMap(0, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x004e A[LOOP:0: B:5:0x0013->B:15:0x004e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0051 A[EDGE_INSN: B:23:0x0051->B:16:0x0051 BREAK  A[LOOP:0: B:5:0x0013->B:15:0x004e], SYNTHETIC] */
    @Override // androidx.compose.material.ripple.RippleNode
    /* JADX INFO: renamed from: addRipple-12SF9DM */
    public void mo668addRipple12SF9DM(PressInteraction.Press press, long j, float f) {
        MutableScatterMap mutableScatterMap = this.ripples;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j2 = jArr[i];
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j2) < 128) {
                            int i4 = (i << 3) + i3;
                            ((RippleAnimation) objArr2[i4]).finish();
                        }
                        j2 >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        RippleAnimation rippleAnimation = new RippleAnimation(getBounded() ? Offset.m1214boximpl(press.m268getPressPositionF1C5BW0()) : null, f, getBounded(), null);
        this.ripples.set(press, rippleAnimation);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new CommonRippleNode$addRipple$2(rippleAnimation, this, press, null), 3, null);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void removeRipple(PressInteraction.Press press) {
        RippleAnimation rippleAnimation = (RippleAnimation) this.ripples.get(press);
        if (rippleAnimation != null) {
            rippleAnimation.finish();
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void drawRipples(DrawScope drawScope) {
        float f;
        int i;
        int i2;
        float pressedAlpha = ((RippleAlpha) getRippleAlpha().invoke()).getPressedAlpha();
        if (pressedAlpha == 0.0f) {
            return;
        }
        MutableScatterMap mutableScatterMap = this.ripples;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j = jArr[i3];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8;
                int i5 = 8 - ((~(i3 - length)) >>> 31);
                long j2 = j;
                int i6 = 0;
                while (i6 < i5) {
                    if ((j2 & 255) < 128) {
                        int i7 = (i3 << 3) + i6;
                        i = i6;
                        i2 = i5;
                        ((RippleAnimation) objArr2[i7]).m672draw4WTKRHQ(drawScope, Color.m1365copywmQWz5c$default(m681getRippleColor0d7_KjU(), pressedAlpha, 0.0f, 0.0f, 0.0f, 14, null));
                    } else {
                        i = i6;
                        i2 = i5;
                    }
                    j2 >>= i4;
                    i6 = i + 1;
                    pressedAlpha = pressedAlpha;
                    i5 = i2;
                    i4 = i4;
                }
                int i8 = i5;
                f = pressedAlpha;
                if (i8 != i4) {
                    return;
                }
            } else {
                f = pressedAlpha;
            }
            if (i3 == length) {
                return;
            }
            i3++;
            pressedAlpha = f;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.ripples.clear();
    }
}
