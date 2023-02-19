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
     * GET /api/group 요청이 들어왔을시 현재 사용자가 만든 모든 그룹을 정보를 반환
     *
     * @param user 요청을 보낸 사용자
     */
    @GetMapping
    public HttpEntity<?> get (User user) {
        return ResponseEntity.ok(groupService.get(user));
    }

    @PostMapping
    public HttpEntity<?> createGroup (@RequestBody GroupDto groupData, User user) {
        groupService.create(user, groupData);
        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteGroup (@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * <h1>존재하지 않는 그룹을 삭제하는 예외를 처리하기 위한 핸들러</h1>
     *
     * @author joyoungjun
     * <p>
     *     DELETE /api/group/{id} 로 요청이 왔을 시 없는 그룹을 삭제하려는 예외가 생기면 <br/>
     *     사용자에게 BAD_REQUEST (400) 응답코드를 반환합니다.
     * </p>
     */
    @ExceptionHandler(NoSuchElementException.class)
    public HttpEntity<?> deleteGroupExceptionHandler (RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
