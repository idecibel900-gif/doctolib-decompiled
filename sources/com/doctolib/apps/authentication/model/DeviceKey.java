package com.doctolib.apps.authentication.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DeviceKey {
    private final String kid;
    private final String publicJwk;
    private final DeviceKeySlot slot;
    private final DeviceKeyStorage storage;
    private final String subject;
    private final DeviceKeyUserAuthentication userAuthentication;

    public static /* synthetic */ DeviceKey copy$default(DeviceKey deviceKey, DeviceKeySlot deviceKeySlot, String str, String str2, String str3, DeviceKeyUserAuthentication deviceKeyUserAuthentication, DeviceKeyStorage deviceKeyStorage, int i, Object obj) {
        if ((i & 1) != 0) {
            deviceKeySlot = deviceKey.slot;
        }
        if ((i & 2) != 0) {
            str = deviceKey.kid;
        }
        if ((i & 4) != 0) {
            str2 = deviceKey.publicJwk;
        }
        if ((i & 8) != 0) {
            str3 = deviceKey.subject;
        }
        if ((i & 16) != 0) {
            deviceKeyUserAuthentication = deviceKey.userAuthentication;
        }
        if ((i & 32) != 0) {
            deviceKeyStorage = deviceKey.storage;
        }
        DeviceKeyUserAuthentication deviceKeyUserAuthentication2 = deviceKeyUserAuthentication;
        DeviceKeyStorage deviceKeyStorage2 = deviceKeyStorage;
        return deviceKey.copy(deviceKeySlot, str, str2, str3, deviceKeyUserAuthentication2, deviceKeyStorage2);
    }

    public final DeviceKey copy(DeviceKeySlot slot, String kid, String publicJwk, String str, DeviceKeyUserAuthentication userAuthentication, DeviceKeyStorage storage) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(publicJwk, "publicJwk");
        Intrinsics.checkNotNullParameter(userAuthentication, "userAuthentication");
        Intrinsics.checkNotNullParameter(storage, "storage");
        return new DeviceKey(slot, kid, publicJwk, str, userAuthentication, storage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceKey)) {
            return false;
        }
        DeviceKey deviceKey = (DeviceKey) obj;
        return this.slot == deviceKey.slot && Intrinsics.areEqual(this.kid, deviceKey.kid) && Intrinsics.areEqual(this.publicJwk, deviceKey.publicJwk) && Intrinsics.areEqual(this.subject, deviceKey.subject) && this.userAuthentication == deviceKey.userAuthentication && this.storage == deviceKey.storage;
    }

    public int hashCode() {
        int iHashCode = ((((this.slot.hashCode() * 31) + this.kid.hashCode()) * 31) + this.publicJwk.hashCode()) * 31;
        String str = this.subject;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.userAuthentication.hashCode()) * 31) + this.storage.hashCode();
    }

    public String toString() {
        return "DeviceKey(slot=" + this.slot + ", kid=" + this.kid + ", publicJwk=" + this.publicJwk + ", subject=" + this.subject + ", userAuthentication=" + this.userAuthentication + ", storage=" + this.storage + ")";
    }

    public DeviceKey(DeviceKeySlot slot, String kid, String publicJwk, String str, DeviceKeyUserAuthentication userAuthentication, DeviceKeyStorage storage) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(publicJwk, "publicJwk");
        Intrinsics.checkNotNullParameter(userAuthentication, "userAuthentication");
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.slot = slot;
        this.kid = kid;
        this.publicJwk = publicJwk;
        this.subject = str;
        this.userAuthentication = userAuthentication;
        this.storage = storage;
    }

    public final DeviceKeySlot getSlot() {
        return this.slot;
    }

    public final String getKid() {
        return this.kid;
    }

    public final String getPublicJwk() {
        return this.publicJwk;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final DeviceKeyUserAuthentication getUserAuthentication() {
        return this.userAuthentication;
    }

    public final DeviceKeyStorage getStorage() {
        return this.storage;
    }
}
