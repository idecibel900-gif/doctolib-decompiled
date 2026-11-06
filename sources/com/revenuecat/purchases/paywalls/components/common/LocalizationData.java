package com.revenuecat.purchases.paywalls.components.common;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "", "Companion", "Image", "Text", "Video", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Image;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Text;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Video;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LocalizationData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer serializer() {
            return LocalizationDataSerializer.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Text;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Text implements LocalizationData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Text m3971boximpl(String str) {
            return new Text(str);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static String m3972constructorimpl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3973equalsimpl(String str, Object obj) {
            return (obj instanceof Text) && Intrinsics.areEqual(str, ((Text) obj).m3977unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3974equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual(str, str2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3975hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3976toStringimpl(String str) {
            return "Text(value=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m3973equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m3975hashCodeimpl(this.value);
        }

        public String toString() {
            return m3976toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ String m3977unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Text$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Text;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return LocalizationData$Text$$serializer.INSTANCE;
            }
        }

        private /* synthetic */ Text(String str) {
            this.value = str;
        }

        public final /* synthetic */ String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Image;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "value", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "constructor-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;)Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getValue", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;)I", "toString", "", "toString-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;)Ljava/lang/String;", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Image implements LocalizationData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ThemeImageUrls value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Image m3962boximpl(ThemeImageUrls themeImageUrls) {
            return new Image(themeImageUrls);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ThemeImageUrls m3963constructorimpl(ThemeImageUrls value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3964equalsimpl(ThemeImageUrls themeImageUrls, Object obj) {
            return (obj instanceof Image) && Intrinsics.areEqual(themeImageUrls, ((Image) obj).m3968unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3965equalsimpl0(ThemeImageUrls themeImageUrls, ThemeImageUrls themeImageUrls2) {
            return Intrinsics.areEqual(themeImageUrls, themeImageUrls2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3966hashCodeimpl(ThemeImageUrls themeImageUrls) {
            return themeImageUrls.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3967toStringimpl(ThemeImageUrls themeImageUrls) {
            return "Image(value=" + themeImageUrls + ')';
        }

        public boolean equals(Object obj) {
            return m3964equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m3966hashCodeimpl(this.value);
        }

        public String toString() {
            return m3967toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ThemeImageUrls m3968unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Image$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Image;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return LocalizationData$Image$$serializer.INSTANCE;
            }
        }

        private /* synthetic */ Image(ThemeImageUrls themeImageUrls) {
            this.value = themeImageUrls;
        }

        public final /* synthetic */ ThemeImageUrls getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Video;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "value", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "constructor-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;)Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "getValue", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;)I", "toString", "", "toString-impl", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;)Ljava/lang/String;", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Video implements LocalizationData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ThemeVideoUrls value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Video m3980boximpl(ThemeVideoUrls themeVideoUrls) {
            return new Video(themeVideoUrls);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ThemeVideoUrls m3981constructorimpl(ThemeVideoUrls value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3982equalsimpl(ThemeVideoUrls themeVideoUrls, Object obj) {
            return (obj instanceof Video) && Intrinsics.areEqual(themeVideoUrls, ((Video) obj).m3986unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3983equalsimpl0(ThemeVideoUrls themeVideoUrls, ThemeVideoUrls themeVideoUrls2) {
            return Intrinsics.areEqual(themeVideoUrls, themeVideoUrls2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3984hashCodeimpl(ThemeVideoUrls themeVideoUrls) {
            return themeVideoUrls.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3985toStringimpl(ThemeVideoUrls themeVideoUrls) {
            return "Video(value=" + themeVideoUrls + ')';
        }

        public boolean equals(Object obj) {
            return m3982equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m3984hashCodeimpl(this.value);
        }

        public String toString() {
            return m3985toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ThemeVideoUrls m3986unboximpl() {
            return this.value;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Video$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData$Video;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return LocalizationData$Video$$serializer.INSTANCE;
            }
        }

        private /* synthetic */ Video(ThemeVideoUrls themeVideoUrls) {
            this.value = themeVideoUrls;
        }

        public final /* synthetic */ ThemeVideoUrls getValue() {
            return this.value;
        }
    }
}
