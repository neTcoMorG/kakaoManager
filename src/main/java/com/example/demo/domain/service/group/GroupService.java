package com.example.demo.domain.service.group;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.User;

import java.util.List;

public interface GroupService {

    public Group create (User user, GroupDto dto);
    public List<Group> getAll (User user);
    public Group update (Group group, GroupDto dto);

    public void delete (Group group);
}
