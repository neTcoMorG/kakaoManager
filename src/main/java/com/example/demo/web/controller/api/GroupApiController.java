package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.service.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupApiController {

    private final GroupService groupService;

    /**
     * getGroupList : GET /group 으로 요청이 들어왔을 시 현재 사용자가 만든 모든 그룹을 정보를 반환
     * @param user
     * @return 그룹정보
     */
    @GetMapping
    public HttpEntity<?> getGroupList(User user) {
        return ResponseEntity.ok(user.getNickname());
    }

    @PostMapping
    public HttpEntity<?> createGroup (GroupDto groupDto, User user) {
        return ResponseEntity.ok("서비스 준비중");
    }
}
