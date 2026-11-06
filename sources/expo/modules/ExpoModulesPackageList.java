package expo.modules;

import expo.modules.adapters.react.ReactAdapterPackage;
import expo.modules.application.ApplicationModule;
import expo.modules.asset.AssetModule;
import expo.modules.battery.BatteryModule;
import expo.modules.calendar.CalendarModule;
import expo.modules.calendar.next.CalendarNextModule;
import expo.modules.clipboard.ClipboardModule;
import expo.modules.constants.ConstantsModule;
import expo.modules.constants.ConstantsService;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.Package;
import expo.modules.device.DeviceModule;
import expo.modules.devlauncher.DevLauncherPackage;
import expo.modules.devlauncher.modules.ExpoDevLauncherModule;
import expo.modules.devmenu.DevMenuPackage;
import expo.modules.devmenu.modules.DevMenuModule;
import expo.modules.documentpicker.DocumentPickerModule;
import expo.modules.easclient.EASClientModule;
import expo.modules.fetch.ExpoFetchModule;
import expo.modules.filesystem.FileSystemModule;
import expo.modules.filesystem.legacy.FileSystemLegacyModule;
import expo.modules.font.FontLoaderModule;
import expo.modules.font.FontUtilsModule;
import expo.modules.haptics.HapticsModule;
import expo.modules.image.ExpoImageModule;
import expo.modules.imageloader.ImageLoaderService;
import expo.modules.imagepicker.ImagePickerModule;
import expo.modules.keepawake.KeepAwakeModule;
import expo.modules.kotlin.ModulesProvider;
import expo.modules.kotlin.edgeToEdge.EdgeToEdgePackage;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.services.Service;
import expo.modules.lineargradient.LinearGradientModule;
import expo.modules.linking.ExpoLinkingModule;
import expo.modules.linking.ExpoLinkingPackage;
import expo.modules.location.LocationModule;
import expo.modules.logbox.ExpoLogBoxPackage;
import expo.modules.network.NetworkModule;
import expo.modules.router.ExpoRouterModule;
import expo.modules.screencapture.ScreenCaptureModule;
import expo.modules.speechrecognition.ExpoSpeechRecognitionModule;
import expo.modules.splashscreen.SplashScreenModule;
import expo.modules.storereview.StoreReviewModule;
import expo.modules.updates.UpdatesModule;
import expo.modules.updates.UpdatesPackage;
import expo.modules.video.VideoModule;
import expo.modules.webbrowser.WebBrowserModule;
import expo.modules.webbrowser.WebBrowserPackage;
import expo.modules.webview.DomWebViewModule;
import io.sentry.react.expo.SentryExpoPackage;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class ExpoModulesPackageList implements ModulesProvider {
    public static final Companion Companion = new Companion(null);
    private static final List packagesList = CollectionsKt.listOf((Object[]) new Package[]{new ExpoLogBoxPackage(), new SentryExpoPackage(), new DevLauncherPackage(), new DevMenuPackage(), new ExpoLinkingPackage(), new ReactAdapterPackage(), new BasePackage(), new EdgeToEdgePackage(), new UpdatesPackage(), new WebBrowserPackage()});
    private static final Map modulesMap = MapsKt.mapOf(TuplesKt.to(DomWebViewModule.class, null), TuplesKt.to(ExpoFetchModule.class, null), TuplesKt.to(ApplicationModule.class, null), TuplesKt.to(AssetModule.class, null), TuplesKt.to(BatteryModule.class, null), TuplesKt.to(CalendarModule.class, null), TuplesKt.to(CalendarNextModule.class, null), TuplesKt.to(ClipboardModule.class, null), TuplesKt.to(ConstantsModule.class, null), TuplesKt.to(ExpoDevLauncherModule.class, null), TuplesKt.to(DevMenuModule.class, null), TuplesKt.to(DeviceModule.class, null), TuplesKt.to(DocumentPickerModule.class, null), TuplesKt.to(EASClientModule.class, null), TuplesKt.to(FileSystemModule.class, null), TuplesKt.to(FileSystemLegacyModule.class, null), TuplesKt.to(FontLoaderModule.class, null), TuplesKt.to(FontUtilsModule.class, null), TuplesKt.to(HapticsModule.class, null), TuplesKt.to(ExpoImageModule.class, null), TuplesKt.to(ImagePickerModule.class, null), TuplesKt.to(KeepAwakeModule.class, null), TuplesKt.to(LinearGradientModule.class, null), TuplesKt.to(ExpoLinkingModule.class, null), TuplesKt.to(LocationModule.class, null), TuplesKt.to(NetworkModule.class, null), TuplesKt.to(ExpoRouterModule.class, null), TuplesKt.to(ScreenCaptureModule.class, null), TuplesKt.to(ExpoSpeechRecognitionModule.class, null), TuplesKt.to(SplashScreenModule.class, null), TuplesKt.to(StoreReviewModule.class, null), TuplesKt.to(UpdatesModule.class, null), TuplesKt.to(VideoModule.class, null), TuplesKt.to(WebBrowserModule.class, null));

    public static final List<Package> getPackageList() {
        return Companion.getPackageList();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List getPackagesList() {
            return ExpoModulesPackageList.packagesList;
        }

        public final List getPackageList() {
            return getPackagesList();
        }
    }

    @Override // expo.modules.kotlin.ModulesProvider
    public Map<Class<? extends Module>, String> getModulesMap() {
        return modulesMap;
    }

    @Override // expo.modules.kotlin.ModulesProvider
    public List<Class<? extends Service>> getServices() {
        return CollectionsKt.listOf((Object[]) new Class[]{ConstantsService.class, ImageLoaderService.class});
    }
}
