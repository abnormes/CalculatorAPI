package ru.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.example.service.SolverService;
import ru.example.service.impl.ExpressionSolverService;
import ru.example.service.impl.UserRequestService;

import javax.script.ScriptException;

/**
 * @author Nail Rogatov
 * @created 30/01/2021
 */
@RestController
public class MainController {

    private final SolverService solverService;
    private final UserRequestService requestService;

    public MainController(ExpressionSolverService solverService,
                          UserRequestService requestService
    ) {
        this.solverService = solverService;
        this.requestService = requestService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "Hello world!";
    }

    @PostMapping("/calculate")
    public String getExpressionResult(@RequestParam String expression) {
        String result = null;
        try {
            result = solverService.solve(expression);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/historyByDate")
    public String getExpressionHistoryByDate(
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        String result = requestService.getRequestHistoryByDate(startDate, endDate);
        return result;
    }

    @PostMapping("/historyByExpression")
    public String getExpressionHistoryByExpression(@RequestParam String expression) {
        String result = requestService.getRequestHistoryByExpression(expression);
        return result;
    }
}
