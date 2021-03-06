package com.parkgr95.springboot.domain.posts;

import com.parkgr95.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
// public Posts() {}와 같은 효과
@Entity // 테이블과 링크될 클래스
// Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue: PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) // Column: 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼
    // 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
