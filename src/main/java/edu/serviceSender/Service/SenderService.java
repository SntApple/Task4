package edu.serviceSender.Service;


import edu.serviceSender.Model.Users;

import javax.jws.WebMethod;

public interface SenderService {
    @WebMethod
    Users getUsers();
}
