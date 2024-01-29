package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    //Поля UserService, NotificationService
    @Autowired
    public UserService userService;

    @Autowired
    public NotificationService notificationService;

    //Метод processRegistration
    public void processRegistration(User user) {
        userService.createUser(user.getName(), user.getAge(), user.getEmail());
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("New user "
                + user.getName() + " has been added to repository.");
    }
}
