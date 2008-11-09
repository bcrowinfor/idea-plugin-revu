package org.sylfra.idea.plugins.revu.ui.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.sylfra.idea.plugins.revu.business.ReviewManager;
import org.sylfra.idea.plugins.revu.model.Review;

/**
 * @author <a href="mailto:sylvain.francois@kalistick.fr">Sylvain FRANCOIS</a>
 * @version $Id$
 */
public class CreateReviewAction extends AnAction
{
  public void actionPerformed(AnActionEvent e)
  {
    Project project = e.getData(DataKeys.PROJECT);
    ReviewManager reviewManager = ServiceManager.getService(project, ReviewManager.class);

    VirtualFile f = LocalFileSystem.getInstance().findFileByPath(
      "D:\\_syfranco\\perso\\dev\\revu\\src\\test\\mock\\reviews\\review.xml");

    Review review = new Review();
    review.setActive(true);
    review.setTitle("test");
    reviewManager.addReview(f, review);
  }

}