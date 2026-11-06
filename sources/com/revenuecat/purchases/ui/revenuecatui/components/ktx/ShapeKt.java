package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0006H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"SCALE_Y_OFFSET_CONCAVE_CONVEX", "", "convertCornerRadiusesToShape", "Landroidx/compose/ui/graphics/Shape;", "Lcom/revenuecat/purchases/paywalls/components/properties/CornerRadiuses;", "toShape", "Lcom/revenuecat/purchases/paywalls/components/properties/MaskShape;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class ShapeKt {
    private static final float SCALE_Y_OFFSET_CONCAVE_CONVEX = 0.1f;

    public static final /* synthetic */ Shape toShape(com.revenuecat.purchases.paywalls.components.properties.Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<this>");
        return convertCornerRadiusesToShape(shape.getCornerRadiuses());
    }

    public static final /* synthetic */ Shape toShape(MaskShape maskShape) {
        Shape shapeConvertCornerRadiusesToShape;
        Intrinsics.checkNotNullParameter(maskShape, "<this>");
        if (maskShape instanceof MaskShape.Rectangle) {
            CornerRadiuses corners = ((MaskShape.Rectangle) maskShape).getCorners();
            return (corners == null || (shapeConvertCornerRadiusesToShape = convertCornerRadiusesToShape(corners)) == null) ? RectangleShapeKt.getRectangleShape() : shapeConvertCornerRadiusesToShape;
        }
        if (maskShape instanceof MaskShape.Concave) {
            return new GenericShape(new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt.toShape.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m4088invoke12SF9DM((Path) obj, ((Size) obj2).m1265unboximpl(), (LayoutDirection) obj3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
                public final void m4088invoke12SF9DM(Path $receiver, long j, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    float fM1259getHeightimpl = Size.m1259getHeightimpl(j) * ShapeKt.SCALE_Y_OFFSET_CONCAVE_CONVEX * 2.0f;
                    $receiver.moveTo(0.0f, 0.0f);
                    $receiver.lineTo(Size.m1261getWidthimpl(j), 0.0f);
                    $receiver.lineTo(Size.m1261getWidthimpl(j), Size.m1259getHeightimpl(j));
                    $receiver.quadraticTo(Size.m1261getWidthimpl(j) / 2, Size.m1259getHeightimpl(j) - fM1259getHeightimpl, 0.0f, Size.m1259getHeightimpl(j));
                    $receiver.lineTo(0.0f, 0.0f);
                }
            });
        }
        if (maskShape instanceof MaskShape.Convex) {
            return new GenericShape(new Function3() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt.toShape.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m4089invoke12SF9DM((Path) obj, ((Size) obj2).m1265unboximpl(), (LayoutDirection) obj3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-12SF9DM, reason: not valid java name */
                public final void m4089invoke12SF9DM(Path $receiver, long j, LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    float fM1259getHeightimpl = Size.m1259getHeightimpl(j) * ShapeKt.SCALE_Y_OFFSET_CONCAVE_CONVEX;
                    $receiver.moveTo(0.0f, 0.0f);
                    $receiver.lineTo(Size.m1261getWidthimpl(j), 0.0f);
                    $receiver.lineTo(Size.m1261getWidthimpl(j), Size.m1259getHeightimpl(j) - fM1259getHeightimpl);
                    $receiver.quadraticTo(Size.m1261getWidthimpl(j) / 2, Size.m1259getHeightimpl(j) + fM1259getHeightimpl, 0.0f, Size.m1259getHeightimpl(j) - fM1259getHeightimpl);
                    $receiver.lineTo(0.0f, 0.0f);
                }
            });
        }
        if (maskShape instanceof MaskShape.Circle) {
            return RoundedCornerShapeKt.getCircleShape();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Shape convertCornerRadiusesToShape(CornerRadiuses cornerRadiuses) {
        if (cornerRadiuses instanceof CornerRadiuses.Percentage) {
            CornerRadiuses.Percentage percentage = (CornerRadiuses.Percentage) cornerRadiuses;
            return RoundedCornerShapeKt.RoundedCornerShape(percentage.getTopLeading(), percentage.getTopTrailing(), percentage.getBottomTrailing(), percentage.getBottomLeading());
        }
        if (!(cornerRadiuses instanceof CornerRadiuses.Dp)) {
            throw new NoWhenBranchMatchedException();
        }
        CornerRadiuses.Dp dp = (CornerRadiuses.Dp) cornerRadiuses;
        return RoundedCornerShapeKt.m460RoundedCornerShapea9UjIt4(Dp.m2551constructorimpl((float) dp.getTopLeading()), Dp.m2551constructorimpl((float) dp.getTopTrailing()), Dp.m2551constructorimpl((float) dp.getBottomTrailing()), Dp.m2551constructorimpl((float) dp.getBottomLeading()));
    }
}
