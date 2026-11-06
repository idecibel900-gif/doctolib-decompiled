package expo.modules.updates.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesDatabase$Companion$MIGRATION_6_7$1 extends Migration {
    UpdatesDatabase$Companion$MIGRATION_6_7$1() {
        super(6, 7);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        UpdatesDatabase.INSTANCE.runInTransactionWithForeignKeysOff(db, new Function1() { // from class: expo.modules.updates.db.UpdatesDatabase$Companion$MIGRATION_6_7$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdatesDatabase$Companion$MIGRATION_6_7$1.migrate$lambda$0((SupportSQLiteDatabase) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit migrate$lambda$0(SupportSQLiteDatabase runInTransactionWithForeignKeysOff) {
        Intrinsics.checkNotNullParameter(runInTransactionWithForeignKeysOff, "$this$runInTransactionWithForeignKeysOff");
        runInTransactionWithForeignKeysOff.execSQL("CREATE TABLE IF NOT EXISTS `new_assets` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT, `key` TEXT, `headers` TEXT, `type` TEXT, `metadata` TEXT, `download_time` INTEGER, `relative_path` TEXT, `hash` BLOB, `hash_type` INTEGER NOT NULL, `marked_for_deletion` INTEGER NOT NULL)");
        runInTransactionWithForeignKeysOff.execSQL("INSERT INTO `new_assets` (`id`, `url`, `key`, `headers`, `type`, `metadata`, `download_time`, `relative_path`, `hash`, `hash_type`, `marked_for_deletion`) SELECT `id`, `url`, `key`, `headers`, `type`, `metadata`, `download_time`, `relative_path`, `hash`, `hash_type`, `marked_for_deletion` FROM `assets`");
        runInTransactionWithForeignKeysOff.execSQL("DROP TABLE `assets`");
        runInTransactionWithForeignKeysOff.execSQL("ALTER TABLE `new_assets` RENAME TO `assets`");
        runInTransactionWithForeignKeysOff.execSQL("CREATE UNIQUE INDEX `index_assets_key` ON `assets` (`key`)");
        return Unit.INSTANCE;
    }
}
