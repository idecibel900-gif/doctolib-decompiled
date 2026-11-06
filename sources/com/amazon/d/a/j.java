package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface j extends IInterface {
    String a() throws RemoteException;

    Map b() throws RemoteException;

    public static abstract class a extends Binder implements j {
        static final int a = 1;
        static final int b = 2;
        private static final String c = "com.amazon.venezia.command.SuccessResult";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, c);
        }

        public static j a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(c);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof j)) {
                return (j) iInterfaceQueryLocalInterface;
            }
            return new C0057a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(c);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(c);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(c);
            Map mapB = b();
            parcel2.writeNoException();
            parcel2.writeMap(mapB);
            return true;
        }

        /* JADX INFO: renamed from: com.amazon.d.a.j$a$a, reason: collision with other inner class name */
        private static class C0057a implements j {
            private IBinder a;

            C0057a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String c() {
                return a.c;
            }

            @Override // com.amazon.d.a.j
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.c);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.j
            public Map b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.c);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readHashMap(getClass().getClassLoader());
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
