package com.stepon.gymapp.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelDetail implements Serializable {

    private boolean isDay;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("workout_title")
    @Expose
    private String workoutTitle;
    @SerializedName("chest_video")
    @Expose
    private String chestVideo;
    @SerializedName("biceps_video")
    @Expose
    private String bicepsVideo;
    @SerializedName("shoulder_video")
    @Expose
    private String shoulderVideo;
    @SerializedName("triceps_video")
    @Expose
    private String tricepsVideo;
    @SerializedName("workout_video")
    @Expose
    private String workoutVideo;
    @SerializedName("workout_detail")
    @Expose
    private String workoutDetail;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("week")
    @Expose
    private String week;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

//    public static ModelDetail createDay(String day) {
//        ModelDetail ret = new ModelDetail();
//        ret.day = day;
//        ret.isDay = true;
//        return ret;
//    }

//    public static ModelDetail createSection(String workoutTitle,String workoutVideo) {
//        ModelDetail ret = new ModelDetail();
//        ret.workoutTitle = workoutTitle;
//        ret.workoutVideo = workoutVideo;
//        ret.isDay = false;
//        return ret;
//    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkoutTitle() {
        return workoutTitle;
    }

    public void setWorkoutTitle(String workoutTitle) {
        this.workoutTitle = workoutTitle;
    }

    public String getChestVideo() {
        return chestVideo;
    }

    public void setChestVideo(String chestVideo) {
        this.chestVideo = chestVideo;
    }

    public String getBicepsVideo() {
        return bicepsVideo;
    }

    public void setBicepsVideo(String bicepsVideo) {
        this.bicepsVideo = bicepsVideo;
    }

    public String getShoulderVideo() {
        return shoulderVideo;
    }

    public void setShoulderVideo(String shoulderVideo) {
        this.shoulderVideo = shoulderVideo;
    }

    public String getTricepsVideo() {
        return tricepsVideo;
    }

    public void setTricepsVideo(String tricepsVideo) {
        this.tricepsVideo = tricepsVideo;
    }

    public String getWorkoutVideo() {
        return workoutVideo;
    }

    public void setWorkoutVideo(String workoutVideo) {
        this.workoutVideo = workoutVideo;
    }

    public String getWorkoutDetail() {
        return workoutDetail;
    }

    public void setWorkoutDetail(String workoutDetail) {
        this.workoutDetail = workoutDetail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDay() {
        return isDay;
    }
}
