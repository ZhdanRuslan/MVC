package mvc.view;


import mvc.bean.User;
import mvc.controller.Controller;
import mvc.model.ModelData;

import java.util.List;

/**
 * Created by ruslan on 14.08.16.
 */
public class UsersView implements View
{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData)
    {
        if (!modelData.isDisplayDeletedUserList())
            System.out.println("All users: ");
        if (modelData.isDisplayDeletedUserList())
            System.out.println("All deleted users:");

        List<User> result = modelData.getUsers();
        for (User u : result)
        {
            System.out.println("\t" + u);
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers()
    {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id)
    {
        controller.onOpenUserEditForm(id);
    }
}
