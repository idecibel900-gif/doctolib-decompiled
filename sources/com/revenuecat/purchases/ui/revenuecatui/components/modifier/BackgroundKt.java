package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import com.facebook.react.modules.appstate.AppStateModule;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0001¨\u0006\u0007"}, d2 = {AppStateModule.APP_STATE_BACKGROUND, "Landroidx/compose/ui/Modifier;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class BackgroundKt {
    public static /* synthetic */ Modifier background$default(Modifier modifier, ColorStyle colorStyle, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return background(modifier, colorStyle, shape);
    }

    public static final /* synthetic */ Modifier background(Modifier modifier, ColorStyle color, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (color instanceof ColorStyle.Solid) {
            return androidx.compose.foundation.BackgroundKt.m115backgroundbw27NRU(modifier, ((ColorStyle.Solid) color).m4133unboximpl(), shape);
        }
        if (color instanceof ColorStyle.Gradient) {
            return androidx.compose.foundation.BackgroundKt.background(modifier, ((ColorStyle.Gradient) color).m4125unboximpl(), shape, 1.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Modifier background$default(Modifier modifier, BackgroundStyle backgroundStyle, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return background(modifier, backgroundStyle, shape);
    }

    public static final /* synthetic */ Modifier background(Modifier modifier, BackgroundStyle background, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (background instanceof BackgroundStyle.Color) {
            return background(modifier, ((BackgroundStyle.Color) background).m4103unboximpl(), shape);
        }
        if (background instanceof BackgroundStyle.Image) {
            BackgroundStyle.Image image = (BackgroundStyle.Image) background;
            return PainterModifierKt.paint$default(ClipKt.clip(modifier, shape), image.getPainter(), false, Alignment.Companion.getTopCenter(), image.getContentScale(), 0.0f, null, 50, null);
        }
        if (background instanceof BackgroundStyle.Video) {
            return modifier;
        }
        throw new NoWhenBranchMatchedException();
    }
}
