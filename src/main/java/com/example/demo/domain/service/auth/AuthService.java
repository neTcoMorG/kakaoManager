package com.example.demo.domain.service.auth;

import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.FriendRepository;
import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.service.kakao.KakaoService;
import com.example.demo.domain.service.kakao.friend.json.FriendResponse;
import com.example.demo.domain.service.kakao.oauth.json.OauthToken;
import com.example.demo.domain.service.kakao.oauth.json.UserProfile;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final KakaoService kakaoService;

    /**
     * 카카오톡 oAuth를 이용한 로그인/회원가입 처리
     * <p>
     *  카카오 oAuth2 API를 이용해 로그인/회원가입을 처리   
     * </p>
     *
     * @author : joyoungjun
     * @param code : Resource owner 로 부터 받은 code
     * @return User 유저 엔티티
     */
    @Transactional
    public Optional<User> login (String code) {
        OauthToken token = null;
        UserProfile userProfile = null;
        
        token = kakaoService.getAuthService().getToken(code);
        userProfile = kakaoService.getAuthService().getProfile(token.getAccess_token());

        Optional<User> userOptional = userRepository.findByUuid(userProfile.getId());
        if (userOptional.isPresent()) {
            User findUser = userOptional.get();
            if (!findUser.getPermissions().contains("friends") && token.getScope().contains("friends")) {
                findUser.setScope(token.getScope());
                initFriend(findUser);
            }
            return userOptional;
        }

        User user = userRepository.save(new User(token.getScope(), token.getAccess_token(), token.getRefresh_token(),
                userProfile.getId(), userProfile.getKakao_account().getProfile().getNickname(),
                userProfile.getKakao_account().getEmail(),
                userProfile.getKakao_account().getProfile().getThumbnail_image_url()));
        initFriend(user);
        return Optional.of(user);
    }

    @Transactional
    private void initFriend (User user) {
        FriendResponse friends = kakaoService.getFriendService().getFriendsTest(user, 0, 100);
        friends.getElements().forEach(friend -> {
            log.info("[AuthService-login friend] " + friend.getProfile_nickname());
            friendRepository.save(new Friend(user, friend.getUuid(), friend.getProfile_thumbnail_image(), friend.getProfile_nickname()));
        });
    }
}
