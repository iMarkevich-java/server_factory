package com.markevich.factorybox.net.serverCommandFactory.client;

import businessObjectFactoryBox.Client;
import com.markevich.factorybox.net.ResponseCode;
import com.markevich.factorybox.net.interfaces.Command;
import com.markevich.factorybox.net.interfaces.Request;
import com.markevich.factorybox.net.interfaces.Response;
import com.markevich.factorybox.service.ServiceFactory;

public class GetSaveClientCommand implements Command {

    @Override
    public void execute(Request request, Response response) {

        String companyName = request.getParameter("company-name");
        String address = request.getParameter("address");
        String legalData = request.getParameter("legal-data");
        String manager = request.getParameter("manager");
        String id = request.getParameter("id");

        Client client = new Client();
        client.setId(id);
        client.setCompanyName(companyName);
        client.setAddress(address);
        client.setLegalData(legalData);
        client.setManager(manager);

        ServiceFactory.ClientService().save(client);
        response.setResponseCode(ResponseCode.OkCode);


    }
}
