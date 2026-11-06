package com.revenuecat.purchases.ui.revenuecatui.components.ktx;

import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "Lcom/revenuecat/purchases/paywalls/components/properties/FontWeight;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class FontKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FontWeight.values().length];
            try {
                iArr[FontWeight.EXTRA_LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FontWeight.THIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FontWeight.LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FontWeight.REGULAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FontWeight.MEDIUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FontWeight.SEMI_BOLD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FontWeight.BOLD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FontWeight.EXTRA_BOLD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FontWeight.BLACK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ androidx.compose.ui.text.font.FontWeight toFontWeight(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[fontWeight.ordinal()]) {
            case 1:
                return androidx.compose.ui.text.font.FontWeight.Companion.getExtraLight();
            case 2:
                return androidx.compose.ui.text.font.FontWeight.Companion.getThin();
            case 3:
                return androidx.compose.ui.text.font.FontWeight.Companion.getLight();
            case 4:
                return androidx.compose.ui.text.font.FontWeight.Companion.getNormal();
            case 5:
                return androidx.compose.ui.text.font.FontWeight.Companion.getMedium();
            case 6:
                return androidx.compose.ui.text.font.FontWeight.Companion.getSemiBold();
            case 7:
                return androidx.compose.ui.text.font.FontWeight.Companion.getBold();
            case 8:
                return androidx.compose.ui.text.font.FontWeight.Companion.getExtraBold();
            case 9:
                return androidx.compose.ui.text.font.FontWeight.Companion.getBlack();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
