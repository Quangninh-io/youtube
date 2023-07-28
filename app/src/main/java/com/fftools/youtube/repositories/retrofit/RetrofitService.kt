package com.fftools.youtube.repositories.retrofit

import com.fftools.youtube.model.detailvideo.DetailVideo
import com.fftools.youtube.model.infochannel.Channel
import com.fftools.youtube.model.listcategory.Category
import com.fftools.youtube.model.listchannelsfromchannel.ChannelsList
import com.fftools.youtube.model.listcomment.Comment
import com.fftools.youtube.model.listplaylistvideochannel.PlayList
import com.fftools.youtube.model.listreplies.Replies
import com.fftools.youtube.model.listvideohome.ListVideo
import com.fftools.youtube.model.playlistitem.PlayListItemVideo
import com.fftools.youtube.model.searchyoutube.Search
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("youtube/v3/videoCategories")
    suspend fun getCategories(
        @Query("part") part: String?,
        @Query("regionCode") regionCode: String?,
        @Query("key") key: String?
    ): Category

    @GET("youtube/v3/search")
    suspend fun search(
        @Query("pageToken") pageToken: String?,
        @Query("part") part: String?,
        @Query("order") order: String?,
        @Query("publishedAfter") publishedAfter: String?,
        @Query("q") q: String?,
        @Query("regionCode") regionCode: String?,
        @Query("type") type: String?,
        @Query("videoCaption") videoCaption: String?,
        @Query("videoDefinition") videoDefinition: String?,
        @Query("videoDimension") videoDimension: String?,
        @Query("videoDuration") videoDuration: String?,
        @Query("videoLicense") videoLicense: String?,
        @Query("videoType") videoType: String?,
        @Query("key") key: String?,
        @Query("maxResults") maxResults: String?
    ): Search


    @GET("youtube/v3/videos")
    fun getNextVideos(
        @Query("pageToken") pageToken: String?,
        @Query("part") partSnippet: String?,
        @Query("part") partStatic: String?,
        @Query("part") contentDe: String?,
        @Query("chart") chart: String?,
        @Query("locale") locale: String?,
        @Query("regionCode") regionCode: String?,
        @Query("videoCategoryId") categoryId: String?,
        @Query("key") key: String?,
        @Query("maxResults") maxResults: String?
    ): ListVideo

    // detail Video
    @GET("youtube/v3/videos")
    fun getDetailVideo(
        @Query("part") partSnippet: String?,
        @Query("part") partStatic: String?,
        @Query("part") contentDe: String?,
        @Query("id") idVideo: String?,
        @Query("key") key: String?
    ): DetailVideo

    // Channel
    @GET("youtube/v3/channels")
    fun getInfoChannel(
        @Query("part") partSnippet: String?,
        @Query("part") partContent: String?,
        @Query("part") partStatic: String?,
        @Query("id") idChannel: String?,
        @Query("key") key: String?
    ): Channel

    // Full thông tin channel
    @GET("youtube/v3/channels")
    fun getInfoChannelFull(
        @Query("part") partContent: String?,
        @Query("part") partSnippet: String?,
        @Query("part") partStatic: String?,
        @Query("part") partTopicDetails: String?,
        @Query("part") partBrand: String?,
        @Query("id") idChannel: String?,
        @Query("key") key: String?
    ): Channel

    // Top comment
    @GET("youtube/v3/commentThreads")
    fun getComment(
        @Query("pageToken") pageToken: String?,
        @Query("part") partSnippet: String?,
        @Query("part") partReplies: String?,
        @Query("order") order: String?,
        @Query("part") id: String?,
        @Query("textFormat") planText: String?,
        @Query("videoId") videoId: String?,
        @Query("key") key: String?,
        @Query("maxResults") maxResults: String?
    ): Comment

    // Replies
    @GET("youtube/v3/comments")
    fun getReplies(
        @Query("pageToken") pageToken: String?,
        @Query("part") partSnippet: String?,
        @Query("maxResults") maxResults: String?,
        @Query("parentId") parentId: String?,
        @Query("textFormat") textFomat: String?,
        @Query("key") key: String?
    ): Replies

    // Related Video Id
    @GET("youtube/v3/search")
    fun getRelatedCall(
        @Query("pageToken") pageToken: String?,
        @Query("part") partSnippetContent: String?,
        @Query("relatedToVideoId") relatedId: String?,
        @Query("type") typeVideo: String?,
        @Query("key") key: String?,
        @Query("maxResults") maxResults: String?
    ): Search

    // Video mới nhất update từ channel
    @GET("youtube/v3/search")
    fun getVideoUpdateNews(
        @Query("pageToken") pageToken: String?,
        @Query("part") partSnippet: String?,
        @Query("part") partId: String?,
        @Query("channelId") channelId: String?,
        @Query("order") order: String?,
        @Query("q") q: String?,
        @Query("type") typeVideo: String?,
        @Query("regionCode") regionCode: String?,
        @Query("key") key: String?,
        @Query("maxResults") maxResults: String?
    ): Search

    // PlayList từ id channel
    @GET("youtube/v3/playlists")
    fun getChannelInPlayList(
        @Query("pageToken") pageToken: String?,
        @Query("part") part: String?,
        @Query("channelId") channelId: String?,
        @Query("id") idPlayList: String?,
        @Query("key") key: String?,
        @Query("maxResults") maxResults: String?
    ): PlayList

    // ItemVideo trong PlayList ở trên
    @GET("youtube/v3/playlistItems")
    fun getVideoInPlayList(
        @Query("pageToken") pageToken: String?,
        @Query("part") part: String?,
        @Query("playlistId") playListId: String?,
        @Query("key") key: String?,
        @Query("maxResults") maxResults: String?
    ): PlayListItemVideo

    // list dữ liệu mà kênh muốn giới thiệu, có list channels
    @GET("youtube/v3/channelSections")
    fun getChannels(
        @Query("part") part: String?,
        @Query("channelId") channelId: String?,
        @Query("key") key: String?
    ): ChannelsList

}