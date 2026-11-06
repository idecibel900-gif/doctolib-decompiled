package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidParagraphIntrinsics_androidKt {
    /* JADX INFO: renamed from: resolveTextDirectionHeuristics-HklW4sA, reason: not valid java name */
    public static final int m2387resolveTextDirectionHeuristicsHklW4sA(int i, LocaleList localeList) {
        Locale platformLocale;
        TextDirection.Companion companion = TextDirection.Companion;
        if (TextDirection.m2491equalsimpl0(i, companion.m2496getContentOrLtrs_7Xco())) {
            return 2;
        }
        if (TextDirection.m2491equalsimpl0(i, companion.m2497getContentOrRtls_7Xco())) {
            return 3;
        }
        if (TextDirection.m2491equalsimpl0(i, companion.m2498getLtrs_7Xco())) {
            return 0;
        }
        if (TextDirection.m2491equalsimpl0(i, companion.m2499getRtls_7Xco())) {
            return 1;
        }
        if (TextDirection.m2491equalsimpl0(i, companion.m2495getContents_7Xco()) ? true : TextDirection.m2491equalsimpl0(i, companion.m2500getUnspecifieds_7Xco())) {
            if (localeList == null || (platformLocale = localeList.get(0).getPlatformLocale()) == null) {
                platformLocale = Locale.getDefault();
            }
            int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(platformLocale);
            return (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) ? 2 : 3;
        }
        throw new IllegalStateException("Invalid TextDirection.");
    }

    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String str, TextStyle textStyle, List list, List list2, Density density, FontFamily.Resolver resolver) {
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasEmojiCompat(TextStyle textStyle) {
        PlatformParagraphStyle paragraphStyle;
        PlatformTextStyle platformStyle = textStyle.getPlatformStyle();
        EmojiSupportMatch emojiSupportMatchM2137boximpl = (platformStyle == null || (paragraphStyle = platformStyle.getParagraphStyle()) == null) ? null : EmojiSupportMatch.m2137boximpl(paragraphStyle.m2172getEmojiSupportMatch_3YsG6Y());
        return !(emojiSupportMatchM2137boximpl == null ? false : EmojiSupportMatch.m2140equalsimpl0(emojiSupportMatchM2137boximpl.m2143unboximpl(), EmojiSupportMatch.Companion.m2146getNone_3YsG6Y()));
    }
}
