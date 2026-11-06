package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface e extends IInterface {
    String a() throws RemoteException;

    Map b() throws RemoteException;

    public static abstract class a extends Binder implements e {
        private static final String a = "com.amazon.venezia.command.DecisionExpirationContext";
        static final int c = 1;
        static final int d = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, a);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof e)) {
                return (e) iInterfaceQueryLocalInterface;
            }
            return new C0052a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                String strA = a();
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i != 2) {
                if (i == 1598968902) {
                    parcel2.writeString(a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a);
            Map mapB = b();
            parcel2.writeNoException();
            parcel2.writeMap(mapB);
            return true;
        }

        /* JADX INFO: renamed from: com.amazon.d.a.e$a$a, reason: collision with other inner class name */
        private static class C0052a implements e {
            private IBinder a;

            C0052a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String c() {
                return a.a;
            }

            @Override // com.amazon.d.a.e
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.e
            public Map b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
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
