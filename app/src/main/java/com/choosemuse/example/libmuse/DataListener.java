package com.choosemuse.example.libmuse;

import com.choosemuse.libmuse.Muse;
import com.choosemuse.libmuse.MuseArtifactPacket;
import com.choosemuse.libmuse.MuseDataListener;
import com.choosemuse.libmuse.MuseDataPacket;

import java.lang.ref.WeakReference;

/**
 * Created by romanismagilov on 10.09.16.
 */

public class DataListener extends MuseDataListener {
    final WeakReference<MainActivity> activityRef;

    DataListener(final WeakReference<MainActivity> activityRef) {
        this.activityRef = activityRef;
    }

    @Override
    public void receiveMuseDataPacket(final MuseDataPacket p, final Muse muse) {
        activityRef.get().receiveMuseDataPacket(p, muse);
    }

    @Override
    public void receiveMuseArtifactPacket(final MuseArtifactPacket p, final Muse muse) {
        activityRef.get().receiveMuseArtifactPacket(p, muse);
    }
}
