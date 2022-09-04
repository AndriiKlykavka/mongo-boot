package ua.kv.klykavka.andrii.Operations;

public interface Operation {

    long toApply(long a, long b);

    boolean toValidate(char operator);
}
