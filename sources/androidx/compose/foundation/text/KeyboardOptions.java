package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class KeyboardOptions {
    public static final Companion Companion = new Companion(null);
    private static final KeyboardOptions Default = new KeyboardOptions(0, null, 0, 0, null, null, null, 127, null);
    private static final KeyboardOptions SecureTextField = new KeyboardOptions(0, Boolean.FALSE, KeyboardType.Companion.m2369getPasswordPjHm6EE(), 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 121, null);
    private final Boolean autoCorrectEnabled;
    private final int capitalization;
    private final LocaleList hintLocales;
    private final int imeAction;
    private final int keyboardType;
    private final Boolean showKeyboardOnFocus;

    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bool, i2, i3, platformImeOptions, bool2, localeList);
    }

    private KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList) {
        this.capitalization = i;
        this.autoCorrectEnabled = bool;
        this.keyboardType = i2;
        this.imeAction = i3;
        this.showKeyboardOnFocus = bool2;
        this.hintLocales = localeList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ KeyboardOptions(int i, Boolean bool, int i2, int i3, PlatformImeOptions platformImeOptions, Boolean bool2, LocaleList localeList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        int iM2355getUnspecifiedIUNYP9k = (i4 & 1) != 0 ? KeyboardCapitalization.Companion.m2355getUnspecifiedIUNYP9k() : i;
        Boolean bool3 = (i4 & 2) != 0 ? null : bool;
        int iM2372getUnspecifiedPjHm6EE = (i4 & 4) != 0 ? KeyboardType.Companion.m2372getUnspecifiedPjHm6EE() : i2;
        int iM2340getUnspecifiedeUduSuo = (i4 & 8) != 0 ? ImeAction.Companion.m2340getUnspecifiedeUduSuo() : i3;
        PlatformImeOptions platformImeOptions2 = (i4 & 16) != 0 ? null : platformImeOptions;
        Boolean bool4 = (i4 & 32) != 0 ? null : bool2;
        this(iM2355getUnspecifiedIUNYP9k, bool3, iM2372getUnspecifiedPjHm6EE, iM2340getUnspecifiedeUduSuo, platformImeOptions2, bool4, (i4 & 64) == 0 ? localeList : null, null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }
    }

    private final boolean getAutoCorrectOrDefault() {
        Boolean bool = this.autoCorrectEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: renamed from: getCapitalizationOrDefault-IUNYP9k, reason: not valid java name */
    private final int m481getCapitalizationOrDefaultIUNYP9k() {
        KeyboardCapitalization keyboardCapitalizationM2345boximpl = KeyboardCapitalization.m2345boximpl(this.capitalization);
        int iM2351unboximpl = keyboardCapitalizationM2345boximpl.m2351unboximpl();
        KeyboardCapitalization.Companion companion = KeyboardCapitalization.Companion;
        if (KeyboardCapitalization.m2348equalsimpl0(iM2351unboximpl, companion.m2355getUnspecifiedIUNYP9k())) {
            keyboardCapitalizationM2345boximpl = null;
        }
        return keyboardCapitalizationM2345boximpl != null ? keyboardCapitalizationM2345boximpl.m2351unboximpl() : companion.m2353getNoneIUNYP9k();
    }

    /* JADX INFO: renamed from: getKeyboardTypeOrDefault-PjHm6EE, reason: not valid java name */
    private final int m482getKeyboardTypeOrDefaultPjHm6EE() {
        KeyboardType keyboardTypeM2357boximpl = KeyboardType.m2357boximpl(this.keyboardType);
        int iM2363unboximpl = keyboardTypeM2357boximpl.m2363unboximpl();
        KeyboardType.Companion companion = KeyboardType.Companion;
        if (KeyboardType.m2360equalsimpl0(iM2363unboximpl, companion.m2372getUnspecifiedPjHm6EE())) {
            keyboardTypeM2357boximpl = null;
        }
        return keyboardTypeM2357boximpl != null ? keyboardTypeM2357boximpl.m2363unboximpl() : companion.m2371getTextPjHm6EE();
    }

    /* JADX INFO: renamed from: getImeActionOrDefault-eUduSuo$foundation_release, reason: not valid java name */
    public final int m483getImeActionOrDefaulteUduSuo$foundation_release() {
        ImeAction imeActionM2325boximpl = ImeAction.m2325boximpl(this.imeAction);
        int iM2331unboximpl = imeActionM2325boximpl.m2331unboximpl();
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m2328equalsimpl0(iM2331unboximpl, companion.m2340getUnspecifiedeUduSuo())) {
            imeActionM2325boximpl = null;
        }
        return imeActionM2325boximpl != null ? imeActionM2325boximpl.m2331unboximpl() : companion.m2332getDefaulteUduSuo();
    }

    private final LocaleList getHintLocalesOrDefault() {
        LocaleList localeList = this.hintLocales;
        return localeList == null ? LocaleList.Companion.getEmpty() : localeList;
    }

    public final ImeOptions toImeOptions$foundation_release(boolean z) {
        return new ImeOptions(z, m481getCapitalizationOrDefaultIUNYP9k(), getAutoCorrectOrDefault(), m482getKeyboardTypeOrDefaultPjHm6EE(), m483getImeActionOrDefaulteUduSuo$foundation_release(), null, getHintLocalesOrDefault(), null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        return KeyboardCapitalization.m2348equalsimpl0(this.capitalization, keyboardOptions.capitalization) && Intrinsics.areEqual(this.autoCorrectEnabled, keyboardOptions.autoCorrectEnabled) && KeyboardType.m2360equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m2328equalsimpl0(this.imeAction, keyboardOptions.imeAction) && Intrinsics.areEqual((Object) null, (Object) null) && Intrinsics.areEqual(this.showKeyboardOnFocus, keyboardOptions.showKeyboardOnFocus) && Intrinsics.areEqual(this.hintLocales, keyboardOptions.hintLocales);
    }

    public int hashCode() {
        int iM2349hashCodeimpl = KeyboardCapitalization.m2349hashCodeimpl(this.capitalization) * 31;
        Boolean bool = this.autoCorrectEnabled;
        int iHashCode = (((((iM2349hashCodeimpl + (bool != null ? bool.hashCode() : 0)) * 31) + KeyboardType.m2361hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m2329hashCodeimpl(this.imeAction)) * 961;
        Boolean bool2 = this.showKeyboardOnFocus;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        LocaleList localeList = this.hintLocales;
        return iHashCode2 + (localeList != null ? localeList.hashCode() : 0);
    }

    public String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) KeyboardCapitalization.m2350toStringimpl(this.capitalization)) + ", autoCorrectEnabled=" + this.autoCorrectEnabled + ", keyboardType=" + ((Object) KeyboardType.m2362toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m2330toStringimpl(this.imeAction)) + ", platformImeOptions=" + ((Object) null) + "showKeyboardOnFocus=" + this.showKeyboardOnFocus + ", hintLocales=" + this.hintLocales + ')';
    }
}
