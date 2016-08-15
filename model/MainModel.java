package mvc.model;


import mvc.bean.User;
import mvc.model.service.UserService;
import mvc.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by ruslan on 14.08.16.
 */
public class MainModel implements Model
{
    UserService userService = new UserServiceImpl();
    ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1, 100)));
        modelData.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers()
    {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId)
    {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id)
    {
        userService.deleteUser(id);
        modelData.setUsers(filter(userService.getUsersBetweenLevels(1, 100)));
        modelData.setDisplayDeletedUserList(false);
    }

    private List<User> filter(List<User> users)
    {
        return userService.filterOnlyActiveUsers(users);
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        userService.createOrUpdateUser(name, id, level);
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getActiveUsers(userService.getUsersBetweenLevels(1, 100)));
    }

    private List<User> getActiveUsers(List<User> userList)
    {
        return userService.filterOnlyActiveUsers(userList);
    }
}
