package expo.modules.updates.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesDatabase$Companion$MIGRATION_8_9$1 extends Migration {
    UpdatesDatabase$Companion$MIGRATION_8_9$1() {
        super(8, 9);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        UpdatesDatabase.INSTANCE.runInTransactionWithForeignKeysOff(db, new Function1() { // from class: expo.modules.updates.db.UpdatesDatabase$Companion$MIGRATION_8_9$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdatesDatabase$Companion$MIGRATION_8_9$1.migrate$lambda$0((SupportSQLiteDatabase) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit migrate$lambda$0(SupportSQLiteDatabase runInTransactionWithForeignKeysOff) {
        Intrinsics.checkNotNullParameter(runInTransactionWithForeignKeysOff, "$this$runInTransactionWithForeignKeysOff");
        runInTransactionWithForeignKeysOff.execSQL("ALTER TABLE `assets` ADD COLUMN `extra_request_headers` TEXT");
        return Unit.INSTANCE;
    }
}
