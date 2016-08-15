package mvc.model;


import mvc.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruslan on 14.08.16.
 */
public class FakeModel implements Model
{

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData()
    {
        return modelData;
    }

    @Override
    public void loadUsers()
    {
        //test
        List<User> usrList = new ArrayList<>();

        User user1 = new User("A", 1, 1);
        User user2 = new User("B", 2, 2);

        usrList.add(user1);
        usrList.add(user2);

        modelData.setUsers(usrList);
    }

    @Override
    public void loadDeletedUsers()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level)
    {
        throw new UnsupportedOperationException();
    }
}
