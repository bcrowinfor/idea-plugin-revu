package org.sylfra.idea.plugins.revu.ui.forms.settings.project.referential.priority;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.sylfra.idea.plugins.revu.model.IssuePriority;
import org.sylfra.idea.plugins.revu.ui.forms.settings.project.referential.AbstractNameHolderReferentialForm;
import org.sylfra.idea.plugins.revu.ui.forms.settings.project.referential.AbstractReferentialDetailForm;
import org.sylfra.idea.plugins.revu.ui.forms.settings.project.referential.ReferentialListHolder;

import java.util.List;

/**
 * @author <a href="mailto:sylfradev@yahoo.fr">Sylvain FRANCOIS</a>
 * @version $Id$
 */
public class ItemPriorityReferentialForm extends AbstractNameHolderReferentialForm<IssuePriority>
{
  public ItemPriorityReferentialForm(Project project)
  {
    super(project);
  }

  protected boolean isTableSelectionMovable()
  {
    return true;
  }

  protected AbstractReferentialDetailForm<IssuePriority> buildNestedFormForDialog()
  {
    return new ItemPriorityDetailForm(table);
  }

  @Nls
  protected String getTitleKeyForDialog(boolean addMode)
  {
    return addMode
      ? "settings.project.review.referential.itemPriority.addDialog.title"
      : "settings.project.review.referential.itemPriority.editDialog.title";
  }

  @NotNull
  protected IssuePriority createDefaultDataForDialog()
  {
    return new IssuePriority();
  }

  @Override
  protected void internalUpdateData(@NotNull ReferentialListHolder<IssuePriority> data)
  {
    super.internalUpdateData(data);

    List<IssuePriority> priorities = data.getItems();
    for (byte i = 0; i < priorities.size(); i++)
    {
      IssuePriority issuePriority = priorities.get(i);
      issuePriority.setOrder(i);
    }
  }
//
//  @Override
//  protected void internalUpdateUI(ReferentialListHolder<IssuePriority> data)
//  {
//    if (data != null)
//    {
//      Collections.sort(data.getItems());
//    }
//    super.internalUpdateUI(data);
//  }
}