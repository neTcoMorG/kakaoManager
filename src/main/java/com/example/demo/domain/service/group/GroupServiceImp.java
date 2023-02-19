package com.example.demo.domain.service.group;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImp implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public Group create (User user, GroupDto dto) {
        return groupRepository.save(new Group(
                user,
                dto.getName()));
    }

    @Override
    public List<Group> getAll(User user) {
        return null;
    }

    @Override
    public Group update (Group group, GroupDto dto) {
        return null;
    }

    @Override
    public void delete(Group group) {

    }
}
