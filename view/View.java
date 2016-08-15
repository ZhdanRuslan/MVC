package mvc.view;

import mvc.controller.Controller;
import mvc.model.ModelData;

/**
 * Created by ruslan on 14.08.16.
 */
public interface View
{
    void refresh(ModelData modelData);

    void setController(Controller controller);
}
