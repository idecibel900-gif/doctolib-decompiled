package expo.modules.location.taskConsumers;

import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.adjust.sdk.network.ErrorCodes;
import com.amazon.a.a.o.b;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingEvent;
import com.google.android.gms.location.GeofencingRequest;
import expo.modules.interfaces.taskManager.TaskConsumer;
import expo.modules.interfaces.taskManager.TaskInterface;
import expo.modules.interfaces.taskManager.TaskManagerUtilsInterface;
import expo.modules.location.GeofencingException;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.GeofencingRegionState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001e\u001a\u00020\u000e2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u00172\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0017H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u0010\u000bJ#\u00103\u001a\u00020\t2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00020\u001cH\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\t2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u001f\u0010>\u001a\u00020=2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000e0I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020!0L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lexpo/modules/location/taskConsumers/GeofencingTaskConsumer;", "Lexpo/modules/interfaces/taskManager/TaskConsumer;", "", "Landroid/content/Context;", "context", "Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;", "taskManagerUtils", "<init>", "(Landroid/content/Context;Lexpo/modules/interfaces/taskManager/TaskManagerUtilsInterface;)V", "", "startGeofencing", "()V", "stopGeofencing", "", "Lcom/google/android/gms/location/Geofence;", "geofences", "Lcom/google/android/gms/location/GeofencingRequest;", "prepareGeofencingRequest", "(Ljava/util/List;)Lcom/google/android/gms/location/GeofencingRequest;", "Landroid/app/PendingIntent;", "preparePendingIntent", "()Landroid/app/PendingIntent;", "param", "", b.f, "", "getParamAsDouble", "(Ljava/lang/Object;Ljava/lang/String;)D", "", "region", "geofenceFromRegion", "(Ljava/util/Map;)Lcom/google/android/gms/location/Geofence;", "identifier", "Landroid/os/PersistableBundle;", "bundleFromRegion", "(Ljava/lang/String;Ljava/util/Map;)Landroid/os/PersistableBundle;", "", "transitionType", "Lexpo/modules/location/records/GeofencingRegionState;", "regionStateForTransitionType", "(I)Lexpo/modules/location/records/GeofencingRegionState;", "eventTypeFromTransitionType", "(I)I", "taskType", "()Ljava/lang/String;", "Lexpo/modules/interfaces/taskManager/TaskInterface;", "task", "didRegister", "(Lexpo/modules/interfaces/taskManager/TaskInterface;)V", "didUnregister", "options", "setOptions", "(Ljava/util/Map;)V", "Landroid/content/Intent;", "intent", "didReceiveBroadcast", "(Landroid/content/Intent;)V", "Landroid/app/job/JobService;", "jobService", "Landroid/app/job/JobParameters;", "params", "", "didExecuteJob", "(Landroid/app/job/JobService;Landroid/app/job/JobParameters;)Z", "mTask", "Lexpo/modules/interfaces/taskManager/TaskInterface;", "mPendingIntent", "Landroid/app/PendingIntent;", "Lcom/google/android/gms/location/GeofencingClient;", "mGeofencingClient", "Lcom/google/android/gms/location/GeofencingClient;", "mGeofencingRequest", "Lcom/google/android/gms/location/GeofencingRequest;", "", "mGeofencingList", "Ljava/util/List;", "", "mRegions", "Ljava/util/Map;", "Companion", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GeofencingTaskConsumer extends TaskConsumer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "GeofencingTaskConsumer";
    private GeofencingClient mGeofencingClient;
    private List<Geofence> mGeofencingList;
    private GeofencingRequest mGeofencingRequest;
    private PendingIntent mPendingIntent;
    private Map<String, PersistableBundle> mRegions;
    private TaskInterface mTask;

    private final int eventTypeFromTransitionType(int transitionType) {
        int i = 1;
        if (transitionType != 1) {
            i = 2;
            if (transitionType != 2) {
                return 0;
            }
        }
        return i;
    }

    public boolean didExecuteJob(JobService jobService, JobParameters params) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(params, "params");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeofencingTaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        super(context, taskManagerUtilsInterface);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGeofencingList = new ArrayList();
        this.mRegions = new HashMap();
    }

    public String taskType() {
        return "geofencing";
    }

    public void didRegister(TaskInterface task) throws GeofencingException {
        Intrinsics.checkNotNullParameter(task, "task");
        startGeofencing();
    }

    public void didUnregister() {
        stopGeofencing();
        this.mPendingIntent = null;
        this.mGeofencingClient = null;
        this.mGeofencingRequest = null;
        this.mGeofencingList.clear();
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumer
    public void setOptions(Map<String, ? extends Object> options) throws GeofencingException {
        Intrinsics.checkNotNullParameter(options, "options");
        super.setOptions(options);
        stopGeofencing();
        startGeofencing();
    }

    public void didReceiveBroadcast(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        GeofencingEvent geofencingEventFromIntent = GeofencingEvent.fromIntent(intent);
        if (geofencingEventFromIntent == null) {
            return;
        }
        if (geofencingEventFromIntent.hasError()) {
            new Error(INSTANCE.getErrorString(geofencingEventFromIntent.getErrorCode()));
            return;
        }
        int geofenceTransition = geofencingEventFromIntent.getGeofenceTransition();
        GeofencingRegionState geofencingRegionStateRegionStateForTransitionType = regionStateForTransitionType(geofenceTransition);
        int iEventTypeFromTransitionType = eventTypeFromTransitionType(geofenceTransition);
        List triggeringGeofences = geofencingEventFromIntent.getTriggeringGeofences();
        if (triggeringGeofences == null) {
            return;
        }
        Iterator it = triggeringGeofences.iterator();
        while (it.hasNext()) {
            PersistableBundle persistableBundle = this.mRegions.get(((Geofence) it.next()).getRequestId());
            if (persistableBundle != null) {
                PersistableBundle persistableBundle2 = new PersistableBundle();
                persistableBundle.putInt("state", geofencingRegionStateRegionStateForTransitionType.ordinal());
                persistableBundle2.putInt("eventType", iEventTypeFromTransitionType);
                persistableBundle2.putPersistableBundle("region", persistableBundle);
                getContext().getApplicationContext();
                getTaskManagerUtils();
                CollectionsKt.listOf(persistableBundle2);
                throw null;
            }
        }
    }

    private final void startGeofencing() throws GeofencingException {
        Context context = getContext();
        if (context != null && LocationHelpers.Companion.isAnyProviderAvailable(context)) {
            this.mRegions = new HashMap();
            this.mGeofencingList = new ArrayList();
            throw new GeofencingException("Task is null, can't start geofencing", null, 2, null);
        }
    }

    private final void stopGeofencing() {
        PendingIntent pendingIntent = this.mPendingIntent;
        if (pendingIntent != null) {
            GeofencingClient geofencingClient = this.mGeofencingClient;
            if (geofencingClient != null) {
                geofencingClient.removeGeofences(pendingIntent);
            }
            pendingIntent.cancel();
        }
    }

    private final GeofencingRequest prepareGeofencingRequest(List<? extends Geofence> geofences) {
        GeofencingRequest geofencingRequestBuild = new GeofencingRequest.Builder().setInitialTrigger(3).addGeofences(geofences).build();
        Intrinsics.checkNotNullExpressionValue(geofencingRequestBuild, "build(...)");
        return geofencingRequestBuild;
    }

    private final PendingIntent preparePendingIntent() {
        getTaskManagerUtils();
        getContext();
        throw null;
    }

    private final double getParamAsDouble(Object param, String errorMessage) throws GeofencingException {
        Double doubleOrNull;
        if (param instanceof Double) {
            doubleOrNull = (Double) param;
        } else if (param instanceof Float) {
            doubleOrNull = Double.valueOf(((Number) param).floatValue());
        } else if (param instanceof Integer) {
            doubleOrNull = Double.valueOf(((Number) param).intValue());
        } else if (param instanceof Long) {
            doubleOrNull = Double.valueOf(((Number) param).longValue());
        } else {
            doubleOrNull = param instanceof String ? StringsKt.toDoubleOrNull((String) param) : null;
        }
        if (doubleOrNull != null) {
            return doubleOrNull.doubleValue();
        }
        throw new GeofencingException(errorMessage, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Geofence geofenceFromRegion(Map<String, ? extends Object> region) throws GeofencingException {
        Object obj = region.get("identifier");
        String string = obj instanceof String ? (String) obj : null;
        if (string == null) {
            string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        }
        double paramAsDouble = getParamAsDouble(region.get("radius"), "Region: radius: `" + region.get("radius") + "` can't be cast to Double");
        double paramAsDouble2 = getParamAsDouble(region.get("longitude"), "Region: longitude: `" + region.get("longitude") + "` can't be cast to Double");
        double paramAsDouble3 = getParamAsDouble(region.get("latitude"), "Region: latitude `" + region.get("latitude") + "` can't be cast to Double");
        Object obj2 = region.get("notifyOnEnter");
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : 1;
        Object obj3 = region.get("notifyOnExit");
        Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
        Geofence geofenceBuild = new Geofence.Builder().setRequestId(string).setCircularRegion(paramAsDouble3, paramAsDouble2, (float) paramAsDouble).setExpirationDuration(-1L).setTransitionTypes((bool2 != null ? bool2.booleanValue() : true ? 2 : 0) | zBooleanValue).build();
        Intrinsics.checkNotNullExpressionValue(geofenceBuild, "build(...)");
        return geofenceBuild;
    }

    private final PersistableBundle bundleFromRegion(String identifier, Map<String, ? extends Object> region) throws GeofencingException {
        PersistableBundle persistableBundle = new PersistableBundle();
        double paramAsDouble = getParamAsDouble(region.get("radius"), "Region: radius: `" + region.get("radius") + "` can't be cast to Double");
        double paramAsDouble2 = getParamAsDouble(region.get("longitude"), "Region: longitude: `" + region.get("longitude") + "` can't be cast to Double");
        double paramAsDouble3 = getParamAsDouble(region.get("latitude"), "Region: latitude: `" + region.get("latitude") + "` can't be cast to Double");
        persistableBundle.putString("identifier", identifier);
        persistableBundle.putDouble("radius", paramAsDouble);
        persistableBundle.putDouble("latitude", paramAsDouble3);
        persistableBundle.putDouble("longitude", paramAsDouble2);
        persistableBundle.putInt("state", GeofencingRegionState.UNKNOWN.ordinal());
        return persistableBundle;
    }

    private final GeofencingRegionState regionStateForTransitionType(int transitionType) {
        if (transitionType != 1) {
            if (transitionType == 2) {
                return GeofencingRegionState.OUTSIDE;
            }
            if (transitionType != 4) {
                return GeofencingRegionState.UNKNOWN;
            }
        }
        return GeofencingRegionState.INSIDE;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/location/taskConsumers/GeofencingTaskConsumer$Companion;", "", "<init>", "()V", "TAG", "", "getErrorString", "errorCode", "", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getErrorString(int errorCode) {
            switch (errorCode) {
                case 1000:
                    return "Geofencing not available.";
                case 1001:
                    return "Too many geofences.";
                case ErrorCodes.UNSUPPORTED_ENCODING_EXCEPTION /* 1002 */:
                    return "Too many pending intents.";
                default:
                    return "Unknown geofencing error.";
            }
        }
    }
}
