package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DynamiteModule {
    private static final ThreadLocal zzh = new ThreadLocal();
    private static final ThreadLocal zzi = new zze();
    private static final VersionPolicy.IVersions zzj = new zzf();
    public static final VersionPolicy PREFER_REMOTE = new zzg();
    public static final VersionPolicy PREFER_LOCAL = new zzh();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzk();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzl();
    public static final VersionPolicy zza = new zzm();
    public static final VersionPolicy zzb = new zzc();

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public interface VersionPolicy {

        public interface IVersions {
        }
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            new StringBuilder(String.valueOf(declaredField.get(null)).length() + 50 + String.valueOf(str).length() + 1);
            return 0;
        } catch (ClassNotFoundException unused) {
            new StringBuilder(String.valueOf(str).length() + 45);
            return 0;
        } catch (Exception e) {
            "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage()));
            return 0;
        }
    }
}
