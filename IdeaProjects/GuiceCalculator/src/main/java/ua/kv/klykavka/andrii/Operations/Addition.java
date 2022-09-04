package ua.kv.klykavka.andrii.Operations;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton @Named("Addition")
public class Addition implements Operation{

    @Override
    public long toApply(long a, long b) {
        return a + b;
    }

    @Override
    public boolean toValidate(char operator) {
        return '+' == operator;
    }
}
