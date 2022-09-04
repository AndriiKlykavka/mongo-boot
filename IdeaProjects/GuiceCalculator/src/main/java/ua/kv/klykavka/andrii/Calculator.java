package ua.kv.klykavka.andrii;

import ua.kv.klykavka.andrii.Operations.Operation;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Calculator {
    private List<Operation> operations;

    @Inject

    public Calculator(@Named("Addition")Operation addition, @Named("Division")Operation division,
                      @Named("Multiplication")Operation multiplication, @Named("Subtraction")Operation subtraction) {
        this.operations = new ArrayList<>();
        operations.add(addition);
        operations.add(division);
        operations.add(multiplication);
        operations.add(subtraction);
    }

    public long calculate(long a, long b, char operator) {
        for (Operation operation : operations) {
            if (operation.toValidate(operator)) {
                return operation.toApply(a, b);
            }
        }
        throw new IllegalArgumentException("Illegal operator is chosen");
    }
}