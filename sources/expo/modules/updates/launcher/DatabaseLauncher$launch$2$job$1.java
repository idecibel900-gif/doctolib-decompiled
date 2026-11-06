package expo.modules.updates.launcher;

import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.manifest.EmbeddedUpdate;
import java.io.File;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class DatabaseLauncher$launch$2$job$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ AssetEntity $asset;
    final /* synthetic */ UpdatesDatabase $database;
    final /* synthetic */ EmbeddedUpdate $embeddedUpdate;
    final /* synthetic */ JSONObject $extraHeaders;
    int label;
    final /* synthetic */ DatabaseLauncher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatabaseLauncher$launch$2$job$1(DatabaseLauncher databaseLauncher, AssetEntity assetEntity, UpdatesDatabase updatesDatabase, EmbeddedUpdate embeddedUpdate, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = databaseLauncher;
        this.$asset = assetEntity;
        this.$database = updatesDatabase;
        this.$embeddedUpdate = embeddedUpdate;
        this.$extraHeaders = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DatabaseLauncher$launch$2$job$1(this.this$0, this.$asset, this.$database, this.$embeddedUpdate, this.$extraHeaders, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DatabaseLauncher$launch$2$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DatabaseLauncher$launch$2$job$1 databaseLauncher$launch$2$job$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DatabaseLauncher databaseLauncher = this.this$0;
            AssetEntity assetEntity = this.$asset;
            UpdatesDatabase updatesDatabase = this.$database;
            EmbeddedUpdate embeddedUpdate = this.$embeddedUpdate;
            JSONObject jSONObject = this.$extraHeaders;
            this.label = 1;
            databaseLauncher$launch$2$job$1 = this;
            obj = databaseLauncher.ensureAssetExists(assetEntity, updatesDatabase, embeddedUpdate, jSONObject, databaseLauncher$launch$2$job$1);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            databaseLauncher$launch$2$job$1 = this;
        }
        return new Pair(databaseLauncher$launch$2$job$1.$asset, (File) obj);
    }
}
