package expo.modules.updates.db;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesDatabase$Companion$MIGRATION_7_8$1 extends Migration {
    UpdatesDatabase$Companion$MIGRATION_7_8$1() {
        super(7, 8);
    }

    @Override // androidx.room.migration.Migration
    public void migrate(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        UpdatesDatabase.INSTANCE.runInTransactionWithForeignKeysOff(db, new Function1() { // from class: expo.modules.updates.db.UpdatesDatabase$Companion$MIGRATION_7_8$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UpdatesDatabase$Companion$MIGRATION_7_8$1.migrate$lambda$0((SupportSQLiteDatabase) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit migrate$lambda$0(SupportSQLiteDatabase runInTransactionWithForeignKeysOff) {
        Intrinsics.checkNotNullParameter(runInTransactionWithForeignKeysOff, "$this$runInTransactionWithForeignKeysOff");
        runInTransactionWithForeignKeysOff.execSQL("CREATE TABLE `new_updates` (`id` BLOB NOT NULL, `scope_key` TEXT NOT NULL, `commit_time` INTEGER NOT NULL, `runtime_version` TEXT NOT NULL, `launch_asset_id` INTEGER, `manifest` TEXT, `status` INTEGER NOT NULL, `keep` INTEGER NOT NULL, `last_accessed` INTEGER NOT NULL, `successful_launch_count` INTEGER NOT NULL DEFAULT 0, `failed_launch_count` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`id`), FOREIGN KEY(`launch_asset_id`) REFERENCES `assets`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        runInTransactionWithForeignKeysOff.execSQL("INSERT INTO `new_updates` (`id`, `scope_key`, `commit_time`, `runtime_version`, `launch_asset_id`, `manifest`, `status`, `keep`, `last_accessed`, `successful_launch_count`, `failed_launch_count`) SELECT `id`, `scope_key`, `commit_time`, `runtime_version`, `launch_asset_id`, `manifest`, `status`, `keep`, `last_accessed`, 1 AS `successful_launch_count`, 0 AS `failed_launch_count` FROM `updates`");
        runInTransactionWithForeignKeysOff.execSQL("DROP TABLE `updates`");
        runInTransactionWithForeignKeysOff.execSQL("ALTER TABLE `new_updates` RENAME TO `updates`");
        runInTransactionWithForeignKeysOff.execSQL("CREATE INDEX `index_updates_launch_asset_id` ON `updates` (`launch_asset_id`)");
        runInTransactionWithForeignKeysOff.execSQL("CREATE UNIQUE INDEX `index_updates_scope_key_commit_time` ON `updates` (`scope_key`, `commit_time`)");
        return Unit.INSTANCE;
    }
}
