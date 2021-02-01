package ru.example.service;

import javax.script.ScriptException;

/**
 * @author Nail Rogatov
 * @created 30/01/2021
 */
public interface SolverService {

    String solve(String expression) throws ScriptException;
}
