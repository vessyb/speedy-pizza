package com.company.speedypizza.web.screens.clerk;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Clerk;

@UiController("speedypizza_Clerk.browse")
@UiDescriptor("clerk-browse.xml")
@LookupComponent("clerksTable")
@LoadDataBeforeShow
public class ClerkBrowse extends StandardLookup<Clerk> {
}