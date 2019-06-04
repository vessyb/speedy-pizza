package com.company.speedypizza.web.screens.clerk;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Clerk;

@UiController("speedypizza_Clerk.edit")
@UiDescriptor("clerk-edit.xml")
@EditedEntityContainer("clerkDc")
@LoadDataBeforeShow
public class ClerkEdit extends StandardEditor<Clerk> {
}