package com.company.speedypizza.web.screens.dish;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza.entity.Dish;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;

@UiController("speedypizza_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {

    @Inject
    private Button clearImageBtn;
    @Inject
    private Button downloadImageBtn;
    @Inject
    private Image dishPhoto;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private ExportDisplay exportDisplay;
    
    private void refreshPhoto(){
        boolean hasPhoto = getEditedEntity().getPhoto() != null;
        if(hasPhoto){
            dishPhoto.setSource(FileDescriptorResource.class).setFileDescriptor(getEditedEntity().getPhoto());
        }
        dishPhoto.setVisible(hasPhoto);
        clearImageBtn.setEnabled(hasPhoto);
        downloadImageBtn.setEnabled(hasPhoto);
    }

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        refreshPhoto();
    }

    @Subscribe("clearImageBtn")
    private void onClearImageBtnClick(Button.ClickEvent event) {
        getEditedEntity().setPhoto(null);
        refreshPhoto();
    }

    @Subscribe("downloadImageBtn")
    private void onDownloadImageBtnClick(Button.ClickEvent event) {
        exportDisplay.show(getEditedEntity().getPhoto(), ExportFormat.OCTET_STREAM);
    }

    @Subscribe("photoField")
    private void onPhotoFieldFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        try {
            FileDescriptor fileDescriptor = uploadField.getFileDescriptor();
            fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fileDescriptor);
            FileDescriptor savedPhoto = dataManager.commit(fileDescriptor);
            getEditedEntity().setPhoto(savedPhoto);
        } catch (FileStorageException e) {
            notifications.create(Notifications.NotificationType.ERROR).withCaption(e.getMessage()).show();
        }
        refreshPhoto();
    }
}