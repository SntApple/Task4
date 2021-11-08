package edu.serviceSender.Service;

import edu.serviceSender.Model.Users;

public class SenderServiceImpl implements SenderService{

    @Override
    public Users getUsers() {
        return new Users();
    }
}
