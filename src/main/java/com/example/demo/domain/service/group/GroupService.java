package com.example.demo.domain.service.group;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Group create (User user, GroupDto dto) {
        return groupRepository.save(new Group(
                user,
                dto.getName()));
    }

    public void delete (Long id) throws RuntimeException {
        Group group = groupRepository.findById(id).orElseThrow();
        groupRepository.delete(group);
    }

}
