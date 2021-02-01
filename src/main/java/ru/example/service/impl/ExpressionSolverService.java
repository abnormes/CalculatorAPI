package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.domain.UserRequest;
import ru.example.service.SolverService;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Date;

/**
 * @author Nail Rogatov
 * @created 30/01/2021
 */
@Service
public class ExpressionSolverService implements SolverService {

    @Autowired
    private UserRequestService requestService;

    @Override
    public String solve(String expression) throws ScriptException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        Object eval = scriptEngine.eval(expression);

        Double result = Double.parseDouble(eval.toString());

        UserRequest userRequest = new UserRequest();
        userRequest.setExpression(expression);
        userRequest.setResult(result);
        userRequest.setRequestDate(new Date());

        requestService.saveRequest(userRequest);

        return result.toString();
    }
}
