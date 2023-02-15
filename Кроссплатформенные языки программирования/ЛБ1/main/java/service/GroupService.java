package service;

import dao.GroupDao;
import model.Group;

import java.util.List;

public class GroupService {

    private GroupDao groupsDao = new GroupDao();

    public GroupService() {
    }

    public Group findGroup(int id) {
        return groupsDao.findById(id);
    }

    public void saveGroup(Group group) {
        groupsDao.save(group);
    }

    public void deleteGroup(Group group) {
        groupsDao.delete(group);
    }

    public void updateStudent(Group group) {
        groupsDao.update(group);
    }

    public List<Group> findAllGroups() {
        return groupsDao.findAll();
    }
}
