package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.service.group.GroupService;
import com.example.demo.domain.service.group.dto.GroupAddFriendDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupApiController {

    private final GroupService groupService;

    /**
     * GET /api/group 요청이 들어왔을시 현재 사용자가 만든 모든 그룹을 정보를 반환
     *
     * @param user 요청을 보낸 사용자
     */
    @GetMapping
    public HttpEntity<?> get (User user) {
        return ResponseEntity.ok(groupService.get(user));
    }

    @PostMapping("/add")
    public HttpEntity<?> addMember (@RequestBody GroupAddFriendDto data, User user) {
        groupService.addMember(data, user);
        return ResponseEntity.ok("OK");
    }

    @PostMapping
    public HttpEntity<?> createGroup (@RequestBody GroupDto groupData, User user) {
        groupService.create(user, groupData);
        return ResponseEntity.ok("OK");
    }

    @Transactional
    @PutMapping("/{group_id}")
    public HttpEntity<?> modifyGroup (@PathVariable(name = "group_id") Long id, @RequestBody GroupDto groupDto, User user) {
        groupService.modify(id, groupDto, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteGroup (@PathVariable Long id, User user) {
        groupService.delete(id, user);
        return ResponseEntity.ok().build();
    }

}
