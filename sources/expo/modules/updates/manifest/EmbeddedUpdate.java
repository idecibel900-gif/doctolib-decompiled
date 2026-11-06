package expo.modules.updates.manifest;

import android.net.Uri;
import expo.modules.manifests.core.EmbeddedManifest;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.db.enums.UpdateStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class EmbeddedUpdate implements Update {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = EmbeddedUpdate.class.getSimpleName();
    private final Lazy assetEntityList$delegate;
    private final JSONArray assets;
    private final Date commitTime;
    private final UUID id;
    private final boolean isDevelopmentMode;
    private final EmbeddedManifest manifest;
    private final Map requestHeaders;
    private final String runtimeVersion;
    private final String scopeKey;
    private final Lazy updateEntity$delegate;
    private final Uri url;

    public /* synthetic */ EmbeddedUpdate(EmbeddedManifest embeddedManifest, UUID uuid, String str, Date date, String str2, JSONArray jSONArray, Uri uri, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(embeddedManifest, uuid, str, date, str2, jSONArray, uri, map);
    }

    private EmbeddedUpdate(EmbeddedManifest embeddedManifest, UUID uuid, String str, Date date, String str2, JSONArray jSONArray, Uri uri, Map map) {
        this.manifest = embeddedManifest;
        this.id = uuid;
        this.scopeKey = str;
        this.commitTime = date;
        this.runtimeVersion = str2;
        this.assets = jSONArray;
        this.url = uri;
        this.requestHeaders = map;
        this.updateEntity$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.EmbeddedUpdate$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EmbeddedUpdate.updateEntity_delegate$lambda$1(this.f$0);
            }
        });
        this.assetEntityList$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.EmbeddedUpdate$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EmbeddedUpdate.assetEntityList_delegate$lambda$4(this.f$0);
            }
        });
    }

    @Override // expo.modules.updates.manifest.Update
    public EmbeddedManifest getManifest() {
        return this.manifest;
    }

    @Override // expo.modules.updates.manifest.Update
    public UpdateEntity getUpdateEntity() {
        return (UpdateEntity) this.updateEntity$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UpdateEntity updateEntity_delegate$lambda$1(EmbeddedUpdate embeddedUpdate) {
        UpdateEntity updateEntity = new UpdateEntity(embeddedUpdate.id, embeddedUpdate.commitTime, embeddedUpdate.runtimeVersion, embeddedUpdate.scopeKey, embeddedUpdate.getManifest().getRawJson(), embeddedUpdate.url, embeddedUpdate.requestHeaders);
        updateEntity.setStatus(UpdateStatus.EMBEDDED);
        return updateEntity;
    }

    @Override // expo.modules.updates.manifest.Update
    public List getAssetEntityList() {
        return (List) this.assetEntityList$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List assetEntityList_delegate$lambda$4(EmbeddedUpdate embeddedUpdate) {
        String string;
        String string2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        ArrayList arrayList = new ArrayList();
        AssetEntity assetEntity = new AssetEntity("bundle-" + embeddedUpdate.id, "js");
        assetEntity.setLaunchAsset(true);
        assetEntity.setEmbeddedAssetFilename("index.android.bundle");
        arrayList.add(assetEntity);
        JSONArray jSONArray3 = embeddedUpdate.assets;
        if (jSONArray3 != null && jSONArray3.length() > 0) {
            int length = embeddedUpdate.assets.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = embeddedUpdate.assets.getJSONObject(i);
                    AssetEntity assetEntity2 = new AssetEntity(jSONObject.getString("packagerHash"), jSONObject.getString("type"));
                    Intrinsics.checkNotNull(jSONObject);
                    boolean zHas = jSONObject.has("resourcesFilename");
                    Class cls = Boolean.TYPE;
                    Class cls2 = Long.TYPE;
                    Class cls3 = Integer.TYPE;
                    Class cls4 = Double.TYPE;
                    if (zHas) {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            string = jSONObject.getString("resourcesFilename");
                            if (string == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                            string = (String) Double.valueOf(jSONObject.getDouble("resourcesFilename"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls3))) {
                            string = (String) Integer.valueOf(jSONObject.getInt("resourcesFilename"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                            string = (String) Long.valueOf(jSONObject.getLong("resourcesFilename"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                            string = (String) Boolean.valueOf(jSONObject.getBoolean("resourcesFilename"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                            Object jSONArray4 = jSONObject.getJSONArray("resourcesFilename");
                            if (jSONArray4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            string = (String) jSONArray4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                            Object jSONObject2 = jSONObject.getJSONObject("resourcesFilename");
                            if (jSONObject2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            string = (String) jSONObject2;
                        } else {
                            Object obj = jSONObject.get("resourcesFilename");
                            if (obj == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            string = (String) obj;
                        }
                    } else {
                        string = null;
                    }
                    assetEntity2.setResourcesFilename(string);
                    if (jSONObject.has("resourcesFolder")) {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            string2 = jSONObject.getString("resourcesFolder");
                            if (string2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls4))) {
                            string2 = (String) Double.valueOf(jSONObject.getDouble("resourcesFolder"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls3))) {
                            string2 = (String) Integer.valueOf(jSONObject.getInt("resourcesFolder"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                            string2 = (String) Long.valueOf(jSONObject.getLong("resourcesFolder"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                            string2 = (String) Boolean.valueOf(jSONObject.getBoolean("resourcesFolder"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                            Object jSONArray5 = jSONObject.getJSONArray("resourcesFolder");
                            if (jSONArray5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            string2 = (String) jSONArray5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                            Object jSONObject3 = jSONObject.getJSONObject("resourcesFolder");
                            if (jSONObject3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            string2 = (String) jSONObject3;
                        } else {
                            Object obj2 = jSONObject.get("resourcesFolder");
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            string2 = (String) obj2;
                        }
                    } else {
                        string2 = null;
                    }
                    assetEntity2.setResourcesFolder(string2);
                    if (jSONObject.has("scales")) {
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JSONArray.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object string3 = jSONObject.getString("scales");
                            if (string3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                            }
                            jSONArray = (JSONArray) string3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls4))) {
                            jSONArray = (JSONArray) Double.valueOf(jSONObject.getDouble("scales"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls3))) {
                            jSONArray = (JSONArray) Integer.valueOf(jSONObject.getInt("scales"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls2))) {
                            jSONArray = (JSONArray) Long.valueOf(jSONObject.getLong("scales"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                            jSONArray = (JSONArray) Boolean.valueOf(jSONObject.getBoolean("scales"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONArray.class))) {
                            jSONArray = jSONObject.getJSONArray("scales");
                            if (jSONArray == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JSONObject.class))) {
                            Object jSONObject4 = jSONObject.getJSONObject("scales");
                            if (jSONObject4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                            }
                            jSONArray = (JSONArray) jSONObject4;
                        } else {
                            Object obj3 = jSONObject.get("scales");
                            if (obj3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
                            }
                            jSONArray = (JSONArray) obj3;
                        }
                        jSONArray2 = jSONArray;
                    } else {
                        jSONArray2 = null;
                    }
                    if (jSONArray2 != null && jSONArray2.length() > 1) {
                        assetEntity2.setScale(Float.valueOf((float) jSONObject.optDouble("scale")));
                        int length2 = jSONArray2.length();
                        Float[] fArr = new Float[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            fArr[i2] = Float.valueOf(0.0f);
                        }
                        int length3 = jSONArray2.length();
                        for (int i3 = 0; i3 < length3; i3++) {
                            fArr[i3] = Float.valueOf((float) jSONArray2.getDouble(i3));
                        }
                        assetEntity2.setScales(fArr);
                    }
                    arrayList.add(assetEntity2);
                } catch (JSONException unused) {
                }
            }
        }
        return arrayList;
    }

    @Override // expo.modules.updates.manifest.Update
    public boolean isDevelopmentMode() {
        return this.isDevelopmentMode;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EmbeddedUpdate fromEmbeddedManifest(EmbeddedManifest manifest, UpdatesConfiguration configuration) {
            Intrinsics.checkNotNullParameter(manifest, "manifest");
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            UUID uuidFromString = UUID.fromString(manifest.getID());
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
            return new EmbeddedUpdate(manifest, uuidFromString, configuration.getScopeKey(), new Date(manifest.getCommitTimeLong()), configuration.getRuntimeVersion(), manifest.getAssets(), configuration.getOriginalEmbeddedUpdateUrl(), configuration.getOriginalEmbeddedRequestHeaders(), null);
        }
    }
}
