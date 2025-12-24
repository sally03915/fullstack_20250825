package com.thejoa703;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.thejoa703"})
public class Project004ExApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project004ExApplication.class, args);
	}
}


/*
> http://localhost:8484/swagger-ui/index.html
> Redis 키고

docker --version
docker ps
docker pull redis
docker run -d --name my-redis -p 6379:6379 redis

docker exec -it my-redis          redis-cli
docker exec -it my-redis          redis-cli FLUSHALL

keys *

 Swagger UI에서 **회원가입 → 로그인 → 사용자 기능 → 게시글 → 댓글 → 좋아요/리트윗 → 해시태그 검색 → 회원탈퇴** 

---

## 📌 Swagger 테스트 시나리오 표

| 단계 | API 엔드포인트 | 메서드 | 요청 예시 | 기대 결과 |
|------|----------------|--------|-----------|------------|
| 1. 회원가입 | `/auth/signup` | POST | `{ "email":"userA@test.com", "password":"1234", "nickname":"userA" }` | 사용자 생성 성공 |
| 2. 로그인 | `/auth/login` | POST | `{ "email":"userA@test.com", "password":"1234" }` | AccessToken + RefreshToken 반환 |
| 3. 토큰 갱신 | `/auth/refresh` | POST | `{ "refreshToken":"..." }` | 새 AccessToken + 새 RefreshToken 발급 |
| 4. 로그아웃 | `/auth/logout/{userId}` | POST | PathVariable: `userId` | RefreshToken 삭제 |

| 5. 사용자 조회 | `/users/{userId}` | GET | PathVariable: `userId` | 사용자 정보 반환 |
| 6. 닉네임 변경 | `/users/{userId}/nickname` | PUT | QueryParam: `nickname=newNick` | 닉네임 변경 성공 |
| 7. 팔로우 | `/users/{followerId}/follow/{followeeId}` | POST | PathVariable: `followerId`, `followeeId` | 팔로우 성공 |
| 8. 언팔로우 | `/users/{followerId}/unfollow/{followeeId}` | DELETE | PathVariable: `followerId`, `followeeId` | 언팔로우 성공 |
| 9. 팔로잉 목록 | `/users/{userId}/followings` | GET | PathVariable: `userId` | 내가 팔로우한 사용자 목록 반환 |
| 10. 팔로워 목록 | `/users/{userId}/followers` | GET | PathVariable: `userId` | 나를 팔로우한 사용자 목록 반환 |
| 11. 팔로워 차단 | `/users/{userId}/block/{followerId}` | POST | PathVariable: `userId`, `followerId` | 특정 팔로워 차단 성공 |
| 12. 회원탈퇴 | `/users/{userId}` | DELETE | PathVariable: `userId` | 소프트 삭제 처리 |

| 13. 게시글 작성 | `/posts/{userId}` | POST | `{ "content":"첫 번째 게시글", "hashtags":["spring","jpa"] }` | 게시글 생성 성공 |
| 14. 게시글 목록 조회 | `/posts?start=1&end=10` | GET | QueryParam: `start`, `end` | 페이징된 게시글 목록 반환 |
| 15. 게시글 수정 | `/posts/{userId}/{postId}` | PUT | `{ "content":"수정된 게시글" }` | 게시글 수정 성공 |
| 16. 게시글 삭제 | `/posts/{userId}/{postId}` | DELETE | PathVariable: `userId`, `postId` | 게시글 소프트 삭제 성공 |
| 17. 댓글 작성 | `/posts/{userId}/{postId}/comments` | POST | `{ "content":"첫 댓글" }` | 댓글 작성 성공 |
| 18. 댓글 수정 | `/posts/{userId}/{postId}/comments/{commentId}` | PUT | `{ "content":"수정된 댓글" }` | 댓글 수정 성공 |
| 19. 댓글 삭제 | `/posts/{userId}/{postId}/comments/{commentId}` | DELETE | PathVariable: `userId`, `postId`, `commentId` | 댓글 소프트 삭제 성공 |
| 20. 좋아요 | `/posts/{userId}/{postId}/like` | POST | PathVariable: `userId`, `postId` | 좋아요 성공 |
| 21. 좋아요 취소 | `/posts/{userId}/{postId}/unlike` | DELETE | PathVariable: `userId`, `postId` | 좋아요 취소 성공 |
| 22. 리트윗 | `/posts/{userId}/{postId}/retweet` | POST | PathVariable: `userId`, `postId` | 리트윗 게시글 생성 |
| 23. 리트윗 취소 | `/posts/{userId}/{postId}/retweet` | DELETE | PathVariable: `userId`, `postId` | 리트윗 취소 성공 |
| 24. 해시태그 검색 | `/posts/hashtag/{name}` | GET | PathVariable: `name` | 해당 해시태그 게시글 목록 반환 |

 
*/