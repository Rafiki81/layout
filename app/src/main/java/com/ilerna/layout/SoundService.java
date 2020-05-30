package com.ilerna.layout;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SoundService extends Service {
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"El Sonido se ha iniciado", Toast.LENGTH_SHORT).show();
        if(player !=null && player.isPlaying()){
            player.stop();
        }
        player = MediaPlayer.create(this,R.raw.ladridos);
        player.setLooping(true);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this,"El Sonido se ha parado", Toast.LENGTH_SHORT).show();
        if(player!=null){
            player.release();
        }
        super.onDestroy();
    }
}
