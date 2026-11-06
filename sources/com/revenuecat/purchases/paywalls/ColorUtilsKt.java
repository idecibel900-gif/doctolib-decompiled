package com.revenuecat.purchases.paywalls;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a0\u0010\n\u001a\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\u00012\b\b\u0001\u0010\r\u001a\u00020\u00012\b\b\u0001\u0010\u000e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0004H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"ALPHA_MATCH_GROUP_INDEX", "", "ALPHA_SHIFT_BITS", "DEFAULT_ALPHA_HEX", "", "GREEN_SHIFT_BITS", "HEX_RADIX", "RED_SHIFT_BITS", "rgbaColorRegex", "Lkotlin/text/Regex;", "colorInt", "alpha", "red", "green", "blue", "parseRGBAColor", "stringRepresentation", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorUtilsKt {
    private static final int ALPHA_MATCH_GROUP_INDEX = 4;
    private static final int ALPHA_SHIFT_BITS = 24;
    private static final String DEFAULT_ALPHA_HEX = "FF";
    private static final int GREEN_SHIFT_BITS = 8;
    private static final int HEX_RADIX = 16;
    private static final int RED_SHIFT_BITS = 16;
    private static final Regex rgbaColorRegex = new Regex("^#([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})([A-Fa-f0-9]{2})?$");

    public static final int colorInt(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static final int parseRGBAColor(String stringRepresentation) {
        Intrinsics.checkNotNullParameter(stringRepresentation, "stringRepresentation");
        MatchResult matchResultMatchEntire = rgbaColorRegex.matchEntire(stringRepresentation);
        if (matchResultMatchEntire != null) {
            MatchResult.Destructured destructured = matchResultMatchEntire.getDestructured();
            String str = (String) destructured.getMatch().getGroupValues().get(1);
            String str2 = (String) destructured.getMatch().getGroupValues().get(2);
            String str3 = (String) destructured.getMatch().getGroupValues().get(3);
            Object orNull = CollectionsKt.getOrNull(matchResultMatchEntire.getGroupValues(), 4);
            String str4 = (String) orNull;
            if (str4 == null || StringsKt.isBlank(str4)) {
                orNull = null;
            }
            String str5 = (String) orNull;
            if (str5 == null) {
                str5 = DEFAULT_ALPHA_HEX;
            }
            return colorInt(Integer.parseInt(str5, CharsKt.checkRadix(16)), Integer.parseInt(str, CharsKt.checkRadix(16)), Integer.parseInt(str2, CharsKt.checkRadix(16)), Integer.parseInt(str3, CharsKt.checkRadix(16)));
        }
        return Color.parseColor(stringRepresentation);
    }
}
