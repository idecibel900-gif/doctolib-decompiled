package expo.modules.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.location.records.LocationLastKnownOptions;
import expo.modules.location.records.LocationOptions;
import expo.modules.location.records.LocationResponse;
import expo.modules.location.records.PermissionRequestResponse;
import java.util.Arrays;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LocationHelpers {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int mapAccuracyToPriority(int i) {
            switch (i) {
                case 1:
                    return 104;
                case 2:
                case 3:
                    return 102;
                case 4:
                case 5:
                case 6:
                    return 100;
                default:
                    return 102;
            }
        }

        private Companion() {
        }

        public final boolean isLocationValid$expo_location_release(Location location, LocationLastKnownOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            if (location == null) {
                return false;
            }
            Double maxAge = options.getMaxAge();
            double dDoubleValue = maxAge != null ? maxAge.doubleValue() : Double.MAX_VALUE;
            Double requiredAccuracy = options.getRequiredAccuracy();
            return ((double) (System.currentTimeMillis() - location.getTime())) <= dDoubleValue && ((double) location.getAccuracy()) <= (requiredAccuracy != null ? requiredAccuracy.doubleValue() : Double.MAX_VALUE);
        }

        public final boolean hasNetworkProviderEnabled(Context context) {
            if (context == null) {
                return false;
            }
            Object systemService = context.getSystemService("location");
            LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
            return locationManager != null && locationManager.isProviderEnabled("network");
        }

        public final LocationRequest prepareLocationRequest$expo_location_release(LocationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            LocationParams locationParamsMapOptionsToLocationParams = mapOptionsToLocationParams(options);
            LocationRequest locationRequestBuild = new LocationRequest.Builder(locationParamsMapOptionsToLocationParams.getInterval()).setMinUpdateIntervalMillis(locationParamsMapOptionsToLocationParams.getInterval()).setMaxUpdateDelayMillis(locationParamsMapOptionsToLocationParams.getInterval()).setMinUpdateDistanceMeters(locationParamsMapOptionsToLocationParams.getDistance()).setPriority(mapAccuracyToPriority(options.getAccuracy())).build();
            Intrinsics.checkNotNullExpressionValue(locationRequestBuild, "build(...)");
            return locationRequestBuild;
        }

        public final CurrentLocationRequest prepareCurrentLocationRequest$expo_location_release(LocationOptions options) {
            Intrinsics.checkNotNullParameter(options, "options");
            LocationParams locationParamsMapOptionsToLocationParams = mapOptionsToLocationParams(options);
            CurrentLocationRequest.Builder builder = new CurrentLocationRequest.Builder();
            builder.setGranularity(0);
            builder.setPriority(LocationHelpers.Companion.mapAccuracyToPriority(options.getAccuracy()));
            builder.setMaxUpdateAgeMillis(locationParamsMapOptionsToLocationParams.getInterval());
            CurrentLocationRequest currentLocationRequestBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(currentLocationRequestBuild, "build(...)");
            return currentLocationRequestBuild;
        }

        public final void requestSingleLocation(FusedLocationProviderClient locationProvider, CurrentLocationRequest locationRequest, final Promise promise) {
            Intrinsics.checkNotNullParameter(locationProvider, "locationProvider");
            Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
            Intrinsics.checkNotNullParameter(promise, "promise");
            try {
                Task currentLocation = locationProvider.getCurrentLocation(locationRequest, null);
                final Function1 function1 = new Function1() { // from class: expo.modules.location.LocationHelpers$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationHelpers.Companion.requestSingleLocation$lambda$1(promise, (Location) obj);
                    }
                };
                Intrinsics.checkNotNull(currentLocation.addOnSuccessListener(new OnSuccessListener() { // from class: expo.modules.location.LocationHelpers$Companion$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        function1.invoke(obj);
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: expo.modules.location.LocationHelpers$Companion$$ExternalSyntheticLambda2
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        LocationHelpers.Companion.requestSingleLocation$lambda$3(promise, exc);
                    }
                }).addOnCanceledListener(new OnCanceledListener() { // from class: expo.modules.location.LocationHelpers$Companion$$ExternalSyntheticLambda3
                    @Override // com.google.android.gms.tasks.OnCanceledListener
                    public final void onCanceled() {
                        LocationHelpers.Companion.requestSingleLocation$lambda$4(promise);
                    }
                }));
            } catch (SecurityException e) {
                promise.reject(new LocationRequestRejectedException(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit requestSingleLocation$lambda$1(Promise promise, Location location) {
            if (location == null) {
                promise.reject(new CurrentLocationIsUnavailableException());
                return Unit.INSTANCE;
            }
            promise.resolve(new LocationResponse(location));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$3(Promise promise, Exception it) {
            Intrinsics.checkNotNullParameter(it, "it");
            promise.reject(new LocationRequestRejectedException(it));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void requestSingleLocation$lambda$4(Promise promise) {
            promise.reject(new LocationRequestCancelledException());
        }

        public final void requestContinuousUpdates(final LocationModule locationModule, LocationRequest locationRequest, final int i, final Promise promise) {
            Intrinsics.checkNotNullParameter(locationModule, "locationModule");
            Intrinsics.checkNotNullParameter(locationRequest, "locationRequest");
            Intrinsics.checkNotNullParameter(promise, "promise");
            locationModule.requestLocationUpdates(locationRequest, Integer.valueOf(i), new LocationRequestCallbacks() { // from class: expo.modules.location.LocationHelpers$Companion$requestContinuousUpdates$1
                @Override // expo.modules.location.LocationRequestCallbacks
                public void onLocationError(CodedException codedException) {
                    LocationRequestCallbacks.DefaultImpls.onLocationError(this, codedException);
                }

                @Override // expo.modules.location.LocationRequestCallbacks
                public void onLocationChanged(Location location) {
                    Intrinsics.checkNotNullParameter(location, "location");
                    locationModule.sendLocationResponse$expo_location_release(i, new LocationResponse(location));
                }

                @Override // expo.modules.location.LocationRequestCallbacks
                public void onRequestSuccess() {
                    promise.resolve((Object) null);
                }

                @Override // expo.modules.location.LocationRequestCallbacks
                public void onRequestFailed(CodedException cause) {
                    Intrinsics.checkNotNullParameter(cause, "cause");
                    promise.reject(cause);
                }
            });
        }

        private final LocationParams mapOptionsToLocationParams(LocationOptions locationOptions) {
            LocationParams locationParamsBuildLocationParamsForAccuracy = buildLocationParamsForAccuracy(locationOptions.getAccuracy());
            Long timeInterval = locationOptions.getTimeInterval();
            if (timeInterval != null) {
                locationParamsBuildLocationParamsForAccuracy.setInterval(timeInterval.longValue());
            }
            Integer distanceInterval = locationOptions.getDistanceInterval();
            if (distanceInterval != null) {
                locationParamsBuildLocationParamsForAccuracy.setDistance(distanceInterval.intValue());
            }
            return locationParamsBuildLocationParamsForAccuracy;
        }

        private final LocationParams buildLocationParamsForAccuracy(int i) {
            switch (i) {
                case 1:
                    return new LocationParams(LocationAccuracy.LOWEST, 3000.0f, 10000L);
                case 2:
                    return new LocationParams(LocationAccuracy.LOW, 1000.0f, HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS);
                case 3:
                    return new LocationParams(LocationAccuracy.MEDIUM, 100.0f, 3000L);
                case 4:
                    return new LocationParams(LocationAccuracy.HIGH, 50.0f, 2000L);
                case 5:
                    return new LocationParams(LocationAccuracy.HIGH, 25.0f, 1000L);
                case 6:
                    return new LocationParams(LocationAccuracy.HIGH, 0.0f, 500L);
                default:
                    return new LocationParams(LocationAccuracy.MEDIUM, 100.0f, 3000L);
            }
        }

        public final boolean isAnyProviderAvailable(Context context) {
            Object systemService = context != null ? context.getSystemService("location") : null;
            LocationManager locationManager = systemService instanceof LocationManager ? (LocationManager) systemService : null;
            if (locationManager == null) {
                return false;
            }
            return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
        }

        public final Object getPermissionsWithPermissionsManager$expo_location_release(Permissions permissions, String[] strArr, Continuation continuation) {
            final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Permissions.getPermissionsWithPermissionsManager(permissions, new Promise() { // from class: expo.modules.location.LocationHelpers$Companion$getPermissionsWithPermissionsManager$2$1
                @Override // expo.modules.kotlin.Promise
                public void reject(CodedException codedException) {
                    Promise.DefaultImpls.reject(this, codedException);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve() {
                    Promise.DefaultImpls.resolve(this);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(double d) {
                    Promise.DefaultImpls.resolve(this, d);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(float f) {
                    Promise.DefaultImpls.resolve((Promise) this, f);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(int i) {
                    Promise.DefaultImpls.resolve((Promise) this, i);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(String str) {
                    Promise.DefaultImpls.resolve(this, str);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(Map map) {
                    Promise.DefaultImpls.resolve(this, map);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(boolean z) {
                    Promise.DefaultImpls.resolve(this, z);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(Object obj) throws ConversionException {
                    Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
                    if (bundle == null) {
                        throw new ConversionException(Object.class, Bundle.class, "value returned by the permission promise is not a Bundle");
                    }
                    Continuation continuation2 = safeContinuation;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m5243constructorimpl(new PermissionRequestResponse(bundle)));
                }

                @Override // expo.modules.kotlin.Promise
                public void reject(String code, String str, Throwable th) {
                    Intrinsics.checkNotNullParameter(code, "code");
                    Continuation continuation2 = safeContinuation;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(new CodedException(code, str, th))));
                }
            }, (String[]) Arrays.copyOf(strArr, strArr.length));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        public final Object askForPermissionsWithPermissionsManager$expo_location_release(Permissions permissions, String[] strArr, Continuation continuation) {
            final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            Permissions.askForPermissionsWithPermissionsManager(permissions, new Promise() { // from class: expo.modules.location.LocationHelpers$Companion$askForPermissionsWithPermissionsManager$2$1
                @Override // expo.modules.kotlin.Promise
                public void reject(CodedException codedException) {
                    Promise.DefaultImpls.reject(this, codedException);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve() {
                    Promise.DefaultImpls.resolve(this);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(double d) {
                    Promise.DefaultImpls.resolve(this, d);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(float f) {
                    Promise.DefaultImpls.resolve((Promise) this, f);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(int i) {
                    Promise.DefaultImpls.resolve((Promise) this, i);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(String str) {
                    Promise.DefaultImpls.resolve(this, str);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(Map map) {
                    Promise.DefaultImpls.resolve(this, map);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(boolean z) {
                    Promise.DefaultImpls.resolve(this, z);
                }

                @Override // expo.modules.kotlin.Promise
                public void resolve(Object obj) throws ConversionException {
                    Continuation continuation2 = safeContinuation;
                    Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
                    if (bundle != null) {
                        continuation2.resumeWith(Result.m5243constructorimpl(bundle));
                        return;
                    }
                    throw new ConversionException(Object.class, Bundle.class, "value returned by the permission promise is not a Bundle");
                }

                @Override // expo.modules.kotlin.Promise
                public void reject(String code, String str, Throwable th) {
                    Intrinsics.checkNotNullParameter(code, "code");
                    Continuation continuation2 = safeContinuation;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(new CodedException(code, str, th))));
                }
            }, (String[]) Arrays.copyOf(strArr, strArr.length));
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }
    }
}
