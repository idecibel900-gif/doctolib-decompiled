package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;

/* JADX INFO: loaded from: classes3.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzx();
    private int zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private int zzf;
    private float zzg;
    private boolean zzh;
    private long zzi;
    private final int zzj;
    private final int zzk;
    private final String zzl;
    private final boolean zzm;
    private final WorkSource zzn;
    private final zzd zzo;

    private static String zzf(long j) {
        return j == Long.MAX_VALUE ? "∞" : zzdj.zza(j);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzm == locationRequest.zzm && this.zzn.equals(locationRequest.zzn) && Objects.equal(this.zzl, locationRequest.zzl) && Objects.equal(this.zzo, locationRequest.zzo)))) {
                return true;
            }
        }
        return false;
    }

    public long getDurationMillis() {
        return this.zze;
    }

    public int getGranularity() {
        return this.zzj;
    }

    public long getIntervalMillis() {
        return this.zzb;
    }

    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    public int getMaxUpdates() {
        return this.zzf;
    }

    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    public int getPriority() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzn);
    }

    public boolean isBatched() {
        long j = this.zzd;
        return j > 0 && (j >> 1) >= this.zzb;
    }

    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (isPassive()) {
            sb.append(zzae.zzb(this.zza));
        } else {
            sb.append("@");
            if (isBatched()) {
                zzdj.zzb(this.zzb, sb);
                sb.append("/");
                zzdj.zzb(this.zzd, sb);
            } else {
                zzdj.zzb(this.zzb, sb);
            }
            sb.append(" ");
            sb.append(zzae.zzb(this.zza));
        }
        if (isPassive() || this.zzc != this.zzb) {
            sb.append(", minUpdateInterval=");
            sb.append(zzf(this.zzc));
        }
        if (this.zzg > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.zzg);
        }
        if (!isPassive() ? this.zzi != this.zzb : this.zzi != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(zzf(this.zzi));
        }
        if (this.zze != Long.MAX_VALUE) {
            sb.append(", duration=");
            zzdj.zzb(this.zze, sb);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.zzf);
        }
        if (this.zzk != 0) {
            sb.append(", ");
            sb.append(zzai.zza(this.zzk));
        }
        if (this.zzj != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.zzj));
        }
        if (this.zzh) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.zzm) {
            sb.append(", bypass");
        }
        if (this.zzl != null) {
            sb.append(", moduleId=");
            sb.append(this.zzl);
        }
        if (!WorkSourceUtil.isEmpty(this.zzn)) {
            sb.append(", ");
            sb.append(this.zzn);
        }
        if (this.zzo != null) {
            sb.append(", impersonation=");
            sb.append(this.zzo);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeString(parcel, 14, this.zzl, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzk;
    }

    public final WorkSource zzb() {
        return this.zzn;
    }

    public final zzd zzc() {
        return this.zzo;
    }

    public final String zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzm;
    }

    public static final class Builder {
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private String zzl;
        private boolean zzm;
        private WorkSource zzn;
        private zzd zzo;

        public Builder(int i, long j) {
            Preconditions.checkArgument(j >= 0, "intervalMillis must be greater than or equal to 0");
            zzae.zza(i);
            this.zza = i;
            this.zzb = j;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public LocationRequest build() {
            int i = this.zza;
            long j = this.zzb;
            long jMin = this.zzc;
            if (jMin == -1) {
                jMin = j;
            } else if (i != 105) {
                jMin = Math.min(jMin, j);
            }
            long jMax = Math.max(this.zzd, this.zzb);
            long j2 = this.zze;
            int i2 = this.zzf;
            float f = this.zzg;
            boolean z = this.zzh;
            long j3 = this.zzi;
            if (j3 == -1) {
                j3 = this.zzb;
            }
            return new LocationRequest(i, j, jMin, jMax, Long.MAX_VALUE, j2, i2, f, z, j3, this.zzj, this.zzk, this.zzl, this.zzm, new WorkSource(this.zzn), this.zzo);
        }

        public Builder setDurationMillis(long j) {
            Preconditions.checkArgument(j > 0, "durationMillis must be greater than 0");
            this.zze = j;
            return this;
        }

        public Builder setGranularity(int i) {
            zzo.zza(i);
            this.zzj = i;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j) {
            boolean z = true;
            if (j != -1 && j < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = j;
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long j) {
            Preconditions.checkArgument(j >= 0, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = j;
            return this;
        }

        public Builder setMaxUpdates(int i) {
            Preconditions.checkArgument(i > 0, "maxUpdates must be greater than 0");
            this.zzf = i;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f) {
            Preconditions.checkArgument(f >= 0.0f, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f;
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long j) {
            boolean z = true;
            if (j != -1 && j < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = j;
            return this;
        }

        public Builder setPriority(int i) {
            zzae.zza(i);
            this.zza = i;
            return this;
        }

        public Builder setWaitForAccurateLocation(boolean z) {
            this.zzh = z;
            return this;
        }

        public final Builder zza(boolean z) {
            this.zzm = z;
            return this;
        }

        public final Builder zzb(String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.zzl = str;
            }
            return this;
        }

        public final Builder zzc(int i) {
            int i2;
            boolean z = true;
            if (i == 0 || i == 1) {
                i2 = i;
            } else {
                i2 = 2;
                if (i == 2) {
                    i = 2;
                } else {
                    z = false;
                    i2 = i;
                }
            }
            Preconditions.checkArgument(z, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i));
            this.zzk = i2;
            return this;
        }

        public final Builder zzd(WorkSource workSource) {
            this.zzn = workSource;
            return this;
        }

        public Builder(long j) {
            Preconditions.checkArgument(j >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = j;
            this.zza = 102;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public Builder(LocationRequest locationRequest) {
            this.zza = locationRequest.getPriority();
            this.zzb = locationRequest.getIntervalMillis();
            this.zzc = locationRequest.getMinUpdateIntervalMillis();
            this.zzd = locationRequest.getMaxUpdateDelayMillis();
            this.zze = locationRequest.getDurationMillis();
            this.zzf = locationRequest.getMaxUpdates();
            this.zzg = locationRequest.getMinUpdateDistanceMeters();
            this.zzh = locationRequest.isWaitForAccurateLocation();
            this.zzi = locationRequest.getMaxUpdateAgeMillis();
            this.zzj = locationRequest.getGranularity();
            this.zzk = locationRequest.zza();
            this.zzl = locationRequest.zzd();
            this.zzm = locationRequest.zze();
            this.zzn = locationRequest.zzb();
            this.zzo = locationRequest.zzc();
        }
    }

    LocationRequest(int i, long j, long j2, long j3, long j4, long j5, int i2, float f, boolean z, long j6, int i3, int i4, String str, boolean z2, WorkSource workSource, zzd zzdVar) {
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4 == Long.MAX_VALUE ? j5 : Math.min(Math.max(1L, j4 - SystemClock.elapsedRealtime()), j5);
        this.zzf = i2;
        this.zzg = f;
        this.zzh = z;
        this.zzi = j6 != -1 ? j6 : j;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = str;
        this.zzm = z2;
        this.zzn = workSource;
        this.zzo = zzdVar;
    }
}
