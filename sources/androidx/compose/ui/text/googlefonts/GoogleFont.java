package androidx.compose.ui.text.googlefonts;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleFont {
    private final boolean bestEffort;
    private final String name;

    public GoogleFont(String str, boolean z) {
        this.name = str;
        this.bestEffort = z;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name cannot be empty");
        }
    }

    public /* synthetic */ GoogleFont(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final boolean getBestEffort() {
        return this.bestEffort;
    }

    public final String getName() {
        return this.name;
    }

    public static final class Provider {
        private final List certificates;
        private final int certificatesRes;
        private final String providerAuthority;
        private final String providerPackage;

        private Provider(String str, String str2, List list, int i) {
            this.providerAuthority = str;
            this.providerPackage = str2;
            this.certificates = list;
            this.certificatesRes = i;
        }

        public final String getProviderAuthority$ui_text_google_fonts_release() {
            return this.providerAuthority;
        }

        public final String getProviderPackage$ui_text_google_fonts_release() {
            return this.providerPackage;
        }

        public final List getCertificates$ui_text_google_fonts_release() {
            return this.certificates;
        }

        public final int getCertificatesRes$ui_text_google_fonts_release() {
            return this.certificatesRes;
        }

        public Provider(String str, String str2, int i) {
            this(str, str2, null, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Provider)) {
                return false;
            }
            Provider provider = (Provider) obj;
            return Intrinsics.areEqual(this.providerAuthority, provider.providerAuthority) && Intrinsics.areEqual(this.providerPackage, provider.providerPackage) && Intrinsics.areEqual(this.certificates, provider.certificates) && this.certificatesRes == provider.certificatesRes;
        }

        public int hashCode() {
            int iHashCode = ((this.providerAuthority.hashCode() * 31) + this.providerPackage.hashCode()) * 31;
            List list = this.certificates;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.certificatesRes;
        }
    }
}
