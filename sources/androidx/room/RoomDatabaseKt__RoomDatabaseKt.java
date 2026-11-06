package androidx.room;

import androidx.room.migration.Migration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
abstract /* synthetic */ class RoomDatabaseKt__RoomDatabaseKt {
    public static final void validateMigrationsNotRequired(Set migrationStartAndEndVersions, Set migrationsNotRequiredFrom) {
        Intrinsics.checkNotNullParameter(migrationStartAndEndVersions, "migrationStartAndEndVersions");
        Intrinsics.checkNotNullParameter(migrationsNotRequiredFrom, "migrationsNotRequiredFrom");
        if (migrationStartAndEndVersions.isEmpty()) {
            return;
        }
        Iterator it = migrationStartAndEndVersions.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (migrationsNotRequiredFrom.contains(Integer.valueOf(iIntValue))) {
                throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: " + iIntValue).toString());
            }
        }
    }

    public static final void validateAutoMigrations(RoomDatabase roomDatabase, DatabaseConfiguration configuration) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set requiredAutoMigrationSpecClasses = roomDatabase.getRequiredAutoMigrationSpecClasses();
        int size = configuration.autoMigrationSpecs.size();
        boolean[] zArr = new boolean[size];
        Iterator it = requiredAutoMigrationSpecClasses.iterator();
        while (true) {
            int i = -1;
            if (it.hasNext()) {
                KClass kClass = (KClass) it.next();
                int size2 = configuration.autoMigrationSpecs.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i2 = size2 - 1;
                        if (kClass.isInstance(configuration.autoMigrationSpecs.get(size2))) {
                            zArr[size2] = true;
                            i = size2;
                            break;
                        } else if (i2 < 0) {
                            break;
                        } else {
                            size2 = i2;
                        }
                    }
                }
                if (i < 0) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + kClass.getQualifiedName() + ") is missing in the database configuration.").toString());
                }
                linkedHashMap.put(kClass, configuration.autoMigrationSpecs.get(i));
            } else {
                int size3 = configuration.autoMigrationSpecs.size() - 1;
                if (size3 >= 0) {
                    while (true) {
                        int i3 = size3 - 1;
                        if (size3 >= size || !zArr[size3]) {
                            throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                        }
                        if (i3 < 0) {
                            break;
                        } else {
                            size3 = i3;
                        }
                    }
                }
                for (Migration migration : roomDatabase.createAutoMigrations(linkedHashMap)) {
                    if (!configuration.migrationContainer.contains(migration.startVersion, migration.endVersion)) {
                        configuration.migrationContainer.addMigration(migration);
                    }
                }
                return;
            }
        }
    }

    public static final void validateTypeConverters(RoomDatabase roomDatabase, DatabaseConfiguration configuration) {
        Intrinsics.checkNotNullParameter(roomDatabase, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Map requiredTypeConverterClassesMap$room_runtime = roomDatabase.getRequiredTypeConverterClassesMap$room_runtime();
        boolean[] zArr = new boolean[configuration.typeConverters.size()];
        for (Map.Entry entry : requiredTypeConverterClassesMap$room_runtime.entrySet()) {
            KClass kClass = (KClass) entry.getKey();
            for (KClass kClass2 : (List) entry.getValue()) {
                int size = configuration.typeConverters.size() - 1;
                if (size < 0) {
                    size = -1;
                    break;
                }
                while (true) {
                    int i = size - 1;
                    if (kClass2.isInstance(configuration.typeConverters.get(size))) {
                        zArr[size] = true;
                        break;
                    } else {
                        if (i < 0) {
                            size = -1;
                            break;
                        }
                        size = i;
                    }
                }
                if (size < 0) {
                    throw new IllegalArgumentException(("A required type converter (" + kClass2.getQualifiedName() + ") for " + kClass.getQualifiedName() + " is missing in the database configuration.").toString());
                }
                roomDatabase.addTypeConverter$room_runtime(kClass2, configuration.typeConverters.get(size));
            }
        }
        int size2 = configuration.typeConverters.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i2 = size2 - 1;
            if (!zArr[size2]) {
                throw new IllegalArgumentException("Unexpected type converter " + configuration.typeConverters.get(size2) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
            }
            if (i2 < 0) {
                return;
            } else {
                size2 = i2;
            }
        }
    }
}
