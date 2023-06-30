package org.looko.example.adapter

/**
 * 适配器模式
 *
 * 适配器模式主要用于解决接口不兼容的问题
 * 比如第三方接口往往意味着无权修改，要对目标接口的实现做适配，其实现就叫做适配器
 *
 * 本质上就是适配器内 wrap 了一层已有类
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


// 适配者接口 (adaptee interface)
interface AdvancedMediaPlayer {
    fun playVlc(fileName: String)
    fun playMp4(fileName: String)
}


// 适配者类 - VLC播放器 (adaptee 1)
class VlcPlayer : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Playing VLC file: $fileName")
    }

    override fun playMp4(fileName: String) {
        // 不实现
    }
}


// 适配者类 - MP4播放器 (adaptee 2)
class Mp4Player : AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        // 不实现
    }

    override fun playMp4(fileName: String) {
        println("Playing MP4 file: $fileName")
    }
}


/**
 *  适配器类 (adapter)
 *
 *  需求：客户端想通过 MediaPlayer 接口播放 vlc 和 mp4
 *  现状：目前手上有个支持该功能的接口 AdvancedMediaPlayer, 但客户端的目标接口 MediaPlayer 不支持
 *  将 AdvancedMediaPlayer 转化成期望的 MediaPlayer 接口
 */
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
