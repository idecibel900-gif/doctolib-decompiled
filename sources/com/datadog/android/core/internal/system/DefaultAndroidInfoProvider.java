package com.datadog.android.core.internal.system;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import android.view.Display;
import com.amazon.a.a.o.c.a.b;
import com.datadog.android.api.context.DeviceType;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAndroidInfoProvider implements AndroidInfoProvider {
    public static final Companion Companion = new Companion(null);
    private final Lazy architecture$delegate;
    private final Lazy currentLocale$delegate;
    private final Lazy deviceBrand$delegate;
    private final String deviceBuildId;
    private final String deviceModel;
    private final Lazy deviceName$delegate;
    private final Lazy deviceType$delegate;
    private final Lazy locales$delegate;
    private final Lazy numberOfDisplays$delegate;
    private final Lazy osMajorVersion$delegate;
    private final String osName;
    private final String osVersion;
    private final Lazy timeZone$delegate;

    public DefaultAndroidInfoProvider(final Context appContext, final String rawDeviceBrand, final String rawDeviceModel, String rawDeviceId, String rawOsVersion) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(rawDeviceBrand, "rawDeviceBrand");
        Intrinsics.checkNotNullParameter(rawDeviceModel, "rawDeviceModel");
        Intrinsics.checkNotNullParameter(rawDeviceId, "rawDeviceId");
        Intrinsics.checkNotNullParameter(rawOsVersion, "rawOsVersion");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.deviceType$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$deviceType$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final DeviceType invoke() {
                return DefaultAndroidInfoProvider.Companion.resolveDeviceType(rawDeviceModel, appContext);
            }
        });
        this.deviceName$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$deviceName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                if (StringsKt.isBlank(this.this$0.getDeviceBrand())) {
                    return this.this$0.getDeviceModel();
                }
                if (StringsKt.contains$default((CharSequence) this.this$0.getDeviceModel(), (CharSequence) this.this$0.getDeviceBrand(), false, 2, (Object) null)) {
                    return this.this$0.getDeviceModel();
                }
                return this.this$0.getDeviceBrand() + " " + this.this$0.getDeviceModel();
            }
        });
        this.locales$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$locales$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List invoke() {
                String languageTag;
                Resources resources = appContext.getResources();
                ArrayList arrayList = new ArrayList();
                LocaleList locales = resources.getConfiguration().getLocales();
                Intrinsics.checkNotNullExpressionValue(locales, "resources.configuration.locales");
                int size = locales.size();
                for (int i = 0; i < size; i++) {
                    Locale locale = locales.get(i);
                    if (locale != null && (languageTag = locale.toLanguageTag()) != null) {
                        arrayList.add(languageTag);
                    }
                }
                return arrayList;
            }
        });
        this.currentLocale$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$currentLocale$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Locale locale = appContext.getResources().getConfiguration().getLocales().get(0);
                String languageTag = locale != null ? locale.toLanguageTag() : null;
                return languageTag == null ? Locale.getDefault().toLanguageTag() : languageTag;
            }
        });
        this.timeZone$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$timeZone$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return TimeZone.getDefault().getID();
            }
        });
        this.deviceBrand$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$deviceBrand$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String strValueOf;
                String str = rawDeviceBrand;
                if (str.length() <= 0) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                char cCharAt = str.charAt(0);
                if (Character.isLowerCase(cCharAt)) {
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    strValueOf = CharsKt.titlecase(cCharAt, US);
                } else {
                    strValueOf = String.valueOf(cCharAt);
                }
                sb.append((Object) strValueOf);
                String strSubstring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb.append(strSubstring);
                return sb.toString();
            }
        });
        this.deviceModel = rawDeviceModel;
        this.deviceBuildId = rawDeviceId;
        this.osName = "Android";
        this.osVersion = rawOsVersion;
        this.osMajorVersion$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$osMajorVersion$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return (String) CollectionsKt.first(StringsKt.split$default((CharSequence) this.this$0.getOsVersion(), new char[]{b.a}, false, 0, 6, (Object) null));
            }
        });
        this.architecture$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$architecture$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String property = System.getProperty("os.arch");
                return property == null ? "unknown" : property;
            }
        });
        this.numberOfDisplays$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: com.datadog.android.core.internal.system.DefaultAndroidInfoProvider$numberOfDisplays$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Object systemService = appContext.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
                if (displayManager == null) {
                    return null;
                }
                Display[] displays = displayManager.getDisplays();
                Intrinsics.checkNotNullExpressionValue(displays, "displayManager.displays");
                int i = 0;
                for (Display display : displays) {
                    if (!SetsKt.setOf((Object[]) new Integer[]{1, 0}).contains(Integer.valueOf(display.getState()))) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultAndroidInfoProvider(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        String str = Build.BRAND;
        String str2 = str == null ? "" : str;
        String str3 = Build.MODEL;
        String str4 = str3 == null ? "" : str3;
        String str5 = Build.ID;
        String str6 = str5 == null ? "" : str5;
        String str7 = Build.VERSION.RELEASE;
        this(appContext, str2, str4, str6, str7 == null ? "" : str7);
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public DeviceType getDeviceType() {
        return (DeviceType) this.deviceType$delegate.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceName() {
        return (String) this.deviceName$delegate.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public List getLocales() {
        return (List) this.locales$delegate.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getCurrentLocale() {
        Object value = this.currentLocale$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-currentLocale>(...)");
        return (String) value;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getTimeZone() {
        Object value = this.timeZone$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-timeZone>(...)");
        return (String) value;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBrand() {
        return (String) this.deviceBrand$delegate.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceModel() {
        return this.deviceModel;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getDeviceBuildId() {
        return this.deviceBuildId;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsName() {
        return this.osName;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsVersion() {
        return this.osVersion;
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getOsMajorVersion() {
        return (String) this.osMajorVersion$delegate.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public String getArchitecture() {
        return (String) this.architecture$delegate.getValue();
    }

    @Override // com.datadog.android.core.internal.system.AndroidInfoProvider
    public Integer getNumberOfDisplays() {
        return (Integer) this.numberOfDisplays$delegate.getValue();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DeviceType resolveDeviceType(String str, Context context) {
            if (isTv(context)) {
                return DeviceType.TV;
            }
            if (isTablet(str, context)) {
                return DeviceType.TABLET;
            }
            if (isMobile(str, context)) {
                return DeviceType.MOBILE;
            }
            return DeviceType.OTHER;
        }

        private final boolean isTv(Context context) {
            Object systemService = context.getSystemService("uimode");
            UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                return true;
            }
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "appContext.packageManager");
            return hasTvFeature(packageManager);
        }

        private final boolean hasTvFeature(PackageManager packageManager) {
            return packageManager.hasSystemFeature("android.software.leanback") || packageManager.hasSystemFeature("com.google.android.tv");
        }

        private final boolean isTablet(String str, Context context) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "tablet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "sm-t", false, 2, (Object) null) || context.getResources().getConfiguration().smallestScreenWidthDp >= 800;
        }

        private final boolean isMobile(String str, Context context) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            boolean z = false;
            if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) AuthorizationRequest.Scope.PHONE, false, 2, (Object) null)) {
                return true;
            }
            Object systemService = context.getSystemService(AuthorizationRequest.Scope.PHONE);
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManager != null && telephonyManager.getPhoneType() == 0) {
                z = true;
            }
            return !z;
        }
    }
}
