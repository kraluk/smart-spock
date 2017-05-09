package com.kraluk.smartspock.introduction.task;

import com.kraluk.smartspock.introduction.service.UltimateAnswerProvider;

/**
 * Simple calculation task
 *
 * @author lukasz
 */
public class CalculationTask {

    private final UltimateAnswerProvider provider;

    public CalculationTask(UltimateAnswerProvider service) {
        this.provider = service;
    }

    public double getResult() {
        return provider.getAnswer() + provider.getAnswer();
    }
}
