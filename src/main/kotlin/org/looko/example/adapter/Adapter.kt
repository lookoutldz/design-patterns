package org.looko.example.adapter

/**
 * 适配器模式
 *
 * 应用场景很多，主要应用于不同业务接口之间的适配
 * 目的是让目标接口能使用一些第三方的接口
 * 因为第三方接口往往意味着无权修改，所以要对目标接口的实现做适配，其实现就叫做适配器
 *
 * 本质上就是适配器内 wrap 了一层第三方接口
 */
fun main() {
    var mediaPlayer: MediaPlayer = MediaAdapter("mp4")
    mediaPlayer.play("mp4", "movie.mp4")
    mediaPlayer = MediaAdapter("vlc")
    mediaPlayer.play("vlc", "music.vlc")
    mediaPlayer = MediaAdapter("mp3")
    mediaPlayer.play("mp3", "song.mp3")
}

// 目标接口
interface MediaPlayer {
    fun play(audioType: String, fileName: String)
}


// 适配者接口
interface AdvancedMediaPlayer {
    fun playVlc(fileName: String)
    fun playMp4(fileName: String)
}


// 适配者类 - VLC播放器
class VlcPlayer : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Playing VLC file: $fileName")
    }

    override fun playMp4(fileName: String) {
        // 不实现
    }
}


// 适配者类 - MP4播放器
class Mp4Player : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        // 不实现
    }

    override fun playMp4(fileName: String) {
        println("Playing MP4 file: $fileName")
    }
}


// 适配器类
class MediaAdapter(audioType: String) : MediaPlayer {
    private var advancedMediaPlayer: AdvancedMediaPlayer? = null

    init {
        if (audioType.equals("vlc", ignoreCase = true)) {
            advancedMediaPlayer = VlcPlayer()
        } else if (audioType.equals("mp4", ignoreCase = true)) {
            advancedMediaPlayer = Mp4Player()
        }
    }

    override fun play(audioType: String, fileName: String) {
        if (audioType.equals("vlc", ignoreCase = true)) {
            advancedMediaPlayer!!.playVlc(fileName)
        } else if (audioType.equals("mp4", ignoreCase = true)) {
            advancedMediaPlayer!!.playMp4(fileName)
        }
    }
}
