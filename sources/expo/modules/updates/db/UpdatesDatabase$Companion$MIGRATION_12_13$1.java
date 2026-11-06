package expo.modules.updates.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesDatabase$Companion$MIGRATION_12_13$1 extends Migration {
    UpdatesDatabase$Companion$MIGRATION_12_13$1() {
        super(12, 13);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        UpdatesDatabase.INSTANCE.runInTransaction(db, new Function1() { // from class: expo.modules.updates.db.UpdatesDatabase$Companion$MIGRATION_12_13$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdatesDatabase$Companion$MIGRATION_12_13$1.migrate$lambda$0((SupportSQLiteDatabase) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit migrate$lambda$0(SupportSQLiteDatabase runInTransaction) {
        Intrinsics.checkNotNullParameter(runInTransaction, "$this$runInTransaction");
        runInTransaction.execSQL("ALTER TABLE `updates` ADD COLUMN `url` TEXT");
        runInTransaction.execSQL("ALTER TABLE `updates` ADD COLUMN `headers` TEXT");
        return Unit.INSTANCE;
    }
}
