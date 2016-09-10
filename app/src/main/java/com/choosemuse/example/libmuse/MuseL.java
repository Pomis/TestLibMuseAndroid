package com.choosemuse.example.libmuse;

import com.choosemuse.libmuse.MuseListener;

import java.lang.ref.WeakReference;

/**
 * Created by romanismagilov on 10.09.16.
 */
public class MuseL extends MuseListener {
    final WeakReference<MainActivity> activityRef;

    MuseL(final WeakReference<MainActivity> activityRef) {
        this.activityRef = activityRef;
    }

    @Override
    public void museListChanged() {
        activityRef.get().museListChanged();
    }
}