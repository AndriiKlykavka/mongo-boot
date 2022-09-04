package ua.kv.klykavka.andrii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kv.klykavka.andrii.Operations.Operation;

import java.util.List;

@Component
public class Calculator {

    @Autowired
    private List<Operation> operations;

    public long calculate(long a, long b, char operator) {
        for (Operation operation : operations) {
            if (operation.toValidate(operator)) {
                return operation.toApply(a, b);
            }
        }
        throw new IllegalArgumentException("Illegal operator is chosen");
    }
}
