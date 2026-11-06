package com.facebook.react.views.image;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public enum ImageResizeMethod {
    AUTO,
    RESIZE,
    SCALE,
    NONE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
        
            if (r3.equals("auto") == false) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        
            if (r3.equals("") == false) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.facebook.react.views.image.ImageResizeMethod parse(java.lang.String r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L70
                int r0 = r3.hashCode()
                r1 = -934437708(0xffffffffc84d9cb4, float:-210546.81)
                if (r0 == r1) goto L47
                if (r0 == 0) goto L3e
                r1 = 3005871(0x2dddaf, float:4.212122E-39)
                if (r0 == r1) goto L35
                r1 = 3387192(0x33af38, float:4.746467E-39)
                if (r0 == r1) goto L29
                r1 = 109250890(0x683094a, float:4.929037E-35)
                if (r0 == r1) goto L1d
                goto L4f
            L1d:
                java.lang.String r0 = "scale"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L26
                goto L4f
            L26:
                com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.SCALE
                return r3
            L29:
                java.lang.String r0 = "none"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L32
                goto L4f
            L32:
                com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.NONE
                return r3
            L35:
                java.lang.String r0 = "auto"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L70
                goto L4f
            L3e:
                java.lang.String r0 = ""
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L70
                goto L4f
            L47:
                java.lang.String r0 = "resize"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L6d
            L4f:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Invalid resize method: '"
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = "'"
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                java.lang.String r0 = "ReactNative"
                com.facebook.common.logging.FLog.w(r0, r3)
                com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.AUTO
                return r3
            L6d:
                com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.RESIZE
                return r3
            L70:
                com.facebook.react.views.image.ImageResizeMethod r3 = com.facebook.react.views.image.ImageResizeMethod.AUTO
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.image.ImageResizeMethod.Companion.parse(java.lang.String):com.facebook.react.views.image.ImageResizeMethod");
        }
    }
}
