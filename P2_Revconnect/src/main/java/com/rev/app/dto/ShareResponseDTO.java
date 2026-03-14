package com.rev.app.dto;

public class ShareResponseDTO {
    private long shareCount;

    public ShareResponseDTO() {
    }

    public ShareResponseDTO(long shareCount) {
        this.shareCount = shareCount;
    }

    public long getShareCount() {
        return shareCount;
    }

    public void setShareCount(long shareCount) {
        this.shareCount = shareCount;
    }
}
