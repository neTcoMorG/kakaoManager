package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.service.group.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupApiController {

    private final GroupService groupService;

    /**
     * getAll : GET /group 으로 요청이 들어왔을 시 현재 사용자가 만든 모든 그룹을 정보를 반환
     * @param user
     * @return 그룹정보
     */
    @GetMapping
    public HttpEntity<?> get(User user) {
        return ResponseEntity.ok(user.getGroupList());
    }

    @PostMapping
    public HttpEntity<?> createGroup (GroupDto groupDto, User user) {
        groupService.create(user, groupDto);
        return ResponseEntity.ok("서비스 준비중");
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteGroup (@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public HttpEntity<?> deleteGroupExceptionHandler (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
