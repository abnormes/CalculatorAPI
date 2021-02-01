package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.domain.UserRequest;
import ru.example.repo.UserRequestRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Nail Rogatov
 * @created 01/02/2021
 */
@Service
public class UserRequestService {

    @Autowired
    private UserRequestRepo requestRepo;

    public String getRequestHistoryByDate(String startDateStr, String endDateStr) {

        String result;
        List<UserRequest> userRequests;

        boolean isDataCorrect = startDateStr != null && endDateStr != null;

        if (isDataCorrect) {
            try {
                final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");

                Date startDate;
                Date endDate;

                startDate = df.parse(startDateStr);
                endDate = df.parse(endDateStr);

                userRequests = requestRepo.findAllByRequestDateIsBetween(startDate, endDate);

                result = getRequests(userRequests);
            } catch (ParseException e) {
                result = "Incorrect date format (correct: dd-MM-yy)";
            }
        }  else {
            result = "Incorrect data";
        }

        return result;
    }

    public String getRequestHistoryByExpression(String expression) {
        String result;

        List<UserRequest> requests = requestRepo.findAllByExpression(expression);
        result = getRequests(requests);

        return result;
    }

    private String getRequests(List<UserRequest> userRequests) {
        StringBuilder sb = new StringBuilder();
        if (userRequests.isEmpty()) {
            sb.append("No expressions");
        } else {
            userRequests.forEach(x -> sb.append(x + "\n"));
        }
        return sb.toString();
    }

    public void saveRequest(UserRequest userRequest) {
        requestRepo.save(userRequest);
    }


}
