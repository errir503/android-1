package com.bitlove.fetlife.model.pojos;

import com.bitlove.fetlife.model.db.FetLifeDatabase;
import com.bitlove.fetlife.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = FetLifeDatabase.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendRequest extends BaseModel implements FriendRequestScreenModelObject {

    public static enum PendingState {
        NEW,
        ACCEPTED,
        REJECTED,
        OUTGOING
    }

    @Column
    @PrimaryKey(autoincrement = false)
    private String clientId;

    @Column
    @JsonProperty("id")
    private String id;

    @Column
    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("member")
    private Member member;

    @JsonProperty("target_member")
    private Member targetMember;

    @Column
    private long date;

    @Column
    private PendingState pendingState = PendingState.NEW;

    @Column
    private boolean pending;

    @Column
    private String memberId;

    @Column
    private String targetMemberId;

    @Column
    private String memberLink;

    @Column
    private String nickname;

    @Column
    private String metaInfo;

    @Column
    private String avatarLink;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public PendingState getPendingState() {
        return pendingState;
    }

    public void setPendingState(PendingState pendingState) {
        this.pendingState = pendingState;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(String metaInfo) {
        this.metaInfo = metaInfo;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getMemberLink() {
        return memberLink;
    }

    public void setMemberLink(String memberLink) {
        this.memberLink = memberLink;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        if (createdAt != null) {
            try {
                setDate(DateUtil.parseDate(createdAt));
            } catch (Exception e) {
            }
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
        if (member != null) {
            setMemberId(member.getId());
            setNickname(member.getNickname());
            setMetaInfo(member.getMetaInfo());
            setAvatarLink(member.getAvatarLink());
            setMemberLink(member.getLink());
        }
    }

    public Member getTargetMember() {
        return targetMember;
    }

    public void setTargetMember(Member targetMember) {
        this.targetMember = targetMember;
        if (targetMember != null) {
            setTargetMemberId(targetMember.getId());
        }
    }

    public String getTargetMemberId() {
        return targetMemberId;
    }

    public void setTargetMemberId(String targetMemberId) {
        this.targetMemberId = targetMemberId;
    }
}


