package com.practice.sms.service.impl;

import com.practice.sms.bean.Group;
import com.practice.sms.dao.GroupMapper;
import com.practice.sms.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyd on 2021/4/25 1:51
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Resource
    private GroupMapper groupMapper;

//    @Override
//    public Group getGroupByGroupName(String groupName) {
//        return groupMapper.getGroupByGroupName(groupName);
//    }

    @Override
    public List<Group> getAllGroups() {
        return groupMapper.getAllGroups();
    }

    @Override
    public int addGroup(Group group) {
        return groupMapper.addGroup(group);
    }

    @Override
    public Group getGroupByGroupId(Integer id) {
        return groupMapper.getGroupByGroupId(id);
    }

    @Override
    public int updateGroup(Group group) {
        return groupMapper.updateGroup(group);
    }

    @Override
    public int deleteGroupById(Integer id) {
        return groupMapper.deleteGroupById(id);
    }
}
