package principle;

public class LKPPrinciple {
}

class Play {
    private void changePlayList() {
        //变更播放列表
    }

    private void showCurrentLyrics() {
        //显示当前歌曲的歌词
    }

    private void playCurrentSong() {
        //播放歌曲
    }

    public void playMusic() {
        changePlayList();
        showCurrentLyrics();
        playCurrentSong();
    }
}

class MediaPlayer {
    public void playMusic() {
        Play play = new Play();
        play.playMusic();
    }
}

class User {

    public void playMusic() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.playMusic();
    }
}
