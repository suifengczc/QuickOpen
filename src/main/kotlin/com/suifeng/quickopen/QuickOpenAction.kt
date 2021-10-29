package com.suifeng.quickopen

import com.intellij.ide.IdeBundle
import com.intellij.ide.RecentProjectListActionProvider
import com.intellij.ide.actions.GotoActionBase
import com.intellij.ide.util.gotoByName.ChooseByNamePopup
import com.intellij.ide.util.gotoByName.DefaultChooseByNameItemProvider
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.DumbAware
import com.suifeng.quickopen.model.QOGoToProjectModel

class QuickOpenAction : GotoActionBase(), DumbAware {

    private val recentOpenedProject = RecentProjectListActionProvider.getInstance().getActions()

    override fun gotoActionPerformed(e: AnActionEvent) {
//        val actions = RecentProjectListActionProvider.getInstance().getActions()
        for (action in recentOpenedProject) {
            QuickOpen.log.info("recentProject fun2 = $action")
        }
        e.getData(CommonDataKeys.PROJECT)?.let { project ->
            showNavigationPopup(
                e,
                QOGoToProjectModel(project),
                object : GotoActionBase.GotoActionCallback<FileType>() {
                    override fun elementChosen(popup: ChooseByNamePopup?, element: Any?) {
                        // TODO
                    }
                },
                "QUICK OPEN PROJECT",
                true,
                false,
                DefaultChooseByNameItemProvider(getPsiContext(e))
            )
        }


    }


}