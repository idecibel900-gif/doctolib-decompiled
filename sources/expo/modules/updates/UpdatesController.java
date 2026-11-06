package expo.modules.updates;

import android.content.Context;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updatesinterface.UpdatesControllerRegistry;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesController {
    public static final UpdatesController INSTANCE = new UpdatesController();
    private static volatile UpdatesConfiguration overrideConfiguration;
    private static volatile IUpdatesController singletonInstance;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdatesConfigurationValidationResult.values().length];
            try {
                iArr[UpdatesConfigurationValidationResult.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_NOT_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_RUNTIME_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private UpdatesController() {
    }

    public static final IUpdatesController getInstance() {
        IUpdatesController iUpdatesController = singletonInstance;
        if (iUpdatesController != null) {
            return iUpdatesController;
        }
        throw new IllegalStateException("UpdatesController.instance was called before the module was initialized");
    }

    public static final void initializeWithoutStarting(Context context, boolean z) throws IOException {
        IUpdatesController disabledUpdatesController;
        Intrinsics.checkNotNullParameter(context, "context");
        if (singletonInstance != null) {
            return;
        }
        if (z && !UpdatesPackage.INSTANCE.isUsingNativeDebug()) {
            UpdatesDevLauncherController updatesDevLauncherControllerInitializeAsDevLauncherWithoutStarting = INSTANCE.initializeAsDevLauncherWithoutStarting(context);
            singletonInstance = updatesDevLauncherControllerInitializeAsDevLauncherWithoutStarting;
            UpdatesControllerRegistry.INSTANCE.setController(new WeakReference(updatesDevLauncherControllerInitializeAsDevLauncherWithoutStarting));
            return;
        }
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogger updatesLogger = new UpdatesLogger(filesDir);
        try {
            File orCreateUpdatesDirectory = UpdatesUtils.INSTANCE.getOrCreateUpdatesDirectory(context);
            UpdatesConfiguration updatesConfiguration = overrideConfiguration;
            if (updatesConfiguration == null) {
                int i = WhenMappings.$EnumSwitchMapping$0[UpdatesConfiguration.Companion.getUpdatesConfigurationValidationResult(context, null).ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        updatesLogger.warn("The expo-updates system is explicitly disabled. To enable it, set the enabled setting to true.", UpdatesErrorCode.InitializationError);
                    } else if (i == 3) {
                        updatesLogger.warn("The expo-updates system is disabled due to an invalid configuration. Ensure a valid URL is supplied.", UpdatesErrorCode.InitializationError);
                    } else {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        updatesLogger.warn("The expo-updates system is disabled due to an invalid configuration. Ensure a runtime version is supplied.", UpdatesErrorCode.InitializationError);
                    }
                    updatesConfiguration = null;
                } else {
                    updatesConfiguration = new UpdatesConfiguration(context, null);
                }
            }
            if (updatesConfiguration != null) {
                disabledUpdatesController = new EnabledUpdatesController(context, updatesConfiguration, orCreateUpdatesDirectory);
                UpdatesControllerRegistry.INSTANCE.setController(new WeakReference(disabledUpdatesController));
            } else {
                disabledUpdatesController = new DisabledUpdatesController(context, null);
                UpdatesControllerRegistry.INSTANCE.setController(new WeakReference(disabledUpdatesController));
            }
            singletonInstance = disabledUpdatesController;
        } catch (Exception e) {
            updatesLogger.error("The expo-updates system is disabled due to a storage access error", e, UpdatesErrorCode.InitializationError);
            singletonInstance = new DisabledUpdatesController(context, e);
        }
    }

    private final UpdatesDevLauncherController initializeAsDevLauncherWithoutStarting(Context context) {
        Exception exc;
        File orCreateUpdatesDirectory;
        if (singletonInstance != null) {
            throw new IllegalStateException("UpdatesController must not be initialized prior to calling initializeAsDevLauncherWithoutStarting");
        }
        try {
            orCreateUpdatesDirectory = UpdatesUtils.INSTANCE.getOrCreateUpdatesDirectory(context);
            exc = null;
        } catch (Exception e) {
            exc = e;
            orCreateUpdatesDirectory = null;
        }
        UpdatesConfiguration updatesConfiguration = overrideConfiguration;
        if (updatesConfiguration == null) {
            updatesConfiguration = UpdatesConfiguration.Companion.getUpdatesConfigurationValidationResult(context, null) == UpdatesConfigurationValidationResult.VALID ? new UpdatesConfiguration(context, null) : null;
        }
        UpdatesDevLauncherController updatesDevLauncherController = new UpdatesDevLauncherController(context, updatesConfiguration, orCreateUpdatesDirectory, exc);
        singletonInstance = updatesDevLauncherController;
        return updatesDevLauncherController;
    }

    public static /* synthetic */ void initialize$default(Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        initialize(context, z);
    }

    public static final synchronized void initialize(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (singletonInstance == null) {
            initializeWithoutStarting(context, z);
            IUpdatesController iUpdatesController = singletonInstance;
            if (iUpdatesController != null) {
                iUpdatesController.start();
            }
        }
    }

    public final void setUpdatesEventManagerObserver$expo_updates_release(WeakReference observer) {
        IUpdatesEventManager eventManager;
        Intrinsics.checkNotNullParameter(observer, "observer");
        IUpdatesController iUpdatesController = singletonInstance;
        if (iUpdatesController != null && (eventManager = iUpdatesController.getEventManager()) != null) {
            eventManager.setObserver(observer);
        }
        IUpdatesController iUpdatesController2 = singletonInstance;
        if (iUpdatesController2 != null) {
            iUpdatesController2.onEventListenerStartObserving();
        }
    }

    public final void removeUpdatesEventManagerObserver$expo_updates_release() {
        IUpdatesEventManager eventManager;
        IUpdatesController iUpdatesController = singletonInstance;
        if (iUpdatesController == null || (eventManager = iUpdatesController.getEventManager()) == null) {
            return;
        }
        eventManager.setObserver(null);
    }
}
