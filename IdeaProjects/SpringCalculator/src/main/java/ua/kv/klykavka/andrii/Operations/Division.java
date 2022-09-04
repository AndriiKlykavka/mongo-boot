package ua.kv.klykavka.andrii.Operations;

import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {

    @Override
    public long toApply(long a, long b) {
        return a / b;
    }

    @Override
    public boolean toValidate(char operator) {
        return '/' == operator;
    }
}
