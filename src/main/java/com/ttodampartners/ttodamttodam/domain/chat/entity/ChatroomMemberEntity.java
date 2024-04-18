package com.ttodampartners.ttodamttodam.domain.chat.entity;

import com.ttodampartners.ttodamttodam.domain.chat.dto.response.ChatroomListResponse;
import com.ttodampartners.ttodamttodam.domain.post.entity.PostEntity;
import com.ttodampartners.ttodamttodam.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "chatroom_member")
public class ChatroomMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long chatroomMemberId;

    // CHATROOMS 테이블과 연결
    @ManyToOne
    @JoinColumn(name = "chatroom_id", nullable = false)
    private ChatroomEntity chatroomEntity;

    // USER 테이블과 연결
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    // 더이상 대화할 수 없는 채팅방이면 false
    @Column(name = "chat_active")
    private boolean chatActive;

    public ChatroomMemberEntity(boolean chatActive) {
        this.chatActive = true;
    }

    // 채팅방 정보를 ChatroomListResponse에 담아서 리턴
    public ChatroomListResponse getChatroomInfos() {
        ChatroomMemberEntity user = this;
        ChatroomEntity userChatroom = this.chatroomEntity;
        PostEntity userChatroomPost = userChatroom.getPostEntity();

        return ChatroomListResponse.builder()
                .userChatroomId(userChatroom.getChatroomId())
                .postImage(userChatroomPost.getPostImgUrl())
                .chatName(userChatroomPost.getTitle())
                .hostId(userChatroomPost.getUser().getId())
                .hostNickname(userChatroomPost.getUser().getNickname())
                .userCount(userChatroom.getUserCount())
                .createAt(userChatroom.getCreateAt())
                .modifiedAt(userChatroom.getModifiedAt())
                .build();
    }
}