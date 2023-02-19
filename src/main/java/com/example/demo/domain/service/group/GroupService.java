package com.example.demo.domain.service.group;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.Friend;
import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.GroupMember;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.FriendRepository;
import com.example.demo.domain.repository.GroupMemberRepository;
import com.example.demo.domain.repository.GroupRepository;
import com.example.demo.domain.service.group.dto.GroupAddFriendDto;
import com.example.demo.domain.service.group.dto.GroupResponseDto;
import com.example.demo.domain.service.group.dto.GroupResponseFriendDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final FriendRepository friendRepository;

    public List<GroupResponseDto> get (User user) {
        List<GroupResponseDto> result = new ArrayList<>();

        user.getGroupList().forEach(group -> {
            GroupResponseDto dto = new GroupResponseDto();
            dto.setMembers(new ArrayList<>());
            dto.setGroup_id(String.valueOf(group.getGroupId()));
            dto.setGroup_name(group.getName());

            group.getGroupMemberList().forEach(groupMember -> {
                dto.getMembers().add(new GroupResponseFriendDto(
                        groupMember.getFriend().getNickname(),
                        groupMember.getFriend().getUuid(),
                        groupMember.getFriend().getUuid()));
            });
            result.add(dto);
        });
        return result;
    }

    public Group create (User user, GroupDto dto) {
        return groupRepository.save(new Group(user, dto.getName()));
    }

    public void addMember (GroupAddFriendDto dto) throws RuntimeException {
        Group group = groupRepository.findById(Long.parseLong(dto.getGroup_id())).orElseThrow();
        List<Friend> addFriends = new ArrayList<>();

        dto.getFriend_uuid().forEach(uuid -> {
            Friend f = friendRepository.findByUuid(uuid).orElseThrow();
            if (!group.getGroupMemberList().contains(f)) {
                addFriends.add(f);
            }
        });

        addFriends.forEach(friend -> { groupMemberRepository.save(new GroupMember(group, friend)); });
    }

    public void delete (Long id) throws RuntimeException {
        Group group = groupRepository.findById(id).orElseThrow();
        groupRepository.delete(group);
    }
}
