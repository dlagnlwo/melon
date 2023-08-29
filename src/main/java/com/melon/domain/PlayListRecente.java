package com.melon.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// 최근 들은 재생 목록 테이블
@Entity
@Setter @Getter
@Table(name="playlist_recente")
public class PlayListRecente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String streamingTime;
    private int songName;

    // N:N
    @OneToMany(mappedBy = "playlist_recente")
    private List<PlayListRecenteSong> playListRecenteSongs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="songName")
    private Song song;
}
