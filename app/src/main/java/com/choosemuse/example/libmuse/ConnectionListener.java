package com.choosemuse.example.libmuse;

import com.choosemuse.libmuse.Muse;
import com.choosemuse.libmuse.MuseConnectionListener;
import com.choosemuse.libmuse.MuseConnectionPacket;

import java.lang.ref.WeakReference;

/**
 * Created by romanismagilov on 10.09.16.
 */
public class ConnectionListener extends MuseConnectionListener {
    final WeakReference<MainActivity> activityRef;

    ConnectionListener(final WeakReference<MainActivity> activityRef) {
        this.activityRef = activityRef;
    }

    @Override
    public void receiveMuseConnectionPacket(final MuseConnectionPacket p, final Muse muse) {
        activityRef.get().receiveMuseConnectionPacket(p, muse);
    }
}
